<template>
  <div class="z-10">
    <transition name="fade">
      <div v-if="isNavbarOpen" class="fixed inset-0 bg-black bg-opacity-50" @click="closePopup"></div>
    </transition>
    <transition name="slide">
      <div v-if="isNavbarOpen" class="fixed flex-col inset-y-0 right-0 w-96 bg-white shadow-md p-4  ">
        <div class="flex flex-col w-full h-1/2">
          <!-- <div class="flex w-full h-1/6">
            <img src="/hello/XLg.png" alt="Close Button" class="h-[4vh] w-auto absolute top-4 right-4"
              @click="closePopup">
          </div> -->
          <div class="flex flex-col w-full h-5/6 bg-blue-500 relative">
            <div class="flex w-full h-1/4 bg-white">
              <img :src="image" alt="Organizers Image" class="w-auto h-14 mb-5 self-center justify-self-center">
              <p class="text-black text-xl font-bold ml-2 mb-5 self-center">{{ name }}</p>
            </div>
            <div class="flex w-full h-3/4 bg-white relative">
              <!-- Rectangle13 image -->
              <div class="relative w-full h-full">
                <img src="/hello/Rectangle13.png" alt="Comment Box" class="h-36 w-auto self-center relative">

                <!-- Textarea covering the entire Rectangle13 -->
                <textarea v-model="inputComment"
                  class="absolute inset-0 w-full h-[20vh] bg-transparent border-none p-4 text-black focus:outline-none self-start resize-none"
                  placeholder="Add your Comments"></textarea>

                <!-- Post button positioned at bottom right -->
                <button class="absolute bottom-0 right-0 mb-4 mr-4" @click="createComment">
                  <p class="text-black text-l font-bold">Post</p>
                </button>
              </div>
            </div>
          </div>
        </div>
        <!-- comment box -->
        <div class="flex flex-col w-full h-1/2 bg-white overflow-y-auto">
          <div v-for="comment in comments" :key="comment.id" class="flex flex-col items-start mb-4">
            <div class="flex items-center">
              <img :src="comment.userImage" alt="Organizers Image" class="w-auto h-11 self-start justify-self-center">
              <p class="text-black text-xl font-bold ml-2">{{ comment.username }}</p>
            </div>
            <p class="text-black text-l ml-2">{{ comment.content }}</p>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
const config = useRuntimeConfig();
// define props
const props = defineProps({
  id: {
    type: String,
    required: true
  }
})
// change props to ref 
const { id } = toRefs(props)
const emit = defineEmits();
const isNavbarOpen = ref(false);
const inputComment = ref('');
const closePopup = () => {
  isNavbarOpen.value = false;
  // 暫停0.5秒
  setTimeout(() => {
    emit('closePopup');
  }, 500);
};
const image = useCookie('image');
const name = useCookie('name');
const comments_tmp = ref([]);
const comments = ref([]);
// const comments = ref(fakeData4);
const createComment = () => {
  axios.post(`${config.public.apiURL}/post/${id.value}/comments`, {
    content: inputComment.value
  }, {
    headers: {
      'Authorization': 'Bearer ' + useCookie('token').value, // useCookie('token').value
      'Content-Type': 'application/json',
      'accept': 'application/json'
    }
  })
    .then((res) => {
      // if code is 200, then hide the modal
      console.log(res);
      if (res.status == 200) {
        window.location.reload();
        console.log("success");
      }
    })
    .catch((err) => {
      // if code is 401, then show error message 
      console.log(err);
      if (err.response.status == 401) {
        console.log("fail");
      }
    })
}

const getCommentData = async () => {
  await axios.get(`${config.public.apiURL}/post/${id.value}/comments`, {
    headers: {
      'Authorization': 'Bearer ' + useCookie('token').value, // useCookie('token').value
      'Content-Type': 'application/json',
      'accept': 'application/json'
    }
  })
    .then(async (res) => {
      // if code is 200, then hide the modal
      console.log(res);
      if (res.status == 200) {
  
        comments_tmp.value = res.data;
        for (const comment of comments_tmp.value) {
          let userinfo = {
            username: "",
            userImage: ""}
          userinfo = await getUserData(comment.user);
          comments.value.push({
            username: userinfo.username,
            userImage: userinfo.userImage,
            content: comment.content
          })
        }
      }
    })
    .catch((err) => {
      // if code is 401, then show error message 
      console.log(err);
      if (err.response.status == 401) {
        console.log("fail");
      }
    })
}

const getUserData = async (userid) => {
  try {
    const response = await axios.get(`${config.public.apiURL}/user/${userid}`, {
      headers: {
        'Authorization': 'Bearer ' + useCookie('token').value
      }
    });
    console.log(response.data);
    return {
      username: response.data.name,
      userImage: response.data.image
    };
  } catch (error) {
    console.log(error);
  }
}

  setTimeout(() => {
    isNavbarOpen.value = true;
  }, 100);
  
  getCommentData();
</script>

<style scoped>

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s ease;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}
.slide-enter-active,
.slide-leave-active {
  transition: transform 0.5s ease;
}

.slide-enter-from,
.slide-leave-to {
  transform: translateX(100%);
}

.slide-enter-to,
.slide-leave-from {
  transform: translateX(0);
}
</style>


<template>
  <div class="flex flex-col w-full h-[92vh]">
    <div class="flex flex-col w-full h-1/2 justify-center items-center">
      <div class="flex flex-row w-full h-1/2 bg-white">
        <div class="flex w-1/3 h-full bg-white"></div>
        <div class="flex flex-col w-2/3 h-full justify-start items-start bg-white">
          <div class="flex w-full h-1/2 bg-white">
            <div v-for="tag in post.tags.slice(0, 4)" :key="tag.id"
              class="w-[7vw] h-[1.5vw] ml-[1vw] mt-5 bg-purple-200 rounded  text-center text-neutral-900 text-[1vw] font-normal font-'Roboto'">
              <p>{{ tag.tagName }}</p>
            </div>
          </div>
          <div class="flex w-full h-1/2 bg-white">
            <p class="text-black text-[3vw]  font-bold my-[3vh] ml-5">{{ post.title }}</p>
          </div>
        </div>
      </div>
      <div class="flex w-full h-1/2 mt-[6vh] bg-white">
        <div class="flex w-1/3 h-full bg-white"></div>
        <div class="flex flex-row w-2/3 h-full bg-white">
          <div class="flex w-1/3 h-full justify-start items-center rounded-full  bg-white">
            <img :src="post.userImage" alt="ID Pic" class="h-[8vh] w-auto   object-cover" />
            <p class="text-black text-xl font-bold ml-4">{{ post.username }}</p>
          </div>
          <div class="flex w-2/3 h-full items-center bg-white">
            <button @click="increaseCount">
              <img src="/hello/Thumb.png" alt="ID Pic" class="h-[4vh] w-auto" />
            </button>
            <p class="text-black text-l font-bold ml-2">{{ count }}</p>
            <button @click="openComment">
              <img src="/hello/ChatRightDots.png" alt="ID Pic" class="h-[4vh] w-auto ml-2" /></button>
            <p class="text-black text-l font-bold ml-2">{{ post.comments }}</p>
            <button @click="copyURL">
              <img src="/hello/Share.png" alt="ID Pic" class="h-[4vh] w-auto ml-2" />
            </button>
            <p class="text-black text-l font-bold ml-2">100</p>
            <img src="/hello/ExclamationCircle.png" alt="ID Pic" class="h-[4vh] w-auto ml-2" />
          </div>
        </div>
      </div>
    </div>

    <editor v-if="post.content && edtiorShow" :content="post.content" />
    <comment v-if="isNavbarOpen" @closePopup="closePopup" :id="id"></comment>
  </div>
</template>
<script setup>
import comment from "@/components/post/PopUp.vue";
import axios from 'axios';
import editor from "@/components/post/Editor.vue";

const post = ref({
  userid: '',
  username: '',
  userImage: '',
  image: '',
  title: '',
  content: '',
  tags: [],
  comments: ''
});

const config = useRuntimeConfig();
// import Edit from '/components/Comment/Editor.vue'

//copy url
const copyURL = () => {
  navigator.clipboard.writeText(window.location.href).then(() => {
    alert('URL copied to clipboard!');
  }).catch(err => {
    alert('Could not copy URL: ', err);
  });
}

// define props
const props = defineProps({
  id: {
    type: String,
    required: true
  }
})
// change props to ref 
const { id } = toRefs(props)

const isNavbarOpen = ref(false);

const closePopup = () => {
  isNavbarOpen.value = false;
};
const openComment = () => {
  isNavbarOpen.value = true;
  console.log('openComment' + isNavbarOpen.value);
};

const copyUrl = async () => {
  const url = window.location.href;
};

try {
  await navigator.clipboard.writeText(url);
  console.log('URL copied to clipboard:', url);
  // You can add additional feedback or actions here if needed
} catch (error) {
  console.error('Error copying to clipboard:', error);
  // You can handle errors or provide feedback to the user
}
// Initialize count
let count = ref(0);

// Function to increase the count
const increaseCount = () => {
  count.value++;
};

const getPostData = async () => {
  await axios.get(`${config.public.apiURL}/post/${id.value}`, {
    headers: {
    }
  })
    .then(response => {
      console.log(response.data);
      post.value.title = response.data.title;
      post.value.content = response.data.content;
      post.value.userid = response.data.user;
      post.value.image = response.data.image;
      post.value.tags = response.data.tags;
      post.value.comments = response.data.comments;

      getUserData(post.value.userid);
    })
    .catch(error => {
      console.log(error);
    });
}

const getUserData = async (userid) => {
  await axios.get(`${config.public.apiURL}/user/${userid}`, {
    headers: {
    }
  })
    .then(response => {
      post.value.username = response.data.name;
      post.value.userImage = response.data.image;
    })
    .catch(error => {
      console.log(error);
    });
}
const edtiorShow = ref(false);
onMounted(() => {
  // 在这里你可以执行一些在组件挂载后需要执行的操作
  // next tick 
  edtiorShow.value = true;

});
getPostData();
</script>
<style scoped>
.slide-enter-active,
.slide-leave-active {
  transition: transform 0.5s ease;
}

.slide-enter,
.slide-leave-to {
  transform: translateX(100%);
}
</style>

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
            <p class="text-black text-2xl font-bold mt-5 ml-5">{{ post.title }}</p>
          </div>
        </div>
      </div>
      <div class="flex w-full h-1/2 bg-white">
        <div class="flex w-1/3 h-full bg-white"></div>
        <div class="flex flex-row w-2/3 h-full bg-white">
          <div class="flex w-1/3 h-full justify-start items-center bg-white">
            <img :src="post.userImage" alt="ID Pic" class="h-[8vh] w-auto" />
            <p class="text-black text-xl font-bold ml-4">{{ post.username }}</p>
          </div>
          <div class="flex w-2/3 h-full items-center bg-white">
            <button @click="increaseCount">
              <img src="/hello/Thumb.png" alt="ID Pic" class="h-[4vh] w-auto" />
            </button>
            <p class="text-black text-l font-bold ml-2">{{ count }}</p>
            <button @click="toggleNavbar">
              <img src="/hello/ChatRightDots.png" alt="ID Pic" class="h-[4vh] w-auto ml-2" /></button>
            <p class="text-black text-l font-bold ml-2">100</p>
            <button @click="copyUrl">
              <img src="/hello/Share.png" alt="ID Pic" class="h-[4vh] w-auto ml-2" />
            </button>
            <p class="text-black text-l font-bold ml-2">100</p>
            <img src="/hello/ExclamationCircle.png" alt="ID Pic" class="h-[4vh] w-auto ml-2" />
          </div>
        </div>
      </div>
    </div>
    <editor v-if="post.content" :content="post.content" :id="123"/>
  </div>
  <div>
    <transition name="fade">
      <div v-if="isNavbarOpen" class="fixed inset-0 bg-black bg-opacity-50" @click="closePopup"></div>
    </transition>
    <transition name="slide">
      <div v-if="isNavbarOpen" class="fixed flex-col inset-y-0 right-0 w-96 bg-white shadow-md p-4 mt-5 rounded-xl">
        <div class="flex flex-col w-full h-1/2">
          <div class="flex w-full h-1/6">
            <img src="/hello/XLg.png" alt="Close Button" class="h-[4vh] w-auto absolute top-4 right-4"
              @click="closePopup">
          </div>
          <div class="flex flex-col w-full h-5/6 bg-blue-500 relative">
            <div class="flex w-full h-1/4 bg-white">
              <img :src="post.value.userImage" alt="Organizers Image"
                class="w-auto h-14 mb-5 self-center justify-self-center">
              <p class="text-black text-xl font-bold ml-2 mb-5 self-center">{{ fakeData3.name2 }}</p>
            </div>
            <div class="flex w-full h-3/4 bg-white relative">
              <!-- Rectangle13 image -->
              <div class="relative w-full h-full">
                <img src="/hello/Rectangle13.png" alt="Comment Box" class="h-36 w-auto self-center relative">

                <!-- Textarea covering the entire Rectangle13 -->
                <textarea v-if="isNavbarOpen"
                  class="absolute inset-0 w-full h-[20vh] bg-transparent border-none p-4 text-black focus:outline-none self-start resize-none"
                  placeholder="Add your Comments"></textarea>

                <!-- Post button positioned at bottom right -->
                <button class="absolute bottom-0 right-0 mb-4 mr-4" @click="handlePostClick">
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
              <img :src="comment.people" alt="Organizers Image" class="w-auto h-11 self-start justify-self-center">
              <p class="text-black text-xl font-bold ml-2">{{ comment.name }}</p>
            </div>
            <p class="text-black text-l ml-2">{{ comment.text }}</p>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>
<script setup>
import { ref } from 'vue';
import fakeData4 from './public/hello/Pic_Folder/fakeData4.json';
import fakeData3 from './public/hello/Pic_Folder/fakeData3.json';
import axios from 'axios';
import editor from "@/components/post/Editor.vue";

const post = ref({
  userid: '',
  username: '',
  userImage: '',
  image: '',
  title: '',
  content: '',
  tags: []
});

const config = useRuntimeConfig();
// import Edit from '/components/Comment/Editor.vue'

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

const toggleNavbar = () => {
  isNavbarOpen.value = !isNavbarOpen.value;
};
const comments = ref(fakeData4);

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

const getPostData = async() => {
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

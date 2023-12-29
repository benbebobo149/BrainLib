<template>
  <button @click="openModal" class="w-auto h-full">
    <img src="@/ListNav.png" class="w-auto h-[80%]" alt="ListNav">
  </button>

  <transition name="fade">
    <div @click="closeModal" v-if="ListNavVisible"
    class="fixed inset-0 flex bg-black bg-opacity-30 w-screen h-screen max-h-full">
  </div>
  </transition>
  <transition name="slide">
    <div v-if="ListNavVisible" class="absolute left-0 w-[25vw] h-[100vh] bg-violet-100">
      <div class="w-auto h-[8%] flex bg-violet-100 items-center border-b border-terotory">
        <NuxtLink to="/main" @click="closeModal" class="flex w-auto h-[80%] ml-[.5vw]">
          <img src="@/logo.png" alt="logo" class="w-full h-auto">
        </NuxtLink>
        <NuxtLink to="/main" @click="closeModal" class="flex w-auto h-[80%] items-center ">
          <p class="text-[2vw] ml-[2vw] ">Home Page</p>
        </NuxtLink>
      </div>
      <div class="w-auto h-[8%] flex bg-violet-100 items-center mt-1 border-b border-terotory">
        <NuxtLink to="/activity" @click="closeModal" class="flex w-auto h-[80%] bg-violet-100 ml-[.5vw]">
          <img src="/ListNav/Calendar.png" alt="Calendar" class="w-auto h-full">
        </NuxtLink>
        <NuxtLink to="/activity" @click="closeModal" class="flex w-auto h-[80%] items-center ml-[2.5vw] ">
          <p class="text-[2vw]">Activity Page</p>
        </NuxtLink>
      </div>
      <div class="w-auto h-[6%] flex bg-violet-100 items-end ">
        <p class="text-[1.3vw] ml-[1vw] text-terotory">All Topics</p>
      </div>
      <div class="w-auto h-[76%] bg-violet-100 overflow-y-hidden">
        <div class="w-auto h-full bg-violet-100 overflow-y-scroll hide-scrollbar fill-available">
          <NuxtLink :to="`/main/${topic.id}`" @click="closeModal" v-for="topic in tags" :key="topic.id"
            class="flex w-auto h-[8vh] items-center justify-center m-3 border  border-terotory rounded-md">
            <p class="text-[2vw] ">{{ topic.tagName }}</p>
          </NuxtLink>
        </div>
      </div>
    </div>
  </transition>
</template>

<script setup>
import { ref } from 'vue';

import Topic from '@/public/TagFakeData/TagFakeData.json';

//get data from databaseimport axios from 'axios';
import axios from 'axios';
const config = useRuntimeConfig();

const tags = ref([]);

//get data from database
const getAllTags = () => {
  const token = useCookie('token');
  axios.get(`${config.public.apiURL}/tag`, { // config.public.apiURL + "/tag"
  }, {
    headers: {
      'Authorization': 'Bearer ' + token.value,
      'Content-Type': 'application/json',
      'accept': 'application/json'
    }
  })
    .then((res) => {
      // if code is 200, then hide the modal
      console.log(res);
      if (res.status == 200) {
        console.log("success");
        tags.value = res.data;
      }
    })
    .catch((err) => {
      // if code is 401, then show error message 
      console.log(err);
      if (err.response.status == 404) {
        console.log("fail");
      } else if (err.response.status == 500) {
        console.log("fail");
      }
    })
}

getAllTags();

const ListNavVisible = ref(false);

const openModal = () => {
  ListNavVisible.value = true;
};
const closeModal = () => {
  ListNavVisible.value = false;
};

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

.fade-enter-to,
.fade-leave-from {
  opacity: 1;
}

.slide-enter-active,
.slide-leave-active {
  transition: transform 0.5s ease;
}

.slide-enter-from,
.slide-leave-to {
  transform: translateX(-100%);
}

.slide-enter-to,
.slide-leave-from {
  transform: translateX(0);
}


/* 自訂的 CSS 類別 */
.hide-scrollbar::-webkit-scrollbar {
  display: none;
  /* 隱藏滾動條 - WebKit browsers */
}

/* 使用 Flexbox 使容器充滿空間 */
.fill-available {
  display: flex;
  flex-direction: column;
}
</style>
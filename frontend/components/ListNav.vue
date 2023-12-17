<template>
  <button @click="openModal" class="w-auto h-full">
    <img src="ListNav.png" class="w-auto h-[80%]" alt="ListNav">
  </button>
  <div v-if="ListNavVisible" class="fixed inset-0 flex bg-black bg-opacity-30 w-screen h-screen max-h-full">
    <div class="relative w-[25%] h-auto bg-violet-100">
      <button @click="closeModal" class="absolute right-2 text-xl font-bold cursor-pointer">&times;</button>
      <div class="w-auto h-[8%] flex bg-violet-100 items-center border-b border-terotory">
        <NuxtLink to="http://localhost:3000/main" class="flex w-auto h-[80%] ml-[.5vw]">
          <img src="logo.png" alt="logo" class="w-full h-auto">
        </NuxtLink>
        <NuxtLink to="http://localhost:3000/main" class="flex w-auto h-[80%] items-center ">
          <p class="text-[2vw] ml-[2vw] ">Home Page</p>
        </NuxtLink>
      </div>
      <div class="w-auto h-[8%] flex bg-violet-100 items-center mt-1 border-b border-terotory">
        <NuxtLink to="./" class="flex w-auto h-[80%] bg-violet-100 ml-[.5vw]">
          <img src="/ListNav/Calendar.png" alt="Calendar" class="w-auto h-full">
        </NuxtLink>
        <NuxtLink to="http://localhost:3000/activity" class="flex w-auto h-[80%] items-center ml-[2.5vw] ">
          <p class="text-[2vw]">Activity Page</p>
        </NuxtLink>
      </div>
      <div class="w-auto h-[6%] flex bg-violet-100 items-end ">
        <p class="text-[1.3vw] ml-[1vw] text-terotory">All Topics</p>
      </div>
      <div class="w-auto h-[76%] bg-violet-100 overflow-y-hidden">
        <div class="w-auto h-full bg-violet-100 overflow-y-scroll hide-scrollbar fill-available">
          <NuxtLink to="./"
            class="flex w-auto h-[8vh] items-center justify-center m-3 border  border-terotory rounded-md">
            <p class="text-[2vw] ">美術</p>
          </NuxtLink>
          <NuxtLink to="./"
            class="flex w-auto h-[8vh] items-center justify-center m-3 border  border-terotory rounded-md">
            <p class="text-[2vw] ">考試</p>
          </NuxtLink>
          <NuxtLink to="./"
            class="flex w-auto h-[8vh] items-center justify-center m-3 border  border-terotory rounded-md">
            <p class="text-[2vw] ">新生</p>
          </NuxtLink>
          <NuxtLink to="./"
            class="flex w-auto h-[8vh] items-center justify-center m-3 border  border-terotory rounded-md">
            <p class="text-[2vw] ">資電</p>
          </NuxtLink>
          <NuxtLink to="./"
            class="flex w-auto h-[8vh] items-center justify-center m-3 border  border-terotory rounded-md">
            <p class="text-[2vw] ">商管</p>
          </NuxtLink>
          <NuxtLink to="./"
            class="flex w-auto h-[8vh] items-center justify-center m-3 border  border-terotory rounded-md">
            <p class="text-[2vw] ">文學</p>
          </NuxtLink>
          <NuxtLink to="./"
            class="flex w-auto h-[8vh] items-center justify-center m-3 border  border-terotory rounded-md">
            <p class="text-[2vw] ">語言</p>
          </NuxtLink>
          <NuxtLink to="./"
            class="flex w-auto h-[8vh] items-center justify-center m-3 border  border-terotory rounded-md">
            <p class="text-[2vw] ">數學</p>
          </NuxtLink>
          <NuxtLink to="./"
            class="flex w-auto h-[8vh] items-center justify-center m-3 border  border-terotory rounded-md">
            <p class="text-[2vw] ">設計</p>
          </NuxtLink>
          <!-- <NuxtLink :to="i.url" v-for="i in TopicName.listNav" :key="i.id"
            class="flex w-auto h-[8vh] items-center justify-center m-3 border  border-terotory rounded-md">
            <p class="text-[2vw] ">{{ i.name }}</p>
          </NuxtLink> -->
        </div>
      </div>
    </div>

  </div>
</template>

<script setup>
import { ref } from 'vue';
//匯入TopicName.json
// import TopicName from '@/assets/TopicName.json';

    const ListNavVisible = ref(false);

    const openModal = () => {
      ListNavVisible.value = true;
    };

    const closeModal = () => {
      ListNavVisible.value = false;
    };

</script>

<style scoped>
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
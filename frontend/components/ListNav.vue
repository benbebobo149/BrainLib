<template>
  <button @click="openModal" class="w-auto h-full">
    <img src="ListNav.png" class="w-auto h-[80%]" alt="ListNav">
  </button>
  <div v-if="ListNavVisible" class="fixed inset-0 flex bg-black bg-opacity-30 w-screen h-screen max-h-full">
    <div class="relative w-[25%] h-auto bg-red-100">
      <button @click="closeModal" class="absolute right-2 text-xl font-bold cursor-pointer">&times;</button>
      <div class="w-auto h-[8%] flex bg-red-100 items-center">
        <NuxtLink to="./" class="flex w-auto h-[80%] bg-green-100 ml-[.5vw]">
          <img src="logo.png" alt="logo" class="w-full h-auto">
        </NuxtLink>
        <NuxtLink to="./" class="flex w-auto h-[80%] bg-green-200 items-center ml-[2vw]">
          <p class="text-[2vw] ">Home Page</p>
        </NuxtLink>
      </div>
      <div class="w-auto h-[8%] flex bg-red-200 items-center">
        <NuxtLink to="./" class="flex w-auto h-[80%] bg-green-100 ml-[.5vw]">
          <img src="/ListNav/Calendar.png" alt="Calendar" class="w-auto h-full">
        </NuxtLink>
        <NuxtLink to="./" class="flex w-auto h-[80%] bg-green-200 items-center ml-[2vw] ">
          <p class="text-[2vw] ">Activity Page</p>
        </NuxtLink>
      </div>
      <div class="w-auto h-[8%] flex bg-red-300 items-end">
        <p class="text-[1.3vw]">All Topics</p>
      </div>
      <div class="w-auto h-[76%] bg-red-400 overflow-y-hidden">
        <div class="w-auto h-full bg-red-400 overflow-y-scroll hide-scrollbar fill-available">
        <NuxtLink to="./" class="flex w-auto h-[8vh] items-center justify-center m-3 border-2 border-neutral-400 rounded-md">
          <p class="text-[2vw] ">新生</p>
        </NuxtLink>
        <NuxtLink to="./" class="flex w-auto h-[8vh] items-center justify-center m-3 border-2 border-neutral-400 rounded-md">
          <p class="text-[2vw] ">考試</p>
        </NuxtLink>
        <NuxtLink to="./" class="flex w-auto h-[8vh] items-center justify-center m-3 border-2 border-neutral-400 rounded-md">
          <p class="text-[2vw] ">新生</p>
        </NuxtLink>
        <NuxtLink to="./" class="flex w-auto h-[8vh] items-center justify-center m-3 border-2 border-neutral-400 rounded-md">
          <p class="text-[2vw] ">資電</p>
        </NuxtLink>
        <NuxtLink to="./" class="flex w-auto h-[8vh] items-center justify-center m-3 border-2 border-neutral-400 rounded-md">
          <p class="text-[2vw] ">商管</p>
        </NuxtLink>
        <NuxtLink to="./" class="flex w-auto h-[8vh] items-center justify-center m-3 border-2 border-neutral-400 rounded-md">
          <p class="text-[2vw] ">文學</p>
        </NuxtLink>
        <NuxtLink to="./" class="flex w-auto h-[8vh] items-center justify-center m-3 border-2 border-neutral-400 rounded-md">
          <p class="text-[2vw] ">語言</p>
        </NuxtLink>
        <NuxtLink to="./" class="flex w-auto h-[8vh] items-center justify-center m-3 border-2 border-neutral-400 rounded-md">
          <p class="text-[2vw] ">數學</p>
        </NuxtLink>
        <NuxtLink to="./" class="flex w-auto h-[8vh] items-center justify-center m-3 border-2 border-neutral-400 rounded-md">
          <p class="text-[2vw] ">設計</p>
        </NuxtLink>
      </div>
      </div>
      
    </div>

  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  name: 'ListNav',
  setup() {
    const ListNavVisible = ref(false);

    const openModal = () => {
      ListNavVisible.value = true;
    };

    const closeModal = () => {
      ListNavVisible.value = false;
    };

    return {
      ListNavVisible,
      openModal,
      closeModal
    };
  }
}
</script>

<style scoped>
  /* 自訂的 CSS 類別 */
  .hide-scrollbar::-webkit-scrollbar {
    display: none; /* 隱藏滾動條 - WebKit browsers */
  }

  /* 使用 Flexbox 使容器充滿空間 */
  .fill-available {
    display: flex;
    flex-direction: column;
  }
</style>
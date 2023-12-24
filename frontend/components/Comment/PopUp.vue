<template>
  <div>
    <transition name="fade">
      <div v-if="isNavbarOpen" class="fixed inset-0 bg-black bg-opacity-50" @click="closePopup"></div>
    </transition>

    <button @click="toggleNavbar" class="top-4 right-4 p-2 bg-blue-500 text-white rounded-full justify-end items-end">
      Toggle Navbar
    </button>

    <transition name="slide">
      <div v-if="isNavbarOpen" class="fixed flex-col inset-y-0 right-0 w-96 bg-white shadow-md p-4 mt-5 rounded-xl">
        <div class="flex flex-col w-full h-1/2">
          <div class="flex w-full h-1/6">
            <img src="/hello/XLg.png" alt="Close Button" class="h-[4vh] w-auto absolute top-4 right-4"
              @click="closePopup">
          </div>
          <div class="flex flex-col w-full h-5/6 bg-blue-500 relative">
            <div class="flex w-full h-1/4 bg-white">
              <img :src="fakeData3.people2" alt="Organizers Image"
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

const isNavbarOpen = ref(false);
const closePopup = () => {
  isNavbarOpen.value = false;
};

const toggleNavbar = () => {
  isNavbarOpen.value = !isNavbarOpen.value;
};
const comments = ref(fakeData4);
</script>

<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}

.fade-enter,
.fade-leave-to {
  opacity: 0;
}

.slide-enter-active,
.slide-leave-active {
  transition: transform 0.5s ease;
}

.slide-enter,
.slide-leave-to {
  transform: translateX(100%);
}
</style>


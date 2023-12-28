<template>
  <div class="flex flex-col w-full h-[92vh] bg-white relative">
    <div class="flex w-full h-1/12 mt-10 items-start justify-center">
      <div class="flex w-1/6 h-full">
      </div>
      <div class="flex w-5/6 h-full justify-start items-start">
        <p class="text-terotory text-[4vw]"> All the activities</p>
        <!-- <button @click="sortByTime" class="text-2xl font-bold text-black">Sort by time</button>
        <button @click="sortByDistance" class="text-2xl font-bold text-black ml-4">Sort by distance</button> -->
      </div>
    </div>
    <div class="flex w-full h-11/12 mt-10 justify-center items-start">
      <component :is="currentScrollBox" class="scrollable-box" />
    </div>
    <NuxtLink to="http://localhost:3000/activity2" class="fixed bottom-4 right-4">
      <img src="/hello/CreateActivity.png" alt="Create Activity" class="w-auto h-[8vh]">
    </NuxtLink>
  </div>
</template>

<style scoped>
.scrollable-box {
  margin-top: 3rem;
}
</style>

<script setup>
import { ref } from 'vue';
import ScrollableBox from './ScrollableBox.vue';
import ScrollBoxByTime from './ScrollBoxByTime.vue';
import ScrollBoxByDistance from './ScrollBoxByDistance.vue';

const components = {
  ScrollableBox,
  ScrollBoxByTime,
  ScrollBoxByDistance,
};

const currentScrollBox = ref(components.ScrollableBox);

const sortByTime = () => {
  currentScrollBox.value = components.ScrollBoxByTime;
};

const sortByDistance = () => {
  currentScrollBox.value = components.ScrollBoxByDistance;
};
</script>

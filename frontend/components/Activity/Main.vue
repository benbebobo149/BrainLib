<template>
  <div>
    <div class="flex flex-col items-center justify-center w-full h-[92vh] bg-white">
      <div class="flex flex-row mt-10">
        <button @click="sortByTime" class="text-2xl font-bold text-black ml-[-40rem]">Sort by time</button>
        <button @click="sortByDistance" class="text-2xl font-bold text-black ml-4">Sort by distance</button>
      </div>
      <component :is="currentScrollBox" class="scrollable-box" />
      <NuxtLink to="http://localhost:3000/activity2" class="self-end justify-self-end">
        <img src="/hello/CreateActivity.png" alt="Create Activity" class="w-auto h-[8vh]">
      </NuxtLink>
    </div>
  </div>
</template>

<style scoped>
.scrollable-box {
  margin-top: 3rem;
  /* Adjust the margin as needed */
  /* Additional styling if required */
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

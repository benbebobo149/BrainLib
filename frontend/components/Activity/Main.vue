<template>
  <div>
    <div class="flex flex-col items-center justify-center w-full h-[92vh] bg-white">
      <div class="flex flex-row mt-10">
        <button @click="sortByTime" class="text-2xl font-bold text-black ml-[-40rem]">Sort by time</button>
        <button @click="sortByDistance" class="text-2xl font-bold text-black ml-4">Sort by distance</button>
      </div>
      <component :is="currentScrollBox" class="scrollable-box" />
      <img src="/hello/CreateActivity.png" alt="Create Activity" class="w-auto h-[8vh] self-end justify-self-end">
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

<script>
import ScrollableBox from './ScrollableBox.vue';
import ScrollBoxByTime from './ScrollBoxByTime.vue'; // Import the component for sorting by time
import ScrollBoxByDistance from './ScrollBoxByDistance.vue'; // Import the component for sorting by distance

export default {
  components: {
    ScrollableBox,
    ScrollBoxByTime,
    ScrollBoxByDistance,
  },
  data() {
    return {
      currentScrollBox: 'ScrollableBox', // Default scroll box
    };
  },
  methods: {
    sortByTime() {
      // Handle sorting by time logic
      this.currentScrollBox = 'ScrollBoxByTime';
    },
    sortByDistance() {
      // Handle sorting by distance logic
      this.currentScrollBox = 'ScrollBoxByDistance';
    },
  },
}
</script>
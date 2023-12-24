
<script setup>
import { ref } from "vue";
import activities from './public/ActivityFakeData/ActivityFakeData.json'; 
</script>

<template>
  <div>
    <div v-for="activity in activities" :key="activity.date" class="relative">
      <div class="w-[18vw] h-[8vh] bg-purple-200 rounded-3xl  mx-auto text-neutral-900 
        text-xl font-normal ">
        <div class="h-[8vh] my-[3vh] text-center align-middle font-'Roboto'">
          {{ activity.title }}
        </div>
      </div>
    </div>
  </div>
</template>

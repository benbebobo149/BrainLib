<template>
  <div >
    <div class="relative">
      <div
        class="w-[20vw] h-[10vh] bg-purple-200 rounded-3xl top-[1rem] absolute text-center text-neutral-900 text-xl font-normal font-'Roboto'">
        <!-- Use a for loop to display 10 names in 10 <h1> tags -->
        <h1 v-for="(name, index) in names.slice(0, 10)" :key="index">{{ name }}</h1>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const names = ref([
  "Alice",
  "Bob",
  "Charlie",
  "David",
  "Emma",
  "Frank",
  "Grace",
  "Henry",
  "Ivy",
  "Jack",
  // Add more names as needed
]);
</script>

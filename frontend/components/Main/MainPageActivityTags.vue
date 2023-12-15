
<script setup>
import { ref } from "vue";
// define props
const props = defineProps({
  activity: {
    type: Object,
    default: () => ({
      title: 'Activity Not Found', author: 'Author Not Found',
      content: 'Content Not Found', topic: 'Topic ', location: 'Location Not Found', date: 'Date Not Found'
    })
  }
});
// change props to ref 
const { activity } = toRefs(props);
</script>

<template>
  <div>
    <div class="relative">
      <div class="w-[18vw] h-[8vh] bg-purple-200 rounded-3xl top-[1rem] absolute mx-auto text-neutral-900 
        text-xl font-normal ">
        <div class="h-[8vh] my-[1vh] text-center font-'Roboto'">
          {{ activity.title }}
        </div>
        <!-- Use a for loop to display 10 names in 10 <h1> tags
        <h1 v-for="(name, index) in names.slice(0, 10)" :key="index">{{ name }}</h1> -->
      </div>
    </div>
  </div>
</template>

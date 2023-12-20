
<script setup>
import { ref } from "vue";
import activities from './public/hello/Pic_Folder/fakeData.json'; // Adjust the path accordingly
// define props
// const props = defineProps({
//   activity: {
//     type: Object,
//     default: () => ({
//       title: 'Activity Not Found', author: 'Author Not Found',
//       content: 'Content Not Found', topic: 'Topic ', location: 'Location Not Found', date: 'Date Not Found'
//     })
//   }
// });
// change props to ref 
// const { activity } = toRefs(props);

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

<template>
  <div class="scrollable-container">
    <div class="w-full flex-row p-4 bg-white" v-for="activity in sortedActivities" :key="activity.id">
      <NuxtLink to="http://localhost:3000/activityPage" class="flex flex-row">
        <img :src="activity.pic" alt="Activity Pic" class="h-auto w-[20vw] mt-8 mb-8" />
        <div class="ml-10">
          <p class="text-2xl text-black font-bold underline mt-2">{{ activity.title }}</p>
          <p class="text-xl text-black mt-10">{{ activity.location }}</p>
          <img src="/hello/Rectangle8.png" alt="Register Button" class="h-[2vh] w-10 mt-10 rounded-full" />
        </div>
        <div class="ml-auto mb-2 flex items-start justify-end">
          <p class="text-xl text-end text-black mt-2 self-startS">{{ activity.date }}</p>
        </div>
      </NuxtLink>
      <div class="ml-auto mb-auto flex items-center justify-end">
        <img src="/hello/GroupStart.png" alt="Register Button" class="h-[5vh] w-auto" @click="showRegistrationPopup" />
      </div>
    </div>
    <RegistrationSuccessPopup v-if="showPopup" @close="closeRegistrationPopup" />
  </div>
</template>


<script setup>
import { ref, watch } from 'vue';
import RegistrationSuccessPopup from './RegistrationSuccessPopup.vue';
import fakeData from './public/hello/Pic_Folder/fakeData.json';

const showPopup = ref(false);

const showRegistrationPopup = () => {
  showPopup.value = true;
};

const closeRegistrationPopup = () => {
  console.log('Closing Registration Popup');
  showPopup.value = false;
};

const activities = ref(fakeData);


const sortedActivities = ref([]);

sortedActivities.value = activities.value.slice().sort((a, b) => new Date(a.date) - new Date(b.date));

watch(activities, () => {
  sortedActivities.value = activities.value.slice().sort((a, b) => new Date(a.date) - new Date(b.date));
});

</script>

<style scoped>
.scrollable-container {
  height: 80%;
  width: 60%;
  margin-top: 15vh;
  overflow-y: scroll;
}
</style>

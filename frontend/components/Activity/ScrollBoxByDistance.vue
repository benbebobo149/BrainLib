<template>
  <div class="scrollable-container">
    <div class="scrollable-box">
      <div class="relative" style="height: 40vh; display: flex; align-items: center; justify-content: center;">
        <img src="/hello/WorldMap.png" alt="Activity Pic" class="w-auto" />
        <label for="locationInput" class="cursor-pointer" @click="showLocation"
          style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">
          <div class="relative">
            <img src="/hello/Rectangle7.png" alt="Centered Image" class="h-[8vh] w-auto" />
            <span class="absolute top-0 left-0 text-white text-lg font-bold p-2">Search</span>
          </div>
        </label>
      </div>
      <div class="mt-10" v-for=" activity in activities" :key="activity.id">
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
    </div>
    <RegistrationSuccessPopup v-if="showPopup" @close="closeRegistrationPopup" />
    <Location v-if="showLocationPopup" @close="closeLocation" />
  </div>
</template>

<script setup>
import { ref } from 'vue';
import RegistrationSuccessPopup from './RegistrationSuccessPopup.vue';
import Location from './Location.vue';
import fakeData from './public/hello/Pic_Folder/fakeData.json';


const showPopup = ref(false);
const showLocationPopup = ref(false);

const showRegistrationPopup = () => {
  showPopup.value = true;
};

const closeRegistrationPopup = () => {
  showPopup.value = false;
};

const showLocation = () => {
  showLocationPopup.value = true;
};

const closeLocation = () => {
  showLocationPopup.value = false;
};

const activities = ref(fakeData);
</script>

<style scoped>
.scrollable-container {
  height: 80%;
  width: 60%;
  margin-top: 15vh;
  overflow-y: scroll;
}

.scrollable-box {
  padding: 16px;
  background-color: #fff;
}

.relative {
  position: relative;
}

.absolute {
  position: absolute;
}

/* Adjust the top-0, left-0, right-0, and text-center values as needed */
.absolute.top-0 {
  top: 0;
}

.absolute.left-0 {
  left: 0;
}

.text-center {
  text-align: center;
}
</style>

<template>
  <div class="scrollable-container">
    <div class="w-full flex-row p-4 bg-white" v-for="(activity, index) in activities" :key="activity.id">
      <NuxtLink to="http://localhost:3000/activityPage" class="flex flex-row">
        <img :src="activity.pic" alt="Activity Pic" class="h-auto w-[20vw] mt-8 mb-8" />
        <div class="ml-10">
          <p class="text-2xl text-black font-bold underline mt-2">{{ activity.title }}</p>
          <p class="text-xl text-black mt-10">{{ activity.location }}</p>
          <div class="flex flex-row">
            <div v-for="tag in activity.tags" :key="tag.tag_id"
              class="bg-purple-200 h-6 w-auto rounded-full text-center text-neutral-900 text-s font-normal px-2 mt-5 ml-2">
              <p class="text-m text-black">{{ tag.tag_name }}</p>
            </div>
          </div>
        </div>
        <div class="ml-auto mb-2 flex items-start justify-end">
          <p class="text-xl text-end text-black mt-2 self-startS">{{ activity.date }}</p>
        </div>
      </NuxtLink>
      <div class="ml-auto mb-auto flex justify-end items-start">
        <img src="/hello/GroupStart.png" alt="Register Button" class="h-[5vh] w-auto mb-5"
          @click="showRegistrationPopup" />
      </div>
      <div v-if="index < activities.length - 1" class="border-b border-black border-1"></div>
    </div>
    <RegistrationSuccessPopup v-if="showPopup" @close="closeRegistrationPopup" />
  </div>
</template>


<script setup>
import { ref } from 'vue';
import RegistrationSuccessPopup from './RegistrationSuccessPopup.vue'; import axios from 'axios';
const config = useRuntimeConfig();

const activities = ref([]);

//get data from database
const getActivityData = () => {
  const token = useCookie('token');
  axios.get(`${config.public.apiURL}/activity/all`, { // config.public.apiURL + "/tag"
  }, {
    headers: {
      'Authorization': 'Bearer ' + token.value,
      'Content-Type': 'application/json',
      'accept': 'application/json'
    }
  })
    .then((res) => {
      // if code is 200, then hide the modal
      console.log(res);
      if (res.status == 200) {
        console.log("success");
        activities.value = res.data;
      }
    })
    .catch((err) => {
      // if code is 401, then show error message 
      console.log(err);
      if (err.response.status == 404) {
        console.log("fail");
      } else if (err.response.status == 500) {
        console.log("fail");
      }
    })
}

getActivityData();
const showPopup = ref(false);

const showRegistrationPopup = () => {
  showPopup.value = true;
};

const closeRegistrationPopup = () => {
  console.log('Closing Registration Popup');
  showPopup.value = false;
};


</script>

<style scoped>
.scrollable-container {
  height: 80%;
  width: 60%;
  margin-top: 15vh;
  overflow-y: scroll;
}
</style>
<template>
  <div class="flex w-full bg-gray-500 h-[28vh]">
    <!-- Left part of the footer (60%) -->
    <div class="w-3/5 h-full bg-slate-100 flex flex-col">
      <p class="text-2xl text-left ml-10 mt-3 text-black font-bold underline">{{ activities.title }}</p>
      <p class="text-2xl text-left ml-10  text-black font-sans mt-[8vh]">{{ activities.location }}</p>
      <p class="text-xl text-left ml-10 mt-3 text-black font-sans">{{ }}</p>
    </div>

    <!-- Right part of the footer (40%) -->
    <div class="w-2/5 h-full bg-slate-100 flex flex-col items-center justify-center">
      <p class="text-black text-3xl font-bold">{{ activities.regNum }}</p>
      <img src="/hello/GroupStart.png" alt="Footer Image" class="h-25 w-60" @click="showRegistrationPopup" />
    </div>
  </div>
  <div class="flex flex-row w-full bg-slate-100 h-[10vh]">
    <div class="w-[5vw] flex flex-col h-full justify-start">
      <!-- <p class="text-xl text-black mt-5 ml-11">Related Tag</p>
      <div class="flex flex-row flex-wrap gap-2 mt-2 ml-2">
        <div v-for="tag in activities.tags" :key="tag.tag_id"
          class="bg-purple-200 rounded text-center text-neutral-900 text-sm font-normal px-2 py-1">
          {{ tag.tag_name }}
        </div>
      </div> -->
    </div>
    <!-- <div class="w-3/4 flex flex-col h-full bg-slate-100">
      <p class="text-black text-[2vw] mt-5">About this event</p>
      <p class="text-black text-xl mx-[2vw] mt-5">{{ activities.content }}</p>
    </div> -->
  </div>
  <div class="flex flex-col w-full bg-gray-400 h-[100vh]">
    <div class="flex w-full h-5/6">
      <div class="flex flex-col w-1/2 h-full ml-5">
        <p class="text-black text-[3vw] font-bold mt-5">About this event</p>
        <!-- <div class="flex flex-col mt-2">
          <p v-if="Array.isArray(activities.agenda)" v-for="(item, index) in activities.agenda" :key="index"
            class="text-black text-xl mt-2">{{ item }}</p>
          <p v-else class="text-black text-2xl">{{ activities.agenda }}</p>
        </div> -->
        <div class="w-3/4 flex flex-col h-full ">
          <p class="text-black text-xl mx-[2vw] mt-5">{{ activities.content }}</p>
        </div>
      </div>

      <div class="flex flex-col w-1/2 h-full">
        <div class="flex flex-col w-full h-1/4">
          <p class="text-black text-2xl font-bold mt-5 ml-10">When</p>
          <p class="text-black text-xl mt-3 ml-10">{{ activities.dateTime }}</p>
        </div>
        <div class="flex flex-col w-full h-3/4">
          <p class="text-black text-2xl font-bold mt-5 ml-10">Where</p>
          <p class="text-black text-xl mt-3 ml-[1vw] self-center">{{ activities.location }}</p>
          <img src="@/public/hello/map2.png" alt="Centered Image" class="h-[40vh] w-[30vw] mt-5 self-center" />
        </div>
      </div>
    </div>
    <!-- <div class="flex flex-row w-full h-1/6 bg-slate-100">
      <div class="flex w-1/3 h-full">
        <p class="text-black text-2xl self-start ml-10 mt-2">Organizers</p>
        <img :src="activities.organizer" alt="Organizers Image" class="w-16 h-16 self-center justify-self-center">
        <p class="text-black text-xl font-bold ml-2 self-center">{{ activities.user }}</p>
      </div>
    </div> -->
    <RegistrationSuccessPopup v-if="showPopup" @close="closeRegistrationPopup" />
  </div>
</template>
<script setup>
import { ref } from 'vue';
import RegistrationSuccessPopup from './RegistrationSuccessPopup.vue';
import axios from 'axios';
const config = useRuntimeConfig();

const activities = ref('');

// define props
const props = defineProps({
  id: {
    type: String,
    required: true
  }
})
// change props to ref 
const { id } = toRefs(props)

//get data from database
const getActivityData = () => {
  const token = useCookie('token');
  axios.get(`${config.public.apiURL}/activity/${id.value}`, { // config.public.apiURL + "/tag"
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
}
</script>
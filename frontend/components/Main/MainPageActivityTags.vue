
<script setup>
import { ref } from "vue";
// import activities from './public/ActivityFakeData/ActivityFakeData.json';
import axios from 'axios';
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
      }else if (err.response.status == 500) {
        console.log("fail");
      }
    })
}

getActivityData();
</script>

<template>
  <div>
    <div v-for="activity in activities" :key="activity.id" class="">
      <div class="w-[18vw] h-full bg-purple-200 rounded-2xl  mx-auto text-neutral-900 
        text-xl font-normal flex-col">
        <NuxtLink :to="'/ActivityPage/'+activity.id" class="h-full font-'Roboto' flex justify-center py-[1vh] my-[2vh]">
          <p class="text-center "> {{ activity.title }}
          </p>
        </NuxtLink>
      </div>
    </div>
  </div>
</template>

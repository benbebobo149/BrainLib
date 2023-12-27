
<script setup>
import { ref } from "vue";
import activities from './public/ActivityFakeData/ActivityFakeData.json';

//get data from database
const getActivityData = () => {
  const token = useCookie('token');
  axios.get(`${config.public.apiURL}/activity`, { // config.public.apiURL + "/tag"

    activity_id: 0,
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
      }
    })
    .catch((err) => {
      // if code is 401, then show error message 
      console.log(err);
      if (err.response.status == 404) {
        console.log("fail");
      }
    })
}


</script>

<template>
  <div>
    <div v-for="activity in activities" :key="activity.date" class="">
      <div class="w-[18vw] h-full bg-purple-200 rounded-2xl  mx-auto text-neutral-900 
        text-xl font-normal flex-col">
        <div class="h-full font-'Roboto' flex justify-center py-[1vh] my-[2vh]">
          <p class="text-center "> {{ activity.title }}
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

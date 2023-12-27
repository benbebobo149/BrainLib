<template>
  <div class="flex w-full bg-gray-500 h-[28vh] ">
    <!-- Left part of the footer (60%) -->
    <div class="w-3/5 h-full bg-slate-100 flex flex-col">
      <p class="text-2xl text-left ml-10 mt-3 text-black font-bold underline">{{ fakeData.title }}</p>
      <p class="text-2xl text-left ml-10 mt-3 text-black font-sans">{{ fakeData.location }}</p>
      <p class="text-xl text-left ml-10 mt-3 text-black font-sans">{{ fakeData.activityDetails }}</p>
    </div>

    <!-- Right part of the footer (40%) -->
    <div class="w-2/5 h-full bg-slate-100 flex flex-col items-center justify-center">
      <p class="text-black text-3xl font-bold">{{ fakeData.regNum }}</p>
      <img src="/hello/GroupStart.png" alt="Footer Image" class="h-25 w-60" @click="showRegistrationPopup" />
    </div>
  </div>
  <div class="flex flex-row w-full bg-slate-100 h-[25vh]">
    <div class="w-1/4 flex flex-col h-full justify-start">
      <p class="text-xl text-black mt-5 ml-11">Related Tag</p>
      <p class="text-l text-black mt-5 ml-11">{{ fakeData.tags }}</p>
    </div>
    <div class="w-3/4 flex flex-col h-full bg-slate-100">
      <p class="text-black text-xl mt-5">About this event</p>
      <p class="text-black text-xl mt-5">{{ fakeData.eventDetails }}</p>
    </div>
  </div>
  <div class="flex flex-col w-full bg-gray-400 h-[100vh]">
    <div class="flex w-full h-5/6">
      <div class="flex flex-col w-1/2 h-full ml-5">
        <p class="text-black text-2xl mt-5">Agenda</p>
        <div class="flex flex-col mt-2">
          <p v-if="Array.isArray(fakeData.agenda)" v-for="(item, index) in fakeData.agenda" :key="index"
            class="text-black text-xl mt-2">{{ item }}</p>
          <p v-else class="text-black text-2xl">{{ fakeData.agenda }}</p>
        </div>
      </div>

      <div class="flex flex-col w-1/2 h-full">
        <div class="flex flex-col w-full h-1/4">
          <p class="text-black text-2xl font-bold mt-5 ml-10">When</p>
          <p class="text-black text-xl mt-3 ml-10">{{ fakeData.whenDetails }}</p>
        </div>
        <div class="flex flex-col w-full h-3/4">
          <p class="text-black text-2xl font-bold mt-5 ml-10">Where</p>
          <p class="text-black text-xl mt-3 ml-10 self-center">{{ fakeData.whereDetails }}</p>
          <img :src="fakeData.map" alt="Centered Image" class="h-auto w-[30vw] mt-5 self-center" />
        </div>
      </div>
    </div>
    <div class="flex flex-row w-full h-1/6 bg-slate-100">
      <div class="flex w-1/3 h-full">
        <p class="text-black text-2xl self-start ml-10 mt-2">Organizers</p>
        <img :src="fakeData.organizer" alt="Organizers Image" class="w-16 h-16 self-center justify-self-center">
        <p class="text-black text-xl font-bold ml-2 self-center">{{ fakeData.name1 }}</p>
      </div>
      <div class="flex w-1/3 h-full justify-center items-center">
        <img :src="fakeData.people2" alt="Organizers Image" class="w-16 h-16 self-center justify-self-center">
        <p class="text-black text-xl font-bold ml-2 self-center">{{ fakeData.name2 }}</p>
      </div>
      <div class="flex w-1/3 h-full justify-center items-center">
        <img :src="fakeData.people2" alt="Organizers Image" class="w-16 h-16 self-center justify-self-center">
        <p class="text-black text-xl font-bold ml-2 self-center">{{ fakeData.name3 }}</p>
      </div>
    </div>
    <RegistrationSuccessPopup v-if="showPopup" @close="closeRegistrationPopup" />
  </div>
</template>
<script setup>
import { ref } from 'vue';
import RegistrationSuccessPopup from './RegistrationSuccessPopup.vue';
import fakeData from './public/hello/Pic_Folder/fakeData3.json';

const showPopup = ref(false);

const showRegistrationPopup = () => {
  showPopup.value = true;
};

const closeRegistrationPopup = () => {
  console.log('Closing Registration Popup');
  showPopup.value = false;
}
</script>


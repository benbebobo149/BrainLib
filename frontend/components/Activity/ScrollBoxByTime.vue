<template>
  <div class="scrollable-container">
    <div class="scrollable-box">
      <!-- Repeat the content as needed -->
      <div class="flex flex-row">
        <img src="/hello/MainPic2.png" alt="Activity Pic" class="h-[20vh] w-auto mt-8 mb-8" />
        <div class="ml-10">
          <p class="text-2xl text-black font-bold underline mt-2">Title</p>
          <p class="text-xl text-black mt-10">Location</p>
          <img src="/hello/Rectangle8.png" alt="Register Button" class="h-[2vh] w-10 mt-10" />
        </div>
        <div class="ml-auto mb-2 flex items-start justify-end">
          <p class="text-xl text-end text-black mt-2">Date</p>
          <img src="/hello/GroupStart.png" alt="Register Button" class="h-[4vh] w-auto self-end"
            @click="showRegistrationPopup" />
        </div>
      </div>
      <!-- Repeat the content as needed -->
    </div>
    <RegistrationSuccessPopup v-if="showPopup" @close="closeRegistrationPopup" />
  </div>
</template>

<script setup>
import RegistrationSuccessPopup from './RegistrationSuccessPopup.vue';
import { ref } from 'vue';

const showPopup = ref(false);

const showRegistrationPopup = () => {
  showPopup.value = true;
};

const closeRegistrationPopup = () => {
  showPopup.value = false;
};
</script>

<style scoped>
.scrollable-container {
  height: 80%;
  width: 60%;
  margin-top: 15vh;
  justify-content: center;
  align-items: center;
  overflow-y: scroll;
}

.scrollable-box {
  padding: 16px;
  background-color: #fff;
}
</style>

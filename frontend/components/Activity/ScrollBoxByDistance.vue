<template>
  <div class="scrollable-container">
    <div class="scrollable-box">
      <div style="position:relative;">

        <!-- WorldMap image -->
        <img src="/hello/WorldMap.png" alt="Activity Pic" class="h-[40vh] w-auto mt-8 mb-8" />

        <!-- Centered image on top of WorldMap -->
        <label for="locationInput" class="cursor-pointer" @click="showLocation"><img src="/hello/Rectangle7.png"
            alt="Centered Image" class="absolute top-1/4 left-1/4 h-[8vh] w-auto" />
        </label>

        <!-- Other content -->
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
      </div>
      <RegistrationSuccessPopup v-if="showPopup" @close="closeRegistrationPopup" />
      <Location v-if="showLocationPopup" @close="closeLocation" />
    </div>
  </div>
</template>

<script setup>
import RegistrationSuccessPopup from './RegistrationSuccessPopup.vue';
import Location from './Location.vue';

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

.absolute {
  position: absolute;
}
</style>

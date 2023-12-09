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

<script>
import RegistrationSuccessPopup from './RegistrationSuccessPopup.vue';

export default {
  components: {
    RegistrationSuccessPopup,
  },
  data() {
    return {
      showPopup: false,
    };
  },
  methods: {
    showRegistrationPopup() {
      this.showPopup = true;
    },
    closeRegistrationPopup() {
      this.showPopup = false;
    },
  },
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


.scrollable-container {
  height: 80%;
  width: 60%;
  margin-top: 15vh;
  justify-content: center;
}

.scrollable-box {
  padding: 16px;
  background-color: #fff;
}

.overlay {
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: #fff;
  z-index: 10;
  display: flex;
  align-items: center;
  justify-content: center;
}

.modal {
  width: 750px;
  background-color: #fff;
  border-radius: 10px;
  padding: 30px;
  position: relative;
  display: flex;
  flex-direction: column;

}
</style>

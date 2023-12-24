<template>
  <div class="popup-overlay">
    <div class="rounded-lg flex flex-col bg-white justify-center items-center">
      <img src="/hello/XLg.png" alt="Register Button" class="h-[3vh] w-auto justify-self-end self-end"
        @click="closePopup">
      <p class="text-3xl text-black font-bold m-10">Registration successful</p>
      <img src="/hello/Confirm.png" alt="Register Button" class="h-[5vh] w-auto" @click="closePopup">
    </div>
  </div>
</template>

<script setup>
const props = defineProps(['show']);
const emit = defineEmits();

const closePopup = () => {
  emit('close');
};
</script>

<style scoped>
.popup-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>

<script setup>
import { defineEmits } from 'vue';

//Emit an event to close the popup when the user clicks on the X button
const emit = defineEmits(['close']);
const closePopup = () => {
  emit('close');
}

const props = defineProps({
  popupMessage: {
    type: String,
    default: 'Default Popup Message',
  }
}) 



</script>
<template>
<div class="popup-overlay">
    <div class="w-[24vw] rounded-lg flex flex-col  bg-white justify-center items-center">
      <img src="@/hello/XLg.png" alt=" Button" class="h-[3vh] w-auto justify-self-end self-end"
        @click="closePopup">
      <p class="text-3xl text-black font-bold m-10">{{popupMessage}}!</p>
      <img src="@/hello/Confirm.png" alt=" Button" class="h-[5vh] w-auto" @click="closePopup">
    </div>
  </div>
</template>


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

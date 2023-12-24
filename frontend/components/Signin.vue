<template>
  <div class="popup-overlay">
    <div  class="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50">
      <div class="bg-white p-6 rounded shadow-md relative">
        <button @click="closeModal" class="absolute top-2 right-2 text-xl font-bold cursor-pointer">&times;</button>
        <div class="text-center mb-4">
          <p class="text-lg font-semibold">Sign in to Brain Library</p>
        </div>
        <div class="flex justify-center gap-4">
          <div>
            <Google class="w-24 h-24" @click="GoogleClick "></Google>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import Google from '@/components/Google.vue';
//import { useCookies } from 'vue-universal-cookies';

const emit = defineEmits(['close_modal'], ['open_modal'], ['GoogleClick']);

const openModal = () => {
  console.log("open model in signin.vue");
  emit('open_modal')
};

const closeModal = () => {
  emit('close_modal')
  console.log("close model in signin.vue");
};

const GoogleClick = () => {
  console.log("GoogleClick in signin.vue");
  emit('close_modal')
  emit('GoogleClick')
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
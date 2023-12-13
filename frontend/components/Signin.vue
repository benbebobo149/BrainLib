<template>
  <div>
   
    <div class="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50">
      <div class="bg-white p-6 rounded shadow-md relative">
        <button @click="closeModal" class="absolute top-2 right-2 text-xl font-bold cursor-pointer">&times;</button>
        <div class="text-center mb-4">
          <p class="text-lg font-semibold">Sign in to Brain Library</p>
        </div>
        <div class="flex justify-center gap-4">
          <div>
            <Google class="w-24 h-24" @click="closeModal "></Google>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
// import { ref } from 'vue';
import Google from '@/components/Google.vue';

const emit = defineEmits(['close_modal'], ['open_modal']);

// const GoogleVisible = ref(false);
// const openModal = () => {
//   GoogleVisible.value = true;
// };
// const closeModal = () => {
//   GoogleVisible.value = false;
// };


const openModal = () => {
  console.log("open model in signin.vue");
  emit('open_modal')
};

const closeModal = () => {
  emit('close_modal')
  console.log("close model in signin.vue");
};

</script>
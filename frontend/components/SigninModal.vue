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
            <Google class="w-24 h-24" @click="checkSingIn"></Google>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import Google from '@/components/Google.vue';
const emit = defineEmits(['close_modal']);

const openModal = () => {
  console.log("open model in signin.vue");
};

const closeModal = () => {
  emit('close_modal')
  console.log("close model in signin.vue");
};

// const checkSingIn = () => {
//   // 接收从 Signin 组件传递过来的值，控制显示与隐藏模态框
//   SigninVisible.value = true;
//   console.log("checkSingIn in signin.vue");
</script>

 
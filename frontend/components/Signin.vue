<template>
  <div>
    <button @click="openModal">
      <img src="Signin.png" alt="Signin">
    </button>
    <div v-if="isModalVisible" class="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50">
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

<script>
import { ref } from 'vue';
import Google from '@/components/Google.vue';

export default {
  name: "Signin",
  components: {
    Google,
  },
  setup() {
    const isModalVisible = ref(false);

    const openModal = () => {
      isModalVisible.value = true;
      console.log("open model in signin.vue");
    };

    const closeModal = () => {
      isModalVisible.value = false;
      console.log("close model in signin.vue");
    };

    // const checkSingIn = () => {
    //   // 接收从 Signin 组件传递过来的值，控制显示与隐藏模态框
    //   SigninVisible.value = true;
    //   console.log("checkSingIn in signin.vue");
    // };

    return {
      isModalVisible,
      openModal,
      closeModal,
      // checkSingIn
    };
  }
};
</script>

 
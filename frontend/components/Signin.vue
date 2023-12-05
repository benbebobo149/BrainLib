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
            <Google class="w-24 h-24"></Google>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Google from '@/components/Google.vue'; // 替换为你的实际组件路径

export default {
  name: "Signin",
  components: {
    Google,
  },
  data() {
    return {
      isModalVisible: false
    };
  },
  methods: {
    openModal() {
      this.isModalVisible = true;
    },
    closeModal() {
      this.isModalVisible = false;
    }
  }
};
</script>
 
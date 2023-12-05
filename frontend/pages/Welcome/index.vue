<template>
  <div>
    <LoginNav></LoginNav>
  </div>

  <div class="w-screen v-screen bg-purple-400">
    <div class="flex w-full h-9/10 bg-red-500">
      <div class="w-1/2 h-full bg-red-400">
        <div class="w-full h-3/4 bg-blue-100 ">
          <img src="Biglogo.png" alt="logo" class="m-auto w-1/2 h-1/2 mt-20">
        </div>
        <div class="flex w-full h-1/4 bg-blue-200">
          <Start class="w-1/3 h-1/3 m-auto mt-5"></Start>
        </div>
      </div>
      <div class="flex w-1/2 h-full bg-yellow-100 m-auto">
        <div class="w-1/3 h-full bg-green-400 m-auto">
          <h1 class="text-5xl font-bold mx-0">學有所成</h1>
        </div>
        <div class="w-2/3 h-full bg-green-500 items-center justify-center">
          <h2 class="text-xl">Share Your Knowledge</h2>
        </div>
      </div>
    </div>
    <div class="flex w-full h-1/10 bg-yellow-100">
      <DoubleDown class="m-auto w-1vw h-1vh"></DoubleDown>
    </div>
  </div>
</template>

<script>
import LoginNav from "@/components/LoginNav.vue";
import Signin from "@/components/Signin.vue";
import DoubleDown from "@/components/Welcome/DoubleDown.vue";
import Start from "@/components/Welcome/Start.vue";

export default {
  name: "Welcome",
  components: {
    LoginNav,
    Signin,
    DoubleDown,
    Start
  },
  data() {
    return {
      isModalVisible: false // 控制模态框显示与隐藏
    };
  },
  methods: {
    toggleModal(value) {
      // 接收从 Signin 组件传递过来的值，控制显示与隐藏模态框
      this.isModalVisible = value;
    },
    closeModal() {
      this.isModalVisible = false; // 点击 "X" 按钮关闭模态框
    }
  }
};

</script>
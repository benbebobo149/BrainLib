<template>
  <div class="w-screen max-w-full h-full overflow-x-hidden	overflow-y-hidden">
    <div @wheel="onWheel" class="w-screen max-w-full h-[93vh] bg-purple-100 -z-30">
      <div class="flex w-full h-[85%]">
        <transition name="slideleft">
          <div v-if="show" class="w-1/2 h-full">
            <div class="flex w-full h-3/4 items-end bg-purple-100">
              <img src="Biglogo.png" alt="logo" class="mx-auto w-auto h-[90%] ">
            </div>
            <div class="flex w-full h-1/4 bg-purple-100">
              <NuxtLink to="/main" class="w-1/3 h-1/3 m-auto">
                <img src="Start.png" alt="GetStart" class="w-auto h-full ">
              </NuxtLink>
            </div>
          </div>
        </transition>
        <transition name="slideright">
          <div v-if="show" class="flex w-1/2 h-full m-auto fixed right-0">
            <div class="w-1/2 h-full m-auto flex items-center">
              <h2 class="text-[5vw] font-bold mx-0 z-10 ">學有所成</h2>
            </div>
            <div class="w-1/2 h-full items-center justify-center flex">
              <h2 class="text-[2vw]">Share Your Knowledge</h2>
            </div>
          </div>
        </transition>
      </div>
      <transition name="fade">
        <div v-if="show" class="flex w-full h-[8%] bg-purple-100 ">
          <NuxtLink to="/main" class=" flex w-auto h-full m-auto">
            <img id="" src="DoubleDown.png" alt="DoubleDown" class="w-auto h-full animate-bounce">
          </NuxtLink>
        </div>
      </transition>
    </div>
  </div>
</template>

<script setup>
const show = ref(false);
const router = useRouter();
const onWheel = (event) => {
  if (event.deltaY > 0) {
    router.push({ name: 'main', params: { transition: 'slide-up' } });
  }
};
onMounted(() => {
  setTimeout(() => {
    show.value = true;
  }, 1000);
});
</script>
<style scoped>
.slideleft-enter-active,
.slideright-enter-active {
  transition: transform 1s ease;
}

.slideleft-enter-from {
  transform: translateX(-100%);
}

.slideright-enter-from {
  transform: translateX(100%);
}
.fade-enter-active{
  transition: opacity 1s ease;
}

/* 透明 */
.fade-enter-from {
  opacity: 0;
}
</style>
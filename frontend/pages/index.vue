<template>
  <div>
    <div class="w-screen max-w-full h-screen  bg-purple-100">
      <div class="flex w-full h-[85%]">
        <div class="w-1/2 h-full">
          <div class="flex w-full h-3/4 items-end bg-purple-100">
            <img src="Biglogo.png" alt="logo" class="mx-auto w-auto h-[90%] ">
          </div>
          <div class="flex w-full h-1/4 bg-purple-100">
            <NuxtLink to="http://localhost:3000/main" class="w-1/3 h-1/3 m-auto">
              <img src="Start.png" alt="GetStart" class="w-auto h-full ">
            </NuxtLink>
          </div>
        </div>
        <div class="flex w-1/2 h-full m-auto  bg-purple-100">
          <div class="w-1/2 h-full m-auto flex items-center">
            <h1 class="text-[5vw] font-bold mx-0">學有所成</h1>
          </div>
          <div class="w-1/2 h-full items-center justify-center flex">
            <h2 class="text-[2vw]">Share Your Knowledge</h2>
          </div>
        </div>
      </div>
      <div class="flex w-full h-[10%] bg-purple-100">
        <NuxtLink to="http://localhost:3000/main" class=" flex w-auto h-full m-auto">
          <img src="DoubleDown.png" alt="DoubleDown" class="w-auto h-full animate-bounce">
        </NuxtLink>
      </div>
    </div>
  </div>
</template>

<script setup>

</script>

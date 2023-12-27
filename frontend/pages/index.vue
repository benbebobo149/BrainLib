<template>
  <div>
    <div class="w-screen max-w-full h-screen  bg-purple-100 -z-30">
      <div class="flex w-full h-[85%]">
        <div id="slideLeft" class="w-1/2 h-full">
          <div class="flex w-full h-3/4 items-end bg-purple-100">
            <img src="Biglogo.png" alt="logo" class="mx-auto w-auto h-[90%] ">
          </div>
          <div class="flex w-full h-1/4 bg-purple-100">
            <NuxtLink to="http://localhost:3000/main" class="w-1/3 h-1/3 m-auto">
              <img src="Start.png" alt="GetStart" class="w-auto h-full ">
            </NuxtLink>
          </div>
        </div>
        <div id="slideRight" class="flex w-1/2 h-full m-auto fixed right-0">
          <div class="w-1/2 h-full m-auto flex items-center">
            <h2 class="text-[5vw] font-bold mx-0 z-10 ">學有所成</h2>
          </div>
          <div class="w-1/2 h-full items-center justify-center flex">
            <h2 class="text-[2vw]">Share Your Knowledge</h2>
          </div>
        </div>
      </div>
      <div class="flex w-full h-[8%] bg-purple-100 ">
        <NuxtLink to="http://localhost:3000/main" class=" flex w-auto h-full m-auto">
          <img id="" src="DoubleDown.png" alt="DoubleDown" class="w-auto h-full animate-bounce">
        </NuxtLink>
      </div>
    </div>
  </div>
</template>

<script setup>

</script>
<style scoped>
#slideLeft {
  position: absolute;
  left: -600px;
  background: blue;
  -webkit-animation: slide 0.5s forwards;
  -webkit-animation-delay: 1.5s;
  animation: slide 1.5s forwards;
  animation-delay: 0.5s;
}

@-webkit-keyframes slide {
  100% {
    left: 0;
  }
}

@keyframes slide {
  100% {
    left: 0;
  }
}

#slideRight {
  position: absolute;
  right: -800px;
  -webkit-animation: slideRight 0.5s forwards;
  -webkit-animation-delay: 1.5s;
  animation: slideRight 1.5s forwards;
  animation-delay: 1.5s;
}

@-webkit-keyframes slideRight {
  100% {
    right: 0;
  }
}

@keyframes slideRight {
  100% {
    right: 0;
  }
}


/* 動畫 但還沒有寫好
h1::before {  
  transform: scaleX(0);
  transform-origin: bottom right;
}

h1:hover::before {
  transform: scaleX(1);
  transform-origin: bottom left;
}

h1::before {
  content: " ";
  display: block;
  position: relative;
  right: 50vh;
  height: 20vh;
  inset: 0 0 0 0;
  background: hsl(200 100% 80%);
  z-index: -1;
  transition: transform .3s ease;
} */

/* h1 {
  position: relative;
  font-size: 5rem;
} */
/* 
html {
  block-size: 100%;
  inline-size: 100%;
} */

/* body {
  min-block-size: 100%;
  min-inline-size: 100%;
  margin: 0;
  box-sizing: border-box;
  display: grid;
  place-content: center;
  font-family: system-ui, sans-serif;
} */

</style>
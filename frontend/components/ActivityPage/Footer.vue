<template>
  <div class="flex w-full bg-gray-500 h-[28vh] ">
    <!-- Left part of the footer (60%) -->
    <div class="w-3/5 h-full bg-slate-100 flex flex-col">
      <p class="text-2xl text-left ml-10 mt-3 text-black font-bold underline">Title</p>
      <p class="text-2xl text-left ml-10 mt-3 text-black font-sans">Location</p>
      <p class="text-2xl text-left ml-10 mt-3 text-black font-sans">Activity details</p>
    </div>

    <!-- Right part of the footer (40%) -->
    <div class="w-2/5 h-full bg-slate-100 flex flex-col items-center justify-center">
      <p class="text-black text-3xl font-bold">0</p>
      <button @click="handleButtonClick" class="flex items-end focus:outline-none">
        <img src="/hello/GroupStart.png" alt="Footer Image" class="h-25 w-60" />
      </button>
    </div>
  </div>
  <div class="flex flex-row w-full bg-gray-200 h-[25vh] ">
    <div class="w-1/4 flex h-full">
      <p class=text-black text-2xl>left part</p>
    </div>
    <div class="w-3/4 flex h-full bg-white">
      <p class=text-black text-2xl>right part</p>
    </div>
  </div>
  <div class="flex flex-col w-full bg-red-500 h-[93vh]">
    <div class="flex w-full h-5/6 bg-gray-500">
      <p class=text-black text-2xl>top</p>
    </div>
    <div class="flex w-full h-1/6 bg-yellow-500">
      <p class=text-black text-2xl>bottom</p>
    </div>
  </div>
</template>
<script>
export default {
  methods: {
    handleButtonClick() {
      // Add your button click logic here
      console.log('Button Clicked!');
    },
  },
};
</script>


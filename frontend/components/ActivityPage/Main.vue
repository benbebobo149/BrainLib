<template>
  <div>
    <div class="w-full bg-gray-500 h-[65vh] flex items-center justify-center">
      <img :src="fakeData.mainImage" alt="Main Image" class="w-full h-[65vh]" />
    </div>
  </div>
</template>

<script setup>
import fakeData from './public/hello/Pic_Folder/fakeData3.json'; 
</script>

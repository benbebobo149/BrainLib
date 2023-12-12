<template>
  <div class="flex h-[92vh]">
    <!-- Left Section -->
    <div class="w-1/2 h-full flex flex-col">
      <!-- Top Section (1/4 height) -->
      <div class="h-1/4 flex bg-slate-50 text-black">
        <!-- Left Subsection (1/3 width) -->
        <div class="w-1/3 bg-slate-50 p-8">
        </div>

        <!-- Right Subsection (2/3 width) -->
        <div class="w-2/3 bg-slate-50 p-8 flex items-center justify-center">
          <img src="/hello/Ellipse2.png" alt="username" class="w-auto h-[8vh]" />
          <div class="text-black text-3xl font-bold ml-4">
            Username
          </div>
        </div>
      </div>
      <div class="h-3/4 flex bg-slate-50 p-6 items-start justify-end">

        <div class="flex-col justify-start">
          <div>
            <input type="text" class="text-black text-2xl" :style="{ fontSize: fontSize[0] }" @input="updateContent(0)"
              placeholder="Add Topic">
          </div>
          <div class="mt-10">
            <input type="text" class="text-black text-2xl" :style="{ fontSize: fontSize[1] }" @input="updateContent(1)"
              placeholder="Add Title">
          </div>
          <div class="mt-10">
            <input type="text" class="text-black text-2xl" :style="{ fontSize: fontSize[2] }" @input="updateContent(2)"
              placeholder="Description">
          </div>
        </div>
      </div>

    </div>

    <!-- Right Section -->
    <div class="w-1/2 h-full flex flex-col">
      <!-- Top Subsection (1/4 height) -->
      <div class="flex flex-row h-1/4 bg-slate-50 text-black justify-center items-end p-8">
        <label for="fileInput" class="cursor-pointer">
          <img src="/hello/AddFile.png" alt="Add file" class="w-auto h-[4vh] mr-10">
        </label>
        <label for="tagInput" class="cursor-pointer" @click="showRegistrationPopup">
          <img src="/hello/AddTag.png" alt="Add tag" class="w-auto h-[4vh] mr-10">
        </label>
        <img src="/hello/Preview.png" alt="Preview" class="w-auto h-[4vh] mr-10">
        <input id="fileInput" type="file" style="display: none;" @change="handleFileChange" />
        <AddTag v-if="showPopup" @close="closeRegistrationPopup" />
      </div>

      <!-- Bottom Subsection (3/4 height) -->
      <div class="h-3/4 bg-slate-50 text-black p-8">
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import AddTag from './AddTag.vue';

const fontSize = ref(["1rem", "1rem", "1rem"]);

const updateContent = (index) => {
  const element = document.querySelector(`[contenteditable]:nth-child(${index + 1})`);
  const content = element.innerText;
};

const handleFileChange = () => {
}

const showPopup = ref(false);

const showRegistrationPopup = () => {
  showPopup.value = true;
};

const closeRegistrationPopup = () => {
  showPopup.value = false;
};
</script>

<style scoped>
[contenteditable] {
  overflow-wrap: break-word;
}

input::placeholder,
input {
  font-size: 25px;
  color: black;
  height: 40px;
  width: 100%;
}
</style>

<template>
  <div class="bg-slate-50">
    <div class="flex h-[22vh]">
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


      </div>

      <!-- Right Section -->
      <div class="w-1/2 h-full flex flex-col">
        <!-- Top Subsection (1/4 height) -->
        <div class="flex flex-row h-1/4 bg-slate-50 text-black justify-center items-end p-8">
          <label for="tagInput" class="cursor-pointer" @click="showRegistrationPopup">
            <img src="/hello/AddTag.png" alt="Add tag" class="w-auto h-[4vh] mr-10">
          </label>
          <img src="/hello/Preview.png" alt="Preview" class="w-auto h-[4vh] mr-10">
          <input id="fileInput" type="file" style="display: none;" @change="handleFileChange" />
          <AddTag v-if="showPopup" class="z-10" @close="closeRegistrationPopup" />
        </div>

        <!-- Bottom Subsection (3/4 height) -->

      </div>
    </div>
    <div class="w-screen flex flex-col justify-center items-center">
      <h1 class="text-[2vw] font-bold text-terotory text-center">輸入框示範</h1>
      <Editor class="w-[60%]" />
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import AddTag from '@/components/CreatePost/AddTag.vue';
// import Editor.vue
import Editor from '@/components/codeTemplate/Editor.vue'

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

const tags = ref([]);
const addTags = (tag) => {
  tags.value.push(tag);
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

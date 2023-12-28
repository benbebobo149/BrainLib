<template>
  <div class="bg-slate-50">
    <div class="flex h-[12vh]">
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
          <AddTag v-if="showPopup" class="z-10" @close="closeRegistrationPopup" @additem="addTags" />
        </div>

        <!-- Bottom Subsection (3/4 height) -->

      </div>
    </div>
    <div class="h-[12vh]">
      <!-- <addedTags /> -->

    </div>
    <div class="w-screen bg-slate-50 flex flex-col justify-center items-center">
      <h1 class="text-[2vw] font-bold text-terotory text-center">Create Post</h1>
      <div class="my-[2vh] flex">
        <P>
          tags:
        </P>
        <div v-for="tag in tags" class="mx-[1vw] flex" @click="removeTag">
          <div
            class="mx-auto rounded-sm border border-terotory text-center text-neutral-900 text-l font-normal font-'Roboto' leading-7 p-[0.5vh] cursor-pointer">
            {{ tag }}
          </div>
        </div>
      </div>

      <Editor class="w-[60%]" @openSucc="() => succVisible = true" @openError="errorVisible = false" />
    </div>
  </div>
  <BoxSucc v-if="succVisible" class="z-10" @close="succVisible = false"></BoxSucc>
  <BoxError v-if="errorVisible" @close="errorVisible = false"></BoxError>
</template>

<script setup>
import { ref } from 'vue';
import AddTag from '@/components/CreatePost/AddTag.vue';
// import Editor.vue
import Editor from '@/components/CreatePost/Editor.vue'
import BoxSucc from '@/components/ModelBox/BoxSucc.vue';
import BoxError from '@/components/ModelBox/BoxError.vue';

const succVisible = ref(false);
const errorVisible = ref(false);



const updateContent = (index) => {
  const element = document.querySelector(`[contenteditable]:nth-child(${index + 1})`);
  const content = element.innerTezxt;
};

const showPopup = ref(false);

const showRegistrationPopup = () => {
  showPopup.value = true;
};

const closeRegistrationPopup = () => {
  showPopup.value = false;
};






//tags
const tags = ref([]);
//added tags
const addTags = (tag) => {
  tags.value.push(tag);
};
//remove tags
// Remove tag
const removeTag = (index) => {
  if (window.confirm('Are you sure you want to remove this tag?')) {
    tags.value.splice(index, 1);
  }
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

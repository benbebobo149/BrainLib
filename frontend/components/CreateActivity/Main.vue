<template>
  <div class="flex h-[92vh]">
    <div class="w-1/2 h-full flex flex-col">
      <div class="h-1/4 flex bg-slate-50 text-black">
        <div class="w-1/3 bg-slate-50 p-8"></div>
        <div class="w-2/3 bg-slate-50 p-8 flex items-center justify-center">
          <img src="/hello/Ellipse2.png" alt="username" class="w-auto h-[8vh]" />
          <div class="text-black text-3xl font-bold ml-4">{{ fakeData.username }}</div>
        </div>
      </div>
      <div class="h-3/4 flex bg-slate-50 p-6 items-start justify-end">
        <div class="h-full flex flex-col">
          <div class="h-1/3">
            <div class="flex flex-row text-black text-xl text-bold items-start justify-start mb-5">
              Tags:
            </div>
            <div v-for="(tag, index) in tags" :key="index" class="tag">
              {{ tag }}
            </div>
            <label for="fileInput" class="cursor-pointer flex items-center">
              <div class="text-black text-3xl text-bold mr-2">Upload Picture</div>
              <img src="/hello/Vector2.png" alt="Upload Button" class="w-auto h-[5vh] mr-10">
            </label>
            <input id="fileInput" type="file" style="display: none;" @change="handleFileChange" />
          </div>
          <div class="h-2/3 flex-col justify-start">
            <div>
              <input type="text" class="text-black text-2xl bg-slate-50" :style="{ fontSize: fontSize[0] }"
                @input="updateContent(0)" placeholder="Enter Title">
            </div>
            <div class="mt-10">
              <input type="text" class="text-black text-2xl  bg-slate-50" :style="{ fontSize: fontSize[1] }"
                @input="updateContent(1)" placeholder="Enter Address">
            </div>
            <div class="mt-10">
              <input type="text" class="text-black text-2xl  bg-slate-50" :style="{ fontSize: fontSize[2] }"
                @input="updateContent(2)" placeholder="Enter Description">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="w-1/2 h-full flex flex-col">
      <div class="flex flex-row h-1/4 bg-slate-50 text-black justify-center items-end p-8">
        <label for="fileInput" class="cursor-pointer">
          <img src="/hello/AddFile.png" alt="Add file" class="w-auto h-[4vh] mr-10">
        </label>
        <label for="tagInput" class="cursor-pointer" @click="showRegistrationPopup">
          <img src="/hello/AddTag.png" alt="Add tag" class="w-auto h-[4vh] mr-10">
        </label>
        <NuxtLink to="http://localhost:3000/activityPage" class="self-end justify-self-end">
          <img src="/hello/Confirm.png" alt="Preview" class="w-auto h-[5vh] mr-10">
        </NuxtLink>
        <input id="fileInput" type="file" style="display: none;" @change="handleFileChange" />
        <AddTag v-if="showPopup" @close="closeRegistrationPopup" @save="handleSaveTag" />
      </div>
      <div class="h-3/4 bg-slate-50 text-black p-8">
        <div class="tag-container">
          <div v-for="(tag, index) in tags" :key="index" class="tag">
            {{ tag }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import AddTag from './AddTag.vue';
import fakeData from './public/hello/Pic_Folder/fakeData2.json'; // Adjust the path accordingly

const fontSize = ref(["1rem", "1rem", "1rem"]);
const tags = ref([]);

const updateTags = (tag) => {
  tags.value.push(tag);
};

const handleFileChange = () => {
  // Handle file change logic
};

const showPopup = ref(false);

const showRegistrationPopup = () => {
  showPopup.value = true;
};

const closeRegistrationPopup = () => {
  showPopup.value = false;
};

const handleSaveTag = (tag) => {
  updateTags(tag);
  closeRegistrationPopup();
};

// Load fake data on component mount
onMounted(() => {
  // Populate data from fakeData
  tags.value = fakeData.tags;
  fontSize.value = ["2rem", "2rem", "2rem"]; // Adjust font sizes as needed
});
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

.tag-container {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  display: flex;
  flex-wrap: wrap;
}

.tag {
  background-color: white;
  border: 1px solid black;
  padding: 5px;
  margin: 5px;
  color: black;
}
</style>

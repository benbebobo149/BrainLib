<template>
  <div class="popup-overlay">
    <div class="rounded-lg flex flex-col bg-white justify-center items-center p-5">
      <img src="/hello/XLg.png" alt="Close Button" class="h-[3vh] w-auto justify-self-end self-end cursor-pointer"
        @click="closePopup">
      <p v-if="errorMsg" class="text-red-600"> 請至少選一個 ! </p>
      <div class="relative mb-4">
        <img src="/hello/Rectangle7.png" alt="Rectangle Box" class="h-[8vh] w-auto cursor-pointer" />
        
        <select v-model="selectedTag" class="absolute top-0 left-0 right-0 bottom-0 p-2 w-full h-full bg-transparent border-none rounded-full">
          <option value="-1">請選擇要加入的Tag</option>
          <option v-for="tag in tagList" :value=tag.id> {{ tag.tagName }}</option>
        </select>
      </div>

      <img src="/hello/Confirm.png" alt="Save and Close Button" class="h-[5vh] w-auto mt-4 cursor-pointer"
        @click="saveAndClosePopup">
    </div>
  </div>
</template>

<script setup>
import { ref, defineEmits } from 'vue';
import axios from 'axios';
const config = useRuntimeConfig();
const tagList = ref([]);
const emit = defineEmits();
const errorMsg = ref(false);
const selectedTag = ref(-1);
const closePopup = () => {
  emit('close');
};

const getTag = () => {
  axios.get(`${config.public.apiURL}/tag`, {
    headers: {
      'Content-Type': 'application/json',
    }
  })
    .then(response => {
      tagList.value = response.data;
    })
    .catch(error => {
      console.error(error);
    });
}


const saveAndClosePopup = () => {

  // 如果沒有選擇 tag 就顯示錯誤訊息
  if(selectedTag.value == -1){
    errorMsg.value = true;
    return;
  }
  errorMsg.value = false;
  // 透過 selectedTag.value 取得選擇的 tag id 在 tagList 中拿到對應的 tag
  const selectedTagObj = tagList.value.find(tag => tag.id == selectedTag.value);
  emit('additem', selectedTagObj);
  emit('close');
  closePopup();
}
getTag();
</script>

<style scoped>
.popup-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}

.relative {
  position: relative;
}
</style>


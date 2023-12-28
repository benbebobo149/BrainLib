<template>
  <div class="popup-overlay">
    <div class="rounded-lg flex flex-col bg-white justify-center items-center p-5">
      <img src="/hello/XLg.png" alt="Close Button" class="h-[3vh] w-auto justify-self-end self-end cursor-pointer"
        @click="closePopup">

      <div class="relative mb-4">
        <img src="/hello/Rectangle7.png" alt="Rectangle Box" class="h-[8vh] w-auto cursor-pointer" />

        <input v-model="enteredText"
          class="absolute top-0 left-0 right-0 bottom-0 p-2 w-full h-full bg-transparent border-none rounded-full"
          placeholder="Enter your text" @keyup.enter="saveAndClosePopup" />
      </div>

      <img src="/hello/Confirm.png" alt="Save and Close Button" class="h-[5vh] w-auto mt-4 cursor-pointer"
        @click="saveAndClosePopup">
    </div>
  </div>
</template>

<script setup>
import { ref, defineEmits } from 'vue';

const enteredText = ref('');
const emit = defineEmits();
const closePopup = () => {
  emit('close');
};

// const saveAndClosePopup = () => {
//   console.log('Entered Text:', enteredText.value);
//   emit('close');
//   closePopup();
// };

const saveAndClosePopup = () => {
  // 加上 trim() 去除頭尾空白並防止沒鍵入文字
  // var value = this.newTodo.trim;
  // 如果輸入欄空白就不會往下執行
  if (enteredText.value) {
    console.log('Entered Text:', enteredText.value);
    emit('additem', enteredText.value);
    enteredText.value = '';
    emit('close');
    closePopup();
    return;
  }
  emit('close');
  closePopup();
}
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


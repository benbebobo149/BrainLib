<script setup>
// import editor from components/codeTemplate/Editor.vue
import Editor from '@/components/codeTemplate/Editor.vue'
const messages = ref([])
const newMessage = ref('')
const sendMessage = () => {

}
</script>
<template>
    <div class="w-screen flex flex-col justify-center items-center">
        <h1 class="text-[3vw] font-bold text-center">輸入框示範</h1>
        <Editor class="w-[80%]"/>
    </div>
</template>

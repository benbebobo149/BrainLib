<template>
    <button @click="openModal" class="w-auto h-full">
        <img src="@/PhotoSticker.png" class="w-auto h-[80%]" alt="PhotoSticker">
    </button>
    <div v-if="PhotoListVisible" class="fixed w-[15%] h-[25%] bg-purple-50 flex  mt-[7vh]">
        <button @click="closeModal" class="h-[3%] absolute left-0 text-md font-bold cursor-pointer">&times;</button>
        <div class="w-full h-auto bg-purple-50 items-center justify-center ml-2">
            <div class="flex h-[25%] w-auto p-1">
                <NuxtLink to="http://localhost:3000/personal" class="w-[20%] h-auto flex justify-center">
                    <img src="/PhotoSticker/PersonalProfile.png" alt="" class="w-full h-auto">
                </NuxtLink>
                <NuxtLink to="http://localhost:3000/personal" class="text-[1vw] flex items-center w-[80%] h-auto ml-5">
                    <p>Personal Profile</p>
                </NuxtLink>
            </div>
            <div class="flex h-1/4 w-full p-1">
                <NuxtLink to="http://localhost:3000/personal/Change" class="w-[20%] h-auto flex justify-center">
                    <img src="/PhotoSticker/Edit.png" alt="" class="w-full h-auto">
                </NuxtLink>
                <NuxtLink to="http://localhost:3000/personal/Change" class="text-[1vw] flex items-center ml-5 w-[80%] h-auto">
                    <p>Edit Profile</p>
                </NuxtLink>
            </div>
            <div class="flex h-1/4 w-full p-1">
                <button @click="LogOut" class="w-[20%] h-auto flex justify-center">
                    <img src="/PhotoSticker/LogOut.png" alt="" class="w-full h-auto">
                </button>
                <button @click="LogOut" class="text-[1vw] flex items-center w-[80%] h-auto ml-5">
                    <p>Log out</p>
                </button>
                
            </div>
            
            <div v-if="Admin" class="flex h-1/4 w-full p-1">
                <NuxtLink to="./" class="w-[20%] h-auto flex justify-center">
                    <img src="/PhotoSticker/Admin.png" alt="" class="w-full h-auto">
                </NuxtLink>
                <NuxtLink class="text-[1vw] flex items-center ml-5 w-[80%] h-auto">
                    <p>Admin Page</p>
                </NuxtLink>
            </div>
        </div>
    </div>
</template>
  
<script setup>
import { ref } from 'vue';

const PhotoListVisible = ref(false);

const openModal = () => {
    PhotoListVisible.value = true;
    console.log("open model in PhotoSticker.vue");
};

const closeModal = () => {
    PhotoListVisible.value = false;
};

const LogOut = () => {
    console.log("LogOut in PhotoSticker.vue");
    alert("確認是否登出");
};

const Admin = ref(false);
</script>
<template>
    <div class="flex x-0 w-screen max-w-full h-[7vh] bg-bgcolor shadow-md " ></div>
    <div class="top-0 z-10 flex w-screen max-w-full h-[7vh] fixed bg-purple-50 shadow-md">
        <div class="flex w-1/2 h-full">
            <div class="flex w-auto h-full ml-4">
                <ListNav class="w-auto h-[8vh]" />
            </div>
            <div class="flex w-4/5 h-full items-center ml-5">
                <label for="name" class="w-auto h-full flex items-center">
                    <img src="Search.png" alt="Search" class="w-auto h-full cursor-pointer p-2.5">
                </label>
                <input type="text" id="name" placeholder="    Search" v-model="SearchContent"
                    class="w-5/6 h-3/4 rounded-full bg-secondary2">
            </div>
        </div>

        <div v-if="NotSignin" class="flex justify-end w-1/2 h-auto">
            <button @click="openModal()" class="w-[15%] h-auto">
                <img src="Signin.png" alt="Signin" class="w-auto h-[80%]">
            </button>


        </div>


        <div v-else class="flex w-1/2 h-full justify-end">
            <NuxtLink to="./" class="flex w-auto h-full items-center mr-[3vw]">
                <img src="PencilSquare.png" alt="PencilButton" class="w-auto h-[85%]">
            </NuxtLink>
            <NuxtLink to="http://localhost:3000/chat" class="flex w-auto h-full items-center mr-[3vw]">
                <img src="Chat.png" alt="Chat" class="w-auto h-[85%]">
            </NuxtLink>
            <!-- <button class="flex w-auto h-full items-center mr-[3vw]">
                <img src="PhotoSticker.png" alt="" class="w-auto h-[85%]">
            </button> -->
            <PhotoSticker class="flex w-auto h-full items-center mr-[3vw]"/>
        </div>

    </div>
    <Signin v-if="EnterVisible" @close_modal="closeModal()" @GoogleClick="GoogleClick" class="z-20" />
   
</template>

<script setup>
import { ref } from 'vue';
import ListNav from "./ListNav.vue";
import Signin from "./Signin.vue";
import PhotoSticker from "./PhotoSticker.vue";


const EnterVisible = ref(false);

const NotSignin = ref(true);
const openModal = () => {
    EnterVisible.value = true;
    console.log("open model in InPageNav.vue");
};
const closeModal = () => {
    EnterVisible.value = false;
    console.log("close model in InPageNav.vue");
};
const Photo = ref('');
Photo.value = 'PhotoSticker.png';

const SearchContent = ref('');

const GoogleClick = () => {
    NotSignin.value = false;
    console.log("GoogleClick in InPageNav.vue");
    // const NotSignin = useCookie(false)
    // console.log(NotSignin)
};


</script>

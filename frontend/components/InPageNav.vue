<template>
    <div class="flex x-0 w-screen max-w-full h-[7vh] bg-bgcolor shadow-md "></div>
    <div class="top-0 z-10 flex w-screen max-w-full h-[7vh] fixed bg-purple-50 shadow-md">
        <div class="flex w-1/2 h-full">
            <div class="flex w-auto h-full ml-4">
                <ListNav class="w-auto h-[8vh]" />
            </div>
            <div class="flex w-4/5 h-full items-center ml-5">
                <label for="name" class="w-auto h-full flex items-center">
                    <img src="@/Search.png" alt="Search" class="w-auto h-full cursor-pointer p-2.5">
                </label>
                <input type="text" id="name" placeholder="Search" v-model="SearchContent"
                    class="w-5/6 h-3/4 rounded-full bg-secondary2 pl-[2vw] box-border">
            </div>
        </div>

        <div v-if="NotSignin" class="flex justify-end w-1/2 h-auto">
            <button @click="openModal()" class="w-[15%] h-auto">
                <img src="@/Signin.png" alt="Signin" class="w-auto h-[80%]">
            </button>
        </div>

        <div v-else class="flex w-1/2 h-full justify-end">
            <NuxtLink to="http://localhost:3000/postCreate" class="flex w-auto h-full items-center mr-[3vw]">
                <img src="@/PencilSquare.png" alt="PencilButton" class="w-auto h-[85%]">
            </NuxtLink>
            <NuxtLink to="http://localhost:3000/chat" class="flex w-auto h-full items-center mr-[3vw]">
                <img src="@/Chat.png" alt="Chat" class="w-auto h-[85%]">
            </NuxtLink>
            <PhotoSticker class="flex w-auto h-full items-center mr-[3vw]" />
        </div>
    </div>
    <Signin v-if="EnterVisible" @close_modal="closeModal()" @GoogleClick="GoogleClick($event)" class="z-20" />
</template>

<script setup>
import { ref } from 'vue';
import ListNav from "./ListNav.vue";
import Signin from "./Signin.vue";
import PhotoSticker from "./PhotoSticker.vue";
import axios from 'axios';
const config = useRuntimeConfig();
//import { useCookie } from "vue-cookie";

// const user = useCookie('user');
// console.log(user);
const user = ref(null);

// const setUserCookie = (value) => {
//     user.value = value;
//     useCookie.set('user', user, 1); 
//     console.log("user.value");
// };

const EnterVisible = ref(false);

const NotSignin = ref(true);

//const google_token = ref(null);

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

    // google_token.value = 'token';
    // useCookie.set('google_token', google_token, 1); // 保存 1 天
    console.log("GoogleClick in InPageNav.vue");
    sendData();
};

const CheckLoggin = () => {
    const google_token = useCookie('token');
    if (google_token.value == null) {
        NotSignin.value = true;
    } else {
        NotSignin.value = false;
    }
};
CheckLoggin();

const sendData = () => {
    axios.post(`${config.public.apiURL}/authenticate`, {

        "name": "jake",
        "email": "16789@hhdbuc"
    }, {
        headers: {
            // 'Authorization': 'Bearer ' + token.value,
            'Content-Type': 'application/json',
            'accept': 'application/json'
        }
    })
        .then((res) => {
            // if code is 200, then hide the modal
            console.log(res);
            if (res.status == 200) {
                const token = useCookie('token');
                token.value = res.data.token;
            }
        })
        .catch((err) => {
            // if code is 401, then show error message 
            console.log(err);
            // if (err.response.status == 401) {

            // }
        })
}

</script>

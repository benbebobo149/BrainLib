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
                    <SearchSticker v-if="isInputFocused" :datas="SearchData" @mousedown.prevent />
                </label>
                <input type="text" id="name" placeholder="Search Post Title" v-model="SearchContent"
                    class="w-5/6 h-3/4 rounded-full bg-secondary2 pl-[2vw] box-border" @focus="isInputFocused = true"
                    @blur="isInputFocused = false" autocomplete="off">
            </div>
        </div>

        <div v-if="NotSignin" class="flex justify-end w-1/2 h-auto">
            <button @click="openModal()" class="w-[15%] h-auto">
                <img src="@/Signin.png" alt="Signin" class="w-auto h-[80%]">
            </button>
        </div>

        <div v-else class="flex w-1/2 h-full justify-end">
            <NuxtLink>

            </NuxtLink>
            <NuxtLink to="/postCreate" class="flex w-auto h-full items-center ">
                <img src="@/PencilSquare.png" alt="PencilButton" class="w-auto h-[85%]">
            </NuxtLink>
            <div class="flex w-auto h-full items-center mr-[3vw] text-yellow-900 text-[1vw] ">
                <NuxtLink to="/postCreate">
                    <p class="pl-[1vw]"> Create post</p>
                </NuxtLink>
            </div>
            <PhotoSticker class="flex w-auto h-full items-center mr-[3vw]" />
        </div>
    </div>
    <Signin v-if="EnterVisible" @close_modal="closeModal()" class="z-20" />
</template>

<script setup>
import { ref } from 'vue';
import ListNav from "./ListNav.vue";
import Signin from "./Signin.vue";
import PhotoSticker from "./PhotoSticker.vue";
import SearchSticker from "./SearchSticker.vue";
const config = useRuntimeConfig();
const EnterVisible = ref(false);
import axios from 'axios';
const NotSignin = ref(true);
const isInputFocused = ref(false);

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
const SearchData = ref([]);
const SearchContent = ref('');
watch(SearchContent, (newValue, oldValue) => {

    const getSearchData = async () => {
        await axios.get(`${config.public.apiURL}/post/search`, {
            params: {
                keyword: SearchContent.value, // 这里假设你的关键词存储在 input.value 中
            }
        })
            .then(response => {
                console.log(response.data);
                SearchData.value = response.data;
            })
            .catch(error => {
                console.log(error);
            });
    }
    if (newValue.length > 0) {
        getSearchData();
    } else {
        SearchData.value = [];
    }
});

const CheckLoggin = () => {
    const google_token = useCookie('token');
    if (google_token.value == null) {
        NotSignin.value = true;
    } else {
        NotSignin.value = false;
    }
};
CheckLoggin();
</script>

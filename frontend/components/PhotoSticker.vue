<template>
    <button @click="openModal" class="w-auto h-full">
        <img :src="image || 'https://via.placeholder.com/95x96 '" class="w-auto h-[80%]" alt="PhotoSticker">
    </button>
    <Transition>
        <div @click="closeModal" v-if="PhotoListVisible" class="fixed inset-0 flex w-screen h-screen max-h-full">
            <div class="PhotoList fixed w-[15%] h-auto bg-purple-50 flex  mt-[7vh] right-0">
                <div class="w-full h-auto bg-purple-50 items-center justify-center">
                    <div class="hover:bg-purple-100 ease-in-out flex h-[6.5vh] w-auto p-1">
                        <NuxtLink to="/personal" class="w-[20%] h-auto flex justify-center">
                            <img src="/PhotoSticker/PersonalProfile.png" alt="" class="w-full h-auto">
                        </NuxtLink>
                        <NuxtLink to="/personal" class="text-[1vw] flex items-center w-[80%] h-auto ml-5">
                            <p>Personal Profile</p>
                        </NuxtLink>
                    </div>
                    <div class="hover:bg-purple-100 flex h-[6.5vh] w-full p-1">
                        <NuxtLink to="/personal/Change" class="w-[20%] h-auto flex justify-center">
                            <img src="/PhotoSticker/Edit.png" alt="" class="w-full h-auto">
                        </NuxtLink>
                        <NuxtLink to="/personal/Change" class="text-[1vw] flex items-center ml-5 w-[80%] h-auto">
                            <p>Edit Profile</p>
                        </NuxtLink>
                    </div>
                    <div class="flex h-[6.5vh] w-full p-1 hover:bg-purple-100">
                        <button @click="LogOut" class="w-[20%] h-auto flex justify-center">
                            <img src="/PhotoSticker/LogOut.png" alt="" class="w-full h-auto">
                        </button>
                        <button @click="LogOut" class="text-[1vw] flex items-center w-[80%] h-auto ml-5">
                            <p>Log out</p>
                        </button>
                    </div>
                    <div v-if="permission == 2" class="hover:bg-purple-100 flex h-[6.5vh] w-full p-1">
                        <NuxtLink to="/admini" class="w-[20%] h-auto flex justify-center">
                            <img src="/PhotoSticker/Admin.png" alt="" class="w-full h-auto">
                        </NuxtLink>
                        <NuxtLink to="/admini" class="text-[1vw] flex items-center ml-5 w-[80%] h-auto">
                            <p>Admin Page</p>
                        </NuxtLink>
                    </div>
                </div>
            </div>
        </div>
    </Transition>
</template>
  
<script setup>
import { ref } from 'vue';
const image = useCookie('image');
const permission = useCookie('permission');
const PhotoListVisible = ref(false);

const openModal = () => {
    PhotoListVisible.value = !PhotoListVisible.value;
    console.log("open model in PhotoSticker.vue");
};

const closeModal = () => {
    PhotoListVisible.value = false;
};

const LogOut = () => {
    if (confirm("確認是否登出")) {
        const google_token = useCookie('token');
        google_token.value = null;
        //move to specific page
        const moveToPage = () => {
            reloadNuxtApp({ path: '/', ttl: 1000 });

        };
        moveToPage();
        console.log("LogOut in PhotoSticker.vue");

    }
};
const Admin = ref(false);


</script>
<style scoped>
.PhotoList {
    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

:hover.List {
    background-color: #F9DEDC ease-in-out;
}

.v-enter-active,
.v-leave-active {
    transition: opacity 0.5s ease;
}

.v-enter-from,
.v-leave-to {
    opacity: 0;
}
</style>
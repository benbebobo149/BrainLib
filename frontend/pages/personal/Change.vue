<template>
    <div class="w-screen h-screen max-w-full flex bg-purple-50">
        <div class="w-1/4 h-auto bg-purple-50"></div>
        <div class="w-1/2 h-auto bg-purple-50">
            <div class="flex w-auto h-[35%]  justify-center mt-2 bg-purple-50">
                <div class="w-1/3 h-auto bg-purple-50 flex justify-center items-center">
                    <img src="@/UserPhoto.png" alt="" class="w-auto h-[50%]">
                </div>
                <div class="w-1/3 h-auto bg-purple-50 flex items-center">
                    <div class="flex w-[15%] h-auto items-center bg-purple-50">

                        <label for="fileInput" class="cursor-pointer flex items-center">
                            <img src="@/Change/UpLoad.png" alt="" w-auto h-full>
                        </label>
                        <input id="fileInput" type="file" accept=".jpg, .png" style="display: none;"
                            @change="handleFileChange">
                    </div>
                    <div class="flex w-[80%] h-auto items-center text-sm ml-1.5 bg-purple-50">
                        <p>Update Your Photo</p>
                    </div>
                </div>
                <div class="w-1/3 h-auto flex items-center bg-purple-50">
                    <button @click="RemovePhoto" class="flex w-[80%] h-auto items-center text-sm bg-purple-50 text-red-500">
                        <p>Remove Photo</p>
                    </button>
                </div>
            </div>
            <div class="w-auto h-[25%]  justify-center">
                <div class="w-auto h-1/3 bg-purple-50 flex">
                    <p class="text-[2vw]">Your Name</p>
                </div>
                <div class="w-auto h-1/3 bg-purple-50">
                    <input type="text" v-model="ChangeNmae" class="w-full h-full">
                </div>
                <div class="w-auto h-1/3 bg-purple-50 text-[1vw] text-stone-500">
                    <p>Appears on your Profile page, as your byline, and in your responses.</p>
                </div>
            </div>
            <div class="w-auto h-[25%]  justify-center">
                <div class="w-auto h-1/3 bg-purple-50">
                    <p class="text-[2vw]">Bio</p>
                </div>
                <div class="w-auto h-1/3 bg-pruple-50">
                    <input type="text" v-model="ChangeIntroduction" class="w-full h-full">
                </div>
                <div class="w-auto h-1/3 bg-purple-50 text-[1vw] text-stone-500">
                    <p>Appears on your Profile and next to your stories.</p>
                </div>
            </div>
            <div class="flex w-auto h-[15%]">
                <div class="w-1/2 h-1/2 bg-purple-50 flex justify-center">
                    <NuxtLink to="http://localhost:3000/personal"
                        class="w-1/2 h-auto flex justify-center items-center bg-purple-50">
                        <img src="@/Change/cancel.png" alt="" class="w-auto h-full">
                    </NuxtLink>
                </div>
                <div class="w-1/2 h-1/2 bg-purple-50 flex justify-center">
                    <NuxtLink to="http://localhost:3000/personal"
                        class="w-1/2 h-auto flex justify-center items-center bg-purple-50">
                        <img src="@/Change/Confirm.png" alt="" class="w-auto h-full">
                    </NuxtLink>
                </div>
            </div>
        </div>
        <div class="w-1/4 h-auto">
            <div class="w-auto h-3/4 bg-purple-50"></div>
            <div class="w-auto h-1/4 flex items-center justify-end">
                <button @click="DeleteAccount" class="w-[9%] h-auto bg-spurple-50">
                    <img src="@/PhotoSticker/DeleteAccount.png" alt="" class="w-auto h-full">
                </button>
                <div class=" mr-5 text-[1vw] text-red-500">
                    <p>Remove Your Account</p>
                </div>
            </div>

        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const ChangeNmae = ref('');
const ChangeIntroduction = ref('');

const handleFileChange = (event) => {
    const file = event.target.files[0];
    const acceptedExtensions = ['image/jpeg', 'image/png'];

    const fileType = file.type;

    // 檢查檔案格式
    if (!acceptedExtensions.includes(fileType)) {
        alert('請上傳 .jpg 或 .png 格式的文件');
        return;
    }
};
const Photo = ref('');
Photo.value = 'UserPhoto.png';
const DeleteAccount = () => {
    console.log("DeleteAccount in PhotoSticker.vue");
    alert("確認是否刪除帳號");
};
const RemovePhoto = () => {
    console.log("RemovePhoto in PhotoSticker.vue");
    alert("確認是否刪除照片");
};
</script>
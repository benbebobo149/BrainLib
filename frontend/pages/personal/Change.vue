<template>
    <div class="w-screen h-screen max-w-full flex bg-purple-50">
        <div class="w-1/4 h-auto bg-purple-50"></div>
        <div class="w-1/2 h-auto bg-purple-50">
            <div class="flex w-auto h-[35%]  justify-center mt-2 bg-purple-50">
                <div id="app" class="w-[60%] h-auto bg-purple-50 flex justify-center items-center rounded-md">
                    <div
                        class="w-[50%] h-[70%] rounded-full  bg-stone-300 flex justify-center items-center overflow-hidden">
                        <img v-if="inputImage" :src="inputImage" width="200" class="w-full h-auto  object-cover" />
                    </div>
                    <div class="w-[40%] h-auto flex items-center ml-[3vw]">
                        <label for="file-input" class="w-[20%] h-full ">
                            <img src="@/Change/UpLoad.png" class="w-auto h-full">
                        </label>
                        <input id="file-input" type="file" @change="fileSelected" style="display: none;">
                        <p class="w-[80%] h-auto text-[1vw]">Update Your Photo</p>
                    </div>
                </div>
                <div class="w-[20%] h-auto bg-purple-50 flex items-center"></div>

            </div>
            <div class="w-auto h-[25%]  justify-center">
                <div class="w-auto h-1/3 bg-purple-50 flex">
                    <p class="text-[2vw]">Your Name</p>
                </div>
                <div class="w-auto h-1/3 bg-purple-50">
                    <input type="text" v-model="inputName" class="w-full h-full rounded-md pl-[1vw]">
                </div>
                <div class="w-auto h-1/3 bg-purple-50 text-[1vw] text-stone-500">
                    <p>Appears on your Profile page, and in your responses.</p>
                </div>
            </div>
            <div class="w-auto h-[25%]  justify-center">
                <div class="w-auto h-1/3 bg-purple-50">
                    <p class="text-[2vw]">Bio</p>
                </div>
                <div class="w-auto h-1/3 bg-pruple-50">
                    <input type="text" v-model="inputProfile" class="w-full h-full rounded-md pl-[1vw]">
                </div>
                <div class="w-auto h-1/3 bg-purple-50 text-[1vw] text-stone-500">
                    <p>Appears on your Profile and next to your stories.</p>
                </div>
            </div>
            <div class="flex w-auto h-[15%]">
                <div class="w-1/2 h-1/2 bg-purple-50 flex justify-center">
                    <NuxtLink class="w-1/2 h-auto flex justify-center items-center bg-purple-50">
                        <img src="@/Change/cancel.png" alt="" class="w-auto h-full">
                    </NuxtLink>
                </div>
                <div class="w-1/2 h-1/2 bg-purple-50 flex justify-center">
                    <button @click="submit()" class="w-1/2 h-auto flex justify-center items-center bg-purple-50">
                        <img src="@/Change/Confirm.png" alt="" class="w-auto h-full">
                    </button>
                </div>
            </div>
        </div>
        <div class="w-1/4 h-auto">
            <div class="w-auto h-3/4 bg-purple-50"></div>
            <div class="w-auto h-1/4 flex items-center justify-end">
                <button @click="deleteUser" class="w-[9%] h-auto bg-spurple-50">
                    <img src="@/PhotoSticker/DeleteAccount.png" alt="" class="w-auto h-full">
                </button>
                <div @click="deleteUser" class="cursor-pointer mr-5 text-[1vw] text-red-500">
                    <p>Remove Your Account</p>
                </div>
            </div>

        </div>
        <loadingModalBox v-if="loading" />
    </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import loadingModalBox from '@/components/loadingModalBox.vue';
const config = useRuntimeConfig();
const inputProfile = ref('')
const inputName = ref('')
const inputImage = ref('');
const file = ref(null);
const imgHasChanged = ref(false);
const loading = ref(false);
const sendData = async () => {
    const token = useCookie('token');
    const id = useCookie('id');
    const permission = useCookie('permission');
    const email = useCookie('email');

    axios.put(`${config.public.apiURL}/user/${id.value}`, {
        "id": id.value,
        "name": inputName.value,
        "profile": inputProfile.value,
        "image": inputImage.value,
        "email": email.value,
        "permission": permission.value
    },
        {
            headers: {
                'Authorization': 'Bearer ' + token.value,
                'Content-Type': 'application/json',
                'accept': 'application/json'
            }
        })
        .then((res) => {
            if (res.status == 200) {
                console.log("success");

            }
        })
        .catch((err) => {
            // if code is 404, then show error message 
            console.log(err);
            if (err.response.status == 404) {
                console.log("Not Found");
            }
        })
    await getUserInfo();
    const moveToPage = () => {
        reloadNuxtApp({ path: '/personal', ttl: 100 });
    };
    moveToPage();

}
const getUserInfo = async () => {
    const id = useCookie('id');
    const token = useCookie('token');
    const name = useCookie('name');
    const image = useCookie('image');
    const permission = useCookie('permission');
    const email = useCookie('email');
    const profile = useCookie('profile');
    await axios.get(`${config.public.apiURL}/user/${id.value}`, {
        headers: {
            'Authorization': `Bearer ${token.value}`, //the token is a variable which holds the token
            'Content-Type': 'application/json',
        }
    })
        .then(response => {
            email.value = response.data.email;
            permission.value = response.data.permission;
            name.value = response.data.name;
            id.value = response.data.id;
            image.value = response.data.image;
            profile.value = response.data.profile;
            inputName.value = name.value;
            inputProfile.value = response.data.profile;
            inputImage.value = image.value;
        })
        .catch(error => {
            console.error(error);
        });
}

const deleteUser = () => {
    console.log("DeleteAccount in PhotoSticker.vue");
    if (confirm("確認是否刪除帳號 (此動作無法復原!!)")) {
        const token = useCookie('token');
        const id = useCookie('id');
        axios.delete(`${config.public.apiURL}/user/${id.value}`, {
            headers: {
                'Authorization': 'Bearer ' + token.value,
                'Content-Type': 'application/json',
                'accept': 'application/json'
            }
        })
            .then(() => {
                const token = useCookie('token');
                token.value = null;
                reloadNuxtApp({ path: "/main", ttl: 500 });
            })
            .catch((err) => {
                console.log(err);
                if (err.response.status == 404) {
                    console.log("Not Found");
                }
            })
    }
}

const fileSelected = (e) => {
    file.value = e.target.files.item(0);
    const reader = new FileReader();
    reader.addEventListener('load', imageLoaded);
    reader.readAsDataURL(file.value);
};

const imageLoaded = (e) => {
    inputImage.value = e.target.result;
    imgHasChanged.value = true;
};

function base64ToFile(base64Str, filename) {
    let arr = base64Str.split(',');
    let mime = arr[0].match(/:(.*?);/)[1];
    let bstr = atob(arr[1]);
    let n = bstr.length;
    let u8arr = new Uint8Array(n);

    while (n--) {
        u8arr[n] = bstr.charCodeAt(n);
    }

    let blob = new Blob([u8arr], { type: mime });
    return new File([blob], filename, { type: mime });
}

const sendImage = () => {
    const token = useCookie('token');

    const imageFile = base64ToFile(inputImage.value, 'image.jpg'); // 從某處獲取圖片檔案

    const formData = new FormData();
    formData.append('image', imageFile);

    axios.post(`${config.public.apiURL}/uploadFile`, formData, {
        headers: {
            'Authorization': 'Bearer ' + token.value,
            'Content-Type': 'multipart/form-data'
        }
    })
        .then((res) => {
            console.log(res);
            if (res.status == 200) {
                console.log("Image upload success");
                inputImage.value = res.data.file.url;
                sendData();
            }
        })
        .catch((err) => {
            console.log(err);
        });
};

const submit = () => {
    loading.value = true;
    if (imgHasChanged.value) {
        sendImage();
    } else {
        sendData();
    }
}
onMounted(() => {
    getUserInfo();
})
</script>
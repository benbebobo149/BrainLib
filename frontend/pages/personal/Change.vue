<template>
    <div class="w-screen h-screen max-w-full flex bg-purple-50">
        <div class="w-1/4 h-auto bg-purple-50"></div>
        <div class="w-1/2 h-auto bg-purple-50">
            <div class="flex w-auto h-[35%]  justify-center mt-2 bg-purple-50">
                <div id="app" class="w-[60%] h-auto bg-purple-50 flex justify-center items-center rounded-md">
                    <div
                        class="w-[50%] h-[70%] rounded-full  bg-stone-300 flex justify-center items-center overflow-hidden">
                        <img v-if="image" :src="image" width="200" class="w-full h-auto  object-cover" />
                    </div>
                    <div class="w-[40%] h-auto flex items-center">
                        <label for="file-input" class="w-[20%] h-full ">
                            <img src="@/Change/UpLoad.png" alt="@/UserPhoto.png" class="w-auto h-full">
                        </label>
                        <input id="file-input" type="file" @change="fileSelected" style="display: none;">
                        <p class="w-[80%] h-auto text-[1vw]">Update Your Photo</p>
                    </div>


                </div>
                <div class="w-[20%] h-auto bg-purple-50 flex items-center"></div>
                <div class="w-1/4 h-auto flex items-center bg-purple-50">
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
                    <input type="text" v-model="ChangeName" class="w-full h-full">
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
                    <NuxtLink to="/personal" class="w-1/2 h-auto flex justify-center items-center bg-purple-50">
                        <img src="@/Change/cancel.png" alt="" class="w-auto h-full">
                    </NuxtLink>
                </div>
                <div class="w-1/2 h-1/2 bg-purple-50 flex justify-center">
                    <button @click="handleClick" class="w-1/2 h-auto flex justify-center items-center bg-purple-50">
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
    </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';

const ChangeName = ref('');
const ChangeIntroduction = ref('');
const config = useRuntimeConfig();

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


const RemovePhoto = () => {
    console.log("RemovePhoto in PhotoSticker.vue");
    if (confirm("確認是否刪除照片")) {
        image.value = '';
    }
};

const sendData = (pic) => {
    console.log(ChangeName.value);
    console.log(ChangeIntroduction.value);
    const token = useCookie('token');
    const userid = useCookie('userid');
    axios.put(`${config.public.apiURL}/user/${userid}`, {
        "username": ChangeName.value,
        "bio": ChangeIntroduction.value,
    },
        {
            headers: {
                'Authorization': 'Bearer ' + token.value,
                'Content-Type': 'application/json',
                'accept': 'application/json'
            }
        })
        .then((res) => {
            // if code is 200, then hide the modal
            console.log(res);
            if (res.status == 200) {
                // const token = useCookie('token');
                // token.value = res.data.token;//存取token
                console.log("success");
                // refresh the page
                window.location.reload();
            }
        })
        .catch((err) => {
            // if code is 404, then show error message 
            console.log(err);
            // if (err.response.status == 404) {
            if (err.response.status == 404) {
                console.log("Not Found");
            }
            // }
        })
    const moveToPage = () => {
        reloadNuxtApp({ path: '/personal', ttl: 1000 });
    };
    moveToPage();

}

const deleteUser = () => {
    console.log("DeleteAccount in PhotoSticker.vue");
    if (confirm("確認是否刪除帳號 (此動作無法復原!!)")) {
        const token = useCookie('token');
        const userid = useCookie('userid');
        axios.delete(`${config.public.apiURL}/user/${userid}`, {
            headers: {
                'Authorization': 'Bearer ' + token.value,
                'Content-Type': 'application/json',
                'accept': 'application/json'
            }
        })
            .then((res) => {
                // if code is 200, then hide the modal
                console.log(res);
                if (res.status == 204) {
                    console.log("No Content");
                }
            })
            .catch((err) => {
                // if code is 401, then show error message 
                console.log(err);
                if (err.response.status == 404) {
                    console.log("Not Found");
                }
            })
    }

}
const image = ref('');
const file = ref(null);

const fileSelected = (e) => {
    file.value = e.target.files.item(0);
    const reader = new FileReader();
    reader.addEventListener('load', imageLoaded);
    reader.readAsDataURL(file.value);
};

const imageLoaded = (e) => {
    image.value = e.target.result;
};

const upload = () => {
    axios.post('/upload', { image: image.value });
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

    const imageFile = base64ToFile(image.value, 'image.jpg'); // 從某處獲取圖片檔案

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
                sendData(res.data.url);
            }
        })
        .catch((err) => {
            console.log(err);
        });

    // 省略其他代碼
};
let clickCount = ref(0);

const handleClick = () => {
    clickCount.value++;
    if (clickCount.value % 2 === 1) {
        sendImage();//奇數點擊數
    } else {
        sendData();//偶數點擊數
    }
};

</script>
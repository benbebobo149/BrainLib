<template>
    <div class="bg-slate-50">
        <div class="flex h-[12vh]">
            <!-- Left Section -->
            <div class="w-1/2 h-full flex flex-col">
                <!-- Top Section (1/4 height) -->
                <div class="h-1/4 flex bg-slate-50 text-black">
                    <!-- Left Subsection (1/3 width) -->
                    <div class="w-1/3 bg-slate-50 p-8">
                    </div>

                    <!-- Right Subsection (2/3 width) -->
                    <div class="w-2/3 bg-slate-50 p-8 flex items-center justify-center">
                        <img :src="image || 'https://via.placeholder.com/95x96 '" alt="username" class="w-auto h-[8vh]" />
                        <div class="text-black text-3xl font-bold ml-4">
                            {{ name }}
                        </div>
                    </div>
                </div>
            </div>

            <!-- Right Section -->
            <div class="w-1/2 h-full flex flex-col">
                <!-- Top Subsection (1/4 height) -->
                <div class="flex flex-row h-1/4 bg-slate-50 text-black justify-center items-center p-8 mt-[2vw]">
                    <label for="tagInput" class="cursor-pointer " @click="showRegistrationPopup">
                        <img src="/hello/AddTag.png" alt="Add tag" class="w-auto h-[4vh] mr-10 ">
                    </label>
                    <button type="button" @click="deletePost"
                        class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2">Delete</button>


                    <!-- <img src="/hello/Preview.png" alt="Preview" class="w-auto h-[4vh] mr-10"> -->
                    <input id="fileInput" type="file" style="display: none;" @change="handleFileChange" />
                    <AddTag v-if="showPopup" class="z-10" @close="closeRegistrationPopup" @additem="addTags" />
                </div>
            </div>
        </div>

        <div class="w-screen bg-slate-50 flex flex-col justify-center items-center">
            <h1 class="text-[2vw] font-bold text-terotory text-center">Edit Post</h1>
            <p v-if="errorInputTitle" class="text-center text-red-600">請輸入標題 ! !</p>
            <p v-if="errorInputImage" class="text-center text-red-600">請上傳封面照片 ! !</p>
            <div class="my-[2vh] flex">
                <p>
                    tags:
                </p>
                <div v-for="tag in tags" class="mx-[1vw] flex" @click="removeTag">
                    <div
                        class="mx-auto rounded-sm border border-terotory text-center text-neutral-900 text-l font-normal font-'Roboto' leading-7 p-[0.5vh] cursor-pointer">
                        {{ tag.tagName }}
                    </div>
                </div>
            </div>
            <div class="w-[60%] h-1/3 flex content-cneter ">
                <div class="flex mt-[10vh]">
                    <input type="text" v-model="inputTitle"
                        class="w-auto text-[3vw] h-[8vh] border-balck pl-[1vw] mb-[2vh] mx-[1vw] ">
                    <p class="text-terotory">enter your title here.</p>
                </div>

                <div id="app" class="w-[30vw] h-[30vh] flex justify-center items-center my-[2vh]">
                    <div class="w-full h-full rounded-md flex justify-center items-center overflow-hidden mx-[1vw]">
                        <img v-if="inputImage" :src="inputImage" width="200" class="w-full h-auto  object-cover" />
                    </div>
                    <div class="w-[40%] h-auto flex items-center">
                        <label for="file-input" class="w-[20%] h-full ">
                            <img src="@/Change/UpLoad.png" class="w-auto h-full">
                        </label>
                        <input id="file-input" type="file" @change="fileSelected" style="display: none;">
                        <p class="w-[60%] text-terotory h-auto text-[1vw] mx-[1vw]">Update Your Post Cover</p>
                    </div>
                </div>

            </div>

            <Editor v-if="inputEditorData && edtiorShow" :content="inputEditorData" class="w-[60%]"
                @clickSubmit="clickSubmit" />
        </div>
        <loadingModalBox class="z-50" v-if="loading" />
        <BoxSucc v-if="succVisible" class="z-10" @editorData=""></BoxSucc>
        <BoxError v-if="errorVisible" @close="errorVisible = false"></BoxError>
    </div>
</template>
  
<script setup>
import { ref } from 'vue';
import AddTag from '@/components/CreatePost/AddTag.vue';
import Editor from '@/components/EditPost/Editor.vue'
import BoxSucc from '@/components/ModelBox/BoxSucc.vue';
import BoxError from '@/components/ModelBox/BoxError.vue';
import loadingModalBox from '@/components/loadingModalBox.vue';
import axios from 'axios';
const succVisible = ref(false);
const errorVisible = ref(false);
const inputTitle = ref('');
const inputEditorData = ref();
const showPopup = ref(false);
const inputImage = ref('');
const file = ref(null);
const config = useRuntimeConfig();
const errorInputTitle = ref(false);
const errorInputImage = ref(false);
const imageHasUploaded = ref(false)
const name = useCookie('name');
const image = useCookie('image');
const route = useRoute();
const id = route.params.id;
const loading = ref(false);
const showRegistrationPopup = () => {
    showPopup.value = true;
};

const closeRegistrationPopup = () => {
    showPopup.value = false;
};

const getEditorData = async (data) => {
    // change proxy object to json
    const jsonData = JSON.stringify(toRaw(data));
    inputEditorData.value = jsonData;
    console.log(inputEditorData.value);
};

//tags
const tags = ref([]);
//added tags
const addTags = (tag) => {
    // 檢查是否已經有加入過
    if (tags.value.find(item => item.id == tag.id)) {
        return;
    }
    tags.value.push(tag);
};

// Remove tag
const removeTag = (index) => {
    if (window.confirm('Are you sure you want to remove this tag?')) {
        tags.value.splice(index, 1);
    }
};

//upload image
const sendImage = async () => {
    console.log("sendImage");
    const token = useCookie('token');

    const imageFile = base64ToFile(inputImage.value, 'image.jpg'); // 從某處獲取圖片檔案

    const formData = new FormData();
    formData.append('image', imageFile);

    await axios.post(`${config.public.apiURL}/uploadFile`, formData, {
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
            }
        })
        .catch((err) => {
            console.log(err);
        });
};
//send data to backend
const updatePost = () => {
    axios.put(`${config.public.apiURL}/post/${id}`, { // config.public.apiURL + "/tag"
        "title": inputTitle.value,
        "content": inputEditorData.value,
        "image": inputImage.value,
        "tags": tags.value
    }, {
        headers: {
            'Authorization': 'Bearer ' + useCookie('token').value, // useCookie('token').value
            'Content-Type': 'application/json',
            'accept': 'application/json'
        }
    })
        .then((res) => {
            // if code is 200, then hide the modal
            console.log(res);
            if (res.status == 200) {
                window.location.reload();
            }
        })
        .catch((err) => {
            // if code is 401, then show error message 
            console.log(err);
            errorVisible.value = true;
            if (err.response.status == 401) {
                alert("create fail!");
                console.log("fail");
            }
        })
}

const fileSelected = (e) => {
    file.value = e.target.files.item(0);
    const reader = new FileReader();
    reader.addEventListener('load', imageLoaded);
    reader.readAsDataURL(file.value);
    imageHasUploaded.value = true;
};

const imageLoaded = (e) => {
    inputImage.value = e.target.result;
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

const clickSubmit = async (data) => {
    if (inputTitle.value == '') {
        errorInputTitle.value = true;
        return;
    }
    errorInputTitle.value = false;
    errorInputImage.value = false;
    loading.value = true;
    await getEditorData(data);
    if (imageHasUploaded.value) {
        await sendImage();
    }
    updatePost();
}

const getPostData = async () => {
    await axios.get(`${config.public.apiURL}/post/${id}`, {
        headers: {
        }
    })
        .then(response => {
            console.log(response.data);
            inputTitle.value = response.data.title;
            inputImage.value = response.data.image;
            tags.value = response.data.tags;
            inputEditorData.value = response.data.content;
        })
        .catch(error => {
            console.log(error);
        });
}

const deletePost = () => {
    if (confirm("確認是否刪除文章 (此動作無法復原!!)")) {
        const token = useCookie('token');
        // change string to int
        axios.delete(`${config.public.apiURL}/post/${id}`,
            {
                headers: {
                    'Authorization': 'Bearer ' + token.value,
                    'Content-Type': 'application/json',
                    'accept': 'application/json'
                }
            })
            .then(() => {
                reloadNuxtApp({ path: "/personal", ttl: 500 });
            })
            .catch((err) => {
                console.log(err);
                if (err.response.status == 404) {
                    console.log("Not Found");
                }
            })
    }
}
const edtiorShow = ref(false);
onMounted(() => {
    edtiorShow.value = true;

});
getPostData();
</script>
  
<style scoped>
[contenteditable] {
    overflow-wrap: break-word;
}

input::placeholder,
input {
    font-size: 25px;
    color: black;
    height: 40px;
    width: 100%;
}
</style>
  
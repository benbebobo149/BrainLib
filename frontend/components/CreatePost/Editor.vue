<script setup>
import EditorJS from '@editorjs/editorjs';
import Header from '@editorjs/header';
import List from '@editorjs/list';
import ImageTool from '@editorjs/image';
const config = useRuntimeConfig();

const emit = defineEmits();

const postTitle = ref('');

//send data to backend
const sendPostData = () => {
    console.log(tagName.value);
    axios.post(`${config.public.apiURL}/post`, { // config.public.apiURL + "/tag"

        "title": "string",
        "content": {},
        "image": "string",
        "tags": [
            {
                "tag_id": 0,
                "tag_name": "string"
            }
        ]
    }, {
        headers: {
            'Content-Type': 'application/json',
            'accept': 'application/json'
        }
    })
        .then((res) => {
            // if code is 200, then hide the modal
            console.log(res);
            if (res.status == 200) {
                console.log("success");
            }
        })
        .catch((err) => {
            // if code is 401, then show error message 
            console.log(err);
            if (err.response.status == 401) {
                console.log("fail");
            }
        })
}


// click the button and console log the content
const sendMessage = () => {
    emit('openSucc')
    editor.save().then((outputData) => {
        console.log('Article data: ', outputData)
        const moveToPage = () => {
            reloadNuxtApp({ path: '/personal', ttl: 8000 });

        };
        setTimeout(moveToPage(), 10000);
    }).catch((error) => {
        console.log('Saving failed: ', error)
        emit('openError')
    })
}
const editor = new EditorJS({
    /** 
     * Id of Element that should contain the Editor 
     */
    holder: 'editorjs',

    /** 
     * Available Tools list. 
     * Pass Tool's class or Settings object for each Tool you want to use 
     */
    tools: {
        header: {
            class: Header,
            config: {
                placeholder: 'Enter a header',
                defaultLevel: 2
            }
        },
        list: {
            class: List
        }, image: {
            class: ImageTool,
            config: {
                endpoints: {
                    byFile: `${config.public.apiURL}/uploadFile`, // Your backend file uploader endpoint
                    byUrl: `${config.public.apiURL}/fetchUrl`, // Your endpoint that provides uploading by Url
                }
            }
        }
    },
})
</script>

<style>
.ce-header {
    font-size: 2.5rem;
    font-weight: bold;
}

.ce-header h1 {}
</style>
<template>
    <div class="flex flex-col justify-center">
        <div v-for="tag in tags" class="flex">
        <div
          class="mx-auto rounded-sm border border-terotory text-center text-neutral-900 text-l font-normal font-'Roboto' leading-7 p-[0.5vh]">
          {{ tag }}
        </div>
      </div>
        <div class="w-auto h-1/3 flex content-cneter ">
            <input type="text"  v-model="postTitle"
                class="w-auto text-[3vw] h-[8vh] pl-[1vw] mb-[2vh]">
            <div class="w-auto h-1/3 text-[1vw] mt-[3vh] ml-[1vw] text-stone-500">
                <p>enter your title here.</p>
            </div>
        </div>
        <div id="editorjs" class="w-full h- border-2 border-terotory "></div>

        <div class="flex justify-end mt-2">
            <button @click="sendMessage"
                class="text-white bg-primary hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 focus:outline-non">傳送內容</button>
        </div>
    </div>
</template>
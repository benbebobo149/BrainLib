<script setup>
import EditorJS from '@editorjs/editorjs';
import Header from '@editorjs/header';
import List from '@editorjs/list';
import ImageTool from '@editorjs/image';
import CodeTool from '@editorjs/code';
import Table from '@editorjs/table'
const config = useRuntimeConfig();

const emit = defineEmits();
// click the button and console log the content
const sendMessage = async () => {
    const inputData = ref();
    await editor.save().then((outputData) => {
        inputData.value = outputData;
        console.log('Article data: ', inputData.value);
        emit('editorData', inputData.value);
    }).catch((error) => {
        console.log('Saving failed: ', error)
    });

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
        , code: CodeTool, table: {
            class: Table,
            inlineToolbar: true,
            config: {
                rows: 2,
                cols: 3,
            },
        },
    }
})
</script>

<style>
.ce-header {
    font-size: 2.5rem;
    font-weight: bold;
}
</style>
<template>
    <div class="flex flex-col justify-center">
        <div v-for="tag in tags" class="flex">
            <div
                class="mx-auto rounded-sm border border-terotory text-center text-neutral-900 text-l font-normal font-'Roboto' leading-7 p-[0.5vh]">
                {{ tag }}
            </div>
        </div>

        <div id="editorjs" class="w-full h-1/3 border-2 border-terotory "></div>

        <div class="flex justify-end mt-2">
            <button @click="sendMessage"
                class="text-white bg-primary hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 focus:outline-non">傳送內容</button>
        </div>
    </div>
</template>
<script setup>
import EditorJS from '@editorjs/editorjs';
import Header from '@editorjs/header';
import List from '@editorjs/list';
import ImageTool from '@editorjs/image';
import CodeTool from '@editorjs/code';
import Table from '@editorjs/table'
const props = defineProps({
    content: {
        type: String,
        required: true
    }
})

const { content } = toRefs(props)
// string to json
const config = useRuntimeConfig();
const emit = defineEmits();
const editor = new EditorJS({
    holder: 'editorjs',

    data: JSON.parse(content.value),
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
        }
    }
})

const sendMessage = async () => {
    const inputData = ref();
    await editor.save().then((outputData) => {
        inputData.value = outputData;
        console.log('Article data: ', inputData.value);
        emit('clickSubmit', inputData.value);
    }).catch((error) => {
        console.log('Saving failed: ', error)
    });
}
</script>

<style>
.ce-header {
    font-size: 2.5rem;
    font-weight: bold;
}
</style>
<template>
    <div class="flex flex-col justify-center items-center">
        <div id="editorjs" class="w-[50vw] h- border-2 border-terotory mb-10"></div>
        <button @click="sendMessage"
            class="text-white bg-primary hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 focus:outline-non">傳送內容</button>
    </div>
</template>
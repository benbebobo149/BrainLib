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
const json = JSON.parse(content.value);
const editor = new EditorJS({
    holder: 'editorjs',
    readOnly: true,
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
</script>

<style>
.ce-header {
    font-size: 2.5rem;
    font-weight: bold;
}
</style>
<template>
    <div class="flex flex-col justify-center items-center">
        <div id="editorjs" class="w-[50vw] h- border-t  border-terotory mt-[5vh] mb-10"></div>
    </div>
</template>
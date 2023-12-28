<script setup>
import EditorJS from '@editorjs/editorjs';
import Header from '@editorjs/header';
import List from '@editorjs/list';
import ImageTool from '@editorjs/image';
const config = useRuntimeConfig()

const emit = defineEmits();

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
    <div class="flex flex-col justify-center items-center">
        <div id="editorjs" class="w-[50vw] h- border-2 border-terotory mb-10"></div>

    </div>
</template>
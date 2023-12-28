<script setup>
import EditorJS from '@editorjs/editorjs';
import Header from '@editorjs/header';
import List from '@editorjs/list';
import ImageTool from '@editorjs/image';
const props = defineProps({
    content: {
    type: String,
    required: true
  }
})

const { content} = toRefs(props)
// string to json
const json = JSON.parse(content.value);
const editor = new EditorJS({
    holder: 'editorjs',
    readOnly: true,
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
            class: ImageTool
        }
    },
    data: json
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
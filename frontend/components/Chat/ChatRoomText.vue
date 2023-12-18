<script setup>
const props = defineProps({
    Text: {
        type: String,
        default: 'Default Text',
    }
});
// const { user } = toRefs(props); // 解構props

</script>
<template>
    <div class="bg-secondiry ml-[1rem] text-black text-xl font-normal font-'Roboto'">
        {{ Text }}
    </div>
</template>
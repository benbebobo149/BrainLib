<script setup>
import Topic from '@/public/TagFakeData/TagFakeData.json';

const Tags = ref(Topic);
const props = defineProps({
    topic: { type: String, default: 'Topic' }
});

</script>

<template>
    <div class="grid grid-cols-3 gap-4">
        <div v-for="Tag in Tags" :key="Tag.tag_id"
            class="mx-auto rounded-sm border border-terotory text-center text-neutral-900 text-l font-normal font-'Roboto' leading-7 p-[0.5vh]">
            {{ Tag.tag_name }}
        </div>
    </div>
</template>
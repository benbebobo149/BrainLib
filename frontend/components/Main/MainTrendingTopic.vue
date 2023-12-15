<script setup>
const props = defineProps({
topic: {  type: String,  default: 'Topic'  }
});

</script>
<template>
    <div class="mx-auto rounded-sm border border-terotory text-center 
                text-neutral-900 text-l font-normal font-['Roboto'] leading-7">{{ topic }}
    </div>
</template>
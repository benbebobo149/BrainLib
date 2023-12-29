<script setup>
const props = defineProps({
    datas: { type: Array, default: [] }
});


</script>
<template>

    <div class="-z-20">
        <div class="PhotoList fixed  h-auto bg-purple-50 flex ml-[1vw]  mt-[4vh] ">
            <div class="w-[30vw] h-auto bg-purple-50 items-center justify-center">
                <NuxtLink :to="'/post/'+data.id" v-for="data in datas" :key="data.id"
                    class="hover:bg-purple-100 ease-in-out flex h-[6.5vh] w-auto p-1 items-center justify-center">
                    <p class="text-[3w] text-left">{{ data.title }}</p>
                </NuxtLink>
            </div>
        </div>
    </div>
</template>
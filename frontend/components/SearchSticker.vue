<script setup>
const SearchStickerVisable = ref('false')
const openSearchModal = () => {
    SearchStickerVisable.value = !SearchStickerVisable.value;
    console.log("open model in PhotoSticker.vue");
};

const closeSearchModal = () => {
    SearchStickerVisable.value = false;
};
</script>
<template>
    <button @click="openSearchModal" class="w-auto h-full">
        <img src="@/Search.png"  class="w-auto h-[70%] mx-[1vw]" alt="PhotoSticker">
    </button>
    <div @click="closeSearchModal" v-if="SearchStickerVisable" class=" -z-20">
        <div class="PhotoList fixed  h-auto bg-purple-50 flex ml-[1vw]  mt-[4vh] ">
            <div class="w-[30vw] h-auto bg-purple-50 items-center justify-center">
                <div class="hover:bg-purple-100 ease-in-out flex h-[6.5vh] w-auto p-1">
                    <NuxtLink to="/personal" class="text-[1vw] flex items-center w-[80%] h-auto ml-5">
                        <p>Personal Profile</p>
                    </NuxtLink>
                </div>
               
            </div>
        </div>
    </div>
</template>
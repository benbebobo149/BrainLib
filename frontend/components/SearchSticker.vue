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
        <img :src="image" class="w-auto h-[80%]" alt="PhotoSticker">
    </button>
    <div @click="closeSearchModal" v-if="SearchStickerVisable" class="fixed inset-0 flex w-screen h-screen max-h-full">
        <div class="PhotoList fixed w-[15%] h-auto bg-purple-50 flex  mt-[7vh] right-0">
            <div class="w-full h-auto bg-purple-50 items-center justify-center">
                <div class="hover:bg-purple-100 ease-in-out flex h-[6.5vh] w-auto p-1">
                    <NuxtLink to="/personal" class="w-[20%] h-auto flex justify-center">
                        <img src="/PhotoSticker/PersonalProfile.png" alt="" class="w-full h-auto">
                    </NuxtLink>
                    <NuxtLink to="/personal" class="text-[1vw] flex items-center w-[80%] h-auto ml-5">
                        <p>Personal Profile</p>
                    </NuxtLink>
                </div>
               
            </div>
        </div>
    </div>
</template>
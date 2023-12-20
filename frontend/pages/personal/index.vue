<template>
    <div class="flex w-screen h-screen bg-bgcolor max-w-full max-h-full">
        <div class="w-[70%] h-screen bg-bgcolor">
            <div class="w-full h-1/4 bg-bgcolor flex items-center text-[2.5vw] p-10 ">
                <div class=" w-1/2 h-full border-b border-terotory flex items-end">
                    <p class="font-bold ">Your Post</p>
                </div>
            </div>
            <div class="w-full h-3/4 overflow-y-hidden">
                <div class="w-auto h-full overflow-y-scroll hide-scrollbar fill-available p-0">
                    <PostPreview />
                    <PostPreview />
                    <PostPreview />
                    <PostPreview />
                    <PostPreview />
                </div>
            </div>
        </div>
        <div class="w-[30%] h-auto bg-bgcolor">
            <div class="w-full h-[60%] bg-bgcolor">
                <div class="flex w-full h-[80%] bg-bgcolor justify-center items-end">
                    <img src="@/UserPhoto.png" alt="UserPhoto" class="w-auto h-[70%] rounded-full border-2 border-terotory">
                </div>
                <div class="flex justify-center items-center w-full h-[20%] bg-bgcolor">
                    <div class=" w-1/2 h-full border-b border-terotory flex items-center justify-center">
                        <p class="text-[2vw]">{{ user.username }}</p>
                    </div>
                </div>
            </div>
            <div class="w-full h-[40%] bg-bgcolor flex justify-center">
                <p class="text-[1.3vw] p-12 pt-3">{{ user.bio }}</p>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import PostPreview from '@/components/PostPreview.vue';
import data from '@/public/personal/UserFakeData.json';

const Photo = ref('');
Photo.value = 'UserPhoto.png';
const user = ref(data[1]);
</script>


<style scoped>
.hide-scrollbar::-webkit-scrollbar {
    display: none;
    /* 隱藏滾動條 - WebKit browsers */
}

/* 使用 Flexbox 使容器充滿空間 */
.fill-available {
    display: flex;
    flex-direction: column;
}
</style>
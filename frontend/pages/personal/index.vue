<template>
    <div class="flex w-screen h-screen bg-bgcolor max-w-full max-h-full">
        <div class="w-2/3 h-screen bg-bgcolor">
            <div class="w-full h-1/4 bg-bgcolor flex items-center text-[2.5vw] p-10 ">
                <div class=" w-1/2 h-full border-b border-terotory flex items-end">
                    <p class="font-bold ">Your Post</p>
                </div>
            </div>
            <div class="w-full h-3/4 overflow-y-hidden">
                <!-- 使用自定義的 CSS 類別 -->
                <div class="w-auto h-full overflow-y-scroll hide-scrollbar fill-available p-2">
                    
                </div>
            </div>
        </div>
        <div class="w-1/2 h-auto bg-bgcolor">
            <div class="w-full h-[60%] bg-bgcolor">
                <div class="flex w-full h-[80%] bg-bgcolor justify-center items-end">
                    <img src="UserPhoto.png" alt="UserPhoto" class="w-auto h-[70%] rounded-full border-2 border-terotory">
                </div>
                <div class="flex justify-center items-center w-full h-[20%] bg-bgcolor">
                    <div class=" w-1/2 h-full border-b border-terotory flex items-center justify-center">
                        <p class="text-[2vw]">{{ name }}</p>
                    </div>
                </div>
            </div>
            <div class="w-full h-[40%] bg-bgcolor flex justify-center">
                <p class="text-[1.3vw] p-12 pt-3">{{ introduction }}</p>
            </div>
        </div>
    </div>
</template>

<script>
import { defineComponent, ref } from 'vue';
import InPageNav from "@/components/InPageNav.vue";

export default defineComponent({
    name: "personal",
    components: {
        InPageNav,
    },
    setup() {
        const name = ref('');
        name.value = "jake";

        const Photo = ref('');
        Photo.value = 'UserPhoto.png';

        const introduction = ref('');
        introduction.value = "在求職之路上遇到許多人的幫助，於是決定撰寫求職相關文章回饋社會的少女。以吃食社會學與哲學維生。在求職之路上遇到許多人的幫助，於是決定撰寫求職相關文章回饋社會的少女。以吃食社會學與哲學維生。在求職之路上遇到許多人的幫助，於是決定撰寫求職相關文章回饋社會的少女。以吃食社會學與哲學維生。在求職之路上遇到許多人的幫助，於是決定撰寫求職相關文章回饋社會的少女。以吃食社會學與哲學維生。";
        return {
            name,
            introduction,
            Photo
        };
    }
});
</script>


<style scoped>
/* 自訂的 CSS 類別 */
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

<script setup>
// define emit
const emit = defineEmits(['close'])

// define props
const props = defineProps({
    post: {
        type: Object,
        default: () => ({
            title: 'Not Found', author: 'Author Not Found',
            content: 'Content Not Found', topic: 'Topic ', likes: 0, comments: 0
        })
    }
});
// change props to ref 
const { post } = toRefs(props);

// define methods
const clickButton = () => {
    console.log('click button')
    emit('close')
}
const passPost = () => {
    emit('passPost', post.value);
    console.log(post.value);
}
const rejectPost = () => {
    emit('rejectPost', post.value);
    console.log(post.value);
}

</script>
<template>
    <div class="flex mx-1 z-0">
        <!-- 預覽文章1 -->
        <div class="w-[75vw] h-[24vh]  box-border my-[0.7rem] relative flex items-start ">
            <div class="w-[8vw] bg-bgcolor"></div>
            <div class=" w-3/4 bg-bgcolor">
                <div class="w-full h-[7vh] bg-green-250 text-black text-[2vw] font-semibold font-Roboto leading-10">
                    {{ post.title }}</div>
                <div class="w-full h-[10vh] left-[1rem]">
                    <div class=" bg-bgcolor text-zinc-600 text-[1.25vw] font-normal font-Roboto ">
                        {{ post.content }}
                    </div>
                </div>

                <div class="w-full h-[6vh]  rounded-sm border-b border-terotory mx-2  flex">
                    <img class=" w-[6vh] h-[6vh] rounded-full  mx-2 " src="https://via.placeholder.com/95x96" />
                    <h2 class="w-[20vw] h-[2vw] text-black text-[1.25vw] font-normal font-Roboto leading-loose">
                        {{ post.author }}
                    </h2>
                    <h1
                        class="w-[8vw] h-[2vw] left-[20vw] ml-8 bg-purple-200 rounded absolute text-center text-neutral-900 text-[1.25vw] font-normal font-'Roboto'">
                        {{ post.topic }}</h1>

                    <img class=" w-[4vh] h-[4vh] ml-[2vw] " src="@/PostPreview/Thumb.png" />
                    <h2 class="w-[6vw] h-[2vw] text-black text-[1.25vw] font-normal font-Roboto leading-loose">
                        {{ post.likes }}
                    </h2>

                    <img class=" w-[4vh] h-[4vh]  mx-[1vw]" src="@/PostPreview/ChatRightDots.png" />
                    <h2 class="w-[6vw] h-[2vw] text-black text-[1.25vw] font-normal font-Roboto leading-loose">
                        {{ post.comments }}
                    </h2>
                </div>

            </div>

            <div class=" w-1/4 h-[18vh]">
                <img class="w-full h-[10vw] my-1 " src="https://via.placeholder.com/240x148" />
            </div>

            <div class="h-[full]  bg-bgcolor ">
                <div class="content-center flex ">
                    <img class="h-[3vw] w-[3vw] mx-[2vh] my-[8vh] cursor-pointer items-center"
                        src="@/PageAdmini/XCircleFill.png" alt="no image found" @click="rejectPost">
                    <img class="h-[3vw] w-[3vw] mx-[2vh] my-[8vh] cursor-pointer items-center"
                        src="@/PageAdmini/CheckCircleFill.png" alt="no image found" @click="passPost">
                </div>
            </div>
        </div>

    </div>
</template>


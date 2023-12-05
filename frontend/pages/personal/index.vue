<template>
    <div>
        <InPageNav></InPageNav>
    </div>

    <div class="flex w-screen h-screen bg-red-100">
        <div class="w-2/3 h-screen bg-yellow-500">
            <div class="w-full h-1/4 bg-yellow-200 flex items-center text-4xl p-10 border-b-2">
                <p>your post</p>
            </div>
            <div class="w-full h-3/4 overflow-y-scroll border border-gray-300">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quo laudantium impedit voluptate illum cupiditate dolorum, dicta repellendus odit quod temporibus? Repudiandae, deserunt eaque neque earum optio nam delectus cum maiores.
                Voluptatibus architecto necessitatibus eveniet ea aperiam perferendis ipsam dolorem incidunt exercitationem atque provident laboriosam cum iste, totam quos deleniti expedita dignissimos nihil rerunt perferendis assumenda atque quae quidem ab officiis iste, ullam esse culpa laboriosam repellat, fugiat tempora. Ducimus, inventore ipsa?</p>
            </div>
        </div>
        <div class="w-1/2 h-full bg-green-100 mt-16">
            <div class="w-full h-1/3 bg-red-400">
                <div class="flex w-full h-3/4 bg-purple-100 justify-center">
                    <img src="UserPhoto.png" alt="UserPhoto" class="w-auto h-full">
                </div>
                <div class="flex justify-center items-center w-full h-1/4 bg-red-200 border-b-2">
                    <p>user name</p>
                </div>
            </div>
            <div class="w-full h-1/2 bg-red-300 flex justify-center">
                <p>在求職之路上遇到許多人的幫助，於是決定撰寫求職相關文章回饋社會的少女。以吃食社會學與哲學維生。在求職之路上遇到許多人的幫助，於是決定撰寫求職相關文章回饋社會的少女。以吃食社會學與哲學維生。在求職之路上遇到許多人的幫助，於是決定撰寫求職相關文章回饋社會的少女。以吃食社會學與哲學維生。在求職之路上遇到許多人的幫助，於是決定撰寫求職相關文章回饋社會的少女。以吃食社會學與哲學維生。</p>
            </div>
        </div>
    </div>
</template>   

<script>
import InPageNav from "@/components/InPageNav.vue";
export default {
    name: "personal",
    components: {
        InPageNav,
    }
};
</script> 
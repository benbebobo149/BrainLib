<template>
    <div>
        <InPageNav></InPageNav>
    </div>

    <div class="flex w-screen h-screen bg-red-100">
        <div class="w-2/3 h-screen bg-yellow-500">
            <div class="w-full h-1/4 bg-yellow-200">
                <p>your post</p>
            </div>
            <div class="w-full h-3/4 overflow-y-scroll border border-gray-300">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quo laudantium impedit voluptate illum cupiditate dolorum, dicta repellendus odit quod temporibus? Repudiandae, deserunt eaque neque earum optio nam delectus cum maiores.
                Voluptatibus architecto necessitatibus eveniet ea aperiam perferendis ipsam dolorem incidunt exercitationem atque provident laboriosam cum iste, totam quos deleniti expedita dignissimos nihil rerunt perferendis assumenda atque quae quidem ab officiis iste, ullam esse culpa laboriosam repellat, fugiat tempora. Ducimus, inventore ipsa?</p>
            </div>
        </div>
        <div class="w-1/3 h-full bg-green-100">
            <div class="w-full h-2/3 bg-red-400">
                <div class="w-full h-3/4 bg-red-100"></div>
                <div class="w-full h-1/4 bg-red-200">
                    <p>user name</p>
                </div>
            </div>
            <div class="w-full h-1/3 bg-red-300"></div>
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
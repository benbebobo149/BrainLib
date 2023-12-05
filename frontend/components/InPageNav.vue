<template>
    <div class="flex w-screen h-[7vh] bg-gray-200">
        <div class="flex w-1/2 h-[7vh] bg-blue-200">
            <div class="flex w-1/5 h-full bg-purple-100">
                <ListNav class="w-1/2 h-full" />
            </div>
            <div class="flex w-4/5 h-full bg-purple-300 items-center">
                <label for="name">
                    <img src="Search.png" alt="Search" class="w-1/6 h-full cursor-pointer">
                </label>
                <input type="text" id="name" placeholder="Search" class="w-5/6 h-3/4 rounded-full">
                <!-- <SearchButton /> -->
            </div>
        </div>
        <div class="flex w-1/2 h-[7vh] bg-red-200 justify-end">
            <NuxtLink to="./" class="flex w-auto h-full bg-green-100 items-center mr-[1vw]">
                <img src="PencilSquare.png" alt="PencilButton" class="w-auto h-3/4">
            </NuxtLink>
            <NuxtLink to="./" class="flex w-auto h-full items-center bg-green-200 mr-[1vw]">
                <img src="Chat.png" alt="Chat" class="w-auto h-3/4">
            </NuxtLink>
            <NuxtLink to="./" class="w-auto h-full flex items-center bg-green-300 mr-[1vw]">
                <img src="PhotoSticker.png" alt="PhotoSticker" class="w-auto h-3/4">
            </NuxtLink>
        </div>
    </div>
</template>

<script>
export default {
    name: "InPageNav",
};
import SearchButton from "./SearchButton.vue";
import Chat from "./Chat.vue";
import PencilButton from "./PencilButton.vue";
import PhotoSticker from "./PhotoSticker.vue";
import ListNav from "./ListNav.vue";

components: {
    SearchButton,
        Chat,
        PencilButton,
        PhotoSticker,
        ListNav
}
</script>
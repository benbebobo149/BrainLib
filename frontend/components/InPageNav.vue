<template>
    <div class="flex w-screen h-7vh bg-gray-200">
        <div class="flex w-1/2 h-7vh bg-blue-200">
            <div class="flex w-1/5 h-full bg-purple-100">
                <ListNav class="w-1/2 h-full"/>
            </div>
            <div class="flex w-2/5 h-full bg-purple-200">
                <div class="w-1/2 h-full">
                    <img src="logo.png" alt="Logo" class="w-1/2 h-full"/>
                </div>
                <div class="flex w-1/2 h-full text-xs">
                    <p>BRAINLIBRARY</p>
                </div> 
            </div>
            <div class="flex w-2/5 h-full bg-purple-300 items-center">
                <SearchButton />
            </div>
        </div>
        <div class="flex w-1/2 h-7vh bg-red-200">
            <div class="flex w-3/5 h-full bg-green-100 items-center justify-end">
                <PencilButton class="w-1/6 h-full"/>
            </div>
            <div class="flex w-1/5 h-full bg-green-200 items-center justify-end">
                <Chat class="w-1/3 h-full" />
            </div>
            <div class="flex w-1/5 h-full bg-green-300 items-center justify-end">
                <PhotoSticker class="rounded-full w-1/3 h-full "/>
            </div>
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
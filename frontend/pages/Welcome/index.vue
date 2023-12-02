<template>
    <div>
        <LoginNav></LoginNav>
    </div>

    <div class="flex w-screen min-h-screen bg-red-500">
        <div class="w-1/2 h-full bg-red-400">
            <div class="w-full h-3/4 bg-blue-100">
                <p>你好</p>
            </div>
            <div class="w-full h-1/4 bg-blue-200">
                <p>你好</p>
            </div>
        </div>
        <div class="flex w-1/2 h-full bg-yellow-100">
            <div class="w-1/2 h-full bg-green-400">
                <p>你好</p>
            </div>
            <div class="w-1/2 h-full bg-green-500">
                <p>你好</p>
            </div>
        </div>
    </div>
    <div class="w-screen h-3vh bg-yellow-100">
        <p>你好</p>
    </div>
</template>

<script>
import LoginNav from "@/components/LoginNav.vue";

export default {
    name: "Welcome",
    components: {
        LoginNav,
    }
};
</script>

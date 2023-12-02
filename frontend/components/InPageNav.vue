<template>
    <div class="flex w-screen h-9vh bg-gray-200">
        <div class="flex w-1/2 h-9vh bg-blue-200">
            <div class="image w-1/5 h-full bg-purple-100">
                <p>你好</p>
            </div>
            <div class="w-1/5 h-full bg-purple-200"></div>
            <div class="w-3/5 h-full bg-purple-300"></div>
        </div>
        <div class="flex w-1/2 h-9vh bg-red-200">
            <div class="w-1/2 h-full bg-green-100"></div>
            <div class="w-1/4 h-full bg-green-200"></div>
            <div class="w-1/4 h-full bg-green-300"></div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "InPageNav",
    };
</script>
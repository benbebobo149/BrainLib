<template>
    <div>
        <div class="w-screen h-1/4 bg-blue-100">
            <div class="flex w-full h-1/3 bg-green-100">
                <div class="w-1/4 h-full bg-red-100">
                    <img src="logo.png" alt="Logo">
                </div>
                <div class="w-2/4 h-full bg-red-200">
                    <p>Home Page</p>
                </div>
                <div class="w-1/4 h-full bg-red-300"></div>
            </div>
            <div class="w-full h-1/3 bg-green-200">
                <div class="w-1/4 h-full bg-yellow-300"></div>
                <div class="w-3/4 h-full bg-yellow-400">
                    <p>Activity Page</p>
                </div>
            </div>
            <div class="w-full h-1/3 bg-green-300">
                <p>All Topics</p>
            </div>
        </div>
        <div class="w-screen h-3/4 bg-blue-200"></div>
    </div>
</template>

<script>
export default {
    name: 'FrameTopic',
}
</script>
<template>
    <div class="flex w-screen h-7vh bg-gray-200">
        <div class="flex w-3/5 h-7vh bg-blue-200">
            <div class="image w-1/5 h-full bg-purple-100">
                <img src="ListNav.png" alt="ListNav">
            </div>
            <div class="flex w-2/5 h-full bg-purple-200">
                <div class="w-1/2 h-full">
                    <img src="logo.png" alt="Logo" />
                </div>
                <div class="w-1/2 h-full text-xs">
                    <p>BRAINLIBRARY</p>
                </div> 
            </div>
            <div class="w-2/5 h-full bg-purple-300"></div>
        </div>
        <div class="flex w-2/5 h-9vh bg-red-200">
            <div class="w-3/5 h-full bg-green-100"></div>
            <div class="w-2/5 h-full bg-green-200">
                <Signin />
            </div>
        </div>
    </div>
   
</template>

<script>
import Signin from './Signin.vue';

export default {
    name: "LoginNav",
    components: {
        Signin
    }
};
</script>

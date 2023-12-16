<script setup>
import AdiminiUserAuthrity from '~/components/Admini/AdiminiUserAuthrity.vue';

import { ref } from 'vue'
const showOverlay = ref(false)

const handleClick = () => {
    console.log('you had clicked the gear');
}

// define props 用戶資料
const props = defineProps({
    user: {
        type: Object,
        default: () => ({
            name: 'Default User Name',
            email: 'Default User Email',
            role: 'Default User Role',
        })
    }
})

</script>

<template>
    <div class="">
        <div class="w-1/4 h-[10vh] bg-green flex">
            <img class="w-[4vw] h-[4vw] rounded-full" src="https://via.placeholder.com/95x96" />
            <div
                class=" w-full  text-black text-l font-normal font-'Roboto' leading-loose relative flex items-center">
                {{ user.name }}
            </div>
        </div>
    </div>
</template>


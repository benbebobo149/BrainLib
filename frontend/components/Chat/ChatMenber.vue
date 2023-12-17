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
            name: 'DefaultName',
            email: 'Default User Email',
            role: 'Default User Role',
        })
    }
})

</script>

<template>
    <div class="flex relative my-2">
        <div>
            <img class="w-[4vw] h-[4vw] ml-[0.5rem] rounded-full" src="https://via.placeholder.com/95x96" />
        </div>
        <div>
            <div class="w-[4vw] h-[4vw] mx-auto ml-[1rem] text-black text-xl font-normal font-'Roboto'">
                {{user.name}}</div>
        </div>
    </div>
</template>


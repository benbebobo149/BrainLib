<script setup>
import users from '@/public/hello/Pic_Folder/fakeDataUser.json'

import { ref } from 'vue'
const showOverlay = ref(false)

const handleClick = () => {
    console.log('you had clicked the gear');
}

// define props 用戶資料
// const props = defineProps({
//     user: {
//         type: Object,
//         default: () => ({
//             name: 'DefaultName',
//             email: 'Default User Email',
//             role: 'Default User Role',
//         })
//     }
// })

</script>

<template>
    <div v-for="user in users" :key="user.id" class="flex relative my-2">
        <div>
            <img class="w-[4vw] h-[4vw] ml-[0.5rem] rounded-full" src="https://via.placeholder.com/95x96" />
        </div>
        <div>
            <p
                class="ml-[2vh] mt-[2vh] h-[full] w-[14vw] bg-text-black text-[1.4vw] font-normal font-'Roboto' flex-auto item-center">
                {{ user.name }}</p>
        </div>

    </div>
</template>


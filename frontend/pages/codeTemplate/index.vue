<script setup>
// set a useCookie


// import the modal component
import Modal from '@/components/codeTemplate/modal.vue'
import data from '@/public/fakeData.json'
const userData ={
    name: 'ben',
    age: 20
}
const areData = 'Vietnam'
const footerState = ref(false)
const open = () => {
    footerState.value = true
    console.log('open modal')
    const user = useCookie('user')
    user.value = 'ben'
}
const close = () => {
    footerState.value = false
    console.log('close modal')
}

// get the data 
const getData = async () => {
    const res = data
    const data = await res.json()
    console.log(res)
}
// read data from database
const readData = async () =>
{
    const res = await fetch('http://localhost:3000/api/user')
    const data = await res.json()
    console.log(data)
}

// send data to database
// const sendData = async () => {
//     const res = await fetch('http://localhost:3000/api/user', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(user.value)
//     })
//     const data = await res.json()
//     console.log(data)
// }

import axios from 'axios'
const config = useRuntimeConfig()

const getArea = async () => {
    axios.get(`${config.public.apiURL}/areas/?skip=0&limit=100`, {
        headers: {
            'Content-Type': 'application/json', 
        }
    })
    .then((res) => {
        // if code is 200, then hide the modal
        if(res.status == 200){
            console.log(res.data);
            areaList.value = res.data;
        }
    })
    .catch((err) => {
        // if code is 401, then show error message 
        console.log(err);
        if(err.response.status == 401){
        }
    })
};

getData()
</script>
<template>
    <h1 class="bg-black text-white">This is Header</h1>
    <button type="button" @click="open()"> Open footer</button>
    <Modal :user="userData" :area="areData" @close="close()"/>
    <input type="text">
    <button>

    </button>
    <p v-for="i in data.name"> {{ i }}</p>
    <h1 v-if="footerState" class="bg-black text-white">This is Footer</h1>
</template>
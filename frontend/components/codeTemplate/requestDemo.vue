<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';
import { useStore } from 'vuex';
const config = useRuntimeConfig()


const token = useCookie('token');
token = 123;
const getSomeData = ()=>{
    axios.get(`${config.public.apiURL}/token/check/`, {
    headers: {
        'Authorization': 'Bearer ' + token.value,
        'accept': 'application/json'
    }
})
    .then((res) => {
        // if code is 200, then hide the modal
        if (res.status == 200) {
            loginState.value = false;
            getUserData();
        }
    })
    .catch((err) => {
        // if code is 401, then show error message 
        console.log(err);
        if (err.response.status == 401) {
            loginState.value = true;
            moveToHomePath()
        }
    })
}


const insertData = ()=>{
    axios.post(`${config.public.apiURL}/APIpath`, {
    headers: {
        'Authorization': 'Bearer ' + token.value,
        'accept': 'application/json'
    }
})
    .then((res) => {
        // if code is 200, then hide the modal
        if (res.status == 200) {
        }
    })
    .catch((err) => {
        // if code is 401, then show error message 
        console.log(err);
        if (err.response.status == 401) {

        }
    })
}


</script>
<template></template>
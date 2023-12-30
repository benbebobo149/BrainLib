<script setup>
import axios from 'axios'
import { jwtDecode } from "jwt-decode";

const config = useRuntimeConfig()

let url = new URL(window.location.href);
let params = new URLSearchParams(url.hash.substring(1));
const accessToken = params.get('access_token');
//send data to database
const sendOauthToken = async () => {
    if (accessToken == null) {
        console.log('no token')
        return
    }
    axios.post(`${config.public.apiURL}/authenticate`, {
        token: accessToken,
    }, {
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then((res) => {
            // if code is 200, then hide the modal
            if (res.status == 200) {
                const token = useCookie('token');
                token.value = res.data.token;//存取token
                // Decode the token
                const decoded = jwtDecode(token.value)

                // Get the id and username
                const id = decoded.id;
                getUserInfo(id);
                
            }
        })
        .catch((err) => {
            // if code is 401, then show error message 
            console.log(err);
            if (err.response.status == 401) {
            }
        })
}

const getUserInfo = (user_id) => {
    const token = useCookie('token');
    axios.get(`${config.public.apiURL}/user/${user_id}`, {
        headers: {
            'Authorization': `Bearer ${token.value}`, //the token is a variable which holds the token
            'Content-Type': 'application/json',
        }
    })
        .then(response => {
            const name = useCookie('name');
            const id = useCookie('id');
            const image = useCookie('image');   
            const permission = useCookie('permission');
            const email = useCookie('email');
            const profile = useCookie('profile');
            email.value = response.data.email;
            permission.value = response.data.permission;
            name.value = response.data.name;
            id.value = response.data.id;
            image.value = response.data.image;
            profile.value = response.data.profile;
            reloadNuxtApp({ path: "/main", ttl: 500 });
        })
        .catch(error => {
            console.error(error);
        });
}
sendOauthToken();
</script>
<template></template>
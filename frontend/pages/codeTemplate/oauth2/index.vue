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
    axios.post(`${config.public.apiURL}/google`, {
        token: accessToken,
    }, {
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then((res) => {
            // if code is 200, then hide the modal
            if (res.status == 200) {
                console.log(res.data)
                const token = useCookie('token');
                token.value = res.data.token;//存取token
                // Decode the token
                const decoded = jwtDecode(token.value)

                // Get the id and username
                const id = decoded.id;
                const username = decoded.username;
                console.log(id, username);
                //reloadNuxtApp({ path: "/main", ttl: 500 });
            }
        })
        .catch((err) => {
            // if code is 401, then show error message 
            console.log(err);
            if (err.response.status == 401) {
            }
        })
}

sendOauthToken();
</script>
<template></template>
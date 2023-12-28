<script setup>
import axios from 'axios'
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
<template>
</template>
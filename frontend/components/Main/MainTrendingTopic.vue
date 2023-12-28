<script setup>
// import Topic from '@/public/TagFakeData/TagFakeData.json';
// const Tags = ref(Topic);
const props = defineProps({
    topic: { type: String, default: 'Topic' }
});


//get data from databaseimport axios from 'axios';
import axios from 'axios';
const config = useRuntimeConfig();

const tags = ref([]);

//get data from database
const getAllTags = () => {
    const token = useCookie('token');
    axios.get(`${config.public.apiURL}/tag`, { // config.public.apiURL + "/tag"
    }, {
        headers: {
            'Authorization': 'Bearer ' + token.value,
            'Content-Type': 'application/json',
            'accept': 'application/json'
        }
    })
        .then((res) => {
            // if code is 200, then hide the modal
            console.log(res);
            if (res.status == 200) {
                console.log("success");
                tags.value = res.data;
            }
        })
        .catch((err) => {
            // if code is 401, then show error message 
            console.log(err);
            if (err.response.status == 404) {
                console.log("fail");
            } else if (err.response.status == 500) {
                console.log("fail");
            }
        })
}

getAllTags();

</script>

<template>
    <div class="grid grid-cols-3 gap-4">
        <NuxtLink :to="`/main/${topic.id}`" @click="closeModal" v-for="topic in tags" :key="topic.id"
            class="mx-auto rounded-sm border border-terotory text-center text-neutral-900 text-l font-normal font-'Roboto' leading-7 p-[0.5vh]">
            {{ topic.tagName }}
        </NuxtLink>
    </div>
</template>
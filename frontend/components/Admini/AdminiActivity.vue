
<script setup>
import AdiminiActivityPassPopup from './AdiminiActivityPassPopup.vue';


// const props = defineProps({
//     activity: {
//         type: Object,
//         default: () => ({
//             title: 'Activity Title',
//             time: 'Activity Time',
//             location: 'Activity Location',
//             distance: 'Activity Distance',
//             description: 'Activity Description',
//             image: 'Activity Image',
//             participants: 'Activity Participants',
//             comments: 'Activity Comments',
//             likes: 'Activity Likes',
//             topic: 'Activity Topic',
//             creator: 'Activity Creator',
//         })
//     }, showPopup: {
//         type: Boolean,
//         default: false,
//     }
// })
// const { activity } = toRefs(props);

const showPopup = ref(false);

// define emit 通過或拒絕活動
const emit = defineEmits(['passActivity', 'rejectActivity'])
const passActivity = () => {
    emit('passActivity', activity.value);
    showPopup.value = true;
    console.log(showPopup); // cant get the value
}
const rejectActivity = () => {
    emit('rejectActivity', activity.value);
    alert('reject');
}

const closePopup = () => {
    showPopup.value = false;
}


//read data from database
import fakeData from '@/public/ActivityFakeData/ActivityFakeData.json'; // Adjust the path accordingly
const activities = ref(fakeData);
</script>

<template>
    <div v-for="activity in activities" :key="activity.id"
        class="w-[56vw] h-[30vh] bg-bgcolor border-b border-terotory mx-2 my-5 flex">
        <div class=" w-[14vw] h-[20vh] my-[4vh] mx-[2vw] bg-orange-500 flex">
            <div class=" h-[20vh] ">
                <img src="https://via.placeholder.com/95x96" alt="no image found">
            </div>
        </div>
        <div class="w-[24vw] h-[6vh] bg-bgcolor ">
            <div class=" mx-auto text-[2vw]">
                {{ activity.title }}
            </div>
            <div class="h-[5vh] my-[6vh]">
                {{ activity.location }}
            </div>
            <div class="flex">
                <div v-for="tag in activity.tags" :key="tag"
                    class="w-[8vw] h-[2vw] ml-[1vw] bg-purple-200 rounded  text-center text-neutral-900 text-[1.25vw] font-normal font-'Roboto'">
                    <p>{{ tag.tag_name }}</p>
                </div>
            </div>
        </div>
        <div class="h-[6vh] bg-bgcolor">
            <div class="w-1/3">
                {{ activity.date }}
            </div>
        </div>
        <div class="h-[full]  bg-bgcolor ">
            <div class="content-center flex ">
                <img class="h-[3vw] w-[3vw] mx-[2vh] my-[8vh] cursor-pointer items-center"
                    src="@/PageAdmini/XCircleFill.png" alt="no image found" @click="rejectActivity">
                <img class="h-[3vw] w-[3vw] mx-[2vh] my-[8vh] cursor-pointer items-center"
                    src="@/PageAdmini/CheckCircleFill.png" alt="no image found" @click="passActivity">
            </div>
        </div>
    </div>
    <AdiminiActivityPassPopup v-if="showPopup" @close="closePopup"></AdiminiActivityPassPopup>
</template>

<style scoped></style>

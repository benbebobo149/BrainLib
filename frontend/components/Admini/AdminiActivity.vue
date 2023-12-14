<template>
    <div>
        <div class="flex flex-col items-center justify-center w-full h-[92vh] bg-white">
            <div class="flex flex-row mt-10">
            </div>
            <component :is="currentScrollBox" class="scrollable-box" />
        </div>
    </div>
</template>

<style scoped>
.scrollable-box {
    margin-top: 3rem;
    /* Adjust the margin as needed */
    /* Additional styling if required */
}
</style>

<script>
import ScrollableBox from '@/components/Activity/ScrollableBox.vue';
import ScrollBoxByTime from '@/components/Activity/ScrollBoxByTime.vue'; // Import the component for sorting by time
import ScrollBoxByDistance from '@/components/Activity/ScrollBoxByDistance.vue'; // Import the component for sorting by distance

export default {
    components: {
        ScrollableBox,
        ScrollBoxByTime,
        ScrollBoxByDistance,
    },
    data() {
        return {
            currentScrollBox: 'ScrollableBox', // Default scroll box
        };
    },
}
</script>
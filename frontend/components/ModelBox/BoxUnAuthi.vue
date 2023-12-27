<template>
    <div class="popup-overlay">
        <div class="rounded-lg flex flex-col bg-bgcolor justify-center items-center p-5">
            <img src="/hello/XLg.png" alt="Close Button" class="h-[4vh] w-auto justify-self-end self-end cursor-pointer"
                @click="closePopup">

            <div class="relative h-[14vh] w-[17vw] ">
                <p class=" absolute w-full h-full items-center mt-[3vh] text-[2.25vw] justify-center text-center">You don't have the authirity to access.
                </p>
            </div>

            <img src="/hello/Confirm.png" alt="Save and Close Button" class="h-[7vh] w-auto mt-4 cursor-pointer"
                @click="closePopup">
        </div>
    </div>
</template>

<script setup>
import { ref, defineEmits } from 'vue';

const enteredText = ref('');
const emit = defineEmits();
const closePopup = () => {
    emit('close');
};

const saveAndClosePopup = () => {
    console.log('Entered Text:', enteredText.value);

    closePopup();
};
</script>

<style scoped>
.popup-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 10;
}

.relative {
    position: relative;
}
</style>


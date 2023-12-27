<script setup>
import { ref } from 'vue';

// Define your reactive data
const selectedOption = ref('');
const options = ref([
    { value: 'normal', text: 'Normal' },
    { value: 'administrator', text: 'Administrator' },
    { value: 'moderator', text: 'Moderator' },
]);

const submitForm = () => {
    console.log(selectedOption.value); // This will log the value of the selected option
    emit('submit');
};
</script>
<template>
    <div>
        <!-- Your other content... -->
        <select v-model="selectedOption">
            <option v-for="option in options" :key="option.value" :value="option.value">
                {{ option.text }}
            </option>
        </select>
        <button class="bg-secodery" type="submit" @click="submitForm">Confirm</button>

        <!-- Your other content... -->
    </div>
</template>


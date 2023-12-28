<script setup>
import { ref } from 'vue';

// Define your reactive data
const selectedOption = ref('');
const options = ref([
    { value: 'normal', text: 'Normal' },
    { value: 'administrator', text: 'Administrator' },
    { value: 'moderator', text: 'Moderator' },
]);

//define emit
const emit = defineEmits();

const submitForm = () => {
    console.log(selectedOption.value); // This will log the value of the selected option
    emit('saveCnage', selectedOption.value);
};
</script>
<template>
    <div>
        <!-- Your other content... -->
        <select v-model="selectedOption" class="bg-slate-200 rounded-md my-[1vh]">
            <option v-for="option in options" :key="option.value" :value="option.value">
                {{ option.text }}
            </option>
        </select>
        <button class="bg-primary text-white w-full rounded-lg " type="submit" @click="submitForm">Confirm</button>

        <!-- Your other content... -->
    </div>
</template>


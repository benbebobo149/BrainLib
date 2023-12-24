<script setup>
import { ref } from 'vue'

const selectedRole = ref('normal');
</script>
<template>
    <div>
        <!-- Your other content... -->

        <select v-model="selectedRole">
            <option value="normal">Normal</option>
            <option value="administrator">Administrator</option>
            <option value="moderator">Moderator</option>
        </select>

        <!-- Your other content... -->
    </div>
</template>


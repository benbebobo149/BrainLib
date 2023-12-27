<template>
    <button @click="Google">
        <img src="@/Signin/Google.png" alt="Google">
    </button>
</template>

<script>
import { ref } from 'vue';

export default {
    name: 'Google',
    setup() {
        const Google = () => {
            // Google button click logic here
        };

        return {
            Google
        };
    }
}
</script>
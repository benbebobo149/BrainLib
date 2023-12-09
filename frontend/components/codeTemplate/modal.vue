<script setup>
// define emit
const emit = defineEmits(['close'])

// define props
const props = defineProps({
    user: {
        type: Object,
        default: () => ({ name: 'John Doe', age: 30 })
    },
    area: {
        type: String,
        default: 'US'
    }
})
// change props to ref 
const { user, area } = toRefs(props)

// define methods
const clickButton = () => {
    console.log('click button')
    emit('close')
}

</script>

<template>
    <p> hello {{user.name}} </p>
    <p> You are from {{area}} </p>
    <button type="button" @click="clickButton()"> Click me</button>
</template>
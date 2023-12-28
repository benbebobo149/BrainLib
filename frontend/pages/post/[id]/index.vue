<script setup>
import Main from '~/components/post/Main.vue'
const route = useRoute();
const id = route.params.id;
</script>
<template>
  <div>
    <Main :id="id"/>
  </div>
</template>
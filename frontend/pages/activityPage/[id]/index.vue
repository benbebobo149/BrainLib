<script setup>
import Header from '~/components/InPageNav.vue'
import Main from '~/components/ActivityPage/Main.vue'
import Footer from '~/components/ActivityPage/Footer.vue'
const route = useRoute();
// get id of the page
const id = route.params.id;
</script>
<template>
  <div>
    <!-- <Header /> -->
    <Main :id="id" />
    <Footer :id="id"  />
  </div>
</template>
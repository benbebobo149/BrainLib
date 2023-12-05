<script setup>
//  import the Footer component
import Footer from '~/components/hello/Footer.vue'
import Header from '~/components/hello/Header.vue'
import Main from '~/components/hello/Main.vue'
import AfterFooter from '~/components/hello/AfterFooter.vue'
</script>
<template>
  <div>
    <Header /> <!-- Import and use the Header component -->
    <Main />
    <Footer />
    <AfterFooter /><!-- Import and use the Footer component -->
  </div>
</template>
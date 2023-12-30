<script setup >
import InPageNav from "@/components/InPageNav.vue";
</script>

<template>
  <div>
    <InPageNav />
    <NuxtPage />

  </div>
</template>

<style>
.page-enter-active,
.page-leave-active {
  transition: all 0.4s;
}

.page-enter-from,
.page-leave-to {
  opacity: 0;
  filter: blur(1rem);
}
</style>


<template>
    <div class="flex w-screen h-7vh bg-gray-200">
      <div class="flex w-1/2 h-7vh bg-blue-200">
        <div class="flex w-1/5 h-full bg-purple-100 items-center">
          <ListNav class="w-1/2 h-full" />
        </div>
        <div class="flex w-4/5 h-full bg-purple-300 items-center">
          <SearchButton class="w-1/2 h-full" />
        </div>
      </div>
      <div class="flex w-1/2 h-7vh bg-red-200">
        <div class="flex w-3/5 h-full bg-green-100 items-center justify-end">
          <PencilButton class="w-1/6 h-full" />
        </div>
        <div class="flex w-2/5 h-full bg-green-200 items-center justify-end">
          <Signin class="w-1/3 h-full" />
        </div>
      </div>
    </div>
  </template>
  

<script>
import Signin from "./Signin.vue";
import SearchButton from "./SearchButton.vue";
import ListNav from "./ListNav.vue";
import PencilButton from "./PencilButton.vue";

export default {
    name: "LoginNav",
    components: {
        Signin,
        SearchButton,
        ListNav,
        PencilButton
    }
};
</script>

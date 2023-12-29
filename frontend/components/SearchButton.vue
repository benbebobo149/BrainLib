<template>
  <div class="flex">
    <div class="w-1/4">
      <button @click="search ">
      <img class="w-2/3 h-full" src="Search.png" alt="Search" />
    </button>
    </div>
    <div class="w-3/4">
      <input class="w-full h-2/3" type="text" v-model="searchText" />
    </div>
  </div>
</template>

<script>
import { ref } from "vue";
import SearchSticker from "./SearchSticker.vue";
export default {
  name: "SearchButton",
  stickerVisible: ref(false),
  data() {
    return {
      searchText: "",
    };
  },
  methods: {
    search() {
      // Perform search logic here
      stickerVisible.value = true;
      console.log("Searching for:", this.searchText);
    },
  },
};
</script>


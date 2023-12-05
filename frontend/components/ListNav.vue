<template>
    <button @click="ListNav">
        <img src="ListNav.png" alt="ListNav">
    </button>
    <!-- <div v-if="ListNavVisible" class="flex-none w-1/4 h-screen bg-purple-100">
      <div class="bg-white p-6 rounded shadow-md relative">
        <button @click="closeModal" class="absolute top-2 right-2 text-xl font-bold cursor-pointer">&times;</button>
        <div class="text-center mb-4">
          <p class="text-lg font-semibold">Sign in to Brain Library</p>
        </div>
        <div class="flex justify-center gap-4">
          <div>
            <Google class="w-24 h-24"></Google>
          </div>
        </div>
      </div>
    </div> -->
</template>

<script>
export default {
    name: 'ListNav',
    data() {
    return {
      ListNavVisible: false
    };
  },
  methods: {
    openModal() {
      this.ListNavVisible = true;
    },
    closeModal() {
      this.ListNavVisible = false;
    }
  }
}
</script>
<template>
  <div class="popup-overlay">
    <div class="rounded-lg flex flex-col bg-white justify-center items-center p-5">
      <img src="/hello/XLg.png" alt="Close Button" class="h-[3vh] w-auto justify-self-end self-end" @click="closePopup">

      <!-- Rectangle7.png image as a background -->
      <div class="relative mb-4">
        <img src="/hello/Rectangle7.png" alt="Rectangle Box" class="h-[8vh] w-auto cursor-pointer" />
        <!-- Entered text overlay -->
        <input v-model="enteredText"
          class="absolute top-0 left-0 right-0 bottom-0 p-2 w-full h-full bg-transparent border-none rounded-full"
          placeholder="Enter your text" />
      </div>

      <!-- Confirm.png image to save and close -->
      <img src="/hello/Confirm.png" alt="Save and Close Button" class="h-[5vh] w-auto mt-4 cursor-pointer"
        @click="saveAndClosePopup">
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      enteredText: '', // Variable to store the entered text
    };
  },
  methods: {
    closePopup() {
      this.$emit('close'); // Emit an event to close the popup
    },
    saveAndClosePopup() {
      // Do something with the entered text (e.g., save to a variable or perform an action)
      console.log('Entered Text:', this.enteredText);

      // Close the popup
      this.closePopup();
    },
  },
};
</script>

<style scoped>
.popup-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}

/* Adjust the styling as needed for the overlay */
.relative {
  position: relative;
}
</style>

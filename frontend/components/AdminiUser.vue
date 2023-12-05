<script setup>
import { ref } from 'vue'
const showOverlay = ref(false)

const handleClick = () => {
	console.log('you had clicked the gear');
}

</script>

<template>
	<div class="bg-green-300 ">
		<div class="w-1/4 h-[10vh] bg-green-400 flex">
			<img class="w-12/96 h-12/96 rounded-full" src="https://via.placeholder.com/95x96" />
			<div class="left-6 w-36/96 bg-green-200 text-black text-xl font-normal font-['Roboto'] leading-loose relative">
				benbenboo
			</div>
			<img class="left-[20vw] w-[3vw] h-[3vw] ml-[0.5rem] cursor-pointer relative" src="@/PageAdmini/GearFill.png" @click="handleClick" />
		</div>
	</div>

	<div v-if="showOverlay" class="w-[10vw] h-[10vh] fixed inset-0 bg-black bg-opacity-50">

	</div>
</template>


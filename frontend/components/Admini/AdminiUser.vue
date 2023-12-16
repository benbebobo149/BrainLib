<script setup>
import AdiminiUserAuthrity from '~/components/Admini/AdiminiUserAuthrity.vue';

import { ref } from 'vue'
const showOverlay = ref(false)

const handleClick = () => {
	console.log('you had clicked the gear');
}

</script>

<template>
	<div class="">
		<div class="w-1/4 h-[10vh] bg-green flex">
			<img class="w-[4vw] h-[4vw] rounded-full" src="https://via.placeholder.com/95x96" />
			<div
				class="left-[10vw] w-[10vw] bg text-black text-xl font-normal font-'Roboto' leading-loose relative flex items-center">
				benbenboo
			</div>
			<!-- <img class="left-[20vw] w-[3vw] h-[3vw] ml-[0.5rem] relative flex cursor-pointer items-center"
				src="@/PageAdmini/GearFill.png" @click="handleClick" /> -->
			<div class="left-[20vw] w-[3vw] h-[3vw] ml-[0.5rem] relative flex cursor-pointer items-center">
				<AdiminiUserAuthrity class="bg-primary broder"></AdiminiUserAuthrity>
			</div>
		</div>
	</div>

	<div v-if="showOverlay" class="w-[10vw] h-[10vh] fixed inset-0 bg-black bg-opacity-50">

	</div>
</template>


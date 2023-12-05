<script setup>
import PostPreview from '@/components/PostPreview';
import AdiminiLeftBar from '~/components/AdiminiLeftBar.vue';
import AdminiUser from '~/components/AdminiUser.vue';

import { ref } from 'vue';

const topicDescription = ref('Enter topic description');
const topicName = ref('Enter topic name');
</script>

<template>
	<!-- temp navbar -->
	<div class=" bg-#E8DEF8 w-screen h-[8vh]">
		<div class=" bg-#E8DEF8 w-screen h-[8vh]">
			<div class="bg-primary">
				<h1> this is temp navbar THIS IS MANAGE USER PAGE</h1>
			</div>

		</div>
		<div class="flex ">
			<!-- 左邊列表 -->
			<div class="w-1/5  bg-indigo-100 overflow-x-auto">
				<div class=" bg-#E8DEF8 w-screen ">
					<AdiminiLeftBar />
				</div>
			</div>

			<!-- 右邊部分 -->
			<div class="w-4/5 h-[100vh] bg-indigo-200">
				<div class="h-[10vh] bg-white ">

					<div class=" text-stone-400 ">
						<h1 class="left-[8vw] w-[45vw]  h-[0.5vw] text-[3vw] font-normal font-['Roboto']
						 relative">Create New Topic</h1>
					</div>
				</div>

				<div class="content-normal">

					<div class=" h-[10vw] bg-slate-50 content-center relative my-[4vh] mx-[10vw]">
						this is Topic
					</div>
					<div class="left-[25vw] my-[4vh]  text-black text-xl font-normal font-['Roboto'] leading-7  relative">
						Topic name
					</div>

					<div
						class=" left-[8vw] w-[18vw] h-[8vh]  bg-white mx-[20vw] rounded-md border border-black border-opacity-10  relative">
						<input
							class="left-[8vw] w-[18vw] h-[8vh] grow shrink basis-0  text-black text-opacity-50 text-lg font-normal font-['Roboto'] leading-7"
							type="text" v-model="topicName">
					</div>

					<div class="left-[25vw] my-[4vh]  text-black text-xl font-normal font-['Roboto'] leading-7 relative">Description</div>

					<div
						class=" left-[8vw] w-[18vw] h-[8vh]  bg-white mx-[20vw] rounded-md border border-black border-opacity-10  relative">
						<input
							class="left-[8vw] w-[18vw] h-[8vh] grow shrink basis-0  text-black text-opacity-50 text-lg font-normal font-['Roboto'] leading-7"
							type="text" v-model="topicDescription">
					</div>

					<div class=" w-[25vw] h-[4vw] bg-slate-300 mx-[25vw]">
						<div
							class="left-[8vw] w-[8vw] h-[8vh] p-3 bg-slate-500 rounded-lg flex-col justify-center items-center inline-flex relative">
							<div class="text-white text-xl font-normal font-['Roboto'] leading-7">Create</div>
						</div>
					</div>
				</div>
			</div>
		</div>

</div></template>
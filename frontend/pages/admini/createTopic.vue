
<script setup>
import PostPreview from '@/components/PostPreview';
import AdiminiLeftBar from '~/components/Admini/AdiminiLeftBar.vue';
import AdminiUser from '~/components/Admini/AdminiUser.vue';
import InPageNav from '~/components/InPageNav.vue';
import axios from 'axios';
const config = useRuntimeConfig();

import { ref } from 'vue';

const topicDescription = ref('');
const topicName = ref('');

const sendData = () => {
	console.log(topicName.value);
	const token = useCookie('token');
	axios.post(`${config.public.apiURL}/tag`, { // config.public.apiURL + "/tag"
		"tagName": topicName.value,
	}, {
		headers: {
			'Authorization': 'Bearer ' + token.value,
			'Content-Type': 'application/json',
			'accept': 'application/json'
		}
	})
		.then((res) => {
			// if code is 200, then hide the modal
			console.log(res);
			if (res.status == 200) {
				window.location.reload();
				alert("Create Topic Success");
				console.log("success");
			}
		})
		.catch((err) => {
			// if code is 401, then show error message 
			console.log(err);
			if (err.response.status == 401) {
				window.location.reload();
				alert("Create Topic Fail");
				console.log("fail");
			}
		})
}
</script>

<template>
	<!-- temp navbar -->
	<div class=" bg-bgcolor  w-screen h-[8vh]">

		<div class="flex ">
			<!-- 左邊列表 -->
			<div class="w-1/5 rounded-sm border-r border-terotory  bg-bgcolor ">
				<div class=" bg-#E8DEF8 w-screen overflow-y-scroll fixed left-0">
					<AdiminiLeftBar />
				</div>
			</div>

			<!-- 右邊部分 -->
			<div class="w-4/5 h-[100vh] bg-bgcolor fixed right-0">
				<div class="h-[10vh] bg-bgcolor ">

					<div class=" text-stone-400 ">
						<h1 class="left-[8vw] w-[45vw]  h-[0.5vw] text-[3vw] font-normal font-'Roboto'
						 relative">Create New Topic</h1>
					</div>
				</div>

				<div class="content-normal">

					<div class=" h-[4vw] content-center text-[3vw] relative my-[4vh] mx-[10vw]">
						this is Topic
					</div>
					<div class="left-[25vw] my-[4vh]  text-black text-xl font-normal font-'Roboto' leading-7  relative">
						Topic name
					</div>

					<div
						class=" left-[8vw] w-[18vw] h-[8vh]  bg-white mx-[20vw] rounded-md border border-black border-opacity-10  relative">
						<input v-model="topicName"
							class="left-[8vw] w-[18vw] h-[8vh] grow shrink basis-0 rounded-lg text-black text-opacity-50 text-lg font-normal font-Roboto leading-7  pl-[1vw]"
							type="text" placeholder="topicName">
					</div>

					<div class="left-[25vw] my-[4vh]  text-black text-xl font-normal font-'Roboto' leading-7 relative">
						Description
					</div>

					<div
						class=" left-[8vw] w-[18vw] h-[8vh]  bg-white mx-[20vw] rounded-md border border-black border-opacity-10  relative">
						<input v-model="topicDescription"
							class="left-[8vw] w-[18vw] h-[8vh] grow shrink basis-0  rounded-lg text-black text-opacity-50 text-lg font-normal font-'Roboto' leading-7 pl-[1vw]"
							type="text" placeholder="topicDescription">
						<!-- <button @click="sendData()" class="bg-black text-color-white">
							click me
						</button> -->
					</div>

					<div class=" w-[25vw] h-[4vw] my-[10vh] mx-[25vw]">
						<div class="left-[8vw] w-[8vw] h-[8vh]  p-3 bg-primary rounded-lg flex-col justify-center items-center inline-flex relative"
							@click="sendData()">
							<div class="text-white  text-xl font-normal font-'Roboto' leading-7  cursor-pointer">Create
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</template>
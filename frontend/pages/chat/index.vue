<script setup >
import InPageNav from '~/components/InPageNav.vue';
import ChatMenber from '~/components/Chat/ChatMenber.vue';
// onMounted(() => {
// 	console.log('mounted');
// 	Pusher.logToConsole = true;

// 	const pusher = new Pusher('25291c0752d6089a660c', {
// 		cluster: 'eu'
// 	});

// 	const channel = pusher.subscribe('chat');
// 	channel.bind('message', data => {
// 		messages.value.push(data);
// 	});
// });

const messages = ref([]);
const message = ref('');

const submit = () => {
	messages.value.push(message.value);
	message.value = '';
};
</script>
<template>
	<!-- temp navbar -->
	<div class=" bg-bgcolor w-screen h-[8vh]">
		<div class="flex h-full">
			<!-- 左邊對話列表 -->
			<div class="w-1/5 h-[100vh] ">
				<!-- 好友名單 -->
				<div>
					<ChatMenber></ChatMenber>
				</div>
			</div>

			<!-- 右邊聊天室 -->
			<div class="w-4/5 h-[120vh] bg-indigo-200">

				<!-- 對方訊息 -->
				<div v-for="message in messages" :key="message">
					<div>
						<img class="w-[4vw] h-[4vw] ml-[0.5rem] rounded-full" src="https://via.placeholder.com/95x96" />
					</div>
					<div>
						<p class="">{{ message.message }}</p>
					</div>
				</div>
				<!-- 我方訊息 -->
				<div>

				</div>
				<form
					class="w-2/3  h-[6vh] top-[90vh] left-[70vh] mx-auto bg-zinc-300 bg-opacity-80 rounded-3xl z-10   fixed"
					@submit.prevent="submit">

					<input v-model="enteredText"
						class="absolute p-[2vh] w-full h-full bg-transparent border-none rounded-full"
						placeholder="Enter your text" />
				</form>
			</div>
		</div>

	</div>
</template>

<!-- create group -->
				<!-- <div class="h-[12vh] bg-bgcolor  bg-error border-b border-terotory  flex">
					<div>
						<img class=" mx-auto ml-[1rem] w-[4vw] h-[4vw] rounded-full" src="https://via.placeholder.com/95x96" />
					</div >
					<div class=" mx-auto ml-[1rem] text-black text-xl font-normalfont-'Roboto' leading-10"> create group</div>
				</div> -->

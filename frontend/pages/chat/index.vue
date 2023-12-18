<script setup>
import InPageNav from '~/components/InPageNav.vue';
import ChatMenber from '~/components/Chat/ChatMenber.vue';
// import  ChatFreinds  from '#build/components';
</script>
<template>
	<!-- temp navbar -->
	<div class=" bg-bgcolor w-screen h-[8vh]">
		 <div class="flex h-full"> 
			 <!-- 左邊對話列表 -->
			<div class="w-1/5 h-[100vh] ">
				<!-- create group -->
				<!-- <div class="h-[12vh] bg-bgcolor  bg-error border-b border-terotory  flex">
					<div>
						<img class=" mx-auto ml-[1rem] w-[4vw] h-[4vw] rounded-full" src="https://via.placeholder.com/95x96" />
					</div >
					<div class=" mx-auto ml-[1rem] text-black text-xl font-normalfont-'Roboto' leading-10"> create group</div>
				</div> -->

				<!-- 好友名單 -->
				<div>

					<ChatMenber></ChatMenber>

				</div>


			</div>

			<!-- 右邊聊天室 -->
			<div class="w-4/5 h-[120vh] bg-indigo-200">
				<div class="w-2/3  h-[6vh] top-[90vh] left-[70vh] mx-auto bg-zinc-300 bg-opacity-80 rounded-3xl z-10   fixed">
					<h1 class="items-end">hello</h1>
			</div>
		</div>
	</div>

</div>
</template>
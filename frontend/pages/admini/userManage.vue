<script setup>
import PostPreview from '@/components/PostPreview';
import AdiminiLeftBar from '~/components/Admini/AdiminiLeftBar.vue';
import AdminiUser from '~/components/Admini/AdminiUser.vue';
import InPageNav from '~/components/InPageNav.vue';
import axios from 'axios';

import BoxSucc from '~/components/ModelBox/BoxSucc.vue';
import BoxError from '~/components/ModelBox/BoxError.vue';
const SelectAllModerators = () => {
	console.log("Select All Moderators");
};
const SelectAllAdministrators = () => {
	console.log("Select All Administrators");
};





</script>

<template>
	<!-- temp navbar -->
	<div class=" bg-bgcolor w-screen h-[8vh]  max-w-full max-h-full">
		<div class="flex ">
			<!-- 左邊列表 -->
			<div class="w-1/5 h-full bg-bgcolor rounded-sm fixed left-0">
				<div class=" bg-#E8DEF8 w-screen ">
					<AdiminiLeftBar />
				</div>
			</div>

			<!-- 右邊部分 -->
			<div class="w-4/5 h-[100vh] bg-bgcolor border-l border-terotory absolute right-0">
				<div class="h-[10vh]  ">
					<div class="mt-[5vh] ml-[10vw] text-stone-400 ">
						<!-- <h1 class="left-[25vw] w-[45vw]  h-[0.5vw] text-[3vw] font-normal font-['Roboto']
						 relative">here comes a search box</h1> -->
						<!-- <div class="flex w-4/5 h-full items-center ml-5">
							<div class="w-full">
								<button @click="SelectAllModerators" class="text-2xl font-bold text-black ">Select
									All
									Moderators</button>
								<button @click="SelectAllAdministrators" class="text-2xl font-bold text-black ml-4">Select
									All Administrators</button>
							</div>
						</div> -->
					</div>
				</div>
				<div class="w-[80vw] h-[80vh]  overflow-y-hidden">
					<div class="w-auto h-full overflow-y-scroll hide-scrollbar fill-available">

						<div class="flex">
							<div class=" content-center relative ml-[10vw]">
								<AdminiUser/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<style scoped>
.hide-scrollbar::-webkit-scrollbar {
	display: none;
	/* 隱藏滾動條 - WebKit browsers */
}

/* 使用 Flexbox 使容器充滿空間 */
.fill-available {
	display: flex;
	flex-direction: column;
}
</style>
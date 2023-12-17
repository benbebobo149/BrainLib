<script setup>
import PostPreview from '@/components/PostPreview';
import AdiminiLeftBar from '~/components/Admini/AdiminiLeftBar.vue';
import AdminiUser from '~/components/Admini/AdminiUser.vue';
import InPageNav from '~/components/InPageNav.vue';

const SelectAllModerators = () => {	
	console.log("Select All Moderators");
};
const SelectAllAdministrators = () => {	
	console.log("Select All Administrators");
};

</script>

<template>
	<!-- temp navbar -->
	<div class=" bg-bgcolor w-screen h-[8vh] ">
		<div class="flex ">
			<!-- 左邊列表 -->
			<div class="w-1/5  bg-bgcolor rounded-sm border-r border-terotory ">
				<div class=" bg-#E8DEF8 w-screen ">
					<AdiminiLeftBar />
				</div>
			</div>

			<!-- 右邊部分 -->
			<div class="w-4/5 h-[100vh] bg-bgcolor">
				<div class="h-[10vh]  ">
					<div class="mt-[5vh] ml-[10vw] text-stone-400 ">
						<!-- <h1 class="left-[25vw] w-[45vw]  h-[0.5vw] text-[3vw] font-normal font-['Roboto']
						 relative">here comes a search box</h1> -->
						<div class="flex w-4/5 h-full items-center ml-5">
							<div class="w-full">
								<button @click="SelectAllModerators" class="text-2xl font-bold text-black ">Select All Moderators</button>
								<button @click="SelectAllAdministrators" class="text-2xl font-bold text-black ml-4">Select All Administrators</button>
							</div>
						</div>
					</div>
				</div>
				<div class="flex">
					<div class=" content-center relative ml-[10vw]">
						<AdminiUser />
						<AdminiUser />
						<AdminiUser />
						<AdminiUser />
						<AdminiUser />
						<AdminiUser />
					</div>

				</div>
			</div>
		</div>

	</div>
</template>
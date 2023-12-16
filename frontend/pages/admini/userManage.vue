<script setup>
import PostPreview from '@/components/PostPreview';
import AdiminiLeftBar from '~/components/Admini/AdiminiLeftBar.vue';
import AdminiUser from '~/components/Admini/AdminiUser.vue';
import InPageNav from '~/components/InPageNav.vue';
</script>

<template>
	<!-- temp navbar -->
	<div class=" bg-bgcolor w-screen h-[8vh] ">
	      <InPageNav></InPageNav>
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
					<div class=" text-stone-400 ">
						<h1 class="left-[25vw] w-[45vw]  h-[0.5vw] text-[3vw] font-normal font-['Roboto']
						 relative">here comes a search box</h1>
					</div>
				</div>
				<div class="flex">
					<div class=" content-center relative ml-[20vw]">
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
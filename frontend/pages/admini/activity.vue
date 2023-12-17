<script setup>
import PostPreview from '@/components/PostPreview';
import { useRouter } from 'vue-router';
import AdiminiLeftBar from '~/components/Admini/AdiminiLeftBar.vue';
import InPageNav from '~/components/InPageNav.vue';
import AdminiActivity from '~/components/Admini/AdminiActivity.vue';
import Main from '~/components/Activity/Main.vue';
const router = useRouter()

const goToPage = () => {
	router.push('/your-path')
}
</script>

<template>
	<!-- temp navbar -->
	<div class=" bg-bgcolor  w-screen">

		<div class="flex ">
			<!-- 左邊列表 -->
			<div class="w-1/5 rounded-sm border-r border-terotory bg-bgcolor ">
				<div class=" bg-#E8DEF8 w-screen overflow-y-scroll ">
					<AdiminiLeftBar />
				</div>
			</div>

			<!-- 右邊部分 -->
			<div class="w-4/5 h-[100vh] bg-bgcolor">
				<div class="h-[10vh] bg-bgcolor ">
					<div class=" text-bgcolor ">
						<h1 class="left-20 w-[45vw] h-[0.5vw] text-[3vw] text-terotory font-normal font-'Roboto' relative">Activity Approvals
						</h1>
					</div>
				</div>
				<div class="ml-[10vw] flex">
					<div class=" bg-bgcolor w-full h-[30vh] content-center">
						<AdminiActivity></AdminiActivity>
						<AdminiActivity></AdminiActivity>
						<AdminiActivity></AdminiActivity>
						<AdminiActivity></AdminiActivity>
						<AdminiActivity></AdminiActivity>
					</div>

				</div>
			</div>
		</div>

	</div>
</template>
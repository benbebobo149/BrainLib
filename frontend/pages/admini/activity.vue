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
			<div class="w-1/5 h-full rounded-sm  bg-bgcolor left-0 fixed">
				<div class=" bg-#E8DEF8 w-screen overflow-y-scroll ">
					<AdiminiLeftBar />
				</div>
			</div>

			<!-- 右邊部分 -->
			<div class="w-4/5 h-full bg-bgcolorborder-l border-terotory absolute right-0">
				<div class="h-[10vh] bg-bgcolor ">
					<div class=" text-bgcolor ">
						<h1 class="left-20 w-[45vw] h-[0.5vw] text-[3vw] text-terotory font-normal font-'Roboto' relative">
							Activity Approvals
						</h1>
					</div>
				</div>
				<div class="ml-[10vw] ">
					<div class=" bg-bgcolor w-full h-[80vh] content-center overflow-y-hidden">
						<div class="w-auto h-full overflow-y-scroll hide-scrollbar fill-available ">
							<AdminiActivity></AdminiActivity>
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
<script setup>
import PostPreview from '@/components/PostPreview';
import { useRouter } from 'vue-router';
import AdiminiLeftBar from '~/components/Admini/AdiminiLeftBar.vue';
import InPageNav from '~/components/InPageNav.vue';

const router = useRouter()

const goToPage = () => {
	router.push('/your-path')
}
</script>

<template>
	<!-- temp navbar -->
	<div class=" bg-bgcolor  w-screen h-[8vh]">
		<InPageNav></InPageNav>

		<div class="flex ">
			<!-- 左邊列表 -->
			<div class="w-1/5 rounded-sm border-r border-terotory bg-bgcolor">
				<div class=" bg-#E8DEF8 w-screen ">
					<AdiminiLeftBar />
				</div>
			</div>

			<!-- 右邊部分 -->
			<div class="w-4/5 h-[100vh] bg-bgcolor">
				<div class="h-[10vh] bg-white ">
					<div class=" text-stone-400 ">
						<h1 class="left-20 w-[45vw]  h-[0.5vw] text-[3vw] font-normal font-['Roboto'] relative">Activity Approvals
						</h1>
					</div>
				</div>
				<div class="flex">
					<div class=" bg-slate-50 content-center">
						<PostPreview />
						<PostPreview />
						<PostPreview />
						<PostPreview />
						<PostPreview />
						<PostPreview />
					</div>

				</div>
			</div>
		</div>

	</div>
</template>
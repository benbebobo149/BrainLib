<script setup>
import PostPreview from '@/components/PostPreview';
import { useRouter } from 'vue-router';
import AdiminiLeftBar from '~/components/Admini/AdiminiLeftBar.vue';
import AdiminiReportPost from '~/components/Admini/AdiminiReportPost.vue';
const router = useRouter()

const goToPage = () => {
	router.push('/your-path')
}

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
				console.log("success");
			}
		})
		.catch((err) => {
			// if code is 401, then show error message 
			console.log(err);
			if (err.response.status == 401) {
				console.log("fail");
			}
		})
}
</script>

<template>
	<!-- temp navbar -->
	<div class=" bg-bgcolor  w-screen h-[8vh]">

		<div class=" bg-bgcolor  flex ">
			<!-- 左邊列表 -->
			<div class="w-1/5 h-full rounded-sm bg-bgcolor left-0 fixed">
				<div class=" bg-#E8DEF8 w-screen  ">
					<div class="">
						<AdiminiLeftBar class="border-r border-terotory" />

					</div>
				</div>
			</div>

			<!-- 右邊部分 -->
			<div class="absolute right-0 w-4/5 h-[100vh] bg-bgcolor border-l border-terotory ">
				<div class="h-[10vh] bg-bgcolor ">
					<div class=" text-stone-400 ">
						<h1 class="left-20 w-[45vw]  h-[0.5vw] text-[3vw] mt-[20vh] font-normal font-'Roboto' relative">This is administrator page </h1>
					</div>
				</div>
				<div class="ml-[1vw] pb-0">
					<div class=" bg-bgcolor w-full h-[80vh] content-center overflow-y-hidden">
						<div class="w-auto h-full overflow-y-scroll hide-scrollbar fill-available ">
							<AdiminiReportPost></AdiminiReportPost>
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
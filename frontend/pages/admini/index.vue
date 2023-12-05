<script setup>
import PostPreview from '@/components/PostPreview';
import { useRouter } from 'vue-router';

const router = useRouter()

const goToPage = () => {
	router.push('/your-path')
}
</script>

<template>
	<!-- temp navbar -->
	<div class=" bg-#E8DEF8 w-screen h-[8vh]">
		<div class=" bg-#E8DEF8 w-screen h-[8vh]">
			<div class="bg-primary">
				<h1> this is temp navbar</h1>
			</div>

		</div>
		<div class="flex h-full">
			<!-- 左邊對話列表 -->
			<div class="w-1/5 h-[100vh] bg-indigo-100 ">
				<div>


					<button class="hover:bg-indigo-200 ease-in-out duration-200">
						<router-link to="/your-path">
							<div class="flex relative my-2 justify-center content-center">
								<div>
									<img class="left-2 w-[5vw] h-[3vw] ml-[0.5rem] relative"
										src="@/PageAdmini/ExclamationOctagonFill.png" />
								</div>
								<div>
									<div
										class="w-[16vw] h-[4vw] left-[1vw] text-left mx-auto ml-[1rem] text-black text-[1.5vw] font-normal font-['Roboto'] text-leftleading-10 relative">
										Reported Posts</div>
								</div>
							</div>
						</router-link>
					</button>

					<button class="hover:bg-indigo-200 ease-in-out duration-200">
						<router-link to="/your-path">
							<div class="flex relative my-2 justify-center content-center">
								<div>
									<img class="left-2 w-[5vw] h-[3vw] ml-[0.5rem] relative" src="@/PageAdmini/CalendarCheckFill.png" />
								</div>
								<div>
									<div
										class="w-[16vw] h-[4vw] left-[1vw] text-left mx-auto ml-[1rem] text-black text-[1.5vw] font-normal font-['Roboto'] text-leftleading-10 relative">
										Activities Approvals </div>
								</div>
							</div>
						</router-link>
					</button>

					<button class="hover:bg-indigo-200 ease-in-out duration-200">
						<router-link to="/your-path">
							<div class="flex relative my-2 justify-center content-center">
								<div>
									<img class="left-2 w-[5vw] h-[3vw] ml-[0.5rem] relative" src="@/PageAdmini/CalendarCheckFill.png" />
								</div>
								<div>
									<div
										class="w-[16vw] h-[4vw] left-[1vw] text-left mx-auto ml-[1rem] text-black text-[1.5vw] font-normal font-['Roboto'] text-leftleading-10 relative">
										Create Topic </div>
								</div>
							</div>
						</router-link>
					</button>

				</div>

			</div>

			<!-- 右邊部分 -->
			<div class="w-4/5 h-[100vh] bg-indigo-200">
				<div class="h-[10vh] bg-white ">
					<div class=" text-stone-400 ">
						<h1 class="left-20  h-[0.5vw] text-[3vw] font-normal font-['Roboto'] relative">Reported Posts</h1>
					</div>
				</div>
				<div class="flex">
					<div class=" bg-slate-50 content-center">
						<PostPreview />
						<PostPreview />
						<PostPreview />
					</div>

				</div>
			</div>
		</div>

	</div>
</template>
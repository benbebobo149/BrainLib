<template>
	<div>
		<!-- 左邊列表 -->
		<div class="w-1/5  bg-indigo-100 ">
			<div class="">
				<button class="bg-indigo-100 hover:bg-indigo-200 ease-in-out duration-200">
					<router-link to="./">
						<div class="flex relative my-2 justify-center content-center">
							<div>
								<img class="left-2 w-[5vw] h-[3vw] ml-[0.5rem] relative" src="@/PageAdmini/ExclamationOctagonFill.png" />
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
					<router-link to="./activity">
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
					<router-link to="./createTopic">
						<div class="flex relative my-2 justify-center content-center">
							<div>
								<img class="left-2 w-[5vw] h-[3vw] ml-[0.5rem] relative" src="@/PageAdmini/Vector.png" />
							</div>
							<div>
								<div
									class="w-[16vw] h-[4vw] left-[1vw] text-left mx-auto ml-[1rem] text-black text-[1.5vw] font-normal font-['Roboto'] text-leftleading-10 relative">
									Create Topic </div>
							</div>
						</div>
					</router-link>
				</button>

				<button class="hover:bg-indigo-200 ease-in-out duration-200">
					<router-link to="./userManage">
						<div class="flex relative my-2 justify-center content-center">
							<div>
								<img class="left-2 w-[5vw] h-[3vw] ml-[0.5rem] relative" src="@/PageAdmini/PeopleFill.png" />
							</div>
							<div>
								<div
									class="w-[16vw] h-[4vw] left-[1vw] text-left mx-auto ml-[1rem] text-black text-[1.5vw] font-normal font-['Roboto'] text-leftleading-10 relative">
									Manage Users </div>
							</div>
						</div>
					</router-link>
				</button>

			</div>

		</div>

	</div>
</template>
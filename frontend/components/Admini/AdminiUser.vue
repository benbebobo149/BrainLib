<script setup>
import AdiminiUserAuthrity from '~/components/Admini/AdiminiUserAuthrity.vue';
import users from '@/public/hello/Pic_Folder/fakeDataUser.json'
import { ref } from 'vue'
const showOverlay = ref(false)

// const handleClick = () => {
// 	console.log('you had clicked the gear');
// }

const DeleteAccount = () => {
	console.log("DeleteAccount in ManageUser.vue");
	alert("確認是否刪除帳號");
};
// const props = defineProps({
// 	user: {
// 		type: Object,
// 		default: () => ({
// 			name: 'DefaultName',
// 			email: 'Default User Email',
// 			role: 'Default User Role',
// 		})
// 	}
// }) 
</script>

<template>
	<div v-for="user in users" :key="user.id" class="">
		<div class="w-1/4 h-[12vh] bg-green flex">
			<img class="w-[4vw] h-[4vw] rounded-full" src="https://via.placeholder.com/95x96 " />
			<div >
				<p class="ml-[2vh] mt-[2vh] h-[full] w-[20vw] bg-primary text-black text-xl font-normal font-'Roboto' flex-auto item-center">{{ user.name }}</p>
			</div>

			<div class="ml-[6vw] ] w-[20vw] flex">
				<button @click="DeleteAccount" class="h-[3vw] w-[3vw] justify-center">
					<img src="@/PhotoSticker/DeleteAccount.png" alt="Delete Account" class="w-full h-auto">
				</button>
				<button @click="DeleteAccount" class="w-[10vw] text-[vw] flex items-center ml-5  h-auto">
					<p>Delete User</p>
				</button>
			</div>

			<!-- <img class="left-[20vw] w-[3vw] h-[3vw] ml-[0.5rem] relative flex cursor-pointer items-center"
				src="@/PageAdmini/GearFill.png" @click="handleClick" /> -->
			<div class="left-[4vw] w-[3vw] h-[3vw] ml-[2vw] relative flex cursor-pointer items-center">
				<AdiminiUserAuthrity class="bg-primary broder"></AdiminiUserAuthrity>
			</div>
		</div>
	</div>

	<div v-if="showOverlay" class="w-[10vw] h-[10vh] fixed inset-0 bg-black bg-opacity-50">

	</div>
</template>


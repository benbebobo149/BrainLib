<script setup>
import AdiminiUserAuthrity from '~/components/Admini/AdiminiUserAuthrity.vue';
// import users from '@/public/hello/Pic_Folder/fakeDataUser.json'
import { ref } from 'vue'
const showOverlay = ref(false)
var selectedOption = 0;
// const handleClick = () => {
// 	console.log('you had clicked the gear');
// }

const options = ref([
	{ value: 0, text: 'Normal' },
	{ value: 1, text: 'Moderator' },
	{ value: 2, text: 'Administrator' },
]);

const DeleteAccount = () => {
	console.log("DeleteAccount in ManageUser.vue");
	confirm("確認是否刪除帳號");
};

const updateData = async (value) => {
	console.log("updateData in ManageUser.vue");
	selectedOption = value;
	console.log(" selectedOption is" + selectedOption);

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


//get data from databaseimport axios from 'axios';
import axios from 'axios';
const config = useRuntimeConfig();

const users = ref([]);

//get data from database
const getAlluser = () => {
	console.log("DeleteAccount in ManageUser.vue");
	const token = useCookie('token');
	axios.get(`${config.public.apiURL}/user/all`, { // config.public.apiURL + "/tag"
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
				users.value = res.data;
			}
		})
		.catch((err) => {
			// if code is 401, then show error message 
			console.log(err);
			if (err.response.status == 404) {
				console.log("fail");
			} else if (err.response.status == 500) {
				console.log("fail");
			}
		})
}

getAlluser();

//delete user // didnt finish

const deUser = ref('');

const deleteUser = (userDeleted) => {
	if (confirm("確認是否刪除帳號")) {
		console.log("DeleteAccount in ManageUser.vue");
		const token = useCookie('token');
		axios.delete(`${config.public.apiURL}/user/${userDeleted.id}`, {
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
					console.log("success to delte");
					users.value = res.data;
				}
			})
			.catch((err) => {
				// if code is 401, then show error message 
				console.log(err);
				if (err.response.status == 401) {
					console.log("fail to delte");
				} else if (err.response.status == 404) {
					console.log("fail to delte");
				}
				else if (err.response.status == 500) {
					console.log("fail to delte");
				}
			})
	}
}

//change permission
let permiLevel = 0;

const changePermission = (userChaged) => {
	// check the usr data is null or not if it is null give a temporary value
	if (userChaged.name == null) {
		userChaged.name = " ";
	}
	if (userChaged.profile == null) {
		userChaged.profile = " ";
	}
	if (userChaged.image == null) {
		userChaged.image = " ";
	}

	const token = useCookie('token');
	axios.put(`${config.public.apiURL}/user/${userChaged.id}`, { // config.public.apiURL + "/tag"
		"id": userChaged.id,
		"name": userChaged.name,
		"email": userChaged.email,
		"permission": userChaged.selectedPermission,
		"profile": userChaged.profile,
		"image": userChaged.image
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
				users.value = res.data;
			}
		})
		.catch((err) => {
			// if code is 401, then show error message 
			console.log(err);
			if (err.response.status == 401) {
				console.log("fail");
			} else if (err.response.status == 404) {
				console.log("fail");
			} else if (err.response.status == 409) {
				console.log("fail");
			}
			else if (err.response.status == 500) {
				console.log("fail");
			}
		})
}

</script>

<template>
	<div v-for="user in users" :key="user.id" class="">
		<div class="w-1/4 h-[12vh] bg-green flex">
			<img class="w-[4vw] h-[4vw] rounded-full" alt="not found"
				:src="user.image || 'https://via.placeholder.com/95x96 '" />
			<div>
				<p
					class="ml-[2vh] mt-[2vh] h-[full] w-[10vw] bg-bgcolor text-black text-xl font-normal font-'Roboto' flex-auto item-center">
					{{ user.name || 'No Name' }}</p>
			</div>

			<div class="ml-[6vw] ] w-[20vw] flex">
				<button @click="deleteUser(user)" class="h-[3vw] w-[3vw] justify-center">
					<img src="@/PhotoSticker/DeleteAccount.png" alt="Delete Account" class="w-full h-auto">
				</button>
				<button @click="deleteUser(user)" class="w-[10vw] text-[1.5vw] flex  justify-center ml-5  h-auto">
					<p class="text-red-700">Delete User</p>
				</button>
			</div>

			<!-- <img class="left-[20vw] w-[3vw] h-[3vw] ml-[0.5rem] relative flex cursor-pointer items-center"
				src="@/PageAdmini/GearFill.png" @click="handleClick" /> -->
			<div class="w-[7vw] h-[4vw] ml-[2vw] relative flex cursor-pointer items-center">
				<select v-model="user.selectedPermission" class="bg-slate-200 rounded-md my-[1vh]">
					<option v-for="option in options" :key="option.value" :value="option.value">
						{{ option.text }}
					</option>
				</select>
				<button class="w-[3vw] h-[2vw] bg-primary text-white w-full rounded-md ml-[1vw]" type="submit"
					@click="changePermission(user)">Confirm</button>
			</div>
		</div>
	</div>

	<div v-if="showOverlay" class="w-[10vw] h-[10vh] fixed inset-0 bg-black bg-opacity-50">

	</div>
</template>



<script setup>

//get data from database
import axios from 'axios';
const config = useRuntimeConfig();
// define props
const props = defineProps({
	id: {
		type: String,
		default: ''
	}
})
// change props to ref 
const { id } = toRefs(props)
const Posts = ref([]);



//get data from database
const getAllPost = () => {
	const token = useCookie('token');
	axios.get(`${config.public.apiURL}/post/all/${id.value}`, { // config.public.apiURL + "/tag"
	}, {
		headers: {
			'Authorization': 'Bearer ' + token.value,
			'Content-Type': 'application/json',
			'accept': 'application/json'
		}
	})
		.then(async (res) => {
			// if code is 200, then hide the modal
			console.log(res);
			if (res.status == 200) {
				console.log("success to get all post");
				Posts.value = res.data;
				// 將文章內容轉成 preview
				Posts.value.forEach(post => {
					post.content = getPreviewContent(post.content);
				});
				// get user image and add add corresponding user image to each post
				for (const post of Posts.value) {
					post.userImage = await getUserImage(post.user);

					console.log("pic " + post.userImage);
				}

			}
		})
		.catch((err) => {
			// if code is 401, then show error message 
			console.log(err);
			if (err.response.status == 404) {
				console.log("fail to get all post");
			} else if (err.response.status == 500) {
				console.log("fail to get all post");
			}
		})
}

const getPreviewContent = (jsonString) => {
	const obj = JSON.parse(jsonString);

	const textBlocks = obj.blocks.filter(block => block.type === 'paragraph' || block.type === 'header');

	let previewText = null;

	if (textBlocks.length > 0) {
		let previewText = textBlocks[0].data.text;
		let i = 1;

		while (previewText.length < 20 && i < textBlocks.length) {
			previewText += ' ' + textBlocks[i].data.text;
			i++;
		}

		return previewText;
	}
}

const getUserImage = async (userid) => {
	try {
		const response = await axios.get(`${config.public.apiURL}/user/${userid}`, {
			headers: {
				// your headers here
			}
		});
		return response.data.image;
	} catch (error) {
		console.log(error);
	}
}

getAllPost();

// define emit
const emit = defineEmits(['close'])


// define methods
const clickButton = () => {
	console.log('click button')
	emit('close')
}



</script>

<template>
	<div v-for="post in Posts" :key="post.post_id" class="flex mx-1 z-0">
		<!-- 預覽文章1 -->
		<NuxtLink :to="'/post/' + post.id" class="w-full h-[24vh]  box-border my-[0.7rem] relative flex items-start ">
			<div class="w-[8vw] bg-bgcolor"></div>
			<div class=" w-3/4 bg-bgcolor">
				<div class="w-full h-[7vh] bg-green-250 text-black text-[2vw] font-semibold font-Roboto leading-10">
					{{ post.title }}</div>
				<div class="w-[12vw] h-[10vh] left-[1rem]">
					<div class=" bg-bgcolor text-zinc-600 text-[1.25vw] font-normal font-Roboto ">
						{{ post.content }}
					</div>
				</div>

				<div class="w-full h-[7vh]  rounded-sm border-b border-terotory mx-2  flex">
					<div class="flex w-[10vw]">
						<img class=" w-[6vh] h-[6vh] rounded-full  mx-2 " :src="post.userImage || 'https://via.placeholder.com/95x96 '" />
						<h2 class="w-[6vw] h-[2vw] text-black text-[1.5vw] font-normal font-Roboto leading-loose">
							{{ post.username }}
						</h2>
					</div>

					<div class="w-[21vw] h-[5vw] flex justify-center">
						<div v-for="tag in post.tags" :key="tag"
							class="w-[7vw] h-[1.5vw] ml-[1vw] bg-purple-200 rounded  text-center text-neutral-900 text-[1vw] font-normal font-'Roboto'">
							<p>{{ tag.tagName }}</p>
						</div>
					</div>
					<div class="w-[12vw] flex"><img class=" w-[4vh] h-[4vh] ml-[1vw] " src="@/PostPreview/Thumb.png" />
						<h2 class="w-[6vw] h-[2vw] ml-[1vw] text-black text-[1.25vw] font-normal font-Roboto leading-loose">
							{{ post.thumbUp }}
						</h2>

						<img class=" w-[4vh] h-[4vh]  mx-[1vw]" src="@/PostPreview/ChatRightDots.png" />
						<h2 class="w-[6vw] h-[2vw] text-black text-[1.25vw] font-normal font-Roboto leading-loose">
							{{ post.comments }}
						</h2>
					</div>

				</div>


			</div>

			<div class=" w-1/4 h-[22vh] ">
				<img class="w-full h-[10vw] mb-[3vh] rounded-md" :src=post.image />
			</div>
			<div class="w-[8vw] bg-bgcolor"></div>
		</NuxtLink>
	</div>
</template>

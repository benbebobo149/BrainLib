<template>
  <div class="bg-slate-50">
    <div class="flex h-[12vh]">
      <!-- Left Section -->
      <div class="w-1/2 h-full flex flex-col">
        <!-- Top Section (1/4 height) -->
        <div class="h-1/4 flex bg-slate-50 text-black">
          <!-- Left Subsection (1/3 width) -->
          <div class="w-1/3 bg-slate-50 p-8">
          </div>

          <!-- Right Subsection (2/3 width) -->
          <div class="w-2/3 bg-slate-50 p-8 flex items-center justify-center">
            <img src="/hello/Ellipse2.png" alt="username" class="w-auto h-[8vh]" />
            <div class="text-black text-3xl font-bold ml-4">
              Username
            </div>
          </div>
        </div>


      </div>

      <!-- Right Section -->
      <div class="w-1/2 h-full flex flex-col">
        <!-- Top Subsection (1/4 height) -->
        <div class="flex flex-row h-1/4 bg-slate-50 text-black justify-center items-end p-8">
          <label for="tagInput" class="cursor-pointer" @click="showRegistrationPopup">
            <img src="/hello/AddTag.png" alt="Add tag" class="w-auto h-[4vh] mr-10">
          </label>
          <img src="/hello/Preview.png" alt="Preview" class="w-auto h-[4vh] mr-10">
          <input id="fileInput" type="file" style="display: none;" @change="handleFileChange" />
          <AddTag v-if="showPopup" class="z-10" @close="closeRegistrationPopup" @additem="addTags" />
        </div>

        <!-- Bottom Subsection (3/4 height) -->

      </div>
    </div>
    <div class="h-[12vh]">
      <!-- <addedTags /> -->

    </div>
    <div class="w-screen bg-slate-50 flex flex-col justify-center items-center">
      <h1 class="text-[2vw] font-bold text-terotory text-center">Edit Post</h1>
      <div class="my-[2vh] flex">
        <P>
          tags:
        </P>
        <div v-for="tag in tags" key="tag.id" class="mx-[1vw] flex" @click="removeTag">
          <div
            class="mx-auto rounded-sm border border-terotory text-center text-neutral-900 text-l font-normal font-'Roboto' leading-7 p-[0.5vh] cursor-pointer">
            {{ tag }}
          </div>
        </div>
      </div>

      <Editor class="w-[60%]" @openSucc="() => succVisible = true" @openError="errorVisible = false" />
    </div>
  </div>
  <BoxSucc v-if="succVisible" class="z-10" @close="succVisible = false"></BoxSucc>
  <BoxError v-if="errorVisible" @close="errorVisible = false"></BoxError>
</template>

<script setup>
import { ref } from 'vue';
import AddTag from '@/components/EditPost/AddTag.vue';
// import Editor.vue
import Editor from '@/components/EditPost/Editor.vue'
import BoxSucc from '../ModelBox/BoxSucc.vue';
import BoxError from '../ModelBox/BoxError.vue';

const succVisible = ref(false);
const errorVisible = ref(false);

const showPopup = ref(false);

const showRegistrationPopup = () => {
  showPopup.value = true;
};

const closeRegistrationPopup = () => {
  showPopup.value = false;
};

//get data from database
import axios from 'axios';
const config = useRuntimeConfig();
const props = defineProps({
  id: {
    type: String,
    required: true
  }
})
// change props to ref 
const { id } = toRefs(props)

const Post = ref('');

//get data from database
const getPost = () => {
  const token = useCookie('token');
  axios.get(`${config.public.apiURL}/post/all/${id.value}`, { // config.public.apiURL + "/tag"
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
        console.log("success to get all post");
        Post.value = res.data;
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

getPost();



//tags
const tags = ref(Post.value.tags);
console.log("tags.value= " + tags.value);
//added tags
const addTags = (tag) => {
  tags.value.push(tag);
};

//remove tags
// Remove tag
const removeTag = (index) => {
  if (window.confirm('Are you sure you want to remove this tag?')) {
    tags.value.splice(index, 1);
  }
};
</script>

<style scoped>
[contenteditable] {
  overflow-wrap: break-word;
}

input::placeholder,
input {
  font-size: 25px;
  color: black;
  height: 40px;
  width: 100%;
}
</style>

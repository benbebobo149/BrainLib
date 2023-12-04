<script setup>
// import PostPreview from './components/PostPreview.vue';
// components: {
//     PostPreView
//   }

// other component options...


</script>
<template>
  <div class="w-full">
    <div class=" bg-indigo-100 w-screen">

      <!-- temp navbar -->
      <div class=" bg-#E8DEF8 w-screen h-[8vh]">
        <div>
          <h1> this is temp navbar</h1>
        </div>

      </div>

      <!-- 左半邊 -->
      <div class="flex">
        <div class=" w-9/12 bg-indigo-100 h-full">
          <div class=" bg-white h-[10vh]">
            <h1> </h1>
          </div>
          <div class=" top-100 h-[10vh]">
            <div class=" w-[20vw] ml-20 text-black text-3xl font-normal font-['Roboto'] leading-10">
              <h1 class=" left-[6rem]">適合你的文章</h1>
            </div>
          </div>

          <PostPreview></PostPreview>
          <!-- 預覽文章1 -->
          <div class="w-full h-[24vh]  box-border relative flex items-start inline-flex">
            <div class="w-[8vw] bg-white"></div>
            <div class=" w-3/4 bg-green-100">
              <div class="w-full h-[7vh] bg-green-250 text-black text-3xl font-semibold font-['Roboto'] leading-10">
                輕鬆學會前端框架 vue實做 : 裕翔老師</div>
              <div class="w-full h-[10vh] left-[1rem]">
                <div class=" bg-green-300 text-zinc-600 text-l font-normal font-['Roboto'] ">
                  這篇文章裡，我們會從 Vue.js 基本概念開始講起，非常適合剛開始接觸 Vue 的朋友們
                  ，接著我們用 Vue component 實作一個動態的飯店編輯頁面
                </div>
              </div>

              <div class="w-full h-[7vh] bg-green-350 mx-2 flex">
                <img class=" w-12/96 h-12/96 rounded-full  mx-2" src="https://via.placeholder.com/95x96" />
                <div class="w-36/96 bg-green-200 text-black text-xl font-normal font-['Roboto'] leading-loose">
                  benbenboo
                </div>
              </div>
            </div>

            <div class=" w-1/4 h-[24vh] bg-green-500 ">
              <img class=" my-1 " src="https://via.placeholder.com/240x148" />
            </div>
            <div class="w-[8vw] bg-white"></div>
          </div>

          <!-- 預覽文章2 -->
          <div class="w-full h-[24vh]  box-border relative flex  items-start inline-flex">
            <div class="w-[8vw] bg-white"></div>
            <div class=" w-3/4 bg-green-100">
              <div class="w-full h-[7vh] bg-green-250 text-black text-3xl font-semibold font-['Roboto'] leading-10">
                輕鬆學會前端框架 vue實做 : 裕翔老師</div>
              <div class="w-full h-[10vh] left-[1rem]">
                <div class=" bg-green-300 text-zinc-600 text-l font-normal font-['Roboto'] ">
                  這篇文章裡，我們會從 Vue.js 基本概念開始講起，非常適合剛開始接觸 Vue 的朋友們
                  ，接著我們用 Vue component 實作一個動態的飯店編輯頁面
                </div>
              </div>

              <div class="w-full h-[7vh] bg-green-350 mx-2 flex">
                <img class=" w-12/96 h-12/96 rounded-full  mx-2" src="https://via.placeholder.com/95x96" />
                <div class="w-36/96 bg-green-200 text-black text-xl font-normal font-['Roboto'] leading-loose">
                  benbenboo
                </div>
              </div>
            </div>

            <div class=" w-1/4 h-[24vh] bg-green-500 ">
              <img class=" my-1 " src="https://via.placeholder.com/240x148" />
            </div>
            <div class="w-[8vw] bg-white"></div>
          </div>


        </div>

        <!-- 右半邊 -->
        <div class=" w-3/12 bg-indigo-200 h-full ">
          <div class=" h-[100vh]">
            <!-- 熱門標籤 -->
            <div class=" h-[50vh] bg-indigo-300 border-b-4 border-indigo-500">
              <div class="w-[20vw] mx-auto">
                <div class=" text-black text-xl font-normal font-['Roboto']">Trending Topics/Tags</div>
              </div>

              <div class="flex">
                <div class="mx-auto rounded-sm border border-stone-400 text-center 
                text-neutral-900 text-l font-normal font-['Roboto'] leading-7">世界大賽
                </div>
                <div class="mx-auto rounded-sm border border-stone-400 text-center 
                text-neutral-900 text-l font-normal font-['Roboto'] leading-7">世界大賽
                </div>
                <div class="mx-auto rounded-sm border border-stone-400 text-center 
                text-neutral-900 text-l font-normal font-['Roboto'] leading-7">世界大賽
                </div>
              </div>
            </div>

            <!-- 活動 -->
            <div class=" h-[50vh] ">
              <div class="w-[16vw] mx-auto">
                <div class=" text-black text-xl font-normal font-['Roboto']">Recent Activity</div>
              </div>
              <div class="w-3/12 h-[10vh] mx-[2rem] relative ">
                <div class="w-[20vw] h-[10vh]  bg-purple-200 rounded-3xl  top-[1rem] absolute 
                      text-center text-neutral-900 text-xl font-normal font-['Roboto']">DevFest Tainan 2023
                  <br />
                </div>

                <div class="w-[20vw] h-[10vh]  bg-purple-200 rounded-3xl  top-[6rem]  absolute 
                        text-center text-neutral-900 text-xl font-normal font-['Roboto']">DevFest Tainan
                  2023
                  <br />
                </div>

              </div>

            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>
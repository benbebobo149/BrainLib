<script>
import { ref } from 'vue'
import TempViewPost from '~/components/TempViewPost.vue';

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
        <div class=" w-9/12 bg-blue-500 h-full">
          <div class=" bg-white h-[10vh]">
            <h1> </h1>
          </div>
          <div class=" top-100 h-[10vh]">
            <div class=" w-[20vw] ml-20 text-black text-3xl font-normal font-['Roboto'] leading-10">
              <h1 class=" left-[6rem]">適合你的文章</h1>
            </div>
          </div>


          <!-- 預覽文章 -->
          <div class="w-full h-[28vh]  box-border relative flex justify-start items-start inline-flex">
            <div class="w-[8vw] bg-white"></div>
            <div class=" w-3/4 bg-green-100">
              <div class="w-full h-[7vh] bg-green-250 text-black text-3xl font-semibold font-['Roboto'] leading-10">
                輕鬆學會前端框架 vue實做 : 裕翔老師</div>
              <div class="w-full h-[10vh] left-[1rem]">
                <div class=" bg-green-300 text-zinc-600 text-l font-normal font-['Roboto'] ">
                  這篇文章裡，我們會從 Vue.js 基本概念開始講起，非常適合剛開始接觸 Vue 的朋友們，接著我們用 Vue component 實作一個動態的飯店編輯頁面
                </div>
              </div>

              <div class="w-full h-[11vh] bg-green-350">
                <div class="w-12/96 mx-[1rem]  bg-red-100 rounded-full"> </div>
                <div class="w-36/96 bg-green-200 text-black text-2xl font-normal font-['Roboto'] leading-loose">benbenboo
                </div>
              </div>
            </div>

            <div class=" w-1/4 h-[7vh] bg-green-500 ">
              <img class=" my-2 " src="https://via.placeholder.com/240x148" />
            </div>
            <div class="w-[8vw] bg-white"></div>
          </div>

                    <div class="w-full h-[28vh]  box-border relative flex justify-start items-start inline-flex">
              <div class="w-[8vw] bg-white"></div>
              <div class=" w-3/4 bg-green-100">
                <div class="w-full h-[7vh] bg-green-250 text-black text-3xl font-semibold font-['Roboto'] leading-10">
                  輕鬆學會前端框架 vue實做 : 裕翔老師</div>
                <div class="w-full h-[10vh] left-[1rem]">
                  <div class=" bg-green-300 text-zinc-600 text-l font-normal font-['Roboto'] ">
                    這篇文章裡，我們會從 Vue.js 基本概念開始講起，非常適合剛開始接觸 Vue 的朋友們，接著我們用 Vue component 實作一個動態的飯店編輯頁面
                  </div>
                </div>

                <div class="w-full h-[11vh] bg-green-350">
                  <div class="w-12/96 mx-[1rem]  bg-red-100 rounded-full"> </div>
                  <div class="w-36/96 bg-green-200 text-black text-2xl font-normal font-['Roboto'] leading-loose">benbenboo
                  </div>
                </div>
              </div>

              <div class=" w-1/4 h-[7vh] bg-green-500 ">
                <img class=" my-2 " src="https://via.placeholder.com/240x148" />
              </div>
              <div class="w-[8vw] bg-white"></div>
            </div>
            
                      <div class="w-full h-[28vh]  box-border relative flex justify-start items-start inline-flex">
              <div class="w-[8vw] bg-white"></div>
              <div class=" w-3/4 bg-green-100">
                <div class="w-full h-[7vh] bg-green-250 text-black text-3xl font-semibold font-['Roboto'] leading-10">
                  輕鬆學會前端框架 vue實做 : 裕翔老師</div>
                <div class="w-full h-[10vh] left-[1rem]">
                  <div class=" bg-green-300 text-zinc-600 text-l font-normal font-['Roboto'] ">
                    這篇文章裡，我們會從 Vue.js 基本概念開始講起，非常適合剛開始接觸 Vue 的朋友們，接著我們用 Vue component 實作一個動態的飯店編輯頁面
                  </div>
                </div>

                <div class="w-full h-[11vh] bg-green-350">
                  <div class="w-12/96 mx-[1rem]  bg-red-100 rounded-full"> </div>
                  <div class="w-36/96 bg-green-200 text-black text-2xl font-normal font-['Roboto'] leading-loose">benbenboo
                  </div>
                </div>
              </div>

              <div class=" w-1/4 h-[7vh] bg-green-500 ">
                <img class=" my-2 " src="https://via.placeholder.com/240x148" />
              </div>
              <div class="w-[8vw] bg-white"></div>
            </div>

        </div>

        <!-- 右半邊 -->
        <div class=" w-3/12 bg-blue-500 h-full ">
          <div class=" h-[100vh]">
            <!-- 熱門標籤 -->
            <div class=" h-[50vh] bg-blue-400 border-b-4 border-indigo-500">

            </div>

            <!-- 活動 -->
            <div class=" h-[50vh] justify-center">
              <div class="w-4/12 h-[10vh] relative ">
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
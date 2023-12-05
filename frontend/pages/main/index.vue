<script setup>
import PostPreview from '@/components/PostPreview'
</script>
<template>
  <div class="w-full">
    <div class=" bg-white w-screen">

      <!-- temp navbar -->
      <div class=" bg-indigo-200 w-screen h-[8vh]">
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

          <!-- 預覽文章1 -->
          <div class=" bg-slate-50 content-center">
            <PostPreview />
            <PostPreview />
            <PostPreview />
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
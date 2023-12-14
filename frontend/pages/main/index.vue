<script setup>
import PostPreview from '@/components/PostPreview';
import InPageNav from '~/components/InPageNav.vue';
// import MainPageActivityTags from '@/components/MainPage/MainPageActivityTags.vue';
</script>
<template>
  <div class="">
    <InPageNav></InPageNav>
  </div>

  <div class="w-full">
    <div class=" bg-bgcolor w-screen">

      <!-- temp navbar -->


      <!-- 左半邊 -->
      <div class="flex">
        <div class=" w-9/12 bg-bgcolor h-full rounded-sm border-r border-terotory">
          <div class=" bg-bgcolor h-[10vh] ">
            <h1> </h1>
          </div>
          <div class=" top-100 h-[10vh]">
            <div
              class=" w-[20vw] ml-[5rem] text-terotory text-xl font-normal font-Roboto leading-10   rounded-sm border-b border-terotory">
              <h2 class=" left-[3vw] relative">適合你的文章</h2>
            </div>
          </div>

          <!-- 預覽文章1 -->
          <div class=" bg-bgcolor content-center -z-10">
            <PostPreview />
            <PostPreview />
            <PostPreview />
            <PostPreview />
            <PostPreview />
          </div>

        </div>

        <!-- 右半邊 -->
        <div class=" w-3/12 bg-bgcolor h-full ">
          <div class=" h-[100vh]">
            <!-- 熱門標籤 -->
            <div class=" h-[50vh] bg-bgcolor my-[4vh] mx-auto rounded-sm border-b border-terotory">
              <div class="w-[20vw] mx-auto">
                <div class=" text-black text-xl font-normal font-Roboto">Trending Topics/Tags</div>
              </div>

              <div class="flex my-[1vh]">
                <div class="mx-auto rounded-sm border border-terotory text-center 
                text-neutral-900 text-l font-normal font-['Roboto'] leading-7">世界大賽
                </div>
                <div class="mx-auto rounded-sm border border-terotory text-center 
                text-neutral-900 text-l font-normal font-['Roboto'] leading-7">世界大賽
                </div>
                <div class="mx-auto rounded-sm border border-terotory text-center 
                text-neutral-900 text-l font-normal font-['Roboto'] leading-7">世界大賽
                </div>
              </div>
            </div>

            <!-- 活動 -->
            <div class=" h-[50vh] ">
              <div class="w-[16vw] mx-auto">
                <div class=" text-black text-xl font-normal font-Roboto">Recent Activity</div>
              </div>
              <div class="w-3/12 h-[10vh] mx-[2rem] relative ">

                <div class="w-[20vw] h-[10vh]  bg-purple-200 rounded-3xl  top-[6rem]  absolute 
                        text-center text-neutral-900 text-xl font-normal font-'Roboto'">DevFest Tainan
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

<style>
InPageNav{
  z-index: 10;
  position: fixed;
}

</style>
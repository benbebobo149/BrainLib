<script setup>
import MainPgePostPreview from '@/components/Main/MainPagePostPreview.vue';
import MainPageActivityTags from '@/components/Main/MainPageActivityTags.vue';
import MainTrendingTopic from '~/components/Main/MainTrendingTopic.vue';

const popupState = ref(true);

</script>
<template>
  <div id="mainPage" class="w-full h-full ">
    <div class=" bg-bgcolor w-screen  max-w-full max-h-full">

      <!-- 左半邊 -->
      <div class="flex w-screen h-screen bg-bgcolor max-w-full max-h-full">
        <div class="w-9/12 h-screen bg-bgcolor ">
          <div class="w-full h-1/4 bg-bgcolor flex items-center text-[2vw] p-10 ">
            <div class=" w-1/2 h-full ml-[5vw] text-terotory border-b border-terotory flex items-end">
              <p class="ml-[2vw] font-bold">all post</p>
            </div>
          </div>
          <div class="w-full h-3/4 overflow-y-hidden ">
            <div class="w-auto h-full overflow-y-scroll hide-scrollbar fill-available p-0 ">
              <MainPgePostPreview class="" />
            </div>
          </div>
        </div>
        <!-- 右半邊 -->
        <div class=" w-3/12 bg-bgcolor h-full border-l border-terotory right-0 fixed">
          <div class=" h-[100vh]">
            <!-- 熱門標籤 -->
            <div class="h-[35vh]  bg-bgcolor my-[4vh] mx-auto rounded-sm border-b border-terotory  overflow-y-hidden">
              <div class="w-[20vw] mx-auto">
                <div class=" text-black text-xl font-normal font-Roboto">Trending Topics/Tags
                </div>
              </div>

              <div class="flex justify-around w-full h-auto my-[3vh]  ">
                <div class="overflow-y-scroll hide-scrollbar fill-available p-0
                ">
                  <MainTrendingTopic />
                </div>
              </div>
            </div>
            <!-- 活動 -->
            <div class=" h-[60vh] overflow-y-hidden">
              <div class="w-[16vw] mx-auto">
                <div class=" text-black text-xl font-normal font-Roboto">Recent Activity
                </div>
              </div>
              <div class="flex w-[20vw] h-[44vh] mx-[2rem] my-[2vh] ">
                <div class=" overflow-y-scroll hide-scrollbar fill-available p-0">
                  <MainPageActivityTags />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
/* .slide-up-enter-active, .slide-up-leave-active {
  transition: all .5s ease;
}

.slide-up-enter, .slide-up-leave-to {
  transform: translateY(100%);
}

.slide-up-leave, .slide-up-enter-to {
  transform: translateY(0);
} */


InPageNav {
  z-index: 10;
  position: fixed;
}

/* 自訂的 CSS 類別 */
.hide-scrollbar::-webkit-scrollbar {
  display: none;
  /* 隱藏滾動條 - WebKit browsers */
}

/* 使用 Flexbox 使容器充滿空間 */
.fill-available {
  display: flex;
  flex-direction: column;
}

body {
  margin: 0;
  padding: 0;
}
</style>
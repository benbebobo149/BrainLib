<script setup>
import PostPreview from '@/components/PostPreview';
import InPageNav from '~/components/InPageNav.vue';
import MainPageActivityTags from '@/components/Main/MainPageActivityTags.vue';
import MainTrendingTopic from '~/components/Main/MainTrendingTopic.vue';
import BoxSucc from '@/components/ModelBox/BoxSucc.vue';
// import MainPageActivityTags from '@/components/MainPage/MainPageActivityTags.vue';
const popupState = ref(true);
</script>
<template>
  
  <div class="w-full">
    <div class=" bg-bgcolor w-screen">

      <!-- 左半邊 -->
      <div class="flex">
        <div class=" w-9/12 bg-bgcolor h-full rounded-sm border-r border-terotory">

          <div class=" top-100 h-[10vh]">
            <div
              class=" w-[20vw] ml-[5rem] text-terotory text-xl font-normal font-Roboto leading-10   rounded-sm border-b border-terotory">
              <h2 class=" left-[3vw] relative">適合你的文章</h2>
            </div>
          </div>
          <!-- 預覽文章1 -->
          <div class=" bg-bgcolor content-center -z-10" v-for="index in 10" :key="index">
            <div class="h-full w-auto"></div>
            <PostPreview/>
          </div>
          <BoxSucc v-if="popupState" @close="() => popupState = false"></BoxSucc>
        </div>
        <!-- 右半邊 -->
        <div class=" w-3/12 bg-bgcolor h-full ">
          <div class=" h-[100vh]">
            <!-- 熱門標籤 -->
            <div class="h-[35vh]  bg-bgcolor my-[4vh] mx-auto rounded-sm border-b border-terotory">
              <div class="w-[20vw] mx-auto">
                <div class=" text-black text-xl font-normal font-Roboto">Trending Topics/Tags
                </div>
              </div>

              <div class="flex justify-around w-full h-auto my-[1vh]">
                <MainTrendingTopic v-for="index in 1" :key="index" />
              </div>
            </div>
            <!-- 活動 -->
            <div class=" h-[65vh] overflow-y-hidden">
              <div class="w-[16vw] mx-auto">
                <div class=" text-black text-xl font-normal font-Roboto">Recent Activity
                </div>
              </div>
              <div class="flex w-3/12 h-[10vh] mx-[2rem] my-[2vh] relative hide-scrollbar fill-available">
                  <MainPageActivityTags/>
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
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
</style>
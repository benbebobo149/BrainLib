// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  //ssr: false,
  devtools: { enabled: false },
  modules: [
    '@nuxtjs/tailwindcss',
  ], runtimeConfig: {
    // Keys within public, will be also exposed to the client-side
    public: {
      //apiURL: 'http://ncu.feyumi.com:35001'
      apiURL: 'http://localhost:1234'
    }
  }
})

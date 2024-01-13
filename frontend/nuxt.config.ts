// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  ssr: false,
  devtools: { enabled: false },
  modules: [
    '@nuxtjs/tailwindcss',
  ], runtimeConfig: {
    // Keys within public, will be also exposed to the client-side
    public: {
      apiURL: 'http://localhost:1234',
      frontendURL: 'http://localhost:3000',
      googleClientId : process.env.GOOGLE_CLIENT_ID
    }
  },
 
  app: {
    pageTransition: { name: 'page', mode: 'out-in' }
  },

})

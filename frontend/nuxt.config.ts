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
      googleClientId: '341589256904-2b8bl47v3ni78ft9f7ottqh3r6b63sf0.apps.googleusercontent.com'
    }
  },
 
  app: {
    pageTransition: { name: 'page', mode: 'out-in' }
  },

})

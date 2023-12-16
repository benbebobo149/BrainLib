/** @type {import('tailwindcss').Config} */
export default {
  content: [
    `./components/**/*.{vue,js,ts}`,
    `./layouts/**/*.vue`,
    `./pages/**/*.vue`,
    `./composables/**/*.{js,ts}`,
    `./plugins/**/*.{js,ts}`,
    `./utils/**/*.{js,ts}`,
    `./App.{js,ts,vue}`,
    `./app.{js,ts,vue}`,
    `./Error.{js,ts,vue}`,
    `./error.{js,ts,vue}`,
    `./app.config.{js,ts}`
  ],
  theme: {
    extend: {
      colors: {
        'primary': '#6750A4',
        'secondary': '#D0BCFF',
        'secondary2': '#E8DEF8',
        'terotory': '#A39292',
        'bgcolor': '#FFFBFF',
        'error': '#FFF0F0',
        // other new colors...
      },
      fontFamily: {
        'sans': ['Roboto'],
      },
    },
  },
  plugins: [],
}







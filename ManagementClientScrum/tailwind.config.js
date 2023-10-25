/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      fontFamily: {
        'custom': ["'Tilt Neon'", 'sans-serif'],
      },
      colors: {
        'primary': '#2664a5',
        'secondary': '#5189BD',
        'background': '#f5f5f5'
      }
    },
  },
  plugins: [],
}


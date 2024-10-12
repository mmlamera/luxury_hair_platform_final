import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
   server: {
     port: 5173 // or any port number you prefer
  },
  plugins: [react()],
})

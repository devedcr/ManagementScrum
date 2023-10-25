import { RouterProvider } from "react-router-dom"
import { router } from "./route/router"
import './assets/css/index.css'

function App() {
  return (
    <RouterProvider router={router} />
  )
}

export default App
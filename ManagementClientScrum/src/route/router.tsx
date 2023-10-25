import { createBrowserRouter } from "react-router-dom"
import { Login } from "../page/auth/login/Login";
import { Register } from "../page/auth/register/Register";

export const router = createBrowserRouter([
    {
        path: "/",
        element: <Login/>,
    },
    {
        path: "/auth/login",
        element: <Login />
    },
    {
        path: "/auth/register",
        element: <Register />
    }
]);

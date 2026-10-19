import { createBrowserRouter } from "react-router";
import App from "./App";
import { Admin } from "./App/Outlet/Admin";
import { Listado } from "./App/Outlet/Listado";

export const router = createBrowserRouter([
  {
    path: "/",
    Component: App,
    children: [
      {
        index: true,
        Component: Listado,
      },
      {
        path: "admin",
        Component: Admin,
      },
    ],
  },
]);
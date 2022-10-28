import React from "react";
import { useRoutes, Outlet } from "react-router-dom";
import { HomeLayout, OrderLayout } from "../components/layout";
import { ShoppingCart } from "../features/home/cart/pages/ShoppingCart";
import { Infor } from "../features/auth/pages/Infor";
import Login from "../features/auth/pages/Login";
import Register from "../features/auth/pages/Register";
import LandingPage from "../features/home/landing/pages/LandingPage";
import NotFound from "../features/home/landing/pages/NotFound";
import { Detail } from "../features/home/product/pages/detail";

type Props = {};

const PublicRoute = (props: Props) => {
  let element = useRoutes([
    {
      path: "/",
      element: <HomeLayout />,
      children: [
        {
          path: "",
          element: <LandingPage />,
          index: true,
        },
        {
          path: "product",
          element: <Outlet />,
          children: [
            // {
            //     path: "",
            //     element: <ProductList />,
            //     index:true,
            // },
            {
              path: ":id",
              element: <Detail />,
            },
          ],
        },
      ],
    },
    {
      path: "/auth",
      element: <Outlet />,
      children: [
        {
          path: "login",
          element: <Login />,
        },
        {
          path: "register",
          element: <Register />,
        },
      ],
    },
    {
      path: "/user",
      element: <HomeLayout />,
      children: [
        {
          path: "infor",
          element: <Infor />,
        },
        {
          path: "cart",
          element: <ShoppingCart />,
        },
        {
          path: "order",
          element: <OrderLayout />,
        },
      ],
    },
    {
      path: "*",
      element: <Login />,
    },
  ]);
  return element;
};

export default PublicRoute;

import React from "react";
import { useRoutes } from "react-router-dom";
import { Dashboard } from "../components/common/dashboard";
import { HomeLayout } from "../components/layout";
import { AdminLayout } from "../components/layout/AdminLayout";

type Props = {};

const ProtectedRoute = (props: Props) => {
  let element = useRoutes([
    {
      path: "/",
      element: <AdminLayout />,
      children: [],
    },
  ]);

  return element;
};

export default ProtectedRoute;

import React from "react";
import ProtectedRoute from "./ProtectedRoute";
import PublicRoute from "./PublicRoute";

type Props = {};

export const AppRoute = (props: Props) => {
  const user = false;
  // if(user == true)  return <ProtectedRoute/>
  // return <PublicRoute />;
  return <ProtectedRoute />;
};

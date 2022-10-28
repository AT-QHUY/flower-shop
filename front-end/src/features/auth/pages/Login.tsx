import { Box, Button, TextField, Grid } from "@mui/material";
import React, { useEffect, useState, useContext } from "react";
import { useForm, Controller } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import InputField from "../../../components/common/input";
import { UserContext } from "../../../context";
import axiosInstance from "../../../lib/AxiosInstance";
import { loginAPI } from "../api";
import { UserFormLogin } from "../types";
import jwt_decode from "jwt-decode";

type Props = {};

const Login = (props: Props) => {
  const { setToken, setUser } = useContext(UserContext);

  const navigate = useNavigate();

  const [formLogin, setFormLogin] = useState<UserFormLogin>({
    username: "",
    password: "",
  });
  const {
    control,
    handleSubmit,
    formState: { errors },
  } = useForm<UserFormLogin>({
    defaultValues: {
      username: "",
      password: "",
    },
  });

  const onSubmit = (values: UserFormLogin) => {
    loginAPI(values)
      .then((res) => {
        if (res) {
          const token = res.data.token;
          localStorage.setItem("Authorization", token);
          const decoded: any = jwt_decode(token);
          localStorage.setItem("userinfor", decoded?.sub);
          localStorage.setItem("userid", res.data.id);
          setToken(token);
          setUser(decoded?.sub);
          navigate("/");
        }
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <Box>
        <Controller
          control={control}
          name="username"
          rules={{ required: "Username is required" }}
          render={({ field }) => <InputField {...field} />}
        />
        <Controller
          control={control}
          name="password"
          rules={{
            required: "Username is required",
            minLength: { value: 6, message: "Password more than 6" },
          }}
          render={({ field }) => <InputField {...field} />}
        />
        <Button type="submit">Login</Button>
      </Box>
    </form>
  );
};

export default Login;

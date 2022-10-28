import React, { createContext, PropsWithChildren, useState } from "react";

export interface UserProviderProps extends PropsWithChildren {}

export interface UserContext {
  id: string;
  user: string;
  token: string;
  setId: (id: string) => void;
  setToken: (token: string) => void;
  setUser: (user: string) => void;
}

export const UserContext = createContext<UserContext>({
  id: "",
  token: "",
  user: "",
  setId: (id: string) => {},
  setToken: (token: string) => {},
  setUser: (user: string) => {},
});

const tmpToken = localStorage.getItem("Authorization");
const tmpUser = localStorage.getItem("userinfor");
const tmpId = localStorage.getItem("userid");

export const UserProvider = ({ children }: UserProviderProps) => {
  const [token, setToken] = useState(tmpToken || "");
  const [user, setUser] = useState(tmpUser || "");
  const [id, setId] = useState(tmpId || "");
  return (
    <UserContext.Provider value={{ token, setToken, user, setUser, id, setId }}>
      {children}
    </UserContext.Provider>
  );
};

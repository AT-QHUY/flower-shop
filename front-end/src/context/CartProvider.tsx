import React, { createContext, PropsWithChildren, useState } from "react";
import { CartItem } from "../type";

export interface CartProviderProps extends PropsWithChildren {}

export interface CartContextValue {
  cartId: string;
  cart: number[];
  setCart: (cart: number[]) => void;
  setCartId: (cartId: string) => void;
}

export const CartContext = createContext<CartContextValue>({
  cartId: "",
  cart: [],
  setCart: (cart: number[]) => {},
  setCartId: (cartId: string) => {},
});

const cardId = localStorage.getItem("cartId");

const CartProvider = ({ children }: CartProviderProps) => {
  const [cartId, setCartId] = useState(cardId || "");
  const [cart, setCart] = useState([0]);
  return (
    <CartContext.Provider value={{ cartId, cart, setCart, setCartId }}>
      {children}
    </CartContext.Provider>
  );
};

export default CartProvider;

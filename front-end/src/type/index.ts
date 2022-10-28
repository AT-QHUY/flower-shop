import { OrderItem } from './../components/common/order/OrderItem';
import { ReactNode } from "react"

export interface ProductData {
    id:number
    name: string,
    url: string,
    image: string,
    price:string,
    category:Category
  }

  export interface ProductDataArray {
    data?: ProductData[]
}

export interface ProductProps {
    data?: ProductData[],
    count? :number
    setPagination: (values:Pagination) => void
    pagination:Pagination
}

export interface Pagination {
  offset: number;
  limit: number;
}
export type ShoppingCartProviderProps = {
  children: ReactNode
}

export interface Category {
  id:number;
  name:string;
}



export interface CartItem {
  id:number
  quantity: number
  flower:ProductData
}

export type CartProps = {
  data: CartItem[]
}

export type ShoppingCartContext = {
  openCart: () => void
  closeCart: () => void
  getItemQuantity: (id: number) => number
  increaseCartQuantity: (id: number) => void
  decreaseCartQuantity: (id: number) => void
  removeFromCart: (id: number) => void
  cartQuantity: number
  cartItems: CartItem[]
}

export interface OrderDetail  {
  id : number
  quantity: number
  flower:ProductData
}

export interface Order {
  id : number
  status: number
  listDetail : OrderDetail[]
}
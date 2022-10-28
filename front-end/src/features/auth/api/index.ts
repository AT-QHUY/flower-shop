import axiosInstance from "../../../lib/AxiosInstance";
import { UserFormLogin } from "../types";


export const loginAPI = async (form: UserFormLogin) => {

    try{
      const res = await axiosInstance.post(`/user/login`, form )
      return res
    }catch(err:any){
      throw err
    }
}

export const getCartAPI =async (id:number) => {
  try{
    const res = await axiosInstance.get(`/cart/${id}`)
    return res.data
  }catch(err:any){
    throw err
  }
}

export const addToCartAPI =async (userId:number, flowerId:number, quantity:number) => {
  try{
    const res = await axiosInstance.put(`/cart/add`,{
      user_id: userId,
      flower_id:flowerId,
      quantity:quantity
    })
    
    return res.data
  }catch(err:any){
    throw err
  }
}

export const updateCartAPI =async (cartId:number, quantity:number) => {
  try{
    const res = await axiosInstance.put(`/cart/update`,{
      id: cartId,
      quantity:quantity
    })   
    return res
  }catch(err:any){
    throw err
  }
}

export const deleteCartItemAPI =async (itemId:number) => {
  try{
    const res = await axiosInstance.delete(`/cart/delete/${itemId}`)   
    return res
  }catch(err:any){
    throw err
  }
}

export const confirmOrderAPI =async (cartId:number) => {
  try {
    const res = await axiosInstance.put(`/cart/confirm/${cartId}`)
    return res
  } catch (err:any) {
    throw err
  }
}
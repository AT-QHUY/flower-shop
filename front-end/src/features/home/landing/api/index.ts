import React from 'react'
import axiosInstance from '../../../../lib/AxiosInstance'

export const getProductAPI = async (page:number, limit:number) => { 
   try{
    const res = await axiosInstance.get(`flower?page=${page}&limit=${limit}`)  
    return res.data
    }catch(err:any){
        throw err
    }
}

export const getProductByIdAPI =async (id:number) => {
    try{
        const res = await axiosInstance.get(`flower/${id}`)
        return res.data
    }catch(err:any){
        throw err
    }
}

export const getProductCountAPI =async () => {
    try{
        const res = await axiosInstance.get(`flower/count`)
        return res.data
    }catch(err:any){
        throw err
    }
}

export const getOrderByUser_IdAPI =async (id:number) => {
    try{
        const res = await axiosInstance.get(`/order/getOrder/${id}`)
        return res.data
    }catch(err:any){
        throw err
    }
}

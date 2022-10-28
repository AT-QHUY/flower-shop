import axiosInstance from "../../../lib/AxiosInstance"

export const getAllProductAPI =async () => {
    try{
        const res = await axiosInstance.get(`flower/getAll`)
        return res.data
    }catch(err:any){
        throw err
    }
}
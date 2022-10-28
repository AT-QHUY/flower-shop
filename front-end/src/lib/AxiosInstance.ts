import axios, { AxiosRequestConfig } from "axios";


const axiosInstance = axios.create({baseURL:process.env.REACT_APP_API_URL});

axiosInstance.interceptors.request.use(function (config) {
    const token = localStorage.getItem('Authorization');
    if(token){
      config.headers!.Authorization = `Bearer ${token}`
    }
   
    return config;
  }, function (error) {
    return Promise.reject(error);
  });

axiosInstance.interceptors.response.use(function (response) {

    return response;
  }, function (error) {

    return Promise.reject(error);
  });

export default axiosInstance
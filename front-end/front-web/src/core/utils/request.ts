import { UserData } from './../types/UserData';
import axios, {Method} from 'axios';

type RequestParams={
    url:string;
    method?:Method;
    data?:UserData;
}

const BASE_URL='http://localhost:8080/'

export const makeRequest=async ({url,method='GET',data}:RequestParams)=>{
   return await axios ({
    method,
    url:`${BASE_URL}${url}`,
    data
   })
}
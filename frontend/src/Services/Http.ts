import axios, { AxiosInstance, AxiosRequestConfig } from 'axios';

const instance = axios.create({
  baseURL: "https://jsonplaceholder.typicode.com",
});

type HTTPRequestConfig = AxiosRequestConfig;

const api = (axios: AxiosInstance) => {
  return {
    get: <T>(url: string, config: HTTPRequestConfig = {}) => {
      return axios.get<T>(url, config);
    },
    put: <T>(url: string, body: unknown, config: HTTPRequestConfig = {}) => {
      return axios.put<T>(url, body, config);
    }
  };
};

export const Http = api(instance);

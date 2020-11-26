import axios from 'axios';

export const utils = {
    api,
    token
}

const api = axios.create({
    baseURL: 'http://localhost:9000/'
  });

const token = '';
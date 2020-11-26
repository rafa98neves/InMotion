import axios from 'axios';

const base =  'http://localhost:8080';
const token = '';

export const utils = {
    createHttp,
    token
}

function createHttp(){

  let api;

  if(token.length > 0){
    api = axios.create({
      headers: { "Authorization": `bearer ${token}` },
      baseURL: base
    });
  }

  else{
    api = axios.create({
      baseURL: base
    });
  }

  return api;
}

import axios from 'axios';

const base =  'http://localhost:9000';
const token = '';
const user = '';

export const utils = {
    createHttp,
    token,
    user
}

function createHttp(){

  let api;

  if(token.length > 0){
    api = axios.create({
      headers: { "Authorization": token, "Content-Type" : "application/json"},
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

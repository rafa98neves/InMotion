import axios from 'axios';

const base = 'http://localhost:9000';

export const utils = {
    createHttp,
    getToken
}

function createHttp(){

  let api;
  let token = getToken();

  if(token.length > 0){
    api = axios.create({
      headers: { "Authorization": token, "Content-Type" : "application/json"},
      baseURL: base
    });
  }

  else{
    api = axios.create({
      headers: { "Content-Type" : "application/json"},
      baseURL: base
    });
  }

  return api;
}

function getToken() {

  if(window.localStorage.getItem('token') != null){
    return window.localStorage.getItem('token')
  } 

  return ''
}
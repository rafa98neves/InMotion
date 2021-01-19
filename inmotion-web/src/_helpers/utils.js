import axios from 'axios';

//backend localhost
const base = 'http://localhost:9000';

export const utils = {
    createHttp,
    getToken
}

//http client
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

//get key from backend
function getToken() {

  if(window.localStorage.getItem('token') != null){
    return window.localStorage.getItem('token')
  } 

  return ''
}

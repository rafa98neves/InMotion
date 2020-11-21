import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:9000/'
  });

  
export const accountService = {
    login
};

async function login(credentials) {
    
    const response = await api.post('api/user/login',credentials)
        .then( response => response.data )
        .catch(error => console.log(error))
        .finally();

    console.log(response)
}


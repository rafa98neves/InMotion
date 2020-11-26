import { router } from "../_helpers/router"
import { utils } from "../_helpers/utils"

export const accountService = {
    login,
    isAuthenticated,
    register
};

function isAuthenticated() {
    return (utils.token.length > 0);
}

async function login(credentials) {
  
    const response = await utils.api.post('api/user/login', credentials)
        .then(response => response.data)
        .catch(error => console.log(error));
    
    window.localStorage.setItem('token', response.token)
    utils.token = response.token

    router.push("/")
}

async function register(user) {

    const response = await api.post('api/user/register', user)
        .catch(error => console.log(error));
    
        console.log(response)
}
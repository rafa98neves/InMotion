import { router } from "../_helpers/router"
import { utils } from "../_helpers/utils"

export const accountService = {
    login,
    isAuthenticated,
    register
};

const api = utils.createHttp();

function isAuthenticated() {
    return (utils.token.length > 0);
}

async function login(credentials) {
  
    await api.post('/api/user/login', credentials)
        .then(response => {
            if(response.status == 200){
                window.localStorage.setItem('token', response.data.token)
                utils.token = response.data.token            
                router.push("/home")
            }
            else{
                console.log(response)
            }})
        .catch(error => {
            console.log(error)
            router.push({name: "error", params: {msg : error}})

        });
}

async function register(user) {
    await api.post('/api/user/register', user)
        .then(response => {
            if(response.status == 200){
                router.push("/login")
            }
            else{
                console.log(response)
            }})
        .catch(error => console.log(error));
}
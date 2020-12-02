import { router } from "../_helpers/router"
import { utils } from "../_helpers/utils"

export const accountService = {
    login,
    isAuthenticated,
    register,
    whoami,
    recoverPassword,
    recover
};

const api = utils.createHttp();

function isAuthenticated() {
    if(utils.token == undefined){
        return false
    }
    return (utils.token.length > 0);
}

async function login(credentials, context) {
  
    await api.post('/login', credentials)
            .then(function(response) {
                if(response.status == 200){
                    window.localStorage.setItem('token', response.headers['authorization'])
                    utils.token = response.headers['authorization']   
                    context.$toast.success("Login successed", { position: "bottom"})       
                    router.push("/")
                }
                else{
                    console.log("status not expected -" + response)
                }})
            .catch(error => {
                if(error.response == undefined){
                    router.push({name: "error", params: {msg : "404 - Server side error"}})
                }
                else if(error.response.status == 403){
                    context.$toast.error("Invalid credentials", { position: "bottom"} )
                }
                else{
                    router.push({name: "error", params: {msg : error.response}})
                }
            });
}

async function register(user, context) {
    await api.post('/register', user)
        .then(response => {
            if(response.status == 200){
                context.$toast.success("Registration successed", { position: "bottom"})   
                router.push("/login")
            }
            else{
                context.$toast.error("Invalid credentials", { position: "bottom"} )
            }})
        .catch(error => console.log(error));
}

async function whoami(){
    await api.get('/whoami')
            .then(response => {
                if(response.status == 200){
                    accountService.user=response.data.user
                    console.log("user = " + accountService.user)
                    return true
                }})
            .catch(error => console.log(error));
    
    router.push('/landingpage');
    return false;    
}

async function recoverPassword(email, context) {
    await api.post('/recover', email)
        .then(response => {
            if(response.status == 200){
                context.form_display = !context.form_display
            }
            else{
                context.$toast.error("Email not found", { position: "bottom"} )
            }})
        .catch(error => console.log(error));
}

async function recover(user, context) {
    await api.post('/newpassword', user)
        .then(response => {
            if(response.status == 200){
                context.$toast.success("Recover password successed", { position: "bottom"})   
                router.push("/login")
            }
            else{
                context.$toast.error("Couldn't change your password", { position: "bottom"} )
            }})
        .catch(error => console.log(error));
}
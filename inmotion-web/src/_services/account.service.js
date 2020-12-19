import { router } from "../_helpers/router"
import { utils } from "../_helpers/utils"

export const accountService = {
    login,
    isAuthenticated,
    register,
    recoverPassword,
    validateToken,
    recover,
    logout,
    whoami,
    getInfo
};

const api = utils.createHttp();

function isAuthenticated() {
    if(utils.getToken() == ''){
        return false
    }
    return true;
}

async function login(credentials, context) {
  
    await api.post('/login', credentials)
            .then(function(response) {
                if(response.status == 200){
                    window.localStorage.setItem('token', response.headers['authorization'])
                    utils.token = response.headers['authorization']   
                    context.$toast.success("Login successed", { position: "bottom"}) 
                    context.loggedIn = true;      
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
                console.log("status not expected -" + response)
            }})
            .catch(error => {
                if(error.response == undefined){
                    router.push({name: "error", params: {msg : "404 - Server side error"}})
                }
                else if(error.response.status == 403){
                    context.$toast.error("Email already exists", { position: "bottom"} )
                }
                else{
                    router.push({name: "error", params: {msg : error.response}})
                }
            });
}

async function recoverPassword(email, context) {
    let email_json = { 'email' : email }
    await api.post('/resetPassword', email_json)
        .then(response => {
            if(response.status == 200){
                context.showForm=false;
            }})
        .catch(error => {
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else if(error.response.status == 400){
                context.$toast.error("This account doens't exist", { position: "bottom"})
            }
            else{
                router.push({name: "error", params: {msg : error.response}})
            }
        });
}

async function validateToken(token, context) {
    let token_json = { 'token' : token }
    await api.post('/validateToken', token_json)
        .then(response => {
            if(response.status == 200){
                context.form_display = true;
            }})
        .catch(error => {
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else if(error.response.status == 400){
                context.$toast.error("Link is no longer valid", { position: "bottom"} )
            }
            else{
                router.push({name: "error", params: {msg : error.response}})
            }
        });
}

async function recover(request, context) {
    await api.post('/changePassword', request)
        .then(response => {
            if(response.status == 200){
                router.push("/login")
                context.$toast.success("Your password has been changed successfully", { position: "bottom"} )
            }})
        .catch(error => {
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else if(error.response.status == 400){
                context.$toast.error("Link is no longer valid", { position: "bottom"} )
                router.push("/recoverpassword")
            }
            else{
                router.push({name: "error", params: {msg : error.response}})
            }
        });
}

async function logout(){
    window.localStorage.clear();
    router.push("/landingpage")
}

async function whoami(){
    await api.get('/whoami')
            .then(response => {
                if(response.status == 200){
                    accountService.user=response.data.user
                    return true
                }})
            .catch(error => console.log(error));
    
    router.push('/landingpage');
    return false;    
}

async function getInfo() {
    const user = {
        name : "Rafael Neves",
        birthdate : "02/03/1998",
        gender : "Male",
        email : "rafa@patient.com",
    }
    return user;
    /*await api.get('/user', user)
        .then(response => {
            if(response.status == 200){
                return response.data
            }
            else{
                console.log("status not expected -" + response)
            }})
        .catch(error => {
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else{
                router.push({name: "error", params: {msg : error.response}})
            }
        });*/
}

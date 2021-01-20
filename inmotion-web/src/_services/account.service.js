import { router } from "../_helpers/router"
import { utils } from "../_helpers/utils"

export const accountService = {
    user : '',
    login,
    isAuthenticated,
    register,
    recoverPassword,
    validateToken,
    recover,
    logout,
    whoami,
    getInfo,
    searchPatient,

    getRoles
};

function isAuthenticated() {
    if(utils.getToken() == ''){
        return false
    }
    return true;
}

//post login and login error
async function login(credentials, context) {
    var api = utils.createHttp();
    await api.post('/login', credentials)
            .then(function(response) {
                if(response.status == 200){
                    window.localStorage.setItem('token', response.headers['authorization'])
                    utils.token = response.headers['authorization']
                    context.$toast.success("Successful login", { position: "bottom"})
                    context.loggedIn = true;
                    router.push("/")
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

//post register and register error
async function register(user, context) {
    var api = utils.createHttp();
    await api.post('/register', user)
        .then(response => {
            if(response.status == 200){
                context.$toast.success("Successful Registration", { position: "bottom"})
                router.push("/login")
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

// post recover password
async function recoverPassword(email, context) {
    var api = utils.createHttp();
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

//post validate token
async function validateToken(token, context) {
    var api = utils.createHttp();
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

//post change password
async function recover(request, context) {
    var api = utils.createHttp();
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

// logout
async function logout(){
    window.localStorage.clear();
    accountService.user = '';
    accountService.isAuthenticated();
    router.push("/landingpage")
}

// get type of user
async function whoami(){
    var api = utils.createHttp();
    await api.get('/user/whoami')
        .then(response => {
            if(response.status == 200){
                accountService.user=response.data;
                return true;
            }})
        .catch(error => {
            console.log(error)
            if(error){
                router.push('/landingpage');
            }
        });
    return false;    
}

// get user information
async function getInfo() {
    var api = utils.createHttp();
    let user;

    await api.get('/user/details')
        .then(response => {
            if(response.status == 200){
                user = response.data
                if(user.birthdate != null && user.birthdate != ''){
                    user.birthdate = user.birthdate.substr(0,10);
                }
            }})
        .catch(error => {
            console.log(error)
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else{
                router.push({name: "error", params: {msg : error.response}})
            }
        });

    return user
}


async function searchPatient(id) {
    var api = utils.createHttp();
    let user;
    await api.get('/api/v1/patients/'+id)
        .then(response => {
            if(response.status == 200){
                user = response.data;
                if(user.birthdate != null && user.birthdate != ''){
                    user.birthdate = user.birthdate.substr(0,10);
                }
            }})
        .catch(error => {
            console.log(error)
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else{
                router.push({name: "error", params: {msg : error.response}})
            }
        });
    return user
}

async function getRoles() {
    let therapist = [
    {name:"user 1", email: "aa@pp", password: "", role: "THERAPIST"},
    {name:"user 2", email: "aa@pp", password: "", role: "THERAPIST"},
    {name:"user 3", email: "aa@pp", password: "", role: "THERAPIST"},
    {name:"user 4", email: "aa@pp", password: "", role: "THERAPIST"}
        
    ]
    return therapist;
    
    /*

    var api = utils.createHttp(); 
    await api.get('/therapist')
        .then(response => {
            if(response.status == 200){
                return response.data;
            }})
        .catch(error => {
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else{
                router.push({name: "error", params: {msg : error.response}})
            }
        }); 


    */
}



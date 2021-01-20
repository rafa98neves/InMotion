import { router } from "../_helpers/router"
import { utils } from "../_helpers/utils"

export const resourcesService = {
    getMedications,
    getGames,
    getGame,
    getScoreboard,
    getScoreboardById,
    registerRecommendedGames,
    getRecommendedGames,
    getRecommendedGamesById,

};


async function getMedications() {
    var api = utils.createHttp();
    await api.get('/medications',)
            .then(function(response) {
                if(response.status == 200){
                    return response.data
                }
                else{
                    console.log("status not expected -" + response)
                }})
            .catch(error => {
                console.log(error)
                return ["None found"]
            });
}

async function getGames() {    
    var api = utils.createHttp();
    await api.get('/games')
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
}

async function getGame(id) {    
    var api = utils.createHttp();
    await api.get('/games/' + id)
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
}


async function getScoreboard() {    
    var api = utils.createHttp();
    await api.get('/patients/gamehistory')
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
}

async function getScoreboardById(id) {    
    var api = utils.createHttp();
    await api.get('/'+id+'/gamehistory')
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
}

async function getRecommendedGames() {   
    var api = utils.createHttp(); 
    await api.get('/patients/recommendedgames')
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
}

async function getRecommendedGamesById(id) {   
    var api = utils.createHttp(); 
    await api.get('/'+id+'/recommendedgames')
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
}

async function registerRecommendedGames(patientId, gameId) {
    var api = utils.createHttp();
    await api.post('/therapist/patients/'+ patientId +'/recommendedgames/'+ gameId)
        .then(response => {
            if(response.status == 200){ 
                router.push("/games/recommendedGames")
            }})
        .catch(error => {
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else{
                router.push({name: "error", params: {msg : error.response}})
            }
        });
}


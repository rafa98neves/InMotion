import { router } from "../_helpers/router"
import { utils } from "../_helpers/utils"

export const resourcesService = {
    getMedications,
    getGames,
    getScoreboard,
    getScoreboardById,
    registerRecommendedGames,
    getRecommendedGames,
    getRecommendedGamesById,

};


async function getMedications() {
    var api = utils.createHttp();
    let medications;
    await api.get('api/v1/medications')
            .then(function(response) {
                if(response.status == 200){
                    medications = response.data
                }})
            .catch(error => {
                console.log(error)
                return ["None found"]
            });
    return medications;
}

async function getGames() {    
    var api = utils.createHttp();
    let games = [];

    await api.get('/games')
        .then(response => {
            if(response.status == 200){
                for(var i = 0; i < response.data.length; i++){
                    games[i] = {
                        "gameId" : response.data[i].id,
                        "id" : response.data[i].name,
                        "link" : "/games/" + response.data[i].name,
                        "src" : response.data[i].name + ".png"
                    }
                  }
            }})
        .catch(error => {
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else{
                router.push({name: "error", params: {msg : error.response}})
            }
        }); 
    return games
}

async function getScoreboard() {    
    var api = utils.createHttp();
    var score;
    await api.get('/patients/gamehistory')
        .then(response => {
            if(response.status == 200){
                score = response.data;
            }})
        .catch(error => {
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else{
                router.push({name: "error", params: {msg : error.response}})
            }
        }); 
    return score;
}

async function getScoreboardById(id) {    
    var api = utils.createHttp();
    var score;
    await api.get('/'+id+'/gamehistory')
        .then(response => {
            if(response.status == 200){
                score = response.data;
            }})
        .catch(error => {
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else{
                score = '';
            }
        }); 
    return score;
}

async function getRecommendedGames() {   
    var api = utils.createHttp();
    let item_list = []; 
    await api.get('/patients/recommendedgames')
        .then(response => {
            if(response.status == 200){
                for(var i = 0; i < response.data.length; i++){
                    item_list[i] = {
                      "id" : response.data[i].name,
                      "link" : "/games/" + response.data[i].name,
                      "src" : response.data[i].name + ".png"
                    }
                  }
            }})
        .catch(error => {
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else{
                router.push({name: "error", params: {msg : error.response}})
            }
        }); 
    return item_list;
}

async function getRecommendedGamesById(id) {   
    var api = utils.createHttp(); 
    let recommended = '';
    await api.get('/'+id+'/recommendedgames')
        .then(response => {
            if(response.status == 200){
                recommended = response.data;
            }})
        .catch(error => {
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
        }); 
    return recommended;
}

async function registerRecommendedGames(patientId, gameId, context) {
    var api = utils.createHttp();
    await api.post('/therapist/patients/'+ patientId +'/recommendedgames/'+ gameId)
        .then(response => {
            if(response.status == 200){ 
                context.$toast.success("Success!", { position: "bottom"} )
            }})
        .catch(error => {
            if(error.response == undefined){
                router.push({name: "error", params: {msg : "404 - Server side error"}})
            }
            else{
                context.$toast.error("This action is not possible", { position: "bottom"} )
            }
        });
}


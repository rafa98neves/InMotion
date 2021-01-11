
import { router } from "../_helpers/router"
import { utils } from "../_helpers/utils"

export const resourcesService = {
    getMedications,
    registerRecommendedGames
};

//const api = utils.createHttp();

function getMedications() {

    let medications = [ "Medication 1" , 
                        "Medication 2", 
                        "Medication 3",
                        "Medication 4", 
                        "Medication 5", 
                        "Medication 6", 
                        "Medication 7"  ]
  
    return medications
    
    /*
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
         
    */
}

async function registerRecommendedGames(games, context) {
    var api = utils.createHttp();
    await api.post('/games/recommendedGames', games)
        .then(response => {
            if(response.status == 200){
                context.$toast.success("Registration game successed", { position: "bottom"})   
                router.push("/games/recommendedGames")
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
            });
}
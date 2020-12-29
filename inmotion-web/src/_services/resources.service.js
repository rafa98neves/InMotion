
/*import { utils } from "../_helpers/utils"
var api = utils.createHttp();*/


export const resourcesService = {
    getMedications,
    getScoreboard
    
};

//const api = utils.createHttp();

async function getMedications() {

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
            });*/
         
    
}

async function getScoreboard() {
    let score = [
    { id: "Juice", time: "0000"},
    { id: "Juice", time: "0000"},
    { id: "Juice", time: "0000"},
    { id: "Juice", time: "0000"},
    { id: "Juice", time: "0000"},
    { id: "Juice", time: "0000"},
    { id: "Juice", time: "0000"},
    { id: "Juice", time: "0000"},
    { id: "Juice", time: "0000"},
    { id: "Juice", time: "0000"},
    { id: "Juice", time: "0000"},
    { id: "Juice", time: "0000"},
        
    ]
    return score;
    
    /*await api.get('/scoreboard', user)
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



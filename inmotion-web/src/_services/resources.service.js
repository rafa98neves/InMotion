//import { utils } from "../_helpers/utils"

export const resourcesService = {
    getMedications
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
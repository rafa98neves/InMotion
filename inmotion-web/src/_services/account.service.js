import { BehaviorSubject } from 'rxjs';
import axios from 'axios';
//mport { router } from '../_helpers/router';


const baseUrl = 'localhost:9000/api/';
const accountSubject = new BehaviorSubject(null);

export const accountService = {
    login,
    //logout,
    account: accountSubject.asObservable(),
    get accountValue () { return accountSubject.value; }
};

async function login() {
    //axios.get(baseUrl + "user/test").then(response => response.data).catch(error => console.log(error));
}

/*
function logout() {
    accountSubject.next(null);
    router.push('/login');
}
*/

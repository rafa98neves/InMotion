import { BehaviorSubject } from 'rxjs';
import axios from 'axios';
import { router } from "../_helpers/router"

const api = axios.create({
    baseURL: 'http://localhost:9000/'
  });

const accountSubject = new BehaviorSubject(null);

  
export const accountService = {
    login,
    account: accountSubject.asObservable(),
    get accountValue () { return accountSubject.value; }
};

async function login(credentials) {
    
    const response = await api.post('api/user/login', credentials)
        .then(response => response.data)
        .catch(error => console.log(error));
    
    window.localStorage.setItem('token', response.token)
    accountSubject.next(response);
    router.push("/")
    
}


import { accountService } from '../_services/account.service';
import { router } from './router';

export function authGuard() {

    if (accountService.isAuthenticated()) {
        /*if(accountService.user==undefined){            
            return accountService.whoami()
        }
        else{ return true; }*/
        return true
    }
    else{
        router.push('/landingpage');
        return false;        
    }
}

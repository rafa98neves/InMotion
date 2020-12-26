import { accountService } from '../_services/account.service';
import { router } from './router';

export async function authGuard() {

    if (accountService.isAuthenticated()) {
        if(accountService.user==''){   
            await accountService.whoami();            
        }
        return true; 
    }
    else{
        router.push('/landingpage');
        return false;        
    }

}

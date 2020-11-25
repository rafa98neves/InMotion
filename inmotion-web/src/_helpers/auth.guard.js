import { accountService } from '../_services/account.service';
import { router } from './router';

export function authGuard() {
    
    const account = accountService.accountValue;
    if (account) {
        return true;
    }

    router.push('/landingpage');
    return false;
}
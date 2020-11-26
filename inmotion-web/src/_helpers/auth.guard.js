import { accountService } from '../_services/account.service';
import { router } from './router';

export function authGuard() {

    if (accountService.isAuthenticated()) {
        return true;
    }

    router.push('/landingpage');
    return false;
}
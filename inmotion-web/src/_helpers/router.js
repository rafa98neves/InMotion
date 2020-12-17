import { createRouter, createWebHistory} from 'vue-router';
import { authGuard } from './auth.guard';
import RegisterPatient from '../components/auth/RegisterPatient';
import RegisterTherapist from '../components/auth/RegisterTherapist';
import LandingPage from '../components/auth/LandingPage'
import Login from '../components/auth/Login'
import RecoverPassword from '../components/auth/RecoverPassword'
import NewPassword from '../components/auth/NewPassword'
import Home from '../components/Homepage'
import ErrorPage from '../components/Error-page'
import Game1 from '../components/games/Game-1'

const routes = [
    { path: '/error', component: ErrorPage, name: 'error' },
    { path: '/landingpage', component: LandingPage, name: 'Landing Page' },
    { path: '/login', component: Login, name: 'Login' },
    { path: '/recoverpassword', component: RecoverPassword, name: 'Recover Password' },
    { path: '/newpassword', component: NewPassword, name: 'New Password' },
    { path: '/registerpatient', component: RegisterPatient, name: 'Create account - Patient'},
    { path: '/registertherapist', component: RegisterTherapist, name: 'Create account - Therapist'},
    { path: '/game/piano', component: Game1, name: 'Piano'},
    { path: '/', component: Home, name: 'Homepage', beforeEnter: authGuard },

    // otherwise redirect to home
    { path: '/:pathMatch(.*)*', redirect: '/'}
];

export const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router
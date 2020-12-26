import { createRouter, createWebHistory} from 'vue-router';
import { authGuard } from './auth.guard';

import RegisterPatient from '../components/auth/RegisterPatient';
import RegisterTherapist from '../components/auth/RegisterTherapist';
import LandingPage from '../components/auth/LandingPage'
import Login from '../components/auth/Login'
import RecoverPassword from '../components/auth/RecoverPassword'
import NewPassword from '../components/auth/NewPassword'

import Home from '../components/Homepage'
import ListOfGames from '../components/games/ListOfGames'
import PersonalInformationPatient from '../components/PersonalInformationPatient';
import PersonalInformationTherapist from '../components/PersonalInformationTherapist';

import ErrorPage from '../components/Error-page'
import Game1 from '../components/games/Game-1'

const routes = [
    { path: '/error', component: ErrorPage, name: 'error' },
    { path: '/landingpage', component: LandingPage, name: 'Landing Page' },
    { path: '/login', component: Login, name: 'Login' },
    { path: '/recoverpassword', component: RecoverPassword, name: 'Recover Password' },
    { path: '/resetPassword', component: NewPassword, name: 'New Password'},
    { path: '/registerpatient', component: RegisterPatient, name: 'Create account - Patient'},
    { path: '/registertherapist', component: RegisterTherapist, name: 'Create account - Therapist'},
    
    { path: '/games/piano', component: Game1, name: 'Piano', beforeEnter: authGuard},
    { path: '/games/list', component: ListOfGames, name: 'List of Games', beforeEnter: authGuard},
    { path: '/patient/info', component: PersonalInformationPatient, name: 'Personal Information Patient'},
    { path: '/therapist/info', component: PersonalInformationTherapist, name: 'Personal Information Therapist' },

    { path: '/', component: Home, name: 'Homepage', beforeEnter: authGuard },

    // otherwise redirect to home
    { path: '/:pathMatch(.*)*', redirect: '/'}
];

export const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router
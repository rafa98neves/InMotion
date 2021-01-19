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
import PersonalInformation from '../components/PersonalInformation';
import RecommendedGames from '../components/games/RecommendedGames'
import Scoreboard from '../components/Scoreboard'
import ErrorPage from '../components/Error-page'
import Game1 from '../components/games/Game-1'
import PatientsPage from "@/components/PatientsPage";
import PatientsInfo from "@/components/PatientsInfo";

//pages
const routes = [
    { path: '/error', component: ErrorPage, name: 'error' },
    { path: '/landingpage', component: LandingPage, name: 'Landing Page' },
    { path: '/login', component: Login, name: 'Login' },
    { path: '/recoverpassword', component: RecoverPassword, name: 'Recover Password' },
    { path: '/resetPassword', component: NewPassword, name: 'New Password'},
    { path: '/registerpatient', component: RegisterPatient, name: 'Create account - Patient'},
    { path: '/registertherapist', component: RegisterTherapist, name: 'Create account - Therapist'},    
    { path: '/games/piano', component: Game1, name: 'Piano', beforeEnter: authGuard},
    { path: '/games/list', component: ListOfGames, name: 'List of Games'},
    { path: '/user/info', component: PersonalInformation, name: 'Personal Information', beforeEnter: authGuard},
    { path: '/patient/page', component: PatientsPage, name: 'Patient\'s Page', beforeEnter: authGuard},
    { path: '/patient/info', component: PatientsInfo, name: 'Patient\'s Personal Information', beforeEnter: authGuard},

    { path: '/scoreboard', component: Scoreboard, name: 'Scoreboard' },
    { path: '/', component: Home, name: 'Homepage', beforeEnter: authGuard },
    { path: '/games/recommendedGames', component: RecommendedGames, name: 'Recommended Games'},

    // otherwise redirect to home
    { path: '/:pathMatch(.*)*', redirect: '/'}
];

export const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router
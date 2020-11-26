import { createRouter, createWebHistory} from 'vue-router';
import { authGuard } from './auth.guard';
import RegisterPatient from '../components/auth/RegisterPatient';
import RegisterTherapist from '../components/auth/RegisterTherapist';
import LandingPage from '../components/auth/LandingPage'
import Login from '../components/auth/Login'
import Home from '../components/Homepage'

const routes = [
    { path: '/', component: Home, name: 'Homepage', beforeEnter: authGuard },
    { path: '/landingpage', component: LandingPage, name: 'Landing Page' },
    { path: '/login', component: Login, name: 'Login' },
    { path: '/registerpatient', component: RegisterPatient, name: 'Create account - Patient'},
    { path: '/registertherapist', component: RegisterTherapist, name: 'Create account - Therapist'},

    // otherwise redirect to home
    { path: '/:pathMatch(.*)*', redirect: '/' }
];

export const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router
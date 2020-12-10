import { createRouter, createWebHistory} from 'vue-router';
import { authGuard } from './auth.guard';
import Login from '../components/auth/Login';
import Home from '../components/Homepage';
import PersonalInformationPatient from '../components/auth/PersonalInformationPatient';
import PersonalInformationTherapist from '../components/auth/PersonalInformationTherapist';

const routes = [
    { path: '/', component: Home, name: 'Homepage', beforeEnter: authGuard },
    { path: '/login', component: Login, name: 'Login' },
    { path: '/personalinformationpatient', component: PersonalInformationPatient, name: 'Personal Information Patient' },
    { path: '/personalinformationtherapist', component: PersonalInformationTherapist, name: 'Personal Information Therapist' },
    // otherwise redirect to home
    { path: '/:pathMatch(.*)*', redirect: '/' }
];

export const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router
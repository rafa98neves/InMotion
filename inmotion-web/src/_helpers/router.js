import { createRouter, createWebHistory} from 'vue-router';

import Login from '../components/auth/Login';
import HelloWorld from '../components/HelloWorld';
import { authGuard } from './auth.guard';
import RegisterPatient from '../components/auth/RegisterPatient';
import RegisterTherapist from '../components/auth/RegisterTherapist';

const routes = [
    { path: '/', component: HelloWorld, beforeEnter: authGuard },
    { path: '/login', component: Login },
    { path: '/api/user/test', component: Login },
    { path: '/registerpatient', component: RegisterPatient},
    { path: '/registertherapist', component: RegisterTherapist},

    // otherwise redirect to home
    { path: '/:pathMatch(.*)*', redirect: '/' }
];

export const router = createRouter({
    history: createWebHistory(),
    routes
});

export default routes
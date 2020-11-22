import { createRouter, createWebHistory} from 'vue-router';
import { authGuard } from './auth.guard';
import RegisterPatient from '../components/auth/RegisterPatient';
import RegisterTherapist from '../components/auth/RegisterTherapist';

const routes = [
    { path: '/', component: Home, name: 'Homepage', beforeEnter: authGuard },
    { path: '/login', component: Login, name: 'Login' },
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

export default router
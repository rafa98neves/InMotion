import { createRouter, createWebHistory} from 'vue-router';
import { authGuard } from './auth.guard';
import Login from '../components/auth/Login';
import HelloWorld from '../components/HelloWorld';

const routes = [
    { path: '/', component: HelloWorld, name: 'home', beforeEnter: authGuard},
    { path: '/login', component: Login, name: 'login' },

    // otherwise redirect to home
    { path: '/:pathMatch(.*)*', redirect: '/' }
];

export const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router
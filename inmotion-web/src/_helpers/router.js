import { createRouter, createWebHistory} from 'vue-router';
import { authGuard } from './auth.guard';
import Login from '../components/auth/Login';
import Home from '../components/Homepage';

const routes = [
    { path: '/', component: Home, name: 'Homepage', beforeEnter: authGuard },
    { path: '/login', component: Login, name: 'Login' },

    // otherwise redirect to home
    { path: '/:pathMatch(.*)*', redirect: '/' }
];

export const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router
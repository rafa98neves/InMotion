import { createApp } from 'vue';
import { router } from './_helpers/router';
import App from './App.vue';
import Toaster from '@meforma/vue-toaster';

createApp(App)
    .use(router)
    .use(Toaster)
    .mount('#app');

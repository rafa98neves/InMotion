import { createApp } from 'vue';

import { router } from './_helpers/router';
import App from './App.vue';

createApp(App)
    .use(router)
    .mount('#app');

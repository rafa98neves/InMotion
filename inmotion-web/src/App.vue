<template>
  <nav class="navbar" v-if="account">
        <div class="navbar-nav">
            <router-link to="/" class="nav-item">Home</router-link>
        </div>
    </nav>

    <!-- main app container -->
    <div class="container">
        <router-view></router-view>
    </div>
</template>

<script>

import { ref } from 'vue';

import { accountService } from './_services/account.service';

export default {
    setup() {
        const account = ref(null);
        accountService.account.subscribe(x => account.value = x);

        return {
            account,
            logout: accountService.logout
        }
    }
}


</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

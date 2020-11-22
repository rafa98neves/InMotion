<template>
  <div class="login-form">

    <h2 class="login-heading">Login</h2>

    <form @submit.prevent="login">
      <div class="form-control-e">
        <label for="email">Email</label>
        <input type="email" name="email" id="email" class="login-input" v-model="email">
      </div>

      <div class="form-control-p">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" class="login-input" v-model="password">
      </div>

      <div class="form-control">
        <button type="submit" class="btn-submit">Entrar</button>
      </div>
    </form>

    <p class="not-registered">
      Not registered?
      <router-link to="/registerpatient">Register</router-link>
    </p>

  </div>
</template>

<script>

import { accountService } from "../../_services/account.service"

export default {
  data() {
    return {
      email: '',
      password: ''
    }
  },
  methods: {
    login() {

      let credentials = {
        email : this.email,
        password : this.password
      }
      accountService.login(credentials);      
    }
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

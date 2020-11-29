<template>
  <div class="login-form">
    
    <form class="form-box" @submit.prevent="login">
      <div class="form-control">
        <label for="email">Email</label>
        <input type="email" name="email" id="email" class="login-input" v-model="email">
      </div>

      <div class="form-control">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" class="login-input" v-model="password">
      </div>
      <h4 class="error-msg">{{ msg }}</h4>

      <div class="form-control">
        <button type="submit" class="btn-submit">Login</button>
      </div>
      
    </form>

    <br>
    <router-link class="btn btn-therapist" to="/recoverpassword"><button>I forgot my password</button></router-link>
    
    <div class="footer-back" id="back">
      <router-link class="btn btn-patient" to="/ladingpage"><button>Back</button></router-link>
    </div>

  </div>
</template>

<script>

import { accountService } from "../../_services/account.service"

export default {
  data() {
    return {
      msg: '',
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
      accountService.login(credentials, this);
    }
  }
}

</script>

<style scoped>
  @import url('auth.css');

  .error-msg{
    margin-left: 30%;
  }
</style>

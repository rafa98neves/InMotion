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

      <div class="form-control">
        <button type="submit" class="btn-submit">Login</button>
      </div>
      
    </form>

    <button><router-link class="btn btn-therapist" to="/registertherapist">I forgot my password</router-link></button>
    
    <div class="footer-back" id="back">
      <button><router-link class="btn btn-patient" to="/ladingpage">Back</router-link></button>
    </div>

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

<style scoped>

.form-box{
  display: table;
  margin-left: 10%;
  width: 80%;
  margin-top: 17%;
}

.form-control label,input {  
  display: inline-block;
  vertical-align: baseline;
  width: 20%;
  margin-bottom: 2%;
}

.form-control label{
  width: 20%;
}

.form-control input {
  width: 60%;
}

button{
  padding: 0.5% 1% 0.5% 1%;
  margin-top: 2%;
}

</style>

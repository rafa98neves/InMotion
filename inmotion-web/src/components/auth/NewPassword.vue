<template>
  <div>
    <form class="form-box" @submit.prevent="recover" v-if="form_display">
      <div class="form-control">
        <label for="email">Email</label>
        {{ email }}
      </div>

      <div class="form-control">
        <label>Password</label>
        <input type="password" name="password" id="password" class="register-input" v-model="password">
      </div>

      <div class="form-control">
        <label>Confirm password</label>
        <input type="password" name="password" id="password" class="register-input" v-model="password2">
        <h4 class="error-msg">{{ msg }}</h4>
      </div>

      <br>
      <button v-bind:disabled="validate() != true">Change password</button>
    </form>

    <div class="footer-back" id="back">
      <router-link class="btn btn-patient" to="/login"><button>Back</button></router-link>
    </div>

    <div class="inbox-header" v-if="!form_display">
      <h1> Check your mail inbox to recover the password </h1>
    </div>
  </div>
</template>

<script>

import { accountService } from "../../_services/account.service"

export default {
  data() {
    return {
      msg: '',
      form_display: true,
      email: '',
      info: '',
      password: '',
      password2: ''
    }
  },  
  methods: {
    recover() {
      let user = {
          'info': this.info,
          'password': this.password
      }
      accountService.recover(user,this);
      this.form_display = !this.form_display;
    }, 
    validate() {
      if(this.password != this.password2){
        this.msg = 'Password does not correspond!'
      }
      else{
        this.msg = ''
        if(this.password != ''){
          return true
        }
      }
      return false
    }
  }
}
</script>

<style scoped>
@import url('auth.css');

.inbox-header{
  text-align: center;
  width: 100%;
  margin-top: 20%;
}
</style>

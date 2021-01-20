<template>
  <MainLayout :loggedIn="false"></MainLayout>

  <div class="Register">

    <div class="form-control-nav">
        <label>Type of Account</label>
        <router-link class="btn btn-patient" to="/registerpatient"><button>Patient</button></router-link>
        <router-link class="btn btn-therapist" to="/registertherapist"><button style="background: #5dbcd2;">Therapist</button></router-link>
    </div>

    <form class="form-box" @submit.prevent="register">
      
      <div class="form-control">
        <label>Name</label>
        <input type="text" name="name" class="register-input" v-model="name">
      </div>

      <div class="form-control">
        <label>Email</label>
        <input type="email" name="email" id="email" class="register-input" v-model="email">
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

      <div class="form-footer">
        <div class="form-submit" id="submit">
          <button type="submit" class="btn-submit" 
              v-bind:disabled="verify() == false">Create Account</button>
        </div>
    
        <div class="form-submit" id="back">
          <router-link class="btn btn-patient" to="/landingpage"><button>Back</button></router-link>
        </div>
        
      </div>
    </form>    
  </div>
</template>

<script>

import { accountService } from "../../_services/account.service"
import MainLayout from '../layout/main_layout'

export default {
  data() {
    return {
      msg: '',
      name: '',
      email: '',
      password: '',
      password2: ''
    }
  },
  components: {
    MainLayout,
  },
  methods: {
    register() {

      let user = {
        name : this.name,
        email : this.email,
        password : this.password,
        role : 'THERAPIST'
      }
      accountService.register(user,this);
    }, 
    verify(){

      let pass_check = false
      if(this.password != this.password2){
        this.msg = 'Password does not correspond!'
        pass_check = false
      }
      else{
        this.msg = ''
        pass_check = true
      }
      
      return (this.email.length > 0 &&
              this.password.length > 0 &&
              pass_check)
    }
  }
}
</script>

<style scoped>
  @import url('auth.css');

  .form-box{
    height: 90%;
    width: 50%;
    margin-left: 26%;
    margin-top: 4.2%;
  }

  .form-control{
    text-align: left;
    margin-bottom: 5%;
  }
  
  .form-control-nav{
    margin: 0 0 1% 0;
  }
  
  .form-control input {
    width: 70%;
    padding: 1%;
  }
      
  .form-control button {
    margin-right: 70%;
  }

</style>

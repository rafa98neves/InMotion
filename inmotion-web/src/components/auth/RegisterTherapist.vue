<template>
  <div class="Register">

    <div class="form-control-nav">
        <label>Type of Account</label>
        <router-link class="btn btn-patient" to="/registerpatient"><button>Patient</button></router-link>
        <router-link class="btn btn-therapist" to="/registertherapist"><button style="background: #5dbcd2;">Therapist</button></router-link>
    </div>

    <form class="form-box" @submit.prevent="register">

      <div class="form-control">
        <label>Name</label>
        <input type="text" name="name" id="name" class="register-input" v-model="name" required>
      </div>

      <div class="form-control">
        <label>Therapist's ID</label>
        <input type="text" name="therapist_id" class="register-input" v-model="therapist_id" required>
     
        <label>Data of Birth</label>
        <input type="date" name="date" id="name" class="register-input" v-model="birthdate" required>
      </div>

      <div class="form-control">
        <label>Gender</label>    
        <select v-model="gender">
          <option disabled value="">Please select one</option>
          <option>Male</option>
          <option>Female</option>
        </select>
      </div>

      <div class="form-control">
        <label>Email</label>
        <input type="email" name="email" id="email" class="register-input" v-model="email" required>
      </div>

      <div class="form-control">
        <label>Password</label>
        <input type="password" name="password" id="password" class="register-input" v-model="password" required>
      </div>

      <div class="form-control">
        <label>Confirm password</label>
        <input v-on:blur="validate" type="password" name="password" id="password" class="register-input" v-model="password2" required>
        <h4 class="error-msg">{{ msg }}</h4>
      </div>

      <div class="form-footer">
        <div class="form-submit" id="submit">
          <button type="submit" class="btn-submit" 
              v-bind:disabled ="name === '' || 
                                password === '' || 
                                email === '' || 
                                gender === '' || 
                                msg !== ''">Create Account</button>
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

export default {
  data() {
    return {
      msg: '',
      name: '',
      therapist_id: '',
      birthdate: '',
      email: '',
      password: '',
      password2: '',
      gender:'',
      filled: false
    }
  },
  methods: {
    register() {
      
      let user = {
        name : this.name,
        id : this.therapist_id,
        birthdate : this.birthdate,
        gender : this.gender,
        email : this.email,
        password : this.password,
        role : 'THERAPIST'
      }
      accountService.register(user,this);
    },    
    validate() {
      if(this.password != this.password2){
        this.msg = 'Password does not correspond!'
      }
      else{
        this.msg = ''
      }
    },
    verify(){
      return (this.name.length > 0 && this.password.length > 0 && this.email.length > 0 && this.gender > 0 && this.msg.length == 0)
    }
  }
}
</script>

<style scoped>
  @import url('auth.css');

  .form-box{
    height: 90%;
    margin-top: 2%;
  }
  
  .form-control-nav{
    margin: 0 0 1% 0;
  }
  
  .form-control input {
    width: 70%;
  }
      
  .form-control button {
    margin-right: 70%;
  }

</style>

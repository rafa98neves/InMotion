<template>

  <MainLayout :loggedIn="false"></MainLayout>

  <div class="Register">

    <div class="form-control-nav">
        <label>Type of Account</label>
        <router-link class="btn btn-patient" to="/registerpatient"><button style="background: #5dbcd2;">Patient</button></router-link>
        <router-link class="btn btn-therapist" to="/registertherapist"><button>Therapist</button></router-link>
    </div>
    
    <form class="form-box" @submit.prevent="register">

      <div class="form-control">
        <label>Name</label>
        <input type="text" name="name" id="name" class="register-input" v-model="name">

        <label>Patient's ID</label>
        <input type="text" name="id" class="register-input" v-model="id">

        <label>Data of Birth</label>
        <input type="date" name="date" id="birthdate" class="register-input" v-model="birthdate">
      </div>
      
      <div class="form-control">
        <label>Diagnosis</label>    
        <input v-model="diagnosis">
      </div>

      <div class="form-control">
        <label>Gender</label>    
        <select v-model="gender">
          <option disabled value="">Please select one</option>
          <option>Male</option>
          <option>Female</option>
        </select>
        
<!--
        <label>Medication</label>    
        <select v-model="medication" multiple size=4>
          <option v-for="med in medications" v-bind:key="med">
            {{ med }}
          </option>
        </select>
-->
      </div>

      <div class="form-control">
        <label>Email</label>
        <input type="email" name="email" id="email" class="register-input" v-model="email">

        <label>Password</label>
        <input type="password" name="password" id="password" class="register-input" v-model="password">


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

import MainLayout from '../layout/main_layout'
import { accountService } from "../../_services/account.service"
//import { resourcesService } from "../../_services/resources.service"

export default {
  data() {
    return {
      msg: '',
      //medications: resourcesService.getMedications(),
      name: '',
      id: '',
      birthdate: '',
      email: '',
      //medication: [],
      password: '',
      password2: '',
      //diagnosis: '',
      gender:''
    }
  },
  components: {
    MainLayout,
  },
  methods: {    
    register() {

      let user = {
        name : this.name,
        patientId : this.id,
        birthdate : this.birthdate,
        //diagnosis: this.diagnosis,
        gender : this.gender,
        email : this.email,
        password : this.password,
        role : 'PATIENT'
      }

      accountService.register(user,this);
    },
    verify(){

      let pass_check = false
      if(this.password != this.password2){
        this.msg = 'Password does not correspond!'
        pass_check = false
      }else{
        this.msg = ''
        pass_check = true
      }

      return (this.name.length > 0 && 
              this.id.length > 0 &&              
              this.birthdate.length > 0 && 
              this.password.length > 0 && 
              this.diagnosis.length > 0 && 
              this.email.length > 0 && 
              this.gender.length > 0 && 
              pass_check)
    }
  }
}
</script>


<style scoped>
  @import url('auth.css');

  .form-box{
    margin-top: 5%;
  }
  
  .form-control input {
    width: 70%;
  }
  
</style>

<template>
  <div class="Register">

    <div class="form-control-nav">
        <label>Type of Account</label>
        <router-link class="btn btn-patient" to="/registerpatient"><button style="background: #5dbcd2;">Patient</button></router-link>
        <router-link class="btn btn-therapist" to="/registertherapist"><button>Therapist</button></router-link>
    </div>
    
    <form class="form-box">
      <div class="form-control">
        <label>Name</label>
        <input type="text" name="name" id="name" class="register-input" v-model="name" required>
      </div>

      <div class="form-control">
        <label>Patient's ID</label>
        <input type="text" name="patient_id" class="register-input" v-model="patient_id" required>

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
        <label>Diagnosis</label>    
        <select>
          <option selected="selected">None</option>
          <option>Diagnosis A</option>
          <option>Diagnosis B</option>
          <option>Diagnosis C</option>
        </select>
      </div>

      <div class="form-control">
        <label>Medication</label>    
        <select>
          <option selected="selected">None</option>
          <option>Medication A</option>
          <option>Medication B</option>
          <option>Medication C</option>
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
        <h4>{{ msg }}</h4>
      </div>
      
      <div class="form-footer">
        <div class="form-submit" id="submit">
          <button type="submit" class="btn-submit" v-on:click="register()" 
              v-bind:disabled ="name === '' || 
                                patient_id === '' ||
                                birthdate === '' ||
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
      patient_id: '',
      birthdate: '',
      email: '',
      password: '',
      password2: '',
      diagnosis: [],
      medication: [],
      gender:'',
    }
  },
  methods: {
    register() {
      let user = {
        type : 'patient',
        name : this.name,
        password : this.password,
        diagnosis : this.diagnosis,
        medication : this.medication,
        gender : this.gender
      }
      accountService.register(user);
    },    
    validate() {
      if(this.password != this.password2){
        this.msg = 'Password does not corresponde!'
      }
      else{
        this.msg = ''
      }
    },
    filled(){
      return (this.name.length > 0 && this.password.length > 0 && this.gender.length > 0 &&  this.msg.length == 0)
    }
  }

}
</script>


<style scoped>
  @import url('auth.css');

  .form-box{
    margin-top: 2%;
  }
  
  .form-control input {
    width: 70%;
  }
  
</style>

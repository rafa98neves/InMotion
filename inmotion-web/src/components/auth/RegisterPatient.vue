<template>

  <MainLayout :loggedIn="false" ref="layout"></MainLayout>

  <div v-if="!loading">
    <div class="Register">

      <div class="form-control-nav">
          <label>Type of Account</label>
          <router-link class="btn btn-patient" to="/registerpatient"><button style="background: #5dbcd2;">Patient</button></router-link>
          <router-link class="btn btn-therapist" to="/registertherapist"><button>Therapist</button></router-link>
      </div>
      
      <form class="form-box" @submit.prevent="register">
        <div class="form-inside-box-left">
          <div class="form-control">
            <label>Name</label>
            <input type="text" name="name" id="name" class="register-input" v-model="name">
          </div>
          <div class="form-control" id="email">
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
          <div class="form-control" id="diag">
            <label>Diagnosis</label>    
            <textarea v-model="diagnosis" />
          </div>
        </div>

        <div class="form-inside-box-right">     
          <div class="form-control">
            <label>Patient's ID</label>
            <input type="text" name="id" class="register-input" v-model="id">
          </div>              
          <div class="form-control" id="email">
            <label>Data of Birth</label>
            <input type="date" name="date" id="birthdate" class="register-input" v-model="birthdate">
          </div>    
          <div class="form-control">
            <label>Gender</label>    
            <select v-model="gender">
              <option disabled value="">Please select one</option>
              <option>Male</option>
              <option>Female</option>
            </select> 
          </div>
          <div class="form-control" id="med">
            <label>Medication</label><br>
            <select v-model="medications" multiple size=8 >
              <option v-for="med in medicationList" v-bind:key="med" v-bind:value="med.id">
                {{ med.name }}
              </option>
            </select>
          </div>
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
  </div>
</template>

<script>

import MainLayout from '../layout/main_layout'
import { accountService } from "../../_services/account.service"
import { resourcesService } from "../../_services/resources.service"

export default {
  components: {
    MainLayout,
  },
  data: function () {
    return {
      loading : true,
      msg: '',
      name: '',
      id: '',
      birthdate: '',
      email: '',
      medications: [],
      medicationList: '',
      password: '',
      password2: '',
      diagnosis: '',
      gender:''
    }
  },
  mounted() {
    this.awaitMedicationList();
  },
  methods: {  
    async awaitMedicationList() {
      this.loading = true;
      this.$refs.layout.setLoading(this.loading);

      const medications = await resourcesService.getMedications();
      this.medicationList = medications;

      this.loading = false;
      this.$refs.layout.setLoading(this.loading);

      return this;
    },
    register() {

      let user = {
        name : this.name,
        patientId : this.id,
        birthdate : this.birthdate,
        diagnosis: this.diagnosis,
        gender : this.gender,
        email : this.email,
        medicationList : this.medications,
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

  .form-box{
    height: 50%;
  }

  .form-control{
    margin-bottom: 20px;
  }

  .form-inside-box-left{
    position: absolute;
    text-align: left;
    top: 25%;
    left: 15%;
    width: 45%;
    height: 50%;
  }

  .form-inside-box-right{
    position: absolute;
    text-align: left;
    top: 25%;
    left: 60%;
    width: 45%;
    height: 50%;
  }

  .form-control input {
    width: 65%;
    padding: 1%;
  }
  
  .form-inside-box-right input{
    width: 25%;
    margin-bottom: 2%;
  }

  .form-control select {
    width: 27%;
    padding: 1%;
  }

  #diag textarea{
    text-align: start;
    padding-bottom: 10%;
    width: 67%;
  }

  #med select{
    margin-top: -5%;
    margin-left: 20%;
  }


</style>

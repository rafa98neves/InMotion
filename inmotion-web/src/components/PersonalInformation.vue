<template>
  <MainLayout :loggedIn="true" ref="layout"></MainLayout>
  <div v-if="!loading">
    <div id="PersonalInformation">
        <div class="personal-information-image">
           <img src="../assets/personal_info.png" width="50" height="60">
        </div>
        <div class="personal-information-text">
           <p>Personal Information</p>
        </div>
    </div>

    <router-link to="/"><button class="back-button" >Back</button></router-link>
    <router-link to="/changepassword"><button class="cp-button">Change password</button></router-link>

    <!-- Patient personal information-->
    <div class="container">
      <div class="left">
        <div class="form-control">
            <label class="label-name">Name</label>
            <p class="info-name">{{user.name}}</p>
        </div>

        <div class="form-control">
          <label class="label-email">Email</label>
          <p class="info-email">{{user.email}}</p>
        </div>

        <div class="form-control" v-if="role=='PATIENT'">
            <label class="label-date">Date of Birth</label>
            <p class="info-date">{{user.birthdate}}</p>
        </div>

        <div class="form-control" v-if="role=='PATIENT'">
            <label class="label-gender">Gender</label>
            <p class="info-gender">{{user.gender}}</p>
        </div>
      </div>
      <div class="right">
        <div class="form-control" v-if="role=='PATIENT'">
          <label class="control-label">Diagnosis</label>
          <div class ="text-box">{{user.diagnosis}}</div>
        </div>

        <div class="form-control" v-if="role=='PATIENT'">
          <label class="label-medication">Medication</label>
          <select multiple size=4 class=info-medication >
            <option v-for="item in user.medicationList" :key="item" disabled>{{ item }}</option>
          </select>
        </div>
      </div>
    </div>
  </div>

</template>

<script>


import MainLayout from './layout/main_layout'
import { accountService } from "@/_services/account.service";

export default {

  name: "App",
  components: {
    MainLayout,
  },
  data: function () {
    return {
      loading : true,
      user: '',
      role: accountService.user.role
    }
  },
  mounted() {
    this.awaitUserInfo();
  },
  methods: {
    async awaitUserInfo() {
      this.loading = true;
      this.$refs.layout.setLoading(this.loading);
      
      const user = await accountService.getInfo();
      this.user = user;

      this.user.medicationList = ["Ben-u-Ron", "Brufen", "test", "test", "test", "test"]

      this.loading = false;
      this.$refs.layout.setLoading(this.loading);

      return this
    }
  }
}

</script>

<style scoped>

  #PersonalInformation{
      position: absolute;
      left: 15%;
      top: 20%;
  }
  .personal-information-image{
    width: 0%;
    float:left;
  }
  .personal-information-text{
    width: 140%;
    float:left;
    font-weight: bold;
    color: black;
    font-size: 18px
  }
  .container{
    position: absolute;
    text-align: left;
    left: 20%;
    top: 30%;
    width: 80%;
  }
  .form-control label p{
    display: block;
  }
  .form-control label{
    font-weight: bold;
    color: black;
    font-size: 18px;
    margin-bottom: 2%;
  }
  .form-control .text-box{
    margin-bottom : 2%;
  }
  .form-control label, p, select{
    display: inline-block;
  }
  .form-control select{
    padding: 1% 10% 1% 1%;
    border: 1px solid black;
  }
  .back-button{
    position: absolute;
    left: 10%;
    bottom: 13%;
  }
  .cp-button{
    position: absolute;
    right: 10%;
    bottom: 13%;
  }
  .text-box{
    border: 1px solid black;
    padding: 1% 40% 20% 1%;
    height: 10%; /* maximum height of the box, feel free to change this! */
    width: 50%;
    overflow-y: scroll;
  }

  .control-label {  
    float:left;
  }

  .left{
    position: absolute;
    top: 25%;
    width: 50%;
  }
  
  .right {
    position: absolute;
    top: 25%;
    left: 40%;
    width: 40%;
  }

  .right select{
    width: 50%;
  }

  select option:disabled{
    color: black;
  }

  .form-control{
    margin-bottom: 5%;
  }
</style>

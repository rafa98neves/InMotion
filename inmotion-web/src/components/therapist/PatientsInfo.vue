<template>
  <MainLayout :loggedIn="true" ref="layout"></MainLayout>
  <div v-if="!loading">
    <div id="PersonalInformation">
      <div class="personal-information-image">
        <img src="../../assets/personal_info.png" width="50" height="60">
      </div>
      <div class="personal-information-text">
        <p>Personal Information</p>
      </div>
    </div>

    <router-link :to="{name: 'Patient\'s Page', params: { userId: $route.params.userId, name: $route.params.name }}"><button class="back-button" >Back</button></router-link>
    <button class="cp-button" v-on:click="insertdiagnosis" >Save</button>

    <div class="container">
      <div class="form-control">
        <label class="label-name">Name</label>
        <p class="info-name">{{user.name}}</p>
      </div>

      <div class="form-control">
        <label class="label-email">Email</label>
        <p class="info-email">{{user.email}}</p>
      </div>

      <div class="form-control">
        <label class="label-date">Date of Birth</label>
        <p class="info-date">{{user.birthdate}}</p>
      </div>

      <div class="form-control">
        <label class="label-gender">Gender</label>
        <p class="info-gender">{{user.gender}}</p>
      </div>

      <div class="form-control">
        <label class="control-label">Diagnosis</label>
        <div class="text-box" contentEditable="true">{{user.diagnosis}}</div>
      </div>

      <div class="form-control">
        <label class="label-medication">Medication</label>
        <select class=info-medication >
          <option v-for="item in user.medicationList" :key="item">{{ item.diagnosis }}</option>
        </select>
      </div>
    </div>
  </div>

</template>

<script>


import MainLayout from '../layout/main_layout'
import { accountService } from "@/_services/account.service";

export default {

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

      const user = await accountService.searchPatient(this.$route.params.userId, this);
      this.user = user;
      if(this.user == ''){
        this.$router.push("/");
      }
      this.loading = false;
      this.$refs.layout.setLoading(this.loading);

      return this
    },

    async insertdiagnosis() {

      let user = {
        name : this.name,
        //patientId : this.id,
        birthdate : this.birthdate,
        //diagnosis: this.diagnosis,
        gender : this.gender,
        //email : this.email,
        //password : this.password,
        //role : 'PATIENT'
      }
      accountService.updatePatient(user,this);
    },
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

.form-control label, p, select{
  display: inline-block;
}

.form-control select{
  padding: 5px 20% 5px 5px;
  border: 1px solid black;
}
.form-control .text-box{
  margin-bottom : 2%;
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
  padding: 5px 5px 10px 5px;
  height: 10%; /* maximum height of the box, feel free to change this! */
  width: 50%;
  overflow-y: scroll;
}
.control-label {
  float:left;
}
</style>

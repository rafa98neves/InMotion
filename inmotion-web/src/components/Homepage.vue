<template>

  <MainLayout :loggedIn="true" ref="layout"></MainLayout>
  <!-- Homepage style-->
  <div class="menu">

    <div class="row">
      <div class="column">
        <img src="../assets/info.png" style="width:40%">
      </div>
      <div class="column">
        <router-link to="/user/info"><button class="btn">Personal Information</button></router-link>
      </div>
    </div>

    <div class="row"  v-if="role=='THERAPIST'">
      <div class="column">
        <img src="../assets/info.png" style="width:40%">
      </div>

      <div class="column">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <input type="text" placeholder="search patient by id" name="id" class="search" v-model="id">
        <button v-on:click="search()" class="button"><i class="fa fa-search"></i></button>
      </div>
    </div>

    <div class="row">
      <div class="column">
        <img src="../assets/gamepad.png" style="width:40%">
      </div>
      <div class="column" v-if="role=='PATIENT'">
        <router-link to="/games/list"><button class="btn">Play Games</button></router-link>
      </div>
      <div class="column" v-if="role=='THERAPIST'">
        <router-link to="/games/list"><button class="btn">See List of Games</button></router-link>
      </div>
    </div>

    <div class="row" v-if="role=='PATIENT'">
      <div class="column">
        <img src="../assets/scoreboard.png" style="width:40%">
      </div>
      <div class="column">
        <router-link to="/scoreboard"><button class="btn" >Scoreboard</button></router-link>
      </div>
    </div>

  </div>
</template>

<script>

import MainLayout from './layout/main_layout'

import { accountService } from '../_services/account.service'

export default {
  components: {
    MainLayout
  },
  data: function () {
    return {
      role: accountService.user.role,
      id: ''
    }
  },
  methods: {
    async search(){
      if(this.id != ''){
        await accountService.searchPatient(this.id, this)
          .then((res) => {
            if(res != ''){
              this.$router.push( {name: 'Patient\'s Page', params : { "name": res.name, "userId": this.id }})
            }
          });
      }
    }
  }
}

</script>
<style scoped>

.menu{
  position: absolute;
  top: 25%;
  left: 27%;
  width: 46%;
}

.column {
  float:left;
  margin-top:7%;
  width: 50%;
}

.column img{
  max-width: 25%;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
  width: 50%;
}

.btn{
  float: left;
  font-size: 25px;
  padding: 10px;
}

.search{
  float: left;
  font-size: 17px;
  padding: 13px;
  width: 60%
}

.button {
  margin-right: 10%;
  width: 15%;
  padding: 15px;
  background: white;
  color: black;
  cursor: pointer;
}

</style>
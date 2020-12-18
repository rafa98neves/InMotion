<template>

  <MainLayout :loggedIn="true"></MainLayout>

  <div class="menu">
    <div class="row">
      <div class="column">
        <img src="../assets/info.png" style="width:40%">
      </div>
      <div class="column" v-if="user.role=='PATIENT'">
        <router-link to="/patient/info"><button class="btn">Personal Information</button></router-link>
      </div>
      <div class="column" v-if="user.role=='THERAPIST'">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <input type="text" placeholder="search patient by id" name="search" class="search">
        <button type="submit" class="button"><i class="fa fa-search"></i></button>
      </div>
    </div>
    <div class="row">
      <div class="column">
        <img src="../assets/gamepad.png" style="width:40%">
      </div>
      <div class="column" v-if="user.role=='PATIENT'">
        <router-link to="/games/list"><button class="btn">Play Games</button></router-link>
      </div>
      <div class="column" v-if="user.role=='THERAPIST'">
        <router-link to="/games/list"><button class="btn">See List of Games</button></router-link>
      </div>
    </div>
    <div class="row" v-if="user.role=='PATIENT'">
      <div class="column">
        <img src="../assets/scoreboard.png" style="width:40%">
      </div>
      <div class="column">
        <router-link to="/to/do"><button class="btn" >Scoreboard</button></router-link>
      </div>
    </div>
  </div>
</template>

<script>

import MainLayout from './layout/main_layout'

export default {
  components: {
    MainLayout,
  },
  data: function () {
    return {
      user: {
        role: 'PATIENT'
      }
    };
  }
}

</script>
<style scoped>

.menu{
  position: absolute;
  top: 25%;
  left: 27%;
}
.column {
  float:left;
  margin-top:5%;
  width: 30%;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}

.btn{
  float: left;
  font-size: 25px;
  padding: 10px;
}

.column img{
  max-width: 25%;
}


.search{
  float: left;
  font-size: 25px;
  padding: 10px;
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


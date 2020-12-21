<template>
  <div class="container">
    <img src="../assets/avatar.png" class="avatar">
    <label class="name">Name Surname</label>
    <img src="../assets/logout.png" class="logout" @click="logout">
  </div>

  <div class="menu">
    <div class="row">
      <div class="column">
        <img src="../assets/info.png" style="width:40%">
      </div>
      <div class="column">
        <button class="btn">Personal Information</button>
      </div>
    </div>
    <div class="row">
      <div class="column">
        <img src="../assets/gamepad.png" style="width:40%">
      </div>
      <div class="column">
        <button class="btn">Play Games</button>
      </div>
    </div>
    <div class="row">
      <div class="column">
        <img src="../assets/scoreboard.png" style="width:40%">
      </div>
      <div class="column">
        <button class="btn">Scoreboard</button>
      </div>
    </div>
  </div>


</template>

<script>

import { accountService } from "../_services/account.service"

export default {
  methods : {
    logout() {
        accountService.logout()
    }
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
  font-size: 30px;
  padding: 10px;
}

.container {
  position: relative;
  display: inline-block;
  margin-right: -90%;
  margin-top: -2%;
}
.avatar {
  width: 60px;
  margin-bottom: 15%;
  cursor: pointer;
}

.name {
  position: absolute;
  top: 110%;
  left: 50%;
  padding: 5px;
  margin-top: -14px;
  margin-left: -50px;
  width: 100px;
  background-color: white;
  text-align: center;
}
.logout {
  position: absolute;
  width: 50px;
  top: 140%;
  left: 15%;
  cursor: pointer;
}

.column img{
  max-width: 25%;
}
</style>


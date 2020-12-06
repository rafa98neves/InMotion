<template>

  <MainLayout :loggedIn="true"></MainLayout>

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

import MainLayout from './layout/main_layout'

export default {
  components: {
    MainLayout,
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

.column img{
  max-width: 25%;
}
</style>


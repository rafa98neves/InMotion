<template>
  <div class="container">
    <img src="../assets/avatar.png" class="avatar">
    <label class="name">Name Surname</label>
    <img src="../assets/logout.png" class="logout">
  </div>


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



</template>

<style scoped>


.column {
  float: left;
  margin-left:20%;
  margin-top:30px;
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
  margin-left: -400px;
  margin-top: 40px;
  font-size: 30px;
  padding: 10px;
  display:inline-block;
}

.container {
  position: relative;
  display: inline-block;
  margin-right: -90%;
  margin-top: -10px;
}
.avatar {
  width: 100px
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
  top: 125%;
  left: 30%;
}
</style>


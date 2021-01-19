

<template>

  <MainLayout :loggedIn="true"></MainLayout>
  <div class="login-form">
    <div class="frame-text">
      <p>Patient's ID {{ $route.params.idPass }}</p>
    </div>
    <div class="Patientboard">
      <div id="frame">
        <div class="menu">

          <div class="row">
            <div class="column">
              <img src="../assets/info.png" style="width:40%">
            </div>
            <div class="column">
              <router-link :to="{name: 'Patient\'s Personal Information', params: { idPass: $route.params.idPass }}"><button class="btn">Patient's Information</button></router-link>
            </div>
          </div>

          <div class="row">
            <div class="column">
              <img src="../assets/gamepad.png" style="width:40%">
            </div>
            <div class="column">
              <router-link to="/games/list"><button class="btn">List of Recommended Games</button></router-link>
            </div>
          </div>

          <div class="row">
            <div class="column">
              <img src="../assets/scoreboard.png" style="width:40%">
            </div>
            <div class="column">
              <router-link to="/to/do"><button class="btn" >Patient's Scoreboard</button></router-link>
            </div>
          </div>
        </div>
      </div>
    </div>

    <router-link to="/homepage"><button  class="back-button">Back</button></router-link>


  </div>

</template>

<script>

import MainLayout from './layout/main_layout'

export default {
  name: "App",
  components: {
    MainLayout,
  }
}
</script>

<style scoped>

 .Patientboard{
    position: absolute;
    width: 70%;
    height: 50%;
    left: 30%;
    top: 25%;
  }

  .Patientboard #frame{
    border: 5px solid black;
    width: 50%;
    height: 100%;
  }

  .frame-text{
    position: absolute;
    width: 70%;
    height: 50%;
    left: 0%;
    top:20%;
    font-weight: bold;
    color: black;
    font-size: 18px
}

  .menu{
    position: absolute;
    top: 7%;
    left: 0%;
    width: 50%;
  }

  .column {
    float:left;
    width: 50%;
    margin-top: 5%;
  }

  .column img{
    max-width: 50%;
    vertical-align: middle;
    horizontal-align: middle;

  }

  /* Clearfix (clear floats) */
  .row::after {
    content: "";
    clear: both;
    display: flex;
    align-content: center;
    width: 100%;
  }

  .btn{
    float: left;
    font-size: 20px;
    padding: 10px;
    margin-top: 7%;
    margin-left: -10%;
    width: 100%;
  }


  .button {
    margin-right: 10%;
    width: 15%;
    padding: 15px;
    background: white;
    color: black;
    cursor: pointer;
  }

.back-button{
    position: absolute;
    bottom: 10%;
    left: 10%;
}

</style>




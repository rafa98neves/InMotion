

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
    width: 50%;
    height: 50%;
    left: 25%;
    top: 25%;
  }

  .Patientboard #frame{
    border: 5px solid black;
    width: 100%;
    height: 100%;
  }

  .frame-text{
    position: absolute;
    width: 60%;
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
    width: 100%;
  }

  .column {
    float:left;
    width: 40%;
    margin-top: 2%;
  }

  .column img{
    max-width: 30%;
    margin-top: 7%;
    vertical-align: middle;
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
    padding: 4% 7%;
    margin-top: 8% ;
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




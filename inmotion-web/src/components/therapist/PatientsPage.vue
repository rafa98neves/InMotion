

<template>

  <MainLayout :loggedIn="true"></MainLayout>
  <div class="login-form">
    <div class="frame-text">
      <p>Patient's ID {{ userId }}</p>
    </div>
    <div class="Patientboard">
      <div id="frame">
        <div class="menu">

          <div class="row">
            <div class="column">
              <img src="../../assets/info.png" style="width:40%">
            </div>
            <div class="column">
                <button class="btn" v-on:click="GetInformation">{{name}}'s Information</button>
            </div>
          </div>

          <div class="row">
            <div class="column">
              <img src="../../assets/gamepad.png" style="width:40%">
            </div>
            <div class="column">
              <button class="btn" v-on:click="GetRecommended">List of Recommended Games</button>
            </div>
          </div>

          <div class="row">
            <div class="column">
              <img src="../../assets/scoreboard.png" style="width:40%">
            </div>
            <div class="column">
              <button class="btn" v-on:click="GetScoreboard">Patient's Scoreboard</button>
            </div>
          </div>
        </div>
      </div>
    </div>

    <router-link to="/homepage"><button  class="back-button">Back</button></router-link>


  </div>

</template>

<script>

import MainLayout from '../layout/main_layout'

import { accountService } from '../../_services/account.service'

export default {
  name: "App",
  components: {
    MainLayout,
  },
  data() {
    return{
      userId: '',
      name: ''      
    }
  },
  mounted() {
    if(this.$route.params.userId == undefined){
      this.$router.push("/");
    }
    else{
      this.userId = this.$route.params.userId;
      this.name = this.$route.params.name;
    }
  },
  methods: {
    async GetInformation(){
      if(this.userId != ''){
        await accountService.searchPatient(this.userId, this)
          .then((res) => {
            if(res != ''){
              this.$router.push({name: 'Patient\'s Personal Information', params: { "userId" : this.userId , "name": this.name }})
            }
          });
      }
    },
    async GetScoreboard(){
      if(this.userId != ''){
        this.$router.push({name: 'Patient\'s Scoreboard', params: { "userId" : this.userId , "name": this.name  }})
      }
    },
    async GetRecommended(){
      if(this.userId != ''){
        this.$router.push({name: 'Patient\'s Recommended Games', params : { "userId" : this.userId , "name": this.name  }} );
      }
    }
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




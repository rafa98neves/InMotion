<template>
  <MainLayout :loggedIn="true" ref="layout"></MainLayout>
  <div v-if="!loading">

 <div class="scoreboard-games">
    
    <div id="scoreboard-title">
      <div class="scoreboard-image">
        <img src="../assets/scoreboard.png"  id="img">
      </div>
      <div class="scoreboard-text">
        <p>Scoreboard</p>
      </div>
    </div>

  
    <div id="scoreboard-list-rectangle">
      <p id="game-played">Games</p>
      <p id="time-played">Time Played</p>
    </div>

  

    <div class="scroll">
        <div class="grid-container" v-for="item in score" :key="item">
          <div class="grid-child-games" >
            <p>
              {{item.id}}
             </p>
          </div>
          <div class="grid-child-time" >
            <p>
              {{item.time}}
            </p>
          </div>
        </div>
      </div>


  </div>

  <div class="footer-back" id="back">
    <router-link class="btn btn-patient" to="/"><button>Back</button></router-link>
  </div>
  </div>

    
</template>

<script>


import MainLayout from './layout/main_layout'
import { resourcesService } from "@/_services/resources.service";

export default {

  name: "App",
  components: {
    MainLayout,
  },
  data: function () {
    return {
      loading : true,
    }
  },

  mounted() {
    this.awaitUserInfo();
  },
  methods: {
    async awaitUserInfo(){
      this.loading = true;
      this.$refs.layout.setLoading(this.loading);
      
      let score = await resourcesService.getScoreboard();
      this.score = score;

      this.loading = false;
      this.$refs.layout.setLoading(this.loading);
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

  .form-control label, p, select{
    display: inline-block;
  }  

  .form-control select{
    padding: 5px 20% 5px 5px;
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

#scoreboard-title{
  position: absolute;
  top: 20%;
  left: 10%;
}
#img{
  width:10%; 
  height:10%; 
}
.scoreboard-text{
  position: absolute;
  top: 10%;
  left: 55%;
  font-weight: bold;
  color: black;
  font-size: 18p
}
#scoreboard-list-rectangle{
  border: 5px solid black;
  position: absolute;
  width: 45%;
  height: 50%;
  left: 30%;
  top: 30%;
}
#game-played{
    float:left;
    margin-left: 5%;
    font-weight: bold;
    color: black;
    font-size: 18px
  }
#time-played{
    float:left;
    margin-left: 45%;
    font-weight: bold;
    color: black;
    font-size: 18px
  }
.scroll{
  position: absolute;
  left: 32%;
  top: 40%;
  width: 40%;
  max-height: 150px;
  overflow-y: scroll;
  max-width: 400;
  overflow-x:hidden;
}
.grid-container {
    position: relative;
    width: 125%;
    height: 7%;
    left: 2%;
    top: -70%;
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-gap: 20px;
    text-align: left;}


  

</style>
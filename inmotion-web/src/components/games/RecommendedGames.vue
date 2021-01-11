

<template>
  <MainLayout :loggedIn="true" ref="layout"></MainLayout>
  

 <div class="scoreboard-games">
    
    <div id="scoreboard-title">
      <div class="scoreboard-image">
        <img src="../../assets/gamepad.png"  id="img">
      </div>
      <div class="scoreboard-text">
        <p>Recommended games</p>
      </div>
    </div>

    
  
    <div id="scoreboard-list-rectangle">

      <form class="check-box" @submit.prevent="registerRecommendedGames">

        <input type="checkbox" id="game-1" v-model="checked" value="Game 1">
        <label for="game-1" id="game-1-text">Game 1</label>

        <input type="checkbox" id="game-2" v-model="checked" value="Game 2">
        <label for="game-2" id="game-2-text">Game 2</label>

        <input type="checkbox" id="game-3" v-model="checked" value="Game 3">
        <label for="game-3" id="game-3-text">Game 3</label>

        <input type="checkbox" id="game-4" v-model="checked" value="Game 4">
        <label for="game-4" id="game-4-text">Game 4</label>

        <div class="check-submit" id="submit">
          <!-- <span>{{ checked }}</span> -->
          <button type="submit" class="btn-submit" id="btn-submit">Register games</button>
        </div>
      </form> 
      
    </div>

  </div>

  <div class="footer-back" id="back">
    <router-link class="btn btn-patient" to="/"><button>Back</button></router-link>
  </div>


    
</template>

<script>
import MainLayout from '../layout/main_layout'
import { resourcesService } from "../../_services/resources.service"

export default {
  name: "App",
  components: {
    MainLayout,
  },

 data() {
    return {
      checked: []
    }
  },

  methods: {
    registerRecommendedGames() {

      let games = {
        games: this.checked,
      }
      resourcesService.registerRecommendedGames(games,this);
    }, }
  }
 
  

</script>

<style scoped>
#game-1{
  position: absolute;
  left: 0%;
  top: 10%;
}

#game-1-text{
  position: absolute;
  left: 15%;
  top: 10%;
  font-weight: bold;
  color: black;
  font-size: 100%
}

#game-2{
  position: absolute;
  left: 0%;
  top: 20%;
}

#game-2-text{
  position: absolute;
  left: 15%;
  top: 20%;
  font-weight: bold;
  color: black;
  font-size: 100%
}

#game-3{
  position: absolute;
  left: 0%;
  top: 30%;
}

#game-3-text{
  position: absolute;
  left: 15%;
  top: 30%;
  font-weight: bold;
  color: black;
  font-size: 100%
}

#game-4{
  position: absolute;
  left: 0%;
  top: 40%;
}

#game-4-text{
  position: absolute;
  left: 15%;
  top: 40%;
  font-weight: bold;
  color: black;
  font-size: 100%
}

#scoreboard-title{
  position: absolute;
  top: 20%;
  left: 5%;
}
#img{
  width:15%; 
  height:15%; 
}
.scoreboard-text{
  position: absolute;
  top: 10%;
  left: 60%;
  font-weight: bold;
  color: black;
  font-size: 18p
}
#scoreboard-list-rectangle{
  border: 5px solid black;
  position: absolute;
  width: 55%;
  height: 50%;
  left: 20%;
  top: 30%;
}

#btn-submit{
  position: absolute;
  left: 80%;
  top: 90%;
}


  
</style>
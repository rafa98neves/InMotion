

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
      
      <form v-if="!loading" class="check-box" @submit.prevent="registerRecommendedGames">
        
        <div class = "recommended-box" v-for="item in games" :key="item">
          <label id="game-text" >{{item.id}}</label>        
          <input id="game" type="checkbox" v-model="checked" :value="item.gameId">
        </div>

        <div class="check-submit" id="submit">
          <!-- <span>{{ checked }}</span> -->
          <button type="submit" class="btn-submit" id="btn-submit">Register games</button>
        </div>
      </form> 
    </div>
  </div>

  <router-link :to="{name: 'Patient\'s Page', params: { userId: $route.params.userId, name: $route.params.name }}"><button class="back-button" >Back</button></router-link>
    
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
      loading: true,
      userId: '',
      name: '',
      games: '',
      checked: []
    }
  },
  mounted(){    
    if(this.$route.params.userId == undefined){
      this.$router.push("/");
    }
    else{
      this.userId = this.$route.params.userId;
      this.name = this.$route.params.name;
    }
    this.getUserRecommended();
  },
  methods: {

    registerRecommendedGames() {
      let i;
      for(i=0 ; i < this.checked.length; i++){
        console.log( this.checked[i] )
        resourcesService.registerRecommendedGames(this.userId , this.checked[i], this);
      }
    }, 

    async getUserRecommended(){

      await resourcesService.getGames()
      .then((res) => {
        this.games = res;
      });

      await resourcesService.getRecommendedGamesById(this.userId)
      .then((res) => {
        console.log(res); 
        this.loading = false;
      });
     
    }
  }
}
 
  

</script>

<style scoped>
#game{
  margin-top: 5%;
}

#game-text{
  margin-top:5%;
  margin-left:10%;
  font-weight: bold;
  color: black;
  font-size: 100%
}

#scoreboard-title{
  position: absolute;
  top: 20%;
  left: 5%;
}

.recommended-box{
  text-align: left;
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

.back-button{
  position: absolute;
  left: 10%;
  bottom: 13%; 
}


  
</style>
<template>

  <MainLayout :loggedIn="true" ref="layout"></MainLayout>
  <div class="login-form">
    <div class="row"  v-if="role=='PATIENT'">
      <div id="Gamepad">
          <div class="gamepad-image">
            <img src="../../assets/gamepad.png" width="50" height="50">
          </div>
          <div class="gamepad-text">
            <p>Play Games</p>
          </div>
      </div>

      <!-- get RecommendedGamesList component-->
      <div class="GamesMenus">      
        <div id="recommended-games-list">
            <p class="games_headers">Recommended Games</p>
            <RecommendedGamesList/>
        </div>
        
        <!-- get AllGamesList component-->
        <div id="all-games-list">
            <p class="games_headers">All Games</p>
            <AllGamesList/>
        </div>
      </div>
    </div>

    <div class="row"  v-if="role=='THERAPIST'">

        <div id="Gamepad">
            <div class="gamepad-image">
              <img src="../../assets/gamepad.png" width="50" height="50">
            </div>
            <div class="gamepad-text">
              <p>List of games</p>
            </div>
        </div>

        <!-- get AllGamesList component-->
        <div id="all-games">
          <div class="loader" v-if="loading"></div> 
          <div v-if="!loading"> 
            <div class=internal v-for="item in items_list" :key="item"> 
              <img :src="getImgUrl(item.src)" width="100" height="100">
              <p>{{ item.id }}</p>
            </div>
          </div>
        </div>
    </div>
    <router-link to="/"><button  class="back-button">Back</button></router-link>

  </div>

</template>

<script>

import MainLayout from '../layout/main_layout'
import RecommendedGamesList from "./RecommendedGamesList";
import AllGamesList from "./AllGamesList";

import { accountService } from '../../_services/account.service'
import { resourcesService } from "../../_services/resources.service"

export default {  
  components: {
    RecommendedGamesList,
    AllGamesList,
    MainLayout
  },
  data: function(){
    return{   
      loading: true,   
      role: accountService.user.role,
      items_list: [],
    }
  },
  mounted() {
    if(this.role == 'THERAPIST'){      
      this.getInformation();
    }
  },
  methods: {
    async getInformation(){
      await resourcesService.getGames()
        .then((res) => {
            this.items_list = res;
            this.loading = false;
        });
      return this;      
    },

    getImgUrl: function (imagePath) {
      return require('@/assets/' + imagePath);
    },
  }
}

</script>

<style scoped>

  .form-box{
    margin-top: 23%;
  }

 .GamesMenus {
    position: absolute;
    width: 70%;
    height: 50%;
    left: 15%;
    top: 25%;   
  }

  .GamesMenus #recommended-games-list{
    border: 5px solid black;
    width: 100%;
    height: 40%;
  }

  .GamesMenus #all-games-list{
    border: 5px solid black;
    width: 100%;
    height: 40%;
    margin-top: 4%;
  }

  .games_headers{
    float:left;
    margin-left: 2%;
    font-weight: bold;
    color: black;
    font-size: 18px

  }

  .select-recommended-games{
     width: 20%;
  }

  #Gamepad{
    position: absolute;
    left: 15%;
    top: 18%; 
    
}
  .gamepad-image{
    width: 0%;
    float:left;
}

  .gamepad-text{
    width: 140%;
    float:left;
    font-weight: bold;
    color: black;
    font-size: 18px
}

.back-button{
    position: absolute;
    bottom: 10%;
    left: 10%;
}

#all-games{
  align-items: initial;
  position: absolute;
  left: 15%;
  width: 70%;
  height: 50%;
  top: 25%;
  border: 5px solid black;
  overflow-y: scroll;
}

.loader {
  position: absolute;
  border: 16px solid #f3f3f3; /* Light grey */
  border-top: 16px solid #3498db; /* Blue */
  border-radius: 50%;
  top: 30%;
  width: 20px;
  height: 20px;
  animation: spin 2s linear infinite;
}

.internal{
  width: 20%;
  height: 50%;
  margin-top: 3%;
  border: 1px transparent;
  display: inline-block;
  font-size: 18px;
  color: black 
}

.internal img{
  width: 30%;
  height: auto;
}

</style>






<template>

  <MainLayout :loggedIn="true"></MainLayout>
  <div class="login-form">

    <div id="Gamepad">
        <div class="gamepad-image">
           <img src="../../assets/gamepad.png" width="50" height="50">
        </div>
        <div class="gamepad-text">
           <p>Play Games</p>
        </div>
    </div>

    <div class="GamesMenus">      
      <div id="recommended-games-list">
           <p class="games_headers">Recommended Games</p>
          <RecommendedGamesList/>
      </div>
      
      <div id="all-games-list">
           <p class="games_headers">All Games</p>
          <AllGamesList/>
      </div>
    </div>

    <router-link to="/"><button  class="back-button">Back</button></router-link>


  </div>

</template>

<script>

import MainLayout from '../layout/main_layout'
import RecommendedGamesList from "./RecommendedGamesList";
import AllGamesList from "./AllGamesList";

export default {
  name: "App",
  components: {
    RecommendedGamesList,
    AllGamesList,
    MainLayout
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

</style>




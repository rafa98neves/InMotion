<template>
  <div class="Register">

  </div>

 <div id="PersonalInformation">
        <div class="personal-information-image">
           <img src="../assets/personal_info.png" width="50" height="60">
        </div>
        <div class="personal-information-text">
           <p>Personal Information</p>
        </div>
    </div>

<div id="BackButton">
      <router-link class="back-button" to="/"><button>Back</button></router-link>
    </div>
  

    <div id="LogoutButton">     
      <router-link class="logout-link" to="/landingpage">
        <img src="../assets/logout.png" width="40" height="40">
      </router-link>
    </div>

    <div id="LoginName">
      <p>Test name</p>
    </div>

    <div id="Name">
        <label class="label-name">Name</label>
        <p class="info-name">testaaaaaaaaaaaaaaaaaaaaaaaaaaa name</p>
    </div>  

    <div id="Email">
        <label class="label-email">Email</label>
        <p class="info-email">testaaaaaaaaaaaaaaaaaaaaaaaaaaaaa email</p>
    </div>


</template>

<script>
export default {
  
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#PersonalInformation{
    position: absolute;
    left: 125px;
    top: 150px; 
    
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

#LogoutButton{
    position: absolute;
    left: 1250px;
    top: 120px; 
    
}
#BackButton{
    position: relative;
    left: -520px;
    top: 480px; 
    
}
#LoginName{
    position: absolute;
    left: 1200px;
    top: 50px; 
    font-weight: bold;
    color: black;
    font-size: 18px
    
}

#Name{
    position: absolute;
    left: 125px;
    top: 250px; 
    font-weight: bold;
    color: black;
    font-size: 18px
    
}
  .label-name{
    position: absolute;
    left: 0px;
    top: -20px; 
    font-weight: bold;
    color: black;
    font-size: 18px
}

  .info-name{
    position: relative;
    left: 185px;
    top: -40px; 
    font-weight: bold;
    color: black;
    font-size: 18px
}

#Email{
    position: absolute;
    left: 142px;
    top: 280px; 
    font-weight: bold;
    color: black;
    font-size: 18px;   
}

  .label-email{
    position: absolute;
    left: -19px;
    top: -20px; 
    font-weight: bold;
    color: black;
    font-size: 18px
}

  .info-email{
    position: relative;
    left: 166px;
    top: -40px; 
    font-weight: bold;
    color: black;
    font-size: 18px
}

</style>

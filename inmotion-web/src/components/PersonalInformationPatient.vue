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

    <div id="Date">
        <label class="label-date">Date of Birth</label>
        <p class="info-date">testaaaaaaaaaaaaaaaaaaaaaaaaaaaaa date</p>
    </div>  

    <div id="Gender">
        <label class="label-gender">Gender</label>
        <p class="info-gender">testaaaaaaaaaaaaaaaaaaaaaaaaaaaaa gender</p>
    </div>  

    <div id="Email">
        <label class="label-email">Email</label>
        <p class="info-email">testaaaaaaaaaaaaaaaaaaaaaaaaaaaaa email</p>
    </div>

    <div id="Diagnosis">
      <label class="label-diagnosis">Diagnosis</label>
      <div class=info-diagnosis v-for="item in items" :key="item">
        <p>{{ item.diagnosis }},</p>
      </div>
    </div>

    <div id="Medication">
      <label class="label-medication">Medication</label>
      <div class=info-medication v-for="item in med" :key="item">
        <p>{{ item.diagnosis }},</p>
      </div>
    </div>


</template>

<script>
export default {
  name: "App",
  data: function () {
    return {
      items: [
        { diagnosis: " diagnosis a" },
        { diagnosis: " diagnosis b" },
        { diagnosis: " diagnosis c"},
        { diagnosis: " diagnosis d"},
        { diagnosis: " diagnosis e"},
      ],


       med: [
        { diagnosis: " medication a" },
        { diagnosis: " medication b" },
        { diagnosis: " medication c"},
      ],
    };
  }
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

#Date{
    position: absolute;
    left: 142px;
    top: 280px; 
    font-weight: bold;
    color: black;
    font-size: 18px;   
}

  .label-date{
    position: absolute;
    left: -19px;
    top: -20px; 
    font-weight: bold;
    color: black;
    font-size: 18px
}

  .info-date{
    position: relative;
    left: 166px;
    top: -40px; 
    font-weight: bold;
    color: black;
    font-size: 18px
}

#Gender{
    position: absolute;
    left: 142px;
    top: 310px; 
    font-weight: bold;
    color: black;
    font-size: 18px;   
}

  .label-gender{
    position: absolute;
    left: -19px;
    top: -20px; 
    font-weight: bold;
    color: black;
    font-size: 18px
}

  .info-gender{
    position: relative;
    left: 166px;
    top: -40px; 
    font-weight: bold;
    color: black;
    font-size: 18px
}

#Email{
    position: absolute;
    left: 142px;
    top: 340px; 
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

#Diagnosis{
    position: absolute;
    left: 142px;
    top: 370px; 
    font-weight: bold;
    color: black;
    font-size: 18px;   
}

  .label-diagnosis{
    position: absolute;
    left: -19px;
    top: -20px; 
    font-weight: bold;
    color: black;
    font-size: 18px
}

  .info-diagnosis{
    position: relative;
    left: 166px;
    top: -40px; 
    font-weight: bold;
    color: black;
    font-size: 18px;
    float: left;
}

#Medication{
    position: absolute;
    left: 142px;
    top: 400px; 
    font-weight: bold;
    color: black;
    font-size: 18px;   
}

  .label-medication{
    position: absolute;
    left: -19px;
    top: -20px; 
    font-weight: bold;
    color: black;
    font-size: 18px
}

  .info-medication{
    position: relative;
    left: 166px;
    top: -40px; 
    font-weight: bold;
    color: black;
    font-size: 18px;
    float: left;
}
</style>

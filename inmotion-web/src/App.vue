<template>
    <!-- main app container -->
    <h1 id="pagename">{{ $route.name }}</h1>
    <div id="header-images">
        <div id="inmotion-logo">
          <img src="./assets/inmotion-logo.jpg">
        </div> 
        <div id="Phys-logo">
          <img src="./assets/LIBPhys-logo.jpg">
        </div> 
    </div>
    <div class="container">
        <router-view/>
    </div>
</template>

<script>

import { ref } from 'vue';
import { accountService } from "./_services/account.service"

export default {
  name : 'App',
  setup() {
      const account = ref(null);
      accountService.account.subscribe(x => account.value = x);

      return {
          account
      }
  }
}


</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

html {
  margin: 2%;
  height: 91%;
  width: 95.3%;
  border: 5px solid black;
}

#pagename{
  position: fixed;
  font-size: 15px;
  background: white;
  top: 1%;
  left: 7%;
  padding: 5px;
}
#header-images div{
  position: absolute;
  display: inline-block;
  margin: auto;
  top: 8%;
  left: 6%;
}
#inmotion-logo img{
  width: 15%;
  margin: 0 100% 0 0;
}
#Phys-logo img {
  width: 35%;
  margin: 2% -20% 0 0;
}

button{
  position: relative;
  border: 2px solid black;
  background: white;
  margin: -0.2%;
  box-shadow: 3px 2px;
  z-index: 2;
}

button a{
  text-decoration: none;
  color: black;
}

button:hover,
button:focus {
  box-shadow: 0.48em .4em;
  transform: translate(-0.25em, -0.25em);
}

input, select{  
  border: 2px solid black;
  border-radius: 3px;
}

label{
  font-size: .8em;
}

.footer-back{
  position: absolute;
  float: left;
  bottom: 11.3%;
  left: 7%;
}

.footer-back button{
  padding: 15.5% 25.5%;
}

</style>

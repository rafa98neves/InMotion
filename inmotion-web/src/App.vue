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

export default {
  name : 'App'
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
  position: absolute;
  font-size: 15px;
  background: white;
  top: 1.5%;
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
  display: inline-block;
  cursor: pointer;
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

button:hover {
  box-shadow: 0.48em .4em;
  transform: translate(-0.25em, -0.25em);
}

button:disabled {
  cursor: default;
  border: 1px solid black;
  box-shadow: 0 0;
  transform: translate(0, 0);
}

input, select, textarea{  
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
  
.error-msg{
    text-align: left;
    margin-top: -1%;
    margin-left: 25%;
    font-size: 10px;
    color: red;
}
  
</style>

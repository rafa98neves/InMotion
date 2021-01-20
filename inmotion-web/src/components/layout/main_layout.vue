<template>
    <h1 id="pagename">{{ $route.name }}</h1>

    <!-- Repeated images -->
    <div id="header-images">
        <div id="inmotion-logo">
          <img src="../../assets/inmotion-logo.jpg">
        </div> 
        <div id="Phys-logo">
          <img src="../../assets/LIBPhys-logo.jpg">
        </div> 
    </div>
    
  <div class="layout-header" v-if="loggedIn">
    <router-link v-if="user.role!='ADMIN'" to="/user/info"><img src="../../assets/avatar.png" class="avatar"></router-link>
    <label class="name"> {{ user.name }} </label><br>
    <img src="../../assets/logout.png" class="logout" @click="logout">
  </div>

   <div class="loader" v-if="loading"></div> 
</template>

<script>

import { accountService } from '../../_services/account.service'

export default {
  name: 'MainLayout',
  props: ['loggedIn'],
  data() {
    return {
      loading : false,
      user : accountService.user
    }
  },
  methods: {
    logout(){
      accountService.logout()
    },
    setLoading(set){
      this.loading = set;
    }
  }
}
</script>

<style>

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

.layout-header {  
    word-wrap: break-word;  
    position: fixed;
    top: 7%;
    right: 5%;
    width: 5%;
    height: auto;
}

.layout-header .avatar {
  width: 60px;
  cursor: pointer;
  margin-bottom: 15%;
}

.layout-header .name {
  width: 100%;
  background-color: white;
  text-align: center;
}

.layout-header .logout {
  margin-top: 25%;
  width: 50%;
  cursor: pointer;
}

.loader {
  position: absolute;
  top: 40%;
  left: 48%;
  border: 16px solid #f3f3f3; /* Light grey */
  border-top: 16px solid #3498db; /* Blue */
  border-radius: 50%;
  width: 80px;
  height: 80px;
  animation: spin 2s linear infinite;
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
  
</style>

<template>
  <MainLayout :loggedIn="false"></MainLayout>
  <div class="login-form">
    
    <div class="form-box">
        <router-link to="/login"><button>Login</button></router-link>
        <router-link class="btn btn-therapist" to="/registertherapist"><button>Create account</button></router-link>
      </div>


  </div>
</template>

<script>
import MainLayout from '../layout/main_layout'
export default {
  components: {
    MainLayout,
  }
}
</script>

<style scoped>

  @import url('auth.css');

  .form-box{
    margin-left: 12%;
    margin-top: 16%;
  }

  button{
    padding: 1.5% 4%;
    margin: 7%; 
  }
</style>

<template>
  <MainLayout :loggedIn="false"></MainLayout>
  <div class="login-form">
    
    <div class="form-box">
        <router-link to="/login"><button style="font-size:18px;">Login</button></router-link>
        <router-link class="btn btn-therapist" to="/registertherapist"><button style="margin-left:300px; font-size:18px;">Create account</button></router-link>
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
    margin-top: 23%;
  }

</style>

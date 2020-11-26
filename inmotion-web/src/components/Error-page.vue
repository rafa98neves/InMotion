<template>
  <div class="container">
    
    <div id="error-image">
      <img src="../assets/error.png">
    </div> 
    <h1> Something went wrong, the site is down!</h1>
    <h3> Try again later </h3>
    <h4>{{ $route.params.msg }}</h4>

    <div class="footer-back" id="back">
      <router-link class="btn btn-patient" to="/ladingpage"><button>Back</button></router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ErrorPage',
  props: {
  }
}

</script>

<style scoped>

.container{
  width: 100%;
  height: 100%;
}

#error-image{
  margin-left: 25%;
  max-width: 50%;
  height: auto;
}
</style>

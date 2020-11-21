<template>
  <nav class="navbar">
    </nav>

    <!-- main app container -->
    <div class="container">
        <router-view/>
    </div>
</template>

<script>

export default {
    name: 'App',
    components: {
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
</style>

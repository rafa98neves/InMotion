<template>
  <div>
  </div>
</template>

<script>

export default {
    name: 'Piano',
    mounted() {

      /* eslint-disable no-undef */

      window.controller = new Leap.Controller
      window.controller.use('handEntry', {})
            .use('riggedHand').connect()

      /* eslint-enalbe no-undef */
    }
}

</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

canvas{
  position: absolute;
  top: 200%;
  pointer-events: none;
}
</style>

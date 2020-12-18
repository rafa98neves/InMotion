<template>
  <div>
  </div>
</template>

<script>

import piano from './game1-logic'

export default {
    name: 'Piano',
    data(){
      return{
        msg : ''
      }
    },
    mounted() {
      
      // eslint-disable-next-line
      var controller = piano();
      controller.connect();
      
    }
}

</script>

<style scoped>

.display_message{
  text-align: center;
  margin-top: 20%;
  width: 100%;
  height: 100%;
}

canvas{
  pointer-events: none;
}

</style>

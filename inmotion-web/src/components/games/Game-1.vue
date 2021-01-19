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
        msg : '',
        controller: ''
      }
    },
    mounted() {
      
      // eslint-disable-next-line
      this.controller = piano();
      this.controller.connect();
      
    },
    beforeUnmount(){
      this.controller.disconnect();
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

<template>
  <div>
    {{msg}}
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
    created() {
        piano()
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
  pointer-events: none;
}

</style>

<template>
  <div id="list">
    <div id="button">
      <button @click="scroll_left" id="r-left-button"><img src="../assets/left_arrow.png" width="30" height="30"></button>
      <button @click="scroll_right" id="r-right-button"><img src="../assets/right_arrow.png" width="30" height="30"></button>
    </div>
    <div class="r-center" id="content" ref="content">     
      <div class=internal v-for="item in items" :key="item">
        <router-link class="Game" :to= item.link >
        <img :src="getImgUrl(item.src)" width="100" height="100">
        </router-link>
        <p>{{ item.id }}</p>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "App",
  data: function () {
    return {
      items: [
        { id: "Juice", src: "juice_game.png", link: "/recoverpassword" },
      ],
    };
  },


  methods: {
    getImgUrl: function (imagePath) {
      return require('@/assets/' + imagePath);
    },

    scroll_left() {
      let content = document.querySelector(".r-center");
      content.scrollLeft -= 50;
    },

    scroll_right() {
      let content = document.querySelector(".r-center");
      content.scrollLeft += 50;
    }

  }
};
</script>


<style scoped>
#list {
  display: flex;
  position: absolute;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  width: 100%;
  height: 40%;
  font-weight: bold; 
}

.internal{
 width: 31.75%;
 height: 50%;
 margin-top: 4%;
 border: 1px transparent;
 display: inline-block;
 font-size: 18px;
 color: black
 
}

.r-center{
 float: left; 
 width: 38.9%;
 border: 1px transparent;
 overflow: hidden;
 white-space: nowrap;  
}

#r-left-button{
  position: absolute;
  left: 20%;
  top: 35%;
}

#r-right-button{
  position: absolute;
  right: 20%;
  top: 35%;
}



</style>

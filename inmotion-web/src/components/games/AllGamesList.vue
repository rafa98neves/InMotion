<template>
    <div id="list">
      <div id="button" v-if="index.length == 3">
        <button @click="scroll_left" id="a-left-button"><img src="../../assets/left_arrow.png" width="30" height="30"></button>
        <button @click="scroll_right" id="a-right-button"><img src="../../assets/right_arrow.png" width="30" height="30"></button>
      </div>

      <div class="a-center" id="content" ref="content">
        {{ msg }}
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
      msg: '',
      items_list: [
        { id: "Juice", src: "juice_game.png", link: "/error" },
        { id: "Piano", src: "piano.png", link: "/games/piano" },
        { id: "Clean With", src: "clean_with_me.png", link: "/error" },
        { id: "Game 4", src: "error.png", link: "/error" },
        { id: "Game 5", src: "error.png", link: "/error" },
        { id: "Game 6", src: "error.png", link: "/error" },
      ],
      index: '',
      items: [],
    };
  },
  mounted() {
    switch(this.items_list.length){
        case 0:
          this.msg = "No games to display";
          break;
        case 1:
          this.items = [this.items_list[0]];
          break;
        case 2:
          this.items = [this.items_list[0], this.items_list[1]];
          break;
        case 3:
          this.items = [this.items_list[0], this.items_list[1], this.items_list[2]];
          break;
        default:
          this.index = [0,1,2];
          this.items = [this.items_list[0], this.items_list[1], this.items_list[2]];
          break;
    }
  },
  methods: {
    getImgUrl: function (imagePath) {
      return require('@/assets/' + imagePath);
    },

    scroll_left() {
      if(this.index.length == 3){
        var i;
        for(i=0; i<3; i++){
          if(this.index[i] == 0) this.index[i] = this.items_list.length-1;
          else this.index[i]--;
          console.log(this.index[i])
          this.items[i] = this.items_list[this.index[i]];
        }
      }
    },

    scroll_right() {
      if(this.index.length == 3){
        var i;
        for(i=0; i<3; i++){
          if(this.index[i] == this.items_list.length-1) this.index[i] = 0;
          else this.index[i]++;
          console.log(this.index[i])

          this.items[i] = this.items_list[this.index[i]];
        }
      }
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

.a-center{
 float: left; 
 width: 38.9%;
 border: 1px transparent;
 margin: 1px;
 overflow: hidden;
 white-space: nowrap; 
}

#a-left-button{
  position: absolute;
  left: 20%;
  top: 35%;
}

#a-right-button{
  position: absolute;
  right: 20%;
  top: 35%;
}

</style>

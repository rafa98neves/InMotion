<template>
    <div id="list">
      <div id="button" v-if="index.length == 3">
        <button @click="scroll_left" id="a-left-button"><img src="../../assets/left_arrow.png" width="30" height="30"></button>
        <button @click="scroll_right" id="a-right-button"><img src="../../assets/right_arrow.png" width="30" height="30"></button>
      </div>

      <!-- get all games list-->
      <div class="a-center" id="content" ref="content">
        <div class="loader" v-if="loading"></div> 
        <div v-if="!loading">   
          {{ msg }}
          <div class=internal v-for="item in items" :key="item">
            <router-link class="Game" :to= item.link >
            <img :src="getImgUrl(item.src)" width="100" height="100">
            </router-link>
            <p>{{ item.id }}</p>
          </div>
        </div>
    </div>  
  </div>
  
</template>

<script>

import { resourcesService } from "../../_services/resources.service"

export default {
  data: function () {
    return {
      msg: '',
      loading: true,
      //list of games
      items_list: [],
      index: '',
      items: [],
    };
  },
  mounted() {
    this.getInformation();
  },
  methods: {

    async getInformation(){
      await resourcesService.getGames()
        .then((res) => {
            this.items_list = res;
            this.displayGames();
            this.loading = false;
        });
      return this;
    },
    displayGames(){
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
    getImgUrl: function (imagePath) {
      return require('@/assets/' + imagePath);
    },
    
    // scroll buttons
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

    // scroll buttons
    scroll_right() {
      if(this.index.length == 3){
        var i;
        for(i=0; i<3; i++){
          if(this.index[i] == this.items_list.length-1) this.index[i] = 0;
          else this.index[i]++;
          
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

.loader {
  position: absolute;
  border: 16px solid #f3f3f3; /* Light grey */
  border-top: 16px solid #3498db; /* Blue */
  border-radius: 50%;
  top: 30%;
  width: 20px;
  height: 20px;
  animation: spin 2s linear infinite;
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

.internal img{
  width: 50%;
  height: auto;
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

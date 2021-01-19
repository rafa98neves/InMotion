<template>
  <div>
    <h2 id="header">Piano Game</h2>
    <img id="pianoImgId" src="../../assets/piano/images/1.jpg"/>

    <img id="tile1_dark" src="../../assets/piano/images/red.png"/>
    <img id="tile1" src="../../assets/piano/images/red80.png"/>
    <img id="tile2_dark" src="../../assets/piano/images/darkorange.png"/>
    <img id="tile2" src="../../assets/piano/images/darkorange80.png"/>
    <img id="tile3_dark" src="../../assets/piano/images/orange.png"/>
    <img id="tile3" src="../../assets/piano/images/orange80.png"/>
    <img id="tile4_dark" src="../../assets/piano/images/yellow.png"/>
    <img id="tile4" src="../../assets/piano/images/yellow80.png"/>
    <img id="tile5_dark" src="../../assets/piano/images/lgreen.png"/>
    <img id="tile5" src="../../assets/piano/images/lgreen80.png"/>
    <img id="tile6_dark" src="../../assets/piano/images/green.png"/>
    <img id="tile6" src="../../assets/piano/images/green80.png"/>
    <img id="tile7_dark" src="../../assets/piano/images/lblue.png"/>
    <img id="tile7" src="../../assets/piano/images/lblue80.png"/>
    <img id="tile8_dark" src="../../assets/piano/images/blue.png"/>
    <img id="tile8" src="../../assets/piano/images/blue80.png"/>
    <img id="tile9_dark" src="../../assets/piano/images/darkblue.png"/>
    <img id="tile9" src="../../assets/piano/images/darkblue80.png"/>
    <img id="tile10_dark" src="../../assets/piano/images/purple.png"/>
    <img id="tile10" src="../../assets/piano/images/purple80.png"/>

    <transition id="fade">
      <button id="play" v-on:click="initGame"> PLAY </button>
    </transition>
  </div>
</template>

<script>
import piano from './game1-logic'

export default {
    name: 'Piano',

    data(){
      return{
        controller: '',
        musics : {
          scale : ["1c","1d","1e","1f","1g","1a", "1b", "2c", "2d", "2e"],
          first : ["1c","1c","1g","1g", "1a", "1a", "1g"],
          second : ["1e","1e","1e","1e","1e","1e","1e", "1g", "1c", "1d", "1e"],
        },
        current_music: '',
        current_note: 0,
        noteMap : {
          "1c" : "tile1",
          "1d" : "tile2",
          "1e" : "tile3",
          "1f" : "tile4",
          "1g" : "tile5",
          "1a" : "tile6",
          "1b" : "tile7",
          "2c" : "tile8",
          "2d" : "tile9",
          "2e" : "tile10",
        },
        nameMap : [ "thumb", "index", "middle", "ring", "pinky"],
        fingerMap: {
          "thumb" : {
            "medium" : 40,
            "hard" : 45,
            "left_hand" : {
              "target" : false,
              "note" : "1g",
              "audio" : new Audio(require("@/assets/piano/sounds/1g.mp3")),
              "tile" : "tile5",
              "pressing" : 0 // 0-not pressing || 1-soft pressing || 2-hard pressing
            },
            "right_hand" : {
              "target" : false,
              "note" : "1a",
              "audio" : new Audio(require("@/assets/piano/sounds/1a.mp3")),
              "tile" : "tile6",
              "pressing" : false
            }
          },
          "index" : {
            "medium" : 15,
            "hard" : 20,
            "left_hand" : {
              "target" : false,
              "note" : "1f",
              "audio" : new Audio(require("../../assets/piano/sounds/1f.mp3")),
              "tile" : "tile4",
              "pressing" : false
            },
            "right_hand" : {
              "target" : false,
              "tile" : "tile7",
              "note" : "1b",
              "audio" : new Audio(require("../../assets/piano/sounds/1b.mp3")),
              "pressing" : false
            }
          },
          "middle" : {
            "medium" : 8,
            "hard" : 10,
            "left_hand" : {
              "target" : false,
              "note" : "1e",
              "audio" : new Audio(require("../../assets/piano/sounds/1e.mp3")),
              "tile" : "tile3",
              "pressing" : false
            },
            "right_hand" : {
              "target" : false,
              "note" : "2c",
              "tile" : "tile8",
              "audio" : new Audio(require("../../assets/piano/sounds/2c.mp3")),
              "pressing" : false
            }
          },
          "ring" : {
            "medium" : 5,
            "hard" : 8,
            "left_hand" : {
              "target" : false,
              "note" : "1d",
              "audio" : new Audio(require("../../assets/piano/sounds/1d.mp3")),
              "tile" : "tile2",
              "pressing" : false
            },
            "right_hand" : {
              "target" : false,
              "tile" : "tile9",
              "note" : "2d",
              "audio" : new Audio(require("../../assets/piano/sounds/2d.mp3")),
              "pressing" : false
            }
          },
          "pinky" : {
            "medium" : 5,
            "hard" : 8,
            "left_hand" : {
              "target" : false,
              "note" : "1c",
              "audio" : new Audio(require("../../assets/piano/sounds/1c.mp3")),
              "tile" : "tile1",
              "pressing" : false
            },
            "right_hand" : {
              "target" : false,
              "tile" : "tile10",
              "note" : "2e",
              "audio" : new Audio(require("../../assets/piano/sounds/2e.mp3")),
              "pressing" : false
            }
          }
        }
      }
    },

    mounted() {
      document.body.style.backgroundColor = "black";
      var fade = document.getElementById("fade");
      fade.classList.add("fade-enter-active");      
    },

    methods : {

      initGame(){  
        var fade = document.getElementById("fade");
        fade.classList.add("fade-leave-active");
        
        var pianoImage = document.getElementById("pianoImgId");
        pianoImage.classList.add("fade-nitid-active");

        if(this.controller == ''){
          this.controller = piano();
          this.controller.connect();  
        }
        else{          
          document.getElementById("header").classList.remove("fade-leave-active");
        }
        this.startGame();
      },

      startGame(){
        var rand = Math.floor(Math.random() * Object.keys(this.musics).length);
        this.current_music = this.musics[Object.keys(this.musics)[rand]];
        this.current_note = 0;
        this.next()
        this.fingerPosition(this.fingerMap, this.nameMap, this.keyPressed); 
      },

      next(){
        //var currentdate = new Date(); 

        var fingerMap = this.fingerMap;
        var nameMap = this.nameMap;
        var current_music = this.current_music;
        var current_note = this.current_note;
        var noteMap = this.noteMap;

        if(current_note != 0){
          //console.log(currentdate.getSeconds());
          document.getElementById(noteMap[current_music[current_note-1]] + "_dark").style.visibility = "hidden";
        }

        if(current_note === current_music.length){
          document.getElementById("header").classList.remove("fade-leave-active");
          document.getElementById("header").textContent = "Good job! You did it!\nPlay again?";
          document.getElementById("header").classList.add("fade-enter-active");
          var fade = document.getElementById("fade");
          fade.classList.remove("fade-leave-active");
          fade.classList.add("fade-enter-active");
        }
        else{
          setTimeout(function(){ 
            document.getElementById(noteMap[current_music[current_note]] + "_dark").style.visibility = "visible"; 
            for(var i = 0; i < 5; i++){
              if(fingerMap[nameMap[i]].right_hand.note === current_music[current_note]){
                fingerMap[nameMap[i]].right_hand.target = true;
              }
              else if(fingerMap[nameMap[i]].left_hand.note === current_music[current_note]){
                fingerMap[nameMap[i]].left_hand.target = true;
              }
            }
            //console.log(currentdate.getSeconds())
          }, 1000);   
        }     
      },

      fingerPosition(fingerMap, nameMap, keyPressed){
        /* eslint-disable */
        this.controller.on('frame', function(frame) {
          if(frame.valid && frame.fingers.length > 0){           
            for( var finger = 0; finger < 10; finger++) {
              var count = 0;
              var average = Leap.vec3.create();   
              var hand_side = false;
              var hand; 
              if(frame.fingers[finger] != undefined){
                for(var i = 0; i < 5; i++){
                  var fingerFromFrame = controller.frame(i).finger(frame.fingers[finger].id); 
                  hand = controller.frame(i).hand(fingerFromFrame.handId);    
                  if(fingerFromFrame.valid && hand.valid) {
                    var vector = Leap.vec3.create;
                    hand_side = hand.type;
                    vector[0] = hand.palmPosition[0] - fingerFromFrame.tipPosition[0];
                    vector[1] = hand.palmPosition[1] - fingerFromFrame.tipPosition[1];
                    vector[2] = hand.palmPosition[2] - fingerFromFrame.tipPosition[2];

                    Leap.vec3.add(average, average, vector);
                    count++;
                  }
                }
                if(count > 0) {
                  Leap.vec3.scale(average, average, 1/count); 

                  var fingerObject 
                  if(finger >= 5){
                    fingerObject = fingerMap[[nameMap[finger-5]]]
                  }
                  else{
                    fingerObject = fingerMap[[nameMap[finger]]]
                  }

                  if(Math.round(average[1]) > fingerObject.hard){
                    if(hand_side === "left"){
                      fingerObject.left_hand.pressing = 2;
                    }
                    else{
                      fingerObject.right_hand.pressing = 2;
                    }
                  }
                  else if(Math.round(average[1]) > fingerObject.medium){
                    if(hand_side === "left"){
                      fingerObject.left_hand.pressing = 1;
                    }
                    else{
                      fingerObject.right_hand.pressing = 1;
                    }
                  }
                  else{
                    if(hand_side === "left"){
                      fingerObject.left_hand.pressing = 0;
                    }
                    else{
                      fingerObject.right_hand.pressing = 0;
                    }
                  } 
                  keyPressed(fingerObject);
                }
              }
            }          
          }
        });
      },

      keyPressed(finger){
        var key = document.getElementById(finger.left_hand.tile);
        var audio = finger.left_hand.audio;

        switch(finger.left_hand.pressing){
          case 0 :            
            key.style.visibility = "hidden";
            break;
          case 1:
            key.style.visibility = "hidden";
            break;
          case 2:
            key.style.visibility = "visible";
            audio.play();
            if(finger.left_hand.target === true){
              finger.left_hand.target = false;
              this.current_note++;
              this.next();
            }
            break;
        }

        
        key = document.getElementById(finger.right_hand.tile);
        audio = finger.right_hand.audio;
        switch(finger.right_hand.pressing){
          case 0 :            
            key.style.visibility = "hidden";
            break;
          case 1:
            key.style.visibility = "hidden";
            break;
          case 2:
            key.style.visibility = "visible";
            audio.play();
            if(finger.right_hand.target === true){
              finger.right_hand.target = false;
              this.current_note++;
              this.next();
            }
            break;
        }
      }
    }
  }
  
</script>

<style scoped>

canvas {
  pointer-events: none;
}

h2{
  position: fixed;
  width: 98%;
  text-align: center;
  font-size: 30px;
  opacity: 1;
}

#pianoImgId{
  position: fixed;
  width: 100%;
  height: 80%;
  top: 30%;
  left: 0;
  overflow: hidden;
  opacity: 0.3;
}

#fade{
  position: fixed;
  top: 50%;
  left: 50%;
  margin-top: -2%;
  margin-left: -4%;
  padding: 2% 4%;
  opacity:0;
}

.fade-enter-active {
  animation: fadeIn 2s linear forwards;
}

@keyframes fadeIn {
 0% { opacity:0; }
 100% { opacity:1; } 
}

.fade-leave-active {
  animation: fadeOut .3s linear forwards;
}

@keyframes fadeOut {
 0% { opacity:1; }
 100% { opacity:0; } 
}

.fade-nitid-active {
  animation: fadeIn2 1s linear forwards;
}

@keyframes fadeIn2 {
 0% { opacity: 0.3; }
 100% { opacity: 0.6; } 
}

#piano{
  position: fixed;
  width: 100%;
  height: 80%;
  top: 20%;
  left: 0;
  opacity: 0.3;
}

#tile1_dark, #tile1{
  position: fixed;
  width: 20%;  
  height: 62%;
  left:1.9%;
  top:38%;
  visibility: hidden;
}

#tile2_dark, #tile2{
  position: fixed;
  width: 14%;  
  height: 62%;
  left:11.9%;
  top:38%;
  visibility: hidden;
}

#tile3_dark, #tile3{
  position: fixed;
  width: 13.5%;  
  height: 62%;
  left:21.5%;
  top:38%;
  visibility: hidden;
}
#tile4_dark, #tile4{
  position: fixed;
  width: 13%;  
  height: 62%;
  left:31%;
  top:38%;
  visibility: hidden;
}
#tile5_dark, #tile5{
  position: fixed;
  width: 15%;  
  height: 61%;
  left:41%;
  top:39%;
  visibility: hidden;
}
#tile6_dark, #tile6{
  position: fixed;
  width: 12%;  
  height: 62%;
  left:51%;
  top:38%;
  visibility: hidden;
}
#tile7_dark, #tile7{
  position: fixed;
  width: 13%;  
  height: 64%;
  left:59%;
  top:36%;
  visibility: hidden;
}
#tile8_dark, #tile8 {
  position: fixed;
  width: 14%;  
  height: 61%;
  left:68.5%;
  top:39%;
  visibility: hidden;
}
#tile9_dark, #tile9{
  position: fixed;
  width: 19.2%;  
  height: 62%;
  left:73.5%;
  top:38.3%;
  visibility: hidden;
}
#tile10_dark, #tile10{
  position: fixed;
  width: 16%;  
  height: 61%;
  left:84%;
  top:39%;
  visibility: hidden;
}

</style>
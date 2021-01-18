<template>
  <div>
    <img id="pianoImgId" src="../../assets/piano/images/1.jpg"/>
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
        nameMap : [ "thumb", "index", "middle", "ring", "pinky" ],
        fingerMap: {
          "thumb" : {
            "medium" : 40,
            "hard" : 45,
            "audio0" : new Audio(require("@/assets/piano/sounds/1g.mp3")),
            "audio1" : new Audio(require("@/assets/piano/sounds/1a.mp3"))
          },
          "index" : {
            "medium" : 15,
            "hard" : 20,
            "audio0" : new Audio(require("../../assets/piano/sounds/1f.mp3")),
            "audio1" : new Audio(require("../../assets/piano/sounds/1b.mp3"))
          },
          "middle" : {
            "medium" : 8,
            "hard" : 10,
            "audio0" : new Audio(require("../../assets/piano/sounds/1e.mp3")),
            "audio1" : new Audio(require("../../assets/piano/sounds/2c.mp3"))
          },
          "ring" : {
            "medium" : 5,
            "hard" : 8,
            "audio0" : new Audio(require("../../assets/piano/sounds/1d.mp3")),
            "audio1" : new Audio(require("../../assets/piano/sounds/2d.mp3"))
          },
          "pinky" : {
            "medium" : 5,
            "hard" : 8,
            "audio0" : new Audio(require("../../assets/piano/sounds/1c.mp3")),
            "audio1" : new Audio(require("../../assets/piano/sounds/2e.mp3"))
          },
          "status" : {
            "finger" : '',
            "power" : 0
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

        this.controller = piano();
        this.controller.connect();  
        //this.fingerPosition(this.fingerMap, this.nameMap, this.playSound);
      },

      fingerPosition(fingerMap, nameMap, playSound){
        /* eslint-disable */
        this.controller.on('frame', function(frame) {
          if(frame.valid && frame.fingers.length > 0){
            var count = 0;
            var average = Leap.vec3.create();       

            for( var finger = 0; finger < 5; finger++) {
              var fingerToAverage = frame.fingers[finger];

              for( var i = 0; i < 10; i++ ) {
                var handFromFrame = controller.frame(i).hand(fingerToAverage.handId);
                var fingerFromFrame = controller.frame(i).finger(fingerToAverage.id);                  

                if( handFromFrame.valid && fingerFromFrame.valid ) {
                    var vector = Leap.vec3.create;
                    vector[0] = handFromFrame.palmPosition[0] - fingerFromFrame.tipPosition[0];
                    vector[1] = handFromFrame.palmPosition[1] - fingerFromFrame.tipPosition[1];
                    vector[2] = handFromFrame.palmPosition[2] - fingerFromFrame.tipPosition[2];
                    Leap.vec3.add(average, average, vector);
                    count++;
                  }
              } 
              
              if(count > 0) {
                console.log(fingerToAverage)
                console.log(fingerToAverage.hand)
                Leap.vec3.scale(average, average, 1/count); 
                if(Math.round(average[1]) > fingerMap[[nameMap[finger]]].hard){
                  fingerMap["status"].finger = nameMap[finger];
                  fingerMap["status"].power = 2;
                  playSound(fingerMap[nameMap[finger]], fingerToAverage.hand, true);
                }
                else if(Math.round(average[1]) > fingerMap[nameMap[finger]].medium){
                  if( fingerMap["status"].power == 2 && fingerMap["status"].finger == nameMap[finger]){
                    fingerMap["status"].finger = nameMap[finger];
                    fingerMap["status"].power = 1;
                    playSound(fingerMap[nameMap[finger]], fingerToAverage.hand, false);
                  }
                  else if(fingerMap["status"].power != 2){
                    fingerMap["status"].finger = nameMap[finger];
                    fingerMap["status"].power = 1;
                    playSound(fingerMap[nameMap[finger]], fingerToAverage.hand, false);
                  }
                }
                else if(fingerMap["status"].finger == nameMap[finger]){
                    fingerMap["status"].finger = '';
                    fingerMap["status"].power = 0;
                }
              }
            }                
          }
        });
      },

      keyPressed(finger, hand, hard){
        var audio;
        if(hard){
          if(hand == 'left'){
            audio = finger.audio0;
          }
          else{
            audio = finger.audio1;
          }
          audio.volume = 0.3;
        }
        else{
          if(hand == 'left'){
            audio = finger.audio0;
          }
          else{
            audio = finger.audio1;
          }
          audio.volume = 0.01;
        }
        audio.play();
      }
    }
  }
</script>

<style scoped>

canvas {
  pointer-events: none;
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

</style>
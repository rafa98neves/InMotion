<template>
  <div>
    <p><span id="avgPosition"></span></p>
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
            "hard" : 45
          },
          "index" : {
            "medium" : 15,
            "hard" : 20
          },
          "middle" : {
            "medium" : 8,
            "hard" : 10
          },
          "ring" : {
            "medium" : 5,
            "hard" : 8
          },
          "pinky" : {
            "medium" : 5,
            "hard" : 8
          },
          "status" : {
            "finger" : '',
            "power" : 0
          }
        }
      }
    },
    mounted() {
        this.controller = piano();
        this.controller.connect();  
        this.fingerPosition(this.fingerMap, this.nameMap);
    },
    methods : {

      fingerPosition(fingerMap, nameMap){
        /* eslint-disable */
        var avgDisplay = document.getElementById('avgPosition');

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
                    Leap.vec3.scale(average, average, 1/count); 
                    if(Math.round(average[1]) > fingerMap[[nameMap[finger]]].hard){
                      fingerMap["status"].finger = nameMap[finger];
                      fingerMap["status"].power = 2;
                      avgDisplay.innerText = nameMap[finger] + " hard click";
                    }
                    else if(Math.round(average[1]) > fingerMap[nameMap[finger]].medium){
                      if( fingerMap["status"].power == 2 && fingerMap["status"].finger == nameMap[finger]){
                        fingerMap["status"].finger = nameMap[finger];
                        fingerMap["status"].power = 1;
                      }
                      else if(fingerMap["status"].power != 2){
                        fingerMap["status"].finger = nameMap[finger];
                        fingerMap["status"].power = 1;
                        avgDisplay.innerText = nameMap[finger] + " medium click";
                      }
                    }
                    else if(fingerMap["status"].finger == nameMap[finger]){
                        fingerMap["status"].finger = '';
                        fingerMap["status"].power = 0;
                        avgDisplay.innerText = "";
                    }
                }
              }                
          }
        });
      }
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

<template>
  <div>
    <button id="1c" v-on:click="playSound('1c')" />
    <button id="1d" v-on:click="playSound('1d')" />
    <button id="1e" v-on:click="playSound('1e')" />
    <button id="1f" v-on:click="playSound('1f')" />
    <button id="1g" v-on:click="playSound('1g')" />
    <button id="1a" v-on:click="playSound('1a')" />
    <button id="1b" v-on:click="playSound('1b')" />
    <button id="2c" v-on:click="playSound('2c')" />
    <button id="2d" v-on:click="playSound('2d')" />
    <button id="2e" v-on:click="playSound('2e')" />
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
        staticFolder : '../../assets/piano/sounds/',
        fingerMap: {
          "thumb" : {
            "medium" : 40,
            "hard" : 45,
            "note0" : '1g',
            "note1" : '1a'
          },
          "index" : {
            "medium" : 15,
            "hard" : 20,
            "note0" : '1f',
            "note1" : '1b'
          },
          "middle" : {
            "medium" : 8,
            "hard" : 10,
            "note0" : '1e',
            "note1" : '2c'
          },
          "ring" : {
            "medium" : 5,
            "hard" : 8,
            "note0" : '1d',
            "note1" : '2d'
          },
          "pinky" : {
            "medium" : 5,
            "hard" : 8,
            "note0" : '1c',
            "note1" : '2e'
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
                    var button = document.getElementById(fingerMap[[nameMap[finger]]].note0);
                    Leap.vec3.scale(average, average, 1/count); 
                    if(Math.round(average[1]) > fingerMap[[nameMap[finger]]].hard){
                      fingerMap["status"].finger = nameMap[finger];
                      fingerMap["status"].power = 2;
                        button.click();
                    }
                    else if(Math.round(average[1]) > fingerMap[nameMap[finger]].medium){
                      if( fingerMap["status"].power == 2 && fingerMap["status"].finger == nameMap[finger]){
                        fingerMap["status"].finger = nameMap[finger];
                        fingerMap["status"].power = 1;
                        button.click();
                      }
                      else if(fingerMap["status"].power != 2){
                        fingerMap["status"].finger = nameMap[finger];
                        fingerMap["status"].power = 1;
                        button.click();
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
      playSound(note){
        var audio = new Audio(require("../../assets/piano/sounds/" + note +".mp3"))
        if(this.fingerMap.status.power == 2){
          audio.volume = 0.3;
        }
        else{
          audio.volume = 0.01;
        }
        audio.play();
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

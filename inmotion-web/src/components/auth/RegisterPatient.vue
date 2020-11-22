<template>
  <div class="Register">

    <div class="form-control-nav">
        <label>Type of Account</label>
        <button style="background: #5dbcd2;"><router-link class="btn btn-patient" to="/registerpatient">Patient</router-link></button>
        <button><router-link class="btn btn-therapist" to="/registertherapist">Therapist</router-link></button>
    </div>
    
    <form class="form-box">
      <div class="form-control">
        <label>Name</label>
        <input type="text" name="name" id="name" class="register-input" v-model="name">
      </div>

      <div class="form-control">
        <label>Email</label>
        <input type="email" name="email" id="email" class="register-input" v-model="email">
      </div>

      <div class="form-control">
        <label>Password</label>
        <input type="password" name="password" id="password" class="register-input" v-model="password">
      </div>

      <div class="form-control">
        <label>Diagnosis</label>    
        <select>
          <option selected="selected">None</option>
          <option>Diagnosis A</option>
          <option>Diagnosis B</option>
          <option>Diagnosis C</option>
        </select>
      </div>

      <div class="form-control">
        <label>Medication</label>    
        <select>
          <option selected="selected">None</option>
          <option>Medication A</option>
          <option>Medication B</option>
          <option>Medication C</option>
        </select>
      </div>

      <div class="form-control-nav">
        <label>Gender</label>    
        <button style="background: #5dbcd2;">Male</button>
        <button>Female</button>
      </div>
      
      <div class="form-footer">
        <div class="form-submit" id="submit">
          <button type="submit" class="btn-submit" v-on:click="register()">Create Account</button>
        </div>

        <div class="form-submit" id="back">
          <button><router-link class="btn btn-patient" to="/login">Back</router-link></button>
        </div>
      </div>

    </form>

    
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: '',
      password: '',
      diagnosis: [],
      medication: [],
      gender:'',
    }
  }

}
</script>


<style scoped>

.form-control-nav{
  display: inline-block;
  margin: 0 0 1% 0;
  width: 50%;
}

.form-control-nav label{
  margin: 2%;
}

.form-control-nav button{
  padding: 1% 2% 1% 2%;
  border: 2px solid black;
  background: white;
  margin: -0.2%;
  box-shadow: 3px 2px;
}

.form-control-nav button a{
  text-decoration: none;
  color: black;
}

.form-box{
  display: table;
  margin-left: 10%;
  width: 80%;
  margin-top: 2%;
}

.form-control label,input {  
  display: inline-block;
  vertical-align: baseline;
  width: 20%;
  margin-bottom: 2%;
}

.form-control label{
  width: 20%;
}

.form-control input {
  border: 3px solid black;
  border-radius: 3px;
  width: 70%;
}

.form-control select {
  border: 3px solid black;
  border-radius: 3px;
  width: 20%;
  margin-right: 51%;
}

.form-footer{
  display: inline-block;
  position: absolute;
  bottom: 15%;
  left: 7%;
  width: 86%;
}

.form-footer button {  
  padding-bottom: 10%;
  padding-top: 10%;
  border: 2px solid black;
  background: white;
  box-shadow: 3px 2px;
}

.form-footer button a{
  text-decoration: none;
  color: black;
}

#submit{
  float: right;
}

#back{
  float: left;
}

</style>

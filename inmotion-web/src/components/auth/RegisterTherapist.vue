<template>
  <div class="Register">

    <div class="form-control-nav">
        <label>Type of Account</label>
        <button><router-link class="btn btn-patient" to="/registerpatient">Patient</router-link></button>
        <button style="background: #5dbcd2;"><router-link class="btn btn-therapist" to="/registertherapist">Therapist</router-link></button>
    </div>

    <form class="form-box">

      <div class="form-control">
        <label>Name</label>
        <input type="text" name="name" id="name" class="register-input" v-model="name" required>
      </div>

      <div class="form-control">
        <label>Email</label>
        <input type="email" name="email" id="email" class="register-input" v-model="email" required>
      </div>

      <div class="form-control">
        <label>Password</label>
        <input type="password" name="password" id="password" class="register-input" v-model="password" required>
      </div>

      <div class="form-control">
        <label>Confirm password</label>
        <input type="password" name="password" id="password" class="register-input" v-model="password" required>
      </div>

      <div class="form-control">
        <label>Gender</label>    
        <select v-model="gender">
          <option disabled value="">Please select one</option>
          <option>Male</option>
          <option>Female</option>
        </select>
      </div>

      <div class="form-footer">
        <div class="form-submit" id="submit">
          <button type="submit" class="btn-submit" v-on:click="register()">Create Account</button>
        </div>

        <div class="form-submit" id="back">
          <button><router-link class="btn btn-patient" to="/landingpage">Back</router-link></button>
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
}

.form-box{
  display: table;
  margin-left: 10%;
  width: 80%;
  height: 90%;
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
  width: 70%;
}

.form-control select {
  width: 20%;
  margin-right: 51%;
}

.form-control button {
  margin-right: 70%;
}

.form-footer{
  display: inline-block;
  position: absolute;
  bottom: 9%;
  left: 7%;
  width: 86%;
}

.form-footer button{  
  padding-bottom: 10%;
  padding-top: 10%;
}

#submit{
  float: right;
}

#back{
  float: left;
}


</style>

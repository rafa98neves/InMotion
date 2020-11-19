<template>
  <div class="Register">

    <h2 class="register-heading">Register Patient</h2> 

    <form>

      <div class="form-control-nav">
          <label>Account type</label>
          <router-link class="btn btn-patient" to="/registerpatient" style="margin-right: 20px; 
          margin-left: 20px">Patient</router-link>
          <router-link class="btn btn-therapist" to="/registertherapist">Therapist</router-link>
      </div>

      <div class="form-control-n">
        <label>Name</label>
        <input type="text" name="name" id="name" class="register-input" v-model="name">
        <p>test name: {{ name }}</p>
      </div>

      <div class="form-control-e">
        <label>Email</label>
        <input type="email" name="email" id="email" class="register-input" v-model="email">
        <p>test email: {{ email }}</p>
      </div>

      <div class="form-control-p">
        <label>Password</label>
        <input type="password" name="password" id="password" class="register-input" v-model="password">
        <p>test pass: {{ password }}</p>
      </div>

      <div class="form-control-p">
        <label>
        <input type="checkbox" value="Diagnosis A" v-model="diagnosis"/>
        Diagnosis A
        </label>
        <label>
        <input type="checkbox" value="Diagnosis B" v-model="diagnosis"/>
        Diagnosis B
        </label>
        <label>
        <input type="checkbox" value="Diagnosis C" v-model="diagnosis"/>
        Diagnosis C
        </label>
        <p>test diagnosis: {{diagnosis.join(', ')}}</p>
      </div>

      <div class="form-control-p">
        <label>
        <input type="checkbox" value="Medication A" v-model="medication"/>
        Medication A
        </label>
        <label>
        <input type="checkbox" value="Medication B" v-model="medication"/>
        Medication B
        </label>
        <label>
        <input type="checkbox" value="Medication C" v-model="medication"/>
        Medication C
        </label>
        <p>test medication: {{medication.join(', ')}}</p>
      </div>

      <div class="form-control-g">
        <label>Gender</label>    
        <select v-model="gender">
          <option disabled value="">Please select one</option>
          <option>Male</option>
          <option>Female</option>
        </select>
      <p>test gender: {{gender}}</p>
      </div>


      <div class="form-control">
        <button type="submit" class="btn-submit" v-on:click="register()">register</button>
      </div>

    </form>

    <p class="already-registered">
      Already registered?
      <router-link to="/login">Login</router-link>
    </p>
    
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

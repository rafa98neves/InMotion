<template>
  <div>

    <form class="form-box">
      <div class="form-control">
        <label for="email">Email</label>
        <input type="email" name="email" id="email" class="login-input" v-model="email">
      </div>

      <div class="form-control">
        <label>Password</label>
        <input type="password" name="password" id="password" class="register-input" v-model="password" required>
      </div>

      <div class="form-control">
        <label>Confirm password</label>
        <input v-on:blur="validate" type="password" name="password" id="password" class="register-input" v-model="password2" required>
        <h4>{{ msg }}</h4>
      </div>

    </form>

    <br>
    <button>Change password</button>

    <div class="footer-back" id="back">
      <router-link class="btn btn-patient" to="/login"><button>Back</button></router-link>
    </div>

  </div>
</template>

<script>

export default {
  data() {
    return {
      email: '',
      password: '',
      password2: ''
    }
  },
  methods: {
    validate() {
      if(this.password != this.password2){
        this.msg = 'Password does not correspond!'
      }
      else{
        this.msg = ''
      }
    }
  }

}
</script>

<style scoped>
@import url('auth.css');
</style>

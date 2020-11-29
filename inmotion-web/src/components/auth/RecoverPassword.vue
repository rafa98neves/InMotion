<template>

  <div>
    <form class="form-box" @submit.prevent="recoverPassword">
      <div class="form-control">
        <label for="email">Email</label>
        <input type="email" name="email" id="email" v-model="email">
      </div>

      <div class="form-control">
        <router-link class="btn btn-patient" to="/newpassword"><button type="submit" class="btn-submit">Send notification</button></router-link>
      </div>
    </form>

    <div class="footer-back" id="back">
      <router-link class="btn btn-patient" to="/login"><button>Back</button></router-link>
    </div>
    <div class="form-footer">
      <div class="form-submit" id="submit">
        <router-link class="btn btn-patient" to="/registerpatient"><button>Create account</button></router-link>
      </div>
    </div>

  </div>


</template>

<script>

import { accountService } from "../../_services/account.service"

export default {
  data() {
    return {
      email: ''
    }
  },
  methods: {
    recoverPassword() {
      let email = this.email
      accountService.recoverPassword(email);
    }
  }
}

</script>

<style scoped>
  @import url('auth.css');
</style>

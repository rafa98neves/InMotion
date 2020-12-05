<template>

  <div>
    <form class="form-box" @submit.prevent="recoverPassword" v-if="showForm">
      <div class="form-control">
        <label for="email">Email</label>
        <input type="email" name="email" id="email" v-model="email">
      </div>

      <div class="form-control">
        <button type="submit" class="btn-submit">Send notification</button>
      </div>
    </form>

    <div class="display_message" v-if="!showForm">
      <h2> We have sent you an email, check your inbox. </h2>
    </div>

    <div class="footer-back" id="back">
      <router-link class="btn btn-patient" to="/login"><button>Back</button></router-link>
    </div>

  </div>


</template>

<script>

import { accountService } from "../../_services/account.service"

export default {
  data() {
    return {
      email: '',
      showForm: true,
    }
  },
  methods: {
    recoverPassword() {
      let email = this.email
      accountService.recoverPassword(email,this);
    }
  }
}

</script>

<style scoped>
  @import url('auth.css');

  .display_message{
    text-align: center;
    margin-top: 20%;
    width: 100%;
    height: 100%;
  }

</style>

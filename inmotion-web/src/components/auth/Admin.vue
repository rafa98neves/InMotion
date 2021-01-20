<template>
  <MainLayout :loggedIn="true" ref="layout"></MainLayout>
  <div v-if="!loading">

  <div class="role">
    
    <div id="role-title">
      <div class="roles-text">
        <p>Therapist roles</p>
      </div>
    </div>

  
    <div id="role-list-rectangle">
      <p id="therapist-name">Request from user</p>
      <p id="therapist-role">Accept therapist?</p>
    </div>

  

    <div class="scroll">
        <div class="grid-container" v-for="item in therapist" :key="item">
          <div class="grid-child-name" >
            <p>
              {{item.name}} - {{item.email}}
             </p>
            <p>
             </p>
          </div>
          <div class="grid-child-role" >
            <p>
              <button v-on:click="buttonHandler(item.id, true)" class="btn btn-accept" id="accept">Accept</button>
            </p>
            <p>
              <button v-on:click="buttonHandler(item.id, false)" class="btn btn-reject" id="decline">Decline</button>
            </p>
         </div>
        </div>
      </div>
  </div>
  </div>

    
</template>

<script>
import MainLayout from '../layout/main_layout'
import { accountService } from "../../_services/account.service";

export default {
  name: "App",
  components: {
    MainLayout,
  },
  data: function () {
    return {
      loading : true,
    }
  },
  mounted() {
    if(accountService.user.role != "ADMIN"){
      this.$router.push("/");
      return;
    }
    this.awaitUserInfo();
  },
  methods: {

    async awaitUserInfo(){
      this.loading = true;
      this.$refs.layout.setLoading(this.loading);
      
      let therapist = await accountService.getRoles();
      this.therapist = therapist;

      this.loading = false;
      this.$refs.layout.setLoading(this.loading);
    },

    buttonHandler(id, accept) {     
      if(accept)  {
        accountService.setTherapist(id, "activate", this);
      }
      else{
        accountService.setTherapist(id, "reject", this);
      }
    },
  }
}
</script>

<style scoped>
  

  .container{
    position: absolute;
    text-align: left;
    left: 20%;
    top: 30%;
    width: 80%;
  }
  .form-control label p{
    display: block;
  }
  .form-control label{
    font-weight: bold;
    color: black;
    font-size: 18px;
    margin-bottom: 2%;
  }
  .form-control label, p, select{
    display: inline-block;
  }  
  .form-control select{
    padding: 5px 20% 5px 5px;
    border: 1px solid black;
  }
  .back-button{
    position: absolute;
    left: 10%;
    bottom: 13%; 
  }
  .cp-button{
    position: absolute;
    right: 10%;
    bottom: 13%; 
  }
  
#roles-title{
  position: absolute;
  top: 20%;
  left: 10%;
}

.roles-text{
  position: absolute;
  top: 20%;
  left: 15%;
  font-weight: bold;
  color: black;
  font-size: 18p
}
#role-list-rectangle{
  border: 5px solid black;
  position: absolute;
  width: 70%;
  height: 50%;
  left: 15%;
  top: 30%;
}
#therapist-name{
    float:left;
    margin-left: 5%;
    font-weight: bold;
    color: black;
    font-size: 18px
  }
#therapist-role{
    float:left;
    margin-left: 38%;
    font-weight: bold;
    color: black;
    font-size: 18px
  }

.scroll{
  position: absolute;
  left: 18%;
  top: 40%;
  width: 60%;
  max-height: 35%;
  overflow-y: scroll;
  overflow-x:hidden;
}
.grid-container {
    position: relative;
    width: 125%;
    height: 7%;
    left: 2%;
    top: -70%;
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-gap: 20px;
    text-align: left;}

#accept{
  position: absolute;
  left: 50%;
  top: 40%;
}

#decline{
  position: absolute;
  left: 62%;
  top: 40%;
}

  
</style>
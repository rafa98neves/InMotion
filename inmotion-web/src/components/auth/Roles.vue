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
      <p id="therapist-name">Name</p>
      <p id="therapist-role">Therapist Role</p>
    </div>

  

    <div class="scroll">
        <div class="grid-container" v-for="item in therapist" :key="item">
          <div class="grid-child-name" >
            <p>
              {{item.name}}
             </p>
          </div>
          <div class="grid-child-role" >
            <p>
              <button v-on:click="acceptButton(item.name,item.role)" class="btn btn-accept" id="accept">Accept</button>
            </p>
            <p>
              <button v-on:click="rejectButton(item.name,item.email,item.password)" class="btn btn-reject" id="decline">Decline</button>
            </p>

         </div>
        </div>
      </div>

      
      

  </div>

  <div class="footer-back" id="back">
    <router-link class="btn btn-role" to="/"><button>Back</button></router-link>
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
      counte: 5
    }
  },
  mounted() {
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

    
     acceptButton(name,role) {

       alert('The user ' + name + ' was accepted as a ' + role )

    },

      rejectButton(name,email,password) {
       
       alert('The user ' + name + ' was not accepted as a THERAPIST')

      let user = {
        name : name,
        email : email,
        password : password,
        role : 'NOT THERAPIST'
      }

      accountService.register(user,this);

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
  left: 30%;
  font-weight: bold;
  color: black;
  font-size: 18p
}
#role-list-rectangle{
  border: 5px solid black;
  position: absolute;
  width: 45%;
  height: 50%;
  left: 30%;
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
    margin-left: 42%;
    font-weight: bold;
    color: black;
    font-size: 18px
  }
.scroll{
  position: absolute;
  left: 32%;
  top: 40%;
  width: 40%;
  max-height: 150px;
  overflow-y: scroll;
  max-width: 400;
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
  left: 42%;
  top: 40%;
}

#decline{
  position: absolute;
  left: 62%;
  top: 40%;
}

  
</style>
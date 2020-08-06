<template>
  <div>
  <b-navbar toggleable="lg" type="light" variant="light" id="design">
    <b-navbar-brand href="/"><img src="@/assets/logo2.png" alt="logoimage" class="logo"></b-navbar-brand>
    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item href="#">BlogList</b-nav-item>
        <b-nav-item href="/blog/create">BlogCreate</b-nav-item>
        <b-nav-item href="#">MyBlog</b-nav-item>
        <!-- <b-nav-item href="#" disabled>Disabled</b-nav-item> -->
      </b-navbar-nav>
      
      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <b-nav-form>
          <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
          <b-button pill size="sm" class="my-2 my-sm-0" variant="outline-dark" type="submit">Search</b-button>
        </b-nav-form>
        <div class="d-flex justify-content-around">
        <button v-if="isLogin"
            type="button"
            class="btn btn-white"
            data-toggle="modal"
            data-target="#exampleModal"
          >Login</button>
          <!-- <b-avatar variant="light" class="ml-3">user</b-avatar>
        <b-nav-item-dropdown right class="dropBtn">

          <template v-slot:button-content >
          </template>
          <b-dropdown-item href="#">Profile</b-dropdown-item>
          <b-dropdown-item href="#">Logout</b-dropdown-item>
        </b-nav-item-dropdown> -->
          <b-dropdown split text="user" class="p-0" variant="outline-light">
            <b-dropdown-item href="#">Admin</b-dropdown-item>
            <!-- <b-dropdown-item href="#">Logout</b-dropdown-item> -->
            <b-dropdown-item class="btn btn-light m-0" @click="logout">Logout</b-dropdown-item>
          </b-dropdown>
        </div>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
  <div
        class="modal fade"
        id="exampleModal"
        tabindex="-1"
        role="dialog"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">로그인</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <Login />
            </div>
          </div>
        </div>
      </div>
</div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
import Login from '@/views/user/Login.vue'
export default {
    name: 'navbar',
    components:{
      Login,
    },
    methods: {
      ...mapActions(["logout"]),
    },
    computed: {
      ...mapGetters(["isLogin"]),
    },
}
</script>

<style>
/* #design {
    /* background-color:lightsteelblue !important; 
}*/
.logo {
  width:50px;
  height: 50px;
}
.logoutBtn {
  padding: 0px !important;
}
.dropBtn {
  margin-right:0.1rem !important;
}
</style>
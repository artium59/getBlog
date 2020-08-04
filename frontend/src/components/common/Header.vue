<template>
  <div class="header">
    <div class="inner">
      <nav class="navbar navbar-expand-lg navbar-light bg-white fixec-top">
        <!-- <router-link to="/" class="navbar-brand"><strong>SS_log</strong></router-link> -->
        <div id="navbarname" class="animate__animated animate__bounce">
          <a class="navbarname" href="/">
            <h4>싸피로그</h4>
          </a>
        </div>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div
          class="collapse navbar-collapse d-flex justify-content-end"
          id="navbarSupportedContent"
        >
          <form class="form-inline my-2 my-lg-0">
            <input
              class="form-control mr-sm-2"
              type="search"
              placeholder="Search"
              aria-label="Search"
              v-model="searchInput"
            />
            <button @click="search(searchInput)" class="btn btn-outline-success my-2 my-sm-0" type="button">Search</button>

            <ul class="navbar-nav mr-auto">
              <span v-if="!isLogIn" class="d-flex justify-content-end">
                <li class="nav-item active">
                  <router-link to="/user/join" class="nav-link">회원가입</router-link>
                </li>
                <li class="nav-item">
                  <button
                    type="button"
                    class="btn btn-white"
                    data-toggle="modal"
                    data-target="#exampleModal"
                  >로그인</button>
                </li>
              </span>
              <span v-if="isLogIn" class="d-flex justify-content-end">
                <!-- <li class="nav-item active">
                            <router-link to="/user/mypage" class="nav-link ml-auto">MyPage</router-link>
                        </li>
                        <li class="nav-item active">
                            <router-link to="/visitpage" class="nav-link mr-auto">방명록</router-link>
                </li >-->
                <li class="nav-item active">
                  <button type="button" class="btn btn-light" @click="logout">로그아웃</button>
                </li>
              </span>
            </ul>
          </form>
        </div>
      </nav>
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
      <nav id="router">
        <ul>
          <li class="routerlist">
            <router-link class="routerlink" :to="{ name:'List' }">목록</router-link>
          </li>
          <li class="routerlist">
            <router-link class="routerlink" :to="{ name:'MyPage' }">MyPage</router-link>
          </li>
          <li class="routerlist">
            <router-link class="routerlink" :to="{ name:'VisitCreate' }">방명록</router-link>
          </li>
        </ul>
      </nav>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
import Login from "@/views/user/Login.vue";
// import $ from 'jquery'

export default {
  name: "Header",
  components: {
    Login,
  },
  data() {
    return {
      searchInput: ''
    }
  },
  methods: {
    ...mapActions(["logout", "search"]),
  },
  computed: {
    ...mapGetters(["isLogIn"]),
  },
};
</script>

<style scoped>
.header {
  border-bottom: 1px solid #eee;
}
#router {
  margin: 0 0;
  height: 66px;
  overflow-x: auto;
  overflow-y: hidden;
}
.routerlist {
  list-style: none;
  float: left;
  padding: 0 26px;
}

.inner {
  position: relative;
  max-width: 1080px;
  margin: 0 auto;
}
#router ul {
  display: inline-block;
  margin-left: -730px;
  vertical-align: top;
  width: 400px;
  padding: 0;
  height: 66px;
}
#router ul li {
  height: 66px;
}

.fixec-top {
  padding: 23px 0;
}
.routerlink {
  color: #424242;
}
.router-link-exact-active {
  color: black;
  text-decoration-line: underline;
}
.navbarname {
  color: black;
  font-family: "Nanum Myeongjo";
  display: flex;
}
.navbarname:hover {
  animation: bounce;
  animation-duration: 1.5s;
}
</style>
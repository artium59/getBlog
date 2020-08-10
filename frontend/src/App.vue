<template>
  <div id="app">
    <v-app>
      <!-- 메인페이지 -->
      <div v-if="renderNum==0">
        <HeaderMain />
        <router-view />
      </div>
      <!-- 첫번째 폼 -->
      <div v-if="renderNum==1">
        <Header />
        <div class="container">
          <div class="row">
            <div class="col-9">
              <router-view />
            </div>
            <div class="col-3">
              <Aside />
            </div>
          </div>
        </div>
      </div>
    </v-app>
  </div>
</template>
<script src="https://cdnjs.cloudflare.com/ajax/libs/scrollmonitor/1.2.0/scrollMonitor.js"></script>
<script>
import Header from "@/components/common/Header.vue";
import HeaderMain from "@/components/common/HeaderMain.vue"
import Aside from "@/views/post/Aside.vue";
import Main from "@/views/home/Main.vue"

import { mapState } from 'vuex'
// import List from '@/views/post/List.vue'

export default {
  components: {
    Header,
    Aside,
    Main,
    HeaderMain,
  },
  computed: {
    ...mapState(['renderNum'])
  }
};
</script>
<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

/* #router {
  margin: 20px;
  height: 66px;
} */

/* ul {
  list-style: none;
  width: auto;
}

li {
  float: left;
  padding: 0 26px;
  width: auto;
  list-style: none;
} */
</style>

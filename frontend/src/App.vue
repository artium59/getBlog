<template>
  <div id="app">
      <!-- <Header /> -->
        <!-- <nav id="router">
          <ul>
            <li><router-link :to="{ name:'List' }">목록</router-link></li>
            <li><router-link :to="{ name:'MyPage' }">MyPage</router-link></li>
            <li><router-link :to="{ name:'VisitCreate' }">방명록</router-link></li>
          </ul>
        </nav> -->
    <!-- <div class="container">
      <div class="row">
        <div class="col-10"><router-view /> </div>
        <div class="col-2"><Aside /></div>
        
      </div> 
    </div> -->
    <router-view />
  </div>
</template>
<script>
  // import Header from '@/components/common/Header.vue'
  // import Aside from '@/views/post/Aside.vue'
  // import List from '@/views/post/List.vue'

  export default {
    components: {
      // Header,
      // Aside,
    },
  }
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

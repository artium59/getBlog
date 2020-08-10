<template>
  <div class="d-flex justify-content-between mt-4 mx-5">
    <router-link to="/" class="router-link"><img src="@/assets/로고.png" alt="" width="200px" ></router-link>
    <div v-if="!isLogIn">
      <router-link to="/user/login"><v-btn rounded color="#283593" outlined>로그인</v-btn></router-link>
    </div>
    <div  v-if="isLogIn">
      <v-btn rounded color="#283593" outlined @click="logout">로그아웃</v-btn> |
      <router-link to="/user/mypage"><v-btn rounded color="#283593" outlined>내 블로그 정보</v-btn></router-link>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
export default {
    name:'header',
    computed: {
    ...mapGetters(["isLogIn"]),
  },
    methods: {
    ...mapActions(["logout", "search"]),
    mounted() {
    this.$store.state.renderNum = 0
  }
  },
};
</script>

<style scoped>
.router-link {
  color:rgb(20, 2, 71);
}
</style>
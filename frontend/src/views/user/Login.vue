<template>
  <div class="container">
    <form class="mx-auto col-6">
      <div class="form-group">
        <label for="email">이메일</label>
        <input
          v-model="loginData.email"
          type="email"
          class="form-control"
          id="email"
          aria-describedby="emailHelp"
        />
      </div>
      <div class="form-group">
        <label for="password">비밀번호</label>
        <input v-model="loginData.password" type="password" class="form-control" id="password" />
      </div>
      <br />
      <button @click="login" type="button" class="btn btn--login btn-success">Submit</button>
    </form>
  </div>
</template>

<script>
// import constants from '../../lib/constants'
import axios from "axios";
import $ from 'jquery'
import 'bootstrap'

export default {
  data() {
    return {
      loginData: {
        email: null,
        password: null,
      },
    };
  },
  methods: {
    modalHide() {
        $('#exampleModal').modal('hide')
    },
    login() {
      axios
        .post(`${this.$store.state.HOST}/auth/login`, this.loginData)
        .then((res) => {
          console.log(res.data);
          this.$store.commit('setCookie', res.data.accessToken);
          $('#exampleModal').modal('hide');
          this.$router.go()
        })
        .catch((err) => {
          alert("이메일 및 비밀번호를 확인해주세요.")
          console.log(err.response.data.message);
        });
    },
  },
};
</script>

<style>
</style>
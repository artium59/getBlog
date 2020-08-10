<template>
  <div class="container">
    <div class="row">
      <div class="col">
        <h3>기본 정보</h3>
        <form class="wrap_set">
          <div class="form-group">
            <div v-if="imageUrl">
              <img :src="imageUrl" alt="" width="100px">
            </div>
            <div v-if="!imageUrl">
              <v-gravatar :email="email" />
            </div>
          </div>
          <div class="form-group">
            <label for="exampleFormControlInput1">이메일</label>
            <input type="email" class="form-control" id="exampleFormControlInput1" v-model="email" />
          </div>
          <div class="form-group">
            <label for="nickname">닉네임</label>
            <input
              type="text"
              class="form-control"
              id="exampleFormControlInput2"
              v-model="userData.nickname"
            />
          </div>
          <div class="form-group">
            <label for="exampleFormControlInput1">새 비밀번호</label>
            <input type="password" class="form-control" id="exampleFormControlInput1" v-model="userData.password" />
          </div>
          <div class="form-group">
            <label for="exampleFormControlTextarea1">소개</label>
            <textarea v-model="userData.introduce" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
          </div>
          <div class="row justify-content-around">
            <v-btn @click="editUserinfo" color="success">수정하기</v-btn>
            <v-btn @click="editUserinfo" color="error">탈퇴하기</v-btn>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
// import { mapState } from "vuex";
export default {
  data() {
    return {
      accessToken: this.$store.state.authToken,
      email: "",
      userData: {
        accessToken: this.$store.state.authToken,
        imageUrl: null,
        introduce: null,
        nickname: null,
        password: null
      }
    };
  },
  methods: {
    getUserinfo() {
      axios
        .get(`${this.$store.state.HOST}/account/userinfo`, {
          params: {
            accessToken: this.$store.state.authToken,
          },
        })
        .then((res) => {
          console.log(res.data);
          this.email = res.data.email;
          this.userData.nickname = res.data.nickname;
          this.userData.imageUrl = res.data.imageUrl
          this.userData.introduce = res.data.introduce
        })
        .catch((err) => {
          console.log(err);
        });
    },
    editUserinfo() {
      axios.put(`${this.$store.state.HOST}/account/modify`, this.userData)
      .then((res) => {
        location.reload()
        console.log(res)
      })
      .catch((err) => {
        console.log(err)
      })
    }
  },
  mounted() {
    this.getUserinfo();
  },
  // created() {
  //   this.getUserinfo();
  // },
  // computed: {
  //   ...mapState(['authToken'])
  // }
};
</script>

<style>
</style>
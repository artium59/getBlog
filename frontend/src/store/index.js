import Vue from 'vue'
import Vuex from 'vuex'

import VueCookies from 'vue-cookies'
import cookies from 'vue-cookies'

// import createPersistedState from 'vuex-persistedstate';
import http from '../util/http-common';

import router from '@/router'

import VueScrollMonitor from 'vue-scrollmonitor'

Vue.use(Vuex);
Vue.use(VueCookies)
Vue.use(VueScrollMonitor)

export default new Vuex.Store({
  // plugins: [
  //   createPersistedState()
  // ],
  state: {
    HOST: 'http://localhost:8080',
    authToken: cookies.get('auth-token'),
    posts: [],
    post: {},
    replies: [],
    reply: {},
    pnoArr: [], // 중복을 걸러주기 위한 pno array
    newPostsArr: [],
    // search
    searchPosts: [],
    searchFlag: false,
    // rendering
    renderNum: '0', // 0: main 1: form1, 2: form2, 3: form3
    // userinfo
    email: '',
    nickname: '',
    imageUrl: '',
    blogname: '',
  },
  getters: {
    // user
    isLogIn: state => !!state.authToken,
    // post
    posts(state){
        return state.posts;
    },
    post(state){
        return state.post;
    },
    replies(state){
      return state.replies;
    },
    reply(state){
      return state.reply;
    },
    newPosts(state){ // state.posts 를 돌면서 새로운 데이터(pnoArr로 판단)를 newPostsArr에 넣어 반환
      for (let post of state.posts) {
        if (state.pnoArr.includes(post.pno)) {
          console.log('중복데이터')
        } else {
          console.log('새로운데이터')
          state.pnoArr.push(post.pno)
          state.newPostsArr.push(post)
        } 
      }
      return state.newPostsArr
    },
  },
  mutations: {
    // user
    setCookie(state, payload) {
      state.authToken = payload
      Vue.$cookies.set('auth-token', payload)
    },
    // post
    setPOSTs(state, payload){
      if (state.searchFlag === true) {
        state.posts = [...payload]
      } else {
        state.posts = [...state.posts, ...payload];
      }
    },
    setPOST(state, payload){
        state.post = payload;
    },
    setREPLIES(state, payload){
      state.replies = payload;
    },
    setREPLY(state, payload){
        state.reply = payload;
    },
    // render
    setRenderNum(state, payload) {
      state.renderNum = payload
    },
    getUserinfo(state) {
      http
        .get(`/account/userinfo`, {
          params: {
            accessToken: this.$store.state.authToken,
          },
        })
        .then((res) => {
          console.log(res.data);
          state.email = res.data.email
          state.nickname = res.data.nickname
          state.imageUrl = res.data.imageUrl
        })
        .catch((err) => {
          console.log(err)
        })
    },
  },
  actions: {
    // user
    logout({commit}) {
      commit('setCookie', null)
      cookies.remove('auth-token')
      router.push({ name: 'Main' })
    },
    // post
    getPOSTs({ commit }) {
      const options = {
        params: {
          // _page: this.page++,
          _limit: 3,
        }
      }
      http
      .get(`/api/post/list`, options)
      .then(({ data }) => {
        console.log(data)
        commit('setPOSTs', data);
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
    },
    getPOST(context, payload) {
      http.get(payload).then(({ data }) => {
        context.commit('setPOST', data);
      });
    },
    getREPLIES(context) {
      http
      .get(`/api/reply/list`)
      .then(({ data }) => {
        context.commit('setREPLIES', data);
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
    },
    getREPLY(context, payload) {
      http.get(payload).then(({ data }) => {
        context.commit('setREPLY', data);
      });
    },
    search({ commit }, searchInput) {
      http.get(`api/post/search/${searchInput}`)
      .then((res) => {
        console.log(res.data)
        this.state.searchFlag = true
        this.state.newPostsArr = []
        this.state.posts = []
        this.state.pnoArr = []
        commit('setPOSTs', res.data)
      .catch((err) => {
        console.log(err)
      })
      })
    },
    moveToblog({ commit }, payload) {
      this.state.blogname = payload.name
      commit('setRenderNum', payload.selected)
      router.push({ name: 'List' })
    }
  },
  modules: {
  }
})

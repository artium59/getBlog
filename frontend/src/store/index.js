import Vue from 'vue'
import Vuex from 'vuex'

import VueCookies from 'vue-cookies'
import cookies from 'vue-cookies'

import createPersistedState from 'vuex-persistedstate';
import http from '../util/http-common';

import router from '@/router'

Vue.use(Vuex);
Vue.use(VueCookies)

export default new Vuex.Store({
  plugins: [
    createPersistedState()
  ],
  state: {
    HOST: 'http://localhost:8080',
    authToken: cookies.get('auth-token'),
    posts: [],
    post: {},
    replies: [],
    reply: {},
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
  },
  mutations: {
    // user
    setCookie(state, payload) {
      state.authToken = payload
      Vue.$cookies.set('auth-token', payload)
    },
    // post
    setPOSTs(state, payload){
      state.posts = payload;
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
  },
  actions: {
    // user
    logout({commit}) {
      commit('setCookie', null)
      cookies.remove('auth-token')
      router.push({ name: 'List' })
    },
    // post
    getPOSTs(context) {
      http
      .get(`/api/post/list`)
      .then(({ data }) => {
        context.commit('setPOSTs', data);
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
        console.log(res)
        commit('setPOSTs', res)
      .catch((err) => {
        console.log(err)
      })
      })
    }
  },
  modules: {
  }
})

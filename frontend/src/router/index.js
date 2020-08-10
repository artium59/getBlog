import Vue from 'vue'
import VueRouter from 'vue-router'

// import constants from '../lib/constants.js'
// home
import Main from '@/views/home/Main.vue'
import BlogCreate from '@/views/home/BlogCreate.vue'

// post
import List from '../views/post/List.vue'
import Read from '../views/post/Read.vue'
import Create from '../views/post/Create.vue'
import Update from '../views/post/Update.vue'
import Delete from '../views/post/Delete.vue'

// user
import Join from '@/views/user/Join.vue'
import Login from '@/views/user/Login.vue'
import MyPage from '@/views/user/MyPage.vue'
import VisitPage from '@/views/board/VisitPage.vue'
import VisitCreate from '@/views/board/VisitCreate.vue'

//err
import NotFoundPage from '@/views/err/NotFoundPage.vue'

import store from '@/store'

// hong place(template3)
// 1.home
import Home from '@/views/template3/home/Home.vue'
// +재완
// lsit2
import List2 from '@/views/post2/List2.vue'

Vue.use(VueRouter)


const routes = [
  // home
  {
    path:'/',
    name:'Main',
    component:Main
  },
  {
    path:'/blogcreate',
    name:'BlogCreate',
    component:BlogCreate
  },
  // user
  {
    path: '/user/join',
    name: 'Join',
    component: Join
  },
  {
    path: '/user/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/user/mypage',
    name: 'MyPage',
    component: MyPage
  },
  {
    path: '/visitPage',
    name: 'VisitPage',
    component: VisitPage
  },
  {
    path: '/visitCreate',
    name: 'VisitCreate',
    component: VisitCreate
  },
  // post
  {
    path: '/temp1',
    name: 'List',
    component: List
  },
  {
    path: '/create',
    name: 'Create',
    component: Create,
  },
  {
    path: '/read',
    name: 'Read',
    component: Read
  },
  {
    path: '/update',
    name: 'Update',
    component: Update,
  },
  {
    path: '/delete',
    name: 'Delete',
    component: Delete,
  },
  {
    path: '/oauth2/redirect',
    name: 'SNSLogin',
    redirect: (to) => {
      console.log(to.query.token);
      store.commit('setCookie', to.query.token);

      return {
        path: '/', query: null
      }
    }
  },
  // err
  {
    path: '*',
    name: 'NotFoundPage',
    component: NotFoundPage
  },
    // hong place(template3)
  // 1. home
  {
    path:'/temp3',
    name:'Home',
    component:Home
  },
  // 재완
  {
    path: '/temp2',
    name: 'List2',
    component: List2
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  const publicPages = ['Login', 'Join', 'List', 'Main']
  const authPages = ['Login', 'Join']

  const authRequired = !publicPages.includes(to.name)
  const unauthRequired = authPages.includes(to.name)
  const isLogin = !!Vue.$cookies.isKey('auth-token')

  if(unauthRequired && isLogin) {
    next('/') 
  }
  authRequired && !isLogin ? next({ name: 'Login' }) : next()
})

export default router

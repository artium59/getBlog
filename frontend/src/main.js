import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// Vuetify
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'

Vue.use(BootstrapVue);

Vue.use(Vuetify);

Vue.config.productionTip = false
Vue.prototype.$http = axios;

new Vue({
  router,
  // index,
  store,
  vuetify : new Vuetify(),
  render: h => h(App)
}).$mount('#app')

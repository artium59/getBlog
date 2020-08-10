import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import Vuetify from 'vuetify'
import Gravatar from 'vue-gravatar';
import 'vuetify/dist/vuetify.min.css'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
// import { index } from './store'

Vue.config.productionTip = false
Vue.prototype.$http = axios;
Vue.use(BootstrapVue)
Vue.use(Vuetify);
Vue.component('v-gravatar', Gravatar);
new Vue({
  vuetify : new Vuetify(),
  router,
  // index,
  store,
  render: h => h(App)
}).$mount('#app')

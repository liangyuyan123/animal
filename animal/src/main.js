// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

//iview
import iView from 'iview';
import 'iview/dist/styles/iview.css';

import { Modal,Message } from 'iview'
Vue.component('Modal', Modal)
Vue.component('Message', Message)

//axios
import VueAxios from 'vue-axios';
import axios from 'axios'
import api from './api/global.js'
// 将API方法绑定到全局
Vue.prototype.$api = api

//vuex
import Vuex from 'vuex'
Vue.use(Vuex)

Vue.config.productionTip = false

Vue.use(iView);
Vue.use(VueAxios,axios);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

import Vue from 'vue'
import VueRouter from 'vue-router'
import Vuetify from 'vuetify'

import 'vuetify/dist/vuetify.min.css'

import "scrollmagic/scrollmagic/uncompressed/plugins/animation.gsap";
import "scrollmagic/scrollmagic/uncompressed/plugins/debug.addIndicators";

import App from "./components/App.vue"
import { store } from "./store"

Vue.use(VueRouter);
Vue.use(Vuetify)


const vuetify = new Vuetify({})

const routes = [
  {path: "/", component: App}
]

const router = new VueRouter({
  mode:"history",
  routes
})

const app = new Vue({
  router,
  store,
  vuetify,
  components: {
    App
  }
}).$mount("#app");

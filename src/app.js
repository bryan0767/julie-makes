import Vue from 'vue'
import VueRouter from 'vue-router'
import 'vue-material/dist/vue-material.min.css'
import 'vue-material/dist/theme/default.css'

import "scrollmagic/scrollmagic/uncompressed/plugins/animation.gsap";
import "scrollmagic/scrollmagic/uncompressed/plugins/debug.addIndicators";

import App from "./components/App.vue"
import { store } from "./store"
import { MdDrawer, MdIcon } from "vue-material/dist/components"

Vue.use(VueRouter);
Vue.use(MdDrawer);
Vue.use(MdIcon);

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
  components: {
    App
  }
}).$mount("#app");

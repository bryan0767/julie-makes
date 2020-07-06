import Vue from 'vue'
import Vuex from "vuex"

Vue.use(Vuex)

import Scroll from "./scroll.js"
import Portfolio from "./portfolio.js"
import About from "./about.js"

export const store = new Vuex.Store({
  modules: {
    Scroll,
    Portfolio,
    About
  }
})

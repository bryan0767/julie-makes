import Vue from 'vue'
import Vuex from "vuex"

Vue.use(Vuex)

import Scroll from "./scroll.js"
import Portfolio from "./portfolio.js"
import About from "./about.js"
import Contact from "./contact.js"
import Home from "./home.js"

export const store = new Vuex.Store({
  modules: {
    Scroll,
    Portfolio,
    About,
    Contact,
    Home
  }
})

import Vue from 'vue'
import Vuex from "vuex"

Vue.use(Vuex)

import Scroll from "./scroll.js"

export const store = new Vuex.Store({
  modules: {
    Scroll
  }
})

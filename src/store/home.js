import ScrollMagic from "scrollmagic"

export default {
  namespaced:true,
  state: {
    showFab:false
  },
  mutations: {
    showFab(state, payload) {
      state.showFab = payload
    }
  },
  actions:{}
}

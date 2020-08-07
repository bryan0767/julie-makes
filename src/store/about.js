import ScrollMagic from "scrollmagic"

export default {
  namespaced:true,
  state: {
    mount: false,
    aboutOpen: false
  },
  mutations: {
    mount(state, value){
      state.mount = value
    },
    toggleOpen(state, value){
      state.aboutOpen = value
    }
  },
  actions:{}
}

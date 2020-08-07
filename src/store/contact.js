import ScrollMagic from "scrollmagic"

export default {
  namespaced:true,
  state: {
    mount: false,
    contactOpen: false
  },
  mutations: {
    mount(state, value){
      state.mount = value
    },
    toggleOpen(state, value){
      state.contactOpen = value
    }
  },
  actions:{}
}

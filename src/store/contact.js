import ScrollMagic from "scrollmagic"

export default {
  namespaced:true,
  state: {
    contactOpen: false
  },
  mutations: {
    toggleOpen(state, value){
      state.contactOpen = value
    }
  },
  actions:{}
}

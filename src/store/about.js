import ScrollMagic from "scrollmagic"

export default {
  namespaced:true,
  state: {
    aboutOpen: false
  },
  mutations: {
    toggleOpen(state, value){
      console.log(value, 'the mutation')
      state.aboutOpen = value
    }
  },
  actions:{}
}

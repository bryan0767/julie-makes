import ScrollMagic from "scrollmagic"

export default {
  namespaced:true,
  state: {
    first_name:"bryan",
    last_name:"atencia",
    main_controller: new ScrollMagic.Controller()
  },
  mutations: {
    addScene(state, data){
      data.addTo(state.main_controller)
    }
  },
  actions:{
    addScene({commit, dispatch}, data){
      commit('addScene', data)
    }
  }
}

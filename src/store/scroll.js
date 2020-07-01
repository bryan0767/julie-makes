import ScrollMagic from "scrollmagic"

export default {
  namespaced:true,
  state: {
    main_controller: new ScrollMagic.Controller(),
    position: 0,
    newPos: 0,
    lastPos: 0
  },
  mutations: {
    addScene(state, data){
      data.addTo(state.main_controller)
    },
    scrollDrawer(state, payload) {
      const { direction, value } = payload

        if(state.position + value < 0) {
          state.position = 0
        } else {
          state.position += value
        }

    },
    changePos(state, payload) {
      const { key, value } = payload
      state[ key ] = parseFloat(value.toFixed(1))
    }     
  },
  actions:{
    addScene({commit, dispatch}, data){
      commit('addScene', data)
    }
  }
}

import ScrollMagic from "scrollmagic"

export default {
  namespaced:true,
  state: {
    progress:0,
    main_controller: new ScrollMagic.Controller(),
    position: 0,
    aboutPosition: 0,
    contactPosition: 0,
    newPos: 0,
    lastPos: 0,
    root:"",
    aboutDrawer:"",
    contactDrawer:"",
    portfolioDrawer:""
  },
  mutations: {
    addScene(state, data){
      data.addTo(state.main_controller)
    },
    changePos(state, payload) {
      const { key, value } = payload
      state[ key ] = parseFloat(value.toFixed(1))
    },
    setElements(state, payload) {
      for( let x = 0;x < payload.length; x++ ) {
        state[payload[x]["key"]] = payload[x]['value']
      }
    },
    scrollDrawer(state, payload) {
      const { key, value } = payload

      if(state[ key ] + value < 0) state[ key ] = 0
      else state[ key ] += value

    },
    changeProgress(state, payload) {
      state['progress'] = payload
    }
  },
  actions:{
    addScene({ commit, dispatch }, data){
      commit('addScene', data)
    }
  }
}

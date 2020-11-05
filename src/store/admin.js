import ScrollMagic from "scrollmagic"

export default {
  namespaced:true,
  state: {
    data: {}
  },
  mutations: {
    setData(state, payload) {
      state['data'] = payload
    }
  },
  actions:{
    setData({ commit }, data) {
      return new Promise((resolve, reject) => {
        commit( 'setData', data )
        resolve("dope")
      });
    }
  }
}

import API from '../../api'

// initial state
// shape: [{ id, quantity }]
const state = {}

// getters
const getters = {}

// actions
const actions = {
  userLogin ({ commit }, userInfo) {
    return API.user.login(userInfo)
  },
  userSignUp ({ commit }, userInfo) {
    return API.user.signUp(userInfo)
  },
  updatePassword ({ commit }, fields) {
    return API.user.updatePassword(fields)
  }
}

// mutations
const mutations = {}

export default {
  state,
  getters,
  actions,
  mutations
}

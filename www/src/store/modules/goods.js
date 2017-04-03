import API from '../../api'

// initial state
// shape: [{ id, quantity }]
const state = {}

// getters
const getters = {}

// actions
const actions = {
  goodsSearch ({ commit }, conditions) {
    return API.goods.search(conditions)
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

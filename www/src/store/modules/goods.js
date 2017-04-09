import Router from 'vue-router'
// import API from '../../api'

const router = new Router()

// initial state
// shape: [{ id, quantity }]
const state = {}

// getters
const getters = {}

// actions
const actions = {
  goodsSearch ({ commit }, conditions) {
    conditions = JSON.stringify(conditions)
    router.push(`/search-result?q=${conditions}`)
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

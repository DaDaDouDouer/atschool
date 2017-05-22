import API from '../../api'

// initial state
// shape: [{ id, quantity }]
const state = {}

// getters
const getters = {}

// actions
const actions = {
  createOrder ({commit, state}, order) {
    return API.order.create(order).then((data) => {
      console.warn('orderCreate', data)
      return data
    })
  },
  getUserOrder ({commit, state}) {
    return API.order.getUserOrder().then((order) => {
      return order
    })
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

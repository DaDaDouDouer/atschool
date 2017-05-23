import API from '../../api'

// initial state
// shape: [{ id, quantity }]
const state = {}

// getters
const getters = {}

// actions
const actions = {
  getAllUserByAdmin ({commit, state}, conditions) {
    return API.admin.getAllUser(conditions).then(users => {
      return users
    })
  },
  deleteUserByAdmin ({commit, state}, id) {
    return API.admin.deleteUser({id}).then(data => {
      return data
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

import API from '../../api'

// initial state
// shape: [{ id, quantity }]
const state = {}

// getters
const getters = {}

// actions
const actions = {
  getUserByAdmin ({commit, state}, conditions) {
    return API.admin.getUser(conditions).then(({data, other}) => {
      return {userList: data, pageCount: other.pageAllCount}
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

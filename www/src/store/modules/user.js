import Router from 'vue-router'
import API from '../../api'

const router = new Router()

const roleMapToRouter = {
  Seller: '/seller',
  User: '/',
  Admin: '/admin'
}

// initial state
// shape: [{ id, quantity }]
const state = {}

// getters
const getters = {}

// actions
const actions = {
  userLogin ({ commit }, userInfo) {
    return API.user.login(userInfo).then((role) => {
      let path = roleMapToRouter[role]
      router.push(path)
    })
  },
  userSignUp ({ commit }, userInfo) {
    return API.user.signUp(userInfo).then((data) => {
      router.push(`/`)
    })
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

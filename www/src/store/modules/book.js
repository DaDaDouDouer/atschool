import API from '../../api'
import { BOOK } from '../mutation-types'

// initial state
// shape: [{ id, quantity }]
const state = {
  bookTypes: null
}

// getters
const getters = {}

// actions
const actions = {
  getAllTypes: ({ commit, state }) => {
    if (state.bookTypes === null) {
      API.book.getAllTypes().then(bookTypes => {
        commit(BOOK.GET_ALL_TYPES, bookTypes)
      }).catch(error => {
        throw error
      })
    } else {
      commit(BOOK.GET_ALL_TYPES)
    }
  }
}

// mutations
const mutations = {
  [BOOK.GET_ALL_TYPES] (state, bookTypes) {
    if (bookTypes) {
      state.bookTypes = bookTypes
    }
    return state.bookTypes
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}

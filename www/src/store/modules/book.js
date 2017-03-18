import API from '../../api'
import { BOOK } from '../mutation-types'

// initial state
// shape: [{ id, quantity }]
const state = {
  bookTypes: null,
  bookList: null
}

// getters
const getters = {}

// actions
const actions = {
  getAllBookTypes: ({ commit, state }) => {
    if (state.bookTypes === null) {
      return API.book.getAllTypes().then(bookTypes => {
        commit(BOOK.GET_ALL_TYPES, bookTypes)
        return bookTypes
      }).catch(error => {
        throw error
      })
    } else {
      commit(BOOK.GET_ALL_TYPES)
    }
  },
  getBookByTypes: ({ commit, state }, id) => {
    if (state.bookList == null) {
      return API.book.searchByTypes([{id}]).then(bookList => {
        commit(BOOK.SEARCH_BY_TYPES, bookList)
        return bookList
      })
    } else {
      commit(BOOK.SEARCH_BY_TYPES)
    }
  }
}

// mutations
const mutations = {
  [BOOK.GET_ALL_TYPES] (state, bookTypes) {
    if (bookTypes) {
      state.bookTypes = bookTypes
    }
  },
  [BOOK.SEARCH_BY_TYPES] (state, bookList) {
    if (bookList) {
      state.bookList = bookList
    }
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}

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
    // 缓存 bookTypes
    if (state.bookTypes === null) {
      return API.book.getBookTypes().then(bookTypes => {
        commit(BOOK.GET_ALL_TYPES, bookTypes)
        return bookTypes
      }).catch(error => {
        throw error
      })
    } else {
      commit(BOOK.GET_ALL_TYPES)
    }
  },
  getBooks: ({ commit, state }, conditions) => {
    return API.goods.search(conditions).then(bookList => {
      commit(BOOK.SEARCH_BY_TYPES, bookList)
      return bookList
    })
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

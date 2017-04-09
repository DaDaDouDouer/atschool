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
    let bookTypes = localStorage.getItem('bookTypes')
    if (bookTypes === null) {
      return API.book.getBookTypes().then(bookTypes => {
        // 缓存到localStorage中
        localStorage.setItem('bookTypes', JSON.stringify(bookTypes))

        commit(BOOK.GET_ALL_TYPES, bookTypes)
        return bookTypes
      }).catch(error => {
        throw error
      })
    } else {
      commit(BOOK.GET_ALL_TYPES, JSON.parse(bookTypes))
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

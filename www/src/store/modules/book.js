import API from '../../api'
import { BOOK } from '../mutation-types'

// initial state
// shape: [{ id, quantity }]
const state = {
  bookTypes: null,
  bookList: null,
  pageCount: null
}

// getters
const getters = {}

// actions
const actions = {
  getAllBookTypes: ({ commit, state }) => {
    let bookTypes = localStorage.getItem('bookTypes')
    if (bookTypes === null) {
      return API.book.getBookTypes().then(bookTypes => {
        // 删除无用元素
        let defaultTypeIndex = bookTypes.findIndex((bookType) => (bookType.id === 'default_type_base_id'))
        bookTypes.splice(defaultTypeIndex, 1)

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
    return API.goods.search(conditions).then(books => {
      commit(BOOK.SEARCH, books)
      return books.bookList
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
  [BOOK.SEARCH] (state, books) {
    state.bookList = books.bookList
    state.pageCount = books.pageCount
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}

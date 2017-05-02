import API from '../../api'
import { CART } from '../mutation-types'

// initial state
const state = {
  goodsList: []
}

// getters
const getters = {
  total (state) {
    return state.goodsList.reduce((sum, item) => {
      if (item.isSelected) {
        return sum + item.goodsCount * item.goods.price
      } else {
        return sum
      }
    }, 0)
  },
  isAllSelected (state) {
    return state.goodsList.every((item) => item.isSelected)
  }
}

// actions
const actions = {
  addCartItem ({ commit }, item) {
    commit(CART.ADD, item)
  },
  deleteCartItem ({ commit }, goodsId) {
    commit(CART.DELETE, goodsId)
  },
  toggleAllCartItemStatus ({ commit }, isAllSelected) {
    commit(CART.TOGGLE_ALL_STATUS, isAllSelected)
  },
  updateGoodsList ({ commit, state }) {
    return API.cart.updateAll(state.goodsList).then((goodsList) => {
      commit(CART.GET, goodsList)
    })
  },
  getGoodsList ({ commit, state }) {
    return API.cart.getAll().then(goodsList => {
      commit(CART.GET, goodsList)
      return goodsList
    })
  },
  createOrder ({commit, state}) {
    let goodsList = {}
    state.goodsList.forEach((item) => {
      if (item.isSelected) {
        goodsList[item.goodsId] = item.goodsCount
      }
    })

    return API.order.create(goodsList).then((data) => {
      console.warn('orderCreate', data)
    })
  }
}

// mutations
const mutations = {
  [CART.ADD] (state, item) {
    state.goodsList.push(item)
  },
  [CART.DELETE] (state, goodsId) {
    state.goodsList = state.goodsList.filter((item) => {
      return item.goodsId !== goodsId
    })
  },
  [CART.TOGGLE_ALL_STATUS] (state, isAllSelected) {
    state.goodsList = state.goodsList.map((item) => {
      item.isSelected = !isAllSelected
      return item
    })
  },
  [CART.GET] (state, goodsList) {
    if (goodsList) {
      state.goodsList = goodsList
    }
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}

import API from '../../api'

// initial state
// shape: [{ id, quantity }]
const state = {}

// getters
const getters = {}

// actions
const actions = {
  addShop ({ commit, state }, shopName) {
    return API.shop.add(shopName).then(data => {
      return data
    })
  },
  getShop ({ commit, state }) {
    return API.shop.get().then(data => {
      return data
    })
  },
  getIndex ({ commit, state }) {
    return API.shop.getIndex().then(data => {
      return data
    })
  },
  updateCarousel ({ commit, state }, carouselList) {
    return API.shop.updateCarousel(carouselList).then(data => {
      return data
    })
  },
  addRecommand ({ commit, state }, goodsId) {
    return API.shop.addRecommand(goodsId).then(data => {
      return data
    })
  },
  removeRecommand ({ commit, state }, goodsId) {
    return API.shop.removeRecommand(goodsId).then(data => {
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

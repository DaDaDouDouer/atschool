import Router from 'vue-router'
import API from '../../api'

const router = new Router()

// initial state
// shape: [{ id, quantity }]
const state = {}

// getters
const getters = {}

// actions
const actions = {
  goodsSearch ({ commit }, conditions) {
    conditions = JSON.stringify(conditions)
    router.push(`/search-result?q=${conditions}`)
  },
  getGoodsDetail ({ commit }, id) {
    return API.goods.getGoodsDetail(id).then(goodsDetail => {
      return goodsDetail
    })
  },
  redirectToGoodsDetail ({ commit }, id) {
    router.push(`/goods-detail?id=${id}`)
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

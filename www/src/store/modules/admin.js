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
  },
  getSellerByAdmin ({commit, state}, conditions) {
    return API.admin.getSeller(conditions).then(({data, other}) => {
      return {sellerList: data, pageCount: other.pageAllCount}
    })
  },
  deleteSellerByAdmin ({commit, state}, id) {
    return API.admin.deleteSeller({id}).then(data => {
      return data
    })
  },
  addSellerByAdmin ({commit, state}, seller) {
    return API.admin.addSeller(seller).then(data => {
      return data
    })
  },
  updateSellerPasswordByAdmin ({commit, state}, conditions) {
    return API.admin.updateSellerPassword(conditions).then(data => {
      return data
    })
  },
  getShopByAdmin ({commit, state}, conditions) {
    return API.admin.getShop(conditions).then(({data, other}) => {
      return {shopList: data, pageCount: other.pageAllCount}
    })
  },
  deleteShopByAdmin ({commit, state}, id) {
    return API.admin.deleteShop({id}).then(data => {
      return data
    })
  },
  getGoodsByAdmin ({commit, state}, conditions) {
    return API.admin.getGoods(conditions).then(({data, other}) => {
      return {goodsList: data, pageCount: other.pageAllCount}
    })
  },
  deleteGoodsByAdmin ({commit, state}, id) {
    return API.admin.deleteGoods({id}).then(data => {
      return data
    })
  },
  getOrderByAdmin ({commit, state}, conditions) {
    return API.admin.getOrder(conditions).then(({data, other}) => {
      return {orderList: data, pageCount: other.pageAllCount}
    })
  },
  deleteOrderByAdmin ({commit, state}, id) {
    return API.admin.deleteOrder({id}).then(data => {
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

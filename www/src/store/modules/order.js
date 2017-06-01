import API from '../../api'

// initial state
// shape: [{ id, quantity }]
const state = {}

// getters
const getters = {}

// actions
const actions = {
  createOrder ({commit, state}, order) {
    return API.order.create(order).then((data) => {
      console.warn('orderCreate', data)
      return data
    })
  },
  getUserOrder ({commit, state}, conditions) {
    return API.order.getUserOrder(conditions).then((order) => {
      return order
    })
  },
  getSellerOrder ({commit, state}, conditions) {
    return API.order.getSellerOrder(conditions).then(({data, other}) => {
      return {orderList: data, pageCount: other.pageAllCount}
    })
  },
  pay ({commit, state}, orderId) {
    return API.order.pay(orderId).then((data) => {
      console.warn('pay', data)
      location.reload()
      return data
    })
  },
  payAll ({commit, state}, orders) {
    return API.order.payAll(orders).then((data) => {
      console.warn('payAll', data)
      location.reload()
      return data
    })
  },
  confirmPayment ({commit, state}, orderId) {
    return API.order.confirmPayment(orderId).then((data) => {
      console.warn('confirmPayment', data)
      location.reload()
      return data
    })
  },
  delivery ({commit, state}, orderId) {
    return API.order.delivery(orderId).then((data) => {
      console.warn('delivery', data)
      location.reload()
      return data
    })
  },
  confirmReceipt ({commit, state}, orderId) {
    return API.order.confirmReceipt(orderId).then((data) => {
      console.warn('confirmReceipt', data)
      location.reload()
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

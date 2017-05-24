import http from '../utils/http'

// 生成一个新的订单
export const create = function (order) {
  return http.post('order/add.do', order)
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// 支付订单
export const pay = function (id) {
  return http.post('order/userPayed.do', {id})
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// 确认支付
export const confirmPayment = function (id) {
  return http.post('order/userPayedOk.do', {id})
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// 发货
export const delivery = function (id) {
  return http.post('order/sellerSended.do', {id})
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// 确认收货
export const confirmReceipt = function (id) {
  return http.post('order/userReceived.do', {id})
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// 获取用户的订单
export const getUserOrder = function (conditions) {
  return http.post('order/selectAllByUserId.do', conditions)
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response
    })
}

// 获取用户的订单
export const getSellerOrder = function (conditions) {
  return http.post('/order/selectAllBySellerId.do', conditions)
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response
    })
}

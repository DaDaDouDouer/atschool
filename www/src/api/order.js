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
export const pay = function (orderId) {
  return http.post('order/userPayed.do', orderId)
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// 确认支付
export const confirmPayment = function (orderId) {
  return http.post('order/userPayedOk.do', orderId)
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// 发货
export const delivery = function (orderId) {
  return http.post('order/sellerSended.do', orderId)
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// 确认收货
export const confirmReceipt = function (orderId) {
  return http.post('order/userReceived.do', orderId)
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// 获取用户的订单
export const getUserOrder = function () {
  return http.get('order/selectAllByUserId.do')
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// 获取用户的订单
export const getSellerOrder = function () {
  return http.get('/order/selectAllBySellerId.do')
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

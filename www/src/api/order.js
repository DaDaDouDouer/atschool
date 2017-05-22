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

// 获取用户的订单
export const getUserOrder = function (goodsList) {
  return http.get('order/selectAllByUserId.do')
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

import http from '../utils/http'

// 生成一个新的订单
export const create = function (goodsList) {
  return http.post('order/add.do', {'goodsIdAndCount': goodsList})
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

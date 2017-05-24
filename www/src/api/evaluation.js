import http from '../utils/http'

// 根据商品Id获取全部评论
export const getAll = function (conditions) {
  return http.post('evaluation/selectAllBySellerId.do', conditions)
    .then(function ({data}) {
      let response = data
      return response
    })
}

// 添加评论
export const add = function (evaluation) {
  return http.post('evaluation/add.do', evaluation)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

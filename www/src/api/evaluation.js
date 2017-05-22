import http from '../utils/http'

// 根据商品Id获取全部评论
export const getAll = function (goodsId) {
  return http.post('evaluation/selectAll.do', {goodsId})
    .then(function ({data}) {
      let response = data
      return response.data
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

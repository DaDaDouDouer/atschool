import http from '../utils/http'

// 每页数量限制
const limit = 20

export const search = function (keyword, pageNo) {
  return http.post('goods/search.do', {keyword, limit, pageNo})
    .then(function (response) {
      console.log(response)
    })
}

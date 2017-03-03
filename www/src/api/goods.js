import axios from 'axios'

// 每页数量限制
const pageLimit = 20

export const search = function (keyword, pageNo) {
  return axios.post('goods/search.do', {keyword, pageLimit, pageNo})
    .then(function (response) {
      console.log(response)
    })
}

import http from '../utils/http'

// 每页数量限制
// const limit = 20

export const search = function (conditions) {
  return http.post('goods/search.do', {...conditions, linkTable: 'tab_book'})
    .then(function ({data}) {
      let response = data

      return {
        bookList: response.data,
        pageCount: response.other.pageAllCount
      }
    })
}

export const getGoodsDetail = function (id) {
  return http.post('goods/getRealGoods.do', {id})
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

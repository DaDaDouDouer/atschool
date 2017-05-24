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

// 删除卖家商品
export const remove = function (id) {
  return http.post('goods/delete.do', {id})
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// 通过ISBN添加书籍
export const addGoodsByIsbn = function (fields) {
  return http.post('goods/addGoodsByIsbn.do', fields)
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
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

export const getGoodsBySeller = function (conditions) {
  return http.post('goods/searchBySellerId.do', conditions)
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response
    })
}

import http from '../utils/http'

export const selectAll = function () {
  return http.get('cartitem/selectAll.do')
    .then(function (response) {
      console.log(response)
    })
}

// {
// 	"goodsId":"3",
// 	"goodsCount":3
// }
export const add = function (goodsInfo) {
  return http.post('cartitem/add.do', goodsInfo)
    .then(function (response) {
      console.log(response)
    })
}

// id 购物车项的httpid
//
// goodsCount 要修改为的数量
//
// {
// 	"id":"bf1210b5-4bc1-4c32-853a-0257d0150bfd",
// 	"goodsCount":12
// }
export const updateGoodsCount = function (goodsInfo) {
  return http.post('cartitem/updateGoodsCount.do', goodsInfo)
    .then(function (response) {
      console.log(response)
    })
}


// id 商品项的id
//
// {
// 	"id":"bf1210b5-4bc1-4c32-853a-0257d0150bfd"
// }
export const deleteById = function (id) {
  return http.post('cartitem/deleteById.do', id)
    .then(function (response) {
      console.log(response)
    })
}

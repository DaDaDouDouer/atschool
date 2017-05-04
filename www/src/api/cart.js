import http from '../utils/http'

// {
//  'goodsId':'3',
//  'goodsCount':3
// }

export const add = function (cartItem) {
  return http.post('cartitem/add.do', cartItem)
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

export const getAll = function () {
  return http.get('cartitem/selectAll.do')
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// [
//   {
//   'goodsId':'1',
//   'goodsCount':12,
//   'isSelected':false
//   },{
//   'goodsId':'2',
//   'goodsCount':5,
//   'isSelected':true
//   }
// ]

export const updateAll = function (goodsList) {
  return http.post('cartitem/updateAll.do', goodsList)
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

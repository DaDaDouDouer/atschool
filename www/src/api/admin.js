import http from '../utils/http'

// 搜索普通用户
export const getAllUser = function (conditions) {
  return http.post('manager-user/search.do', conditions)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 删除普通用户
export const deleteUser = function (id) {
  return http.post('manager-user/delete.do', id)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 搜索卖家
export const getAllSeller = function (conditions) {
  return http.post('manager-seller/search.do', conditions)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 添加卖家
export const addSeller = function (seller) {
  return http.post('manager-seller/add.do', seller)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 删除卖家
export const deleteSeller = function (id) {
  return http.post('manager-seller/delete.do', id)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 修改卖家密码
export const updateSellerPassword = function (conditions) {
  return http.post('manager-seller/updatePassword.do', conditions)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 搜索商铺
export const getShop = function (id) {
  return http.post('manager-shop/search.do', id)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 删除商铺
export const deleteShop = function (conditions) {
  return http.post('manager-shop/delete.do', conditions)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 更改商铺名
export const updateShopName = function (conditions) {
  return http.post('manager-shop/updateName.do', conditions)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 获取商品
export const getGoods = function (conditions) {
  return http.post('manager-goods/search.do', conditions)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 删除商品
export const deleteGoods = function (id) {
  return http.post('manager-goods/delete.do', id)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 获取订单
export const getOrder = function (conditions) {
  return http.post('manager-order/search.do', conditions)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 删除订单
export const deleteOrder = function (id) {
  return http.post('manager-order/delete.do', id)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

import http from '../utils/http'

// 获取店铺信息，需要卖家登录
export const get = function () {
  return http.get('shop/getOwn.do')
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 通过卖家ID获取商铺信息
export const getBySellerId = function (sellerId) {
  return http.post('shop/getBySellerId.do', {sellerId})
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 获取首页信息
export const getIndex = function () {
  return http.post('shop/getBySellerId.do', {sellerId: '586c450b-1d91-48af-8e1b-a12b8edfe03c'})
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 更新轮播图
export const updateCarousel = function (carouselList) {
  return http.post('shop/updateCarousel.do', carouselList)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 新建商铺
export const add = function (name) {
  return http.post('shop/add.do', {name})
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 推荐书籍
export const addRecommand = function (id) {
  return http.post('shop/addRecommand.do', {id})
    .then(function ({data}) {
      let response = data
      alert(response.msg)
      return response.data
    })
}

// 取消推荐书籍
export const removeRecommand = function (id) {
  return http.post('shop/removeRecommand.do', {id})
    .then(function ({data}) {
      let response = data
      alert(response.msg)
      return response.data
    })
}

// 添加轮播图
export const addCarousel = function (carousel) {
  return http.post('shop/addCarousel.do', carousel)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

// 删除轮播图
export const removeCarousel = function (imgUrl) {
  return http.post('shop/removeCarousel.do', {imgUrl})
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

import http from '../utils/http'

// 获取店铺信息
export const get = function () {
  return http.get('shop/updateOwn.do')
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
      return response.data
    })
}

// 取消推荐书籍
export const removeRecommand = function (id) {
  return http.post('shop/removeRecommand.do', {id})
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

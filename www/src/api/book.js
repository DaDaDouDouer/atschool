import http from '../utils/http'

// 获取书的全部分类
export const getBookTypes = function () {
  return http.post('goods/type/selectByLinkTable.do', {'linkTable': 'tab_book'})
    .then(function ({data}) {
      let response = data
      if (typeof response.data.default_type_base !== 'undefined') {
        delete response.data.default_type_base
      }
      return response.data
    })
}

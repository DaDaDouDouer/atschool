import http from '../utils/http'

export const getAllTypes = function () {
  return http.get('book/type/selectAll.do')
    .then(function (response) {
      if (typeof response.data.default_book_type_base !== 'undefined') {
        delete response.data.default_book_type_base
      }
      return response.data
    })
}

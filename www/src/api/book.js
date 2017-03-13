import http from '../utils/http'

export const getAllTypes = function () {
  return http.get('book/type/selectAll.do')
    .then(function (response) {
      console.log(response)
    })
}

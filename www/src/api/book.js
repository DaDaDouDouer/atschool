import axios from 'axios'

export const getAllTypes = function () {
  return axios.get('book/type/selectAll.do')
    .then(function (response) {
      console.log(response)
    })
}

import http from '../utils/http'

// 图片上传
export const upload = function (formData) {
  return http.post('file/pic/upload.do', formData)
    .then(function ({data}) {
      let response = data
      return response.data
    })
}

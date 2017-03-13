import http from '../utils/http'

export const login = function (userInfo) {
  return http.post('auth/user/login.do', userInfo)
    .then(function (response) {
      console.log(response)
    })
}

export const signUp = function (userInfo) {
  return http.post('auth/user/register.do', userInfo)
    .then(function (response) {
      console.log(response)
    })
}

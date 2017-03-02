import axios from 'axios'

export const login = function (userInfo) {
  return axios.post('auth/user/login.do', userInfo)
    .then(function (response) {
      console.log(response)
    })
}

export const signUp = function (userInfo) {
  return axios.post('auth/user/register.do', userInfo)
    .then(function (response) {
      console.log(response)
    })
}

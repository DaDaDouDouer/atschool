import http from '../utils/http'

export const login = function (userInfo) {
  return http.post('auth/login.do', userInfo)
    .then(function ({data}) {
      console.log(data)
      return data.other
    })
}

export const signUp = function (userInfo) {
  return http.post('auth/user/register.do', userInfo)
    .then(function (response) {
      console.log(response)
      return null
    })
}

// 收货地址

export const getAllAddress = function () {
  return http.get('auth/user/register.do')
    .then(function (response) {
      console.log(response)
    })
}

export const addAddress = function (address) {
  return http.post('user/addAddress.do', {address})
    .then(function (response) {
      console.log(response)
    })
}

export const deleteAddress = function (id) {
  return http.post('user/deleteAddress.do', {id})
    .then(function (response) {
      console.log(response)
    })
}

// 更改账户密码

export const updatePassword = function (fields) {
  return http.post('user/updatePassword.do', fields)
    .then(function (response) {
      console.log(response)
    })
}

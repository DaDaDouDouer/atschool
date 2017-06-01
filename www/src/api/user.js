import http from '../utils/http'

export const login = function (userInfo) {
  return http.post('auth/login.do', userInfo)
    .then(function ({data}) {
      if (data.status !== 200) {
        alert('用户名或密码错误，请重新输入！')
      }
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

// 获取用户信息

export const getUserInfo = function () {
  return http.get('user/getUserInfoInMarketByUserId.do')
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

// 收货地址

export const addAddress = function (address) {
  return http.post('user/addAddress.do', {address})
    .then(function (response) {
      console.log(response)
      return null
    })
}

export const deleteAddress = function (id) {
  return http.post('user/deleteAddress.do', {id})
    .then(function (response) {
      console.log(response)
      return null
    })
}

// 更改账户密码

export const updatePassword = function (fields) {
  return http.post('user/updatePassword.do', fields)
    .then(function ({data}) {
      let response = data
      console.log(response)
      return response.data
    })
}

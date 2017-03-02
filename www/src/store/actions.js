import API from '../api'

export const login = ({ commit }, userInfo) => {
  return API.user.login(userInfo)
}

export const signUp = ({ commit }, userInfo) => {
  return API.user.signUp(userInfo)
}

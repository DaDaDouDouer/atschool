import API from '../api'

export const login = ({ commit }, userInfo) => {
  return API.user.login(userInfo)
}

export const signUp = ({ commit }, userInfo) => {
  return API.user.signUp(userInfo)
}

export const search = ({ commit }, {keyword, pageNo}) => {
  return API.goods.search(keyword, pageNo)
}

import Router from 'vue-router'

const router = new Router()

export default function (response) {
  response = JSON.parse(response)

  // 401用户未登录，重定向到登录界面
  if (response.status === 401) {
    router.push('login')
  }

  return response
}

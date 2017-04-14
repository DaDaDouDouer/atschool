import Router from 'vue-router'

const router = new Router()

export default function (data) {
  if (typeof data === 'string') {
    try {
      data = JSON.parse(data)
    } catch (e) { /* Ignore */
    }
  }

  // 401用户未登录，重定向到登录界面
  if (data.status === 401) {
    router.push('login')
    return
  }

  return {
    data: data.data,
    other: data.other
  }
}

import Vue from 'vue'
import Router from 'vue-router'
import Index from 'components/Index'
import Hello from 'components/Hello'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/hello',
      name: 'Hello',
      component: Hello
    }
  ]
})

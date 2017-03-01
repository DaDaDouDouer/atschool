import Vue from 'vue'
import Router from 'vue-router'
import Index from 'components/Index'
import Hello from 'components/Hello'
import Login from 'components/Login'
import SignUp from 'components/SignUp'
import Cart from 'components/Cart'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/sign-up',
      name: 'SignUp',
      component: SignUp
    },
    {
      path: '/cart',
      name: 'Cart',
      component: Cart
    },
    {
      path: '/hello',
      name: 'Hello',
      component: Hello
    }
  ]
})

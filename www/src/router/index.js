import Vue from 'vue'
import Router from 'vue-router'
import Index from 'components/Index'
import Hello from 'components/Hello'
import Login from 'components/Login'
import SignUp from 'components/SignUp'
import Cart from 'components/Cart'
import SearchResult from 'components/SearchResult'
import GoodsDetail from 'components/GoodsDetail'
import PersonalCenter from 'components/PersonalCenter'

const pages = {Index, Hello, Login, SignUp, Cart, SearchResult, GoodsDetail, PersonalCenter}

Vue.use(Router)

const routes = Object.keys(pages).map((pageName) => {
  let router = {
    name: pageName,
    component: pages[pageName]
  }

  // 大驼峰转连字符
  router.path = pageName === 'Index' ? '/'
  : pageName.replace(/([A-Z])/g, '-$1').replace(/^-/, '/').toLowerCase()

  return router
})

export default new Router({routes})

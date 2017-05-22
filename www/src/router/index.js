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
import ChangePassword from 'components/ChangePassword'
import ManageReceivingAddress from 'components/ManageReceivingAddress'
import MyOrder from 'components/MyOrder'
import Admin from 'components/Admin'
import Seller from 'components/Seller'
import UserManager from 'components/UserManager'
import SellerManager from 'components/SellerManager'
import UpdateSeller from 'components/UpdateSeller'
import AddSeller from 'components/AddSeller'
import ShopManager from 'components/ShopManager'
import GoodsManager from 'components/GoodsManager'
import OrderManager from 'components/OrderManager'

// const personalCenterChildern = {}
const pages = {Index, Hello, Login, SignUp, Cart, SearchResult, GoodsDetail, PersonalCenter, ChangePassword, ManageReceivingAddress, MyOrder, Admin, Seller, UserManager, SellerManager, UpdateSeller, AddSeller, ShopManager, GoodsManager, OrderManager}
// 配置嵌套子路由
const routerConfig = {
  PersonalCenter: [
    'ChangePassword',
    'ManageReceivingAddress',
    'MyOrder'
  ],
  Admin: [
    'UserManager',
    'SellerManager',
    'UpdateSeller',
    'AddSeller',
    'ShopManager',
    'GoodsManager',
    'OrderManager'
  ]
}

Vue.use(Router)

// 创建路由对象
function routerFactory (routerName, component) {
  let router = {
    name: routerName,
    component: component
  }

  // 大驼峰转连字符
  router.path = routerName === 'Index' ? '/'
  : routerName.replace(/([A-Z])/g, '-$1').replace(/^-/, '/').toLowerCase()

  return router
}

// TODO: 优化代码结构
function createRoutesByConfig () {
  let routes = null
  // 根据pages对象生成相应的router对象
  routes = Object.keys(pages).map((pageName) => {
    return routerFactory(pageName, pages[pageName])
  })

  // 根据配置文件，嵌套router对象
  Object.keys(routerConfig).forEach((routerName) => {
    // 查找有嵌套路由的路由对象
    let router = routes.find((router) => {
      return router.name === routerName
    })

    // 查找有嵌套路由需要嵌套的路由对象
    let routerChildren = routes.filter((router, index) => {
      return routerConfig[routerName].some((routerName) => {
        return router.name === routerName
      })
    })
    // 嵌套路由对象
    router.children = routerChildren
  })

  return routes
}

const routes = createRoutesByConfig()

export default new Router({routes})

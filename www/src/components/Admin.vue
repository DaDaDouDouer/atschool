<template>
  <div class="admin">
    <v-row>
      <v-col xs2>
        <div v-for="item in menu">
          <a :href="'#/' + item.path">
            <v-btn block dark large class="teal" >{{item.text}}</v-btn>
          </a>
        </div>
      </v-col>
      <v-col xs10>
        <router-view></router-view>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: 'admin',
  data () {
    return {
      menu: [{
        text: '用户管理',
        path: 'user-manager'
      }, {
        text: '商家管理',
        path: 'seller-manager'
      }, {
        text: '店铺管理',
        path: 'shop-manager'
      }, {
        text: '商品管理',
        path: 'goods-manager'
      }, {
        text: '订单管理',
        path: 'order-manager'
      }]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.admin {
  margin: 0 10px;
}
</style>

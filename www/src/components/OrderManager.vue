<template>
  <div class="order-manager">
    <v-card>
      <v-card-title>
        订单管理
        <v-spacer></v-spacer>
        <v-text-field
          append-icon="search"
          label="搜索"
          single-line
          hide-details
          v-model="conditions.keyword"
          @keyup.enter.native="getOrderList"
        ></v-text-field>
      </v-card-title>
      <table class="table">
        <thead>
          <tr>
            <th v-for="header in headers">
              {{header.text}}
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in orderList">
            <td class="text-xs-center">{{ item.userName }}</td>
            <td class="text-xs-center">{{ item.sellerName }}</td>
            <td class="text-xs-center">{{ new Date(item.createTime).toLocaleDateString() }}</td>
            <td class="text-xs-center">￥{{ item.totalPrice.toFixed(2) }}</td>
            <td class="text-xs-center">{{ item.address }}</td>
            <td class="text-xs-center">
              <table>
                <thead>
                  <tr>
                    <th>商品名</th>
                    <th>数量</th>
                    <th>价格</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="goodsItem in item.orderItems">
                    <td>{{goodsItem.goods.name}}</td>
                    <td>{{goodsItem.goodsCount}}</td>
                    <td>{{goodsItem.goods.price}}</td>
                  </tr>
                </tbody>
              </table>
            </td>
            <td class="text-xs-center">
              <v-btn small primary dark slot="activator" @click.native="remove(item.id)">删除</v-btn>
            </td>
          </tr>
        </tbody>
      </table>
      <div class="text-xs-center">
        <v-pagination :length.number="pageCount" v-model="conditions.pageNo"></v-pagination>
      </div>
    </v-card>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'order-manager',
  mounted () {
    this.getOrderList()
  },
  data () {
    return {
      headers: [{
        text: '买家名'
      }, {
        text: '卖家名'
      }, {
        text: '创建时间'
      }, {
        text: '总价'
      }, {
        text: '收货地址'
      }, {
        text: '订单详情'
      }, {
        text: '操作'
      }],
      orderList: [],
      conditions: {
        keyword: '',
        pageNo: 1,
        limit: 20
      },
      pageCount: 0
    }
  },
  methods: {
    ...mapActions([
      'getOrderByAdmin',
      'deleteOrderByAdmin'
    ]),
    getOrderList () {
      return this.getOrderByAdmin(this.conditions).then(({orderList, pageCount}) => {
        this.orderList = orderList
        this.pageCount = pageCount
      })
    },
    remove (id) {
      this.deleteOrderByAdmin(id).then(data => {
        alert('删除订单成功！')
        return this.getOrderList()
      })
    }
  },
  watch: {
    'conditions.pageNo': function (val, oldVal) {
      this.getOrderList()
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.order-manager tr th {
  text-align: center!important;
}
</style>

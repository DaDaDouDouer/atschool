<template>
  <div class="my-orderList">
    <h4>我的订单</h4>
    <v-divider/>
    <div class="order-item" v-for="order in orderList">
      <v-card>
        <v-card-row>
          <v-card-title>
            <v-col xs4>
              卖家名：{{order.sellerName}}
            </v-col>
            <v-col xs8>
              订单号：<span style="font-size: 10px">{{order.id}}</span>
            </v-col>
          </v-card-title>
        </v-card-row>
        <v-divider/>
        <v-card-text>
          <v-card-row>
            <v-col xs2 class="text-center">
              商品
            </v-col>
            <v-col xs2 class="text-center">
              数量
            </v-col>
            <v-col xs2 class="text-center">
              价格
            </v-col>
            <v-col xs2 class="text-center">
              总价
            </v-col>
            <v-col xs2 class="text-center">
              状态
            </v-col>
          </v-card-row>
        </v-card-text>
        <v-divider/>
        <v-card-text v-for="(orderItem, index) in order.orderItems">
          <v-card-row>
            <v-col xs2 class="text-center">
              <img :src="orderItem.goods.imgUrl" :alt="orderItem.goods.name" class="cover">
              <p class="text-center">{{orderItem.goods.name}}</p>
            </v-col>
            <v-col xs2 class="text-center">
              {{orderItem.goodsCount}}
            </v-col>
            <v-col xs2 class="text-center">
              {{orderItem.goods.price}}
            </v-col>
            <v-col xs2 class="text-center">
              {{(orderItem.goods.price * orderItem.goodsCount).toFixed(2)}}
            </v-col>
            <v-col xs2 class="text-center">
              {{orderStatusCodeToText[orderItem.status]}}
            </v-col>
            <v-col xs2 class="text-center" v-if="orderItem.status === 1004">
              <v-btn small primary dark>添加评论</v-btn>
            </v-col>
          </v-card-row>
          <v-divider v-if="order.orderItems.length - index > 1" />
        </v-card-text>
        <v-divider/>
        <v-card-row>
          <v-col xs3 offset-xs1>
            总计：{{order.totalPrice}}元
          </v-col>
          <v-col xs8>
            购买时间：{{order.createTime}}
          </v-col>
        </v-card-row>
        <v-divider/>
        <v-card-row>
          <v-col xs11 offset-xs1>
            收货地址：{{order.address}}
          </v-col>
        </v-card-row>
      </v-card>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import orderStatusCodeToText from '../utils/orderStatusCodeToText'

export default {
  name: 'my-orderList',
  mounted () {
    this.getUserOrder().then((orderList) => {
      this.orderList = orderList
      console.log(orderList)
    })
  },
  data () {
    return {
      orderStatusCodeToText,
      orderList: []
    }
  },
  methods: {
    ...mapActions([
      'getUserOrder'
    ]),
    getOrders () {

    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.my-orderList {
  margin-bottom: 100px;
}

.order-item {
  margin-top: 20px;
}

.cover {
  width: 100px;
  height: 100%;
}
</style>

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
              <v-dialog v-model="orderItem.isShowDialog">
                <v-btn small primary dark slot="activator">添加评论</v-btn>
                <v-card>
                  <v-card-row>
                    <v-card-title>添加评论</v-card-title>
                  </v-card-row>
                  <v-card-row>
                    <v-card-text>
                      <v-container fluid>
                        <v-text-field label="评论内容" v-model="evaluation.content" required />
                      </v-container>
                    </v-card-text>
                  </v-card-row>
                  <v-card-row actions>
                    <v-btn class="blue--text darken-1" flat @click.native="orderItem.isShowDialog = false">取消</v-btn>
                    <v-btn class="blue--text darken-1" flat @click.native="(orderItem.isShowDialog = false) || add(orderItem.goodsId)">确认</v-btn>
                  </v-card-row>
                </v-card>
              </v-dialog>
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
      orderList.forEach(order => {
        order.orderItems = order.orderItems.map(orderItem => {
          orderItem.isShowDialog = false
          return orderItem
        })
      })

      this.orderList = orderList
    })
  },
  data () {
    return {
      isShowDialog: false,
      orderStatusCodeToText,
      orderList: [],
      evaluation: {
        goodsId: '',
        content: ''
      }
    }
  },
  methods: {
    ...mapActions([
      'getUserOrder',
      'addEvaluation'
    ]),
    add (goodsId) {
      this.evaluation.goodsId = goodsId
      this.addEvaluation(this.evaluation)
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

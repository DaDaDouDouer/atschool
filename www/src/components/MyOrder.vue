<template>
  <div class="my-orderList">
    my-orderList
    <div class="order-item" v-for="order in orderList">
      <v-card horizontal>
        <v-card-row>
          {{order.id}}
        </v-card-row>
        <v-card-row v-for="orderItem in order.orderItems">
          <img :src="orderItem.goods.imgUrl" :alt="orderItem.goods.name">
          {{orderItem.goods.name}}
          {{orderItem.goodsCount}}
        </v-card-row>
      </v-card>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

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

</style>

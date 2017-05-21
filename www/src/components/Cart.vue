<template>
<v-container class="cart">
  <table class="table">
    <thead>
      <tr>
        <th>
          <v-icon class="blue--text text--darken-2 pointer" @click.native="toggleAllCartItemStatus(isAllSelected)">
            {{isAllSelected ? "check_box" : "check_box_outline_blank"}}
          </v-icon>
        </th>
        <th v-for="header in headers" v-text="header"></th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="item in goodsList">
        <td>
          <v-icon class="blue--text text--darken-2 pointer" @click.native="item.isSelected = !item.isSelected">
            {{item.isSelected ? "check_box" : "check_box_outline_blank"}}
          </v-icon>
        </td>
        <td>
          <v-row>
            <v-col xs12>
              <img :src="item.goods.imgUrl" :alt="item.goods.name" style="width: 100px">
            </v-col>
            <v-col xs12>
              {{item.goods.name}}
            </v-col>
          </v-row>
        </td>
        <td>{{item.goods.price}}</td>
        <td>
          <v-icon large class="blue--text text--darken-2 pointer" @click.native="(item.goodsCount < item.goods.count) && (item.goodsCount++)">add</v-icon>
          <span style="line-height: 49px;">{{item.goodsCount}}</span>
          <v-icon large class="blue--text text--darken-2 pointer" @click.native="item.goodsCount && item.goodsCount--">remove</v-icon>
        </td>
        <td>{{(item.goods.price * item.goodsCount).toFixed(2)}}</td>
        <td>
          <v-btn small primary dark @click.native="deleteCartItem(item.goodsId)">删除</v-btn>
        </td>
      </tr>
    </tbody>
  </table>
  <div style="float: right; margin-top: 20px;">
    <p>总计： ￥{{total}}</p>
    <v-btn primary dark @click.native="submitGoodsList">支付</v-btn>
  </div>
</v-container>
</template>

<script>
import { mapState, mapActions, mapGetters } from 'vuex'

export default {
  name: 'cart',
  mounted () {
    // 获取商品列表
    this.getGoodsList()
  },
  data () {
    return {
      headers: [
        '商品信息',
        '单价',
        '数量',
        '金额',
        '操作'
      ]
    }
  },
  computed: {
    ...mapState({
      goodsList (state) {
        return state.cart.goodsList
      }
    }),
    ...mapGetters([
      'total',
      'isAllSelected'
    ])
  },
  methods: {...mapActions([
    'getGoodsList',
    'toggleAllCartItemStatus',
    'deleteCartItem',
    'updateGoodsList',
    'submitGoodsList'
  ])},
  watch: {
    goodsList: {
      handler: function (val, oldVal) {
        this.updateGoodsList(val)
      },
      deep: true
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.cart th, .cart td {
  text-align: center;
  padding: 10px;
}

.pointer {
  cursor: pointer;
}
</style>

<template>
  <div class="goods-manager">
    <v-card>
      <v-card-title>
        商品管理
        <v-spacer></v-spacer>
        <v-text-field
          append-icon="search"
          label="搜索"
          single-line
          hide-details
          v-model="conditions.keyword"
          @keyup.enter.native="getGoodsList"
        ></v-text-field>
      </v-card-title>
      <v-data-table
          :headers="headers"
          v-model="goodsList"
          hide-actions
          no-data-text="没有数据"
        >
        <template slot="items" scope="props">
          <td class="text-xs-center">{{ props.item.userName }}</td>
          <td class="text-xs-center">{{ props.item.sellerName }}</td>
          <td class="text-xs-center">{{ new Date(props.item.createTime).toLocaleDateString() }}</td>
          <td class="text-xs-center">￥{{ props.item.totalPrice.toFixed(2) }}</td>
          <td class="text-xs-center">{{ props.item.address }}</td>
          <td class="text-xs-center">
            <v-btn small primary dark slot="activator" @click.native="remove(props.item.id)">删除</v-btn>
          </td>
        </template>
      </v-data-table>
      <div class="text-xs-center">
        <v-pagination :length.number="pageCount" v-model="conditions.pageNo"></v-pagination>
      </div>
    </v-card>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'goods-manager',
  mounted () {
    this.getGoodsList()
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
        text: '操作'
      }],
      goodsList: [],
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
      'getGoodsByAdmin',
      'deleteGoodsByAdmin'
    ]),
    getGoodsList () {
      return this.getGoodsByAdmin(this.conditions).then(({goodsList, pageCount}) => {
        this.goodsList = goodsList
        this.pageCount = pageCount
      })
    },
    remove (id) {
      this.deleteGoodsByAdmin(id).then(data => {
        alert('删除普通用户成功！')
        return this.getGoodsList()
      })
    }
  },
  watch: {
    'conditions.pageNo': function (val, oldVal) {
      this.getGoodsList()
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.goods-manager tr th {
  text-align: center!important;
}
</style>

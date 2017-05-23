<template>
  <div class="seller-goods">
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
          <td class="text-xs-center">{{ props.item.name }}</td>
          <td class="text-xs-center">{{ props.item.count }}</td>
          <td class="text-xs-center">￥{{ props.item.price.toFixed(2) }}</td>
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
  name: 'seller-goods',
  mounted () {
    this.getGoodsList()
  },
  data () {
    return {
      headers: [{
        text: '书名'
      }, {
        text: '单价'
      }, {
        text: '数量'
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
      'getGoodsBySeller',
      'deleteGoodsByAdmin'
    ]),
    getGoodsList () {
      return this.getGoodsBySeller(this.conditions).then(({goodsList, pageCount}) => {
        this.goodsList = goodsList
        this.pageCount = pageCount
      })
    },
    remove (id) {
      this.deleteGoodsByAdmin(id).then(data => {
        alert('删除商品成功！')
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
.seller-goods tr th {
  text-align: center!important;
}
</style>

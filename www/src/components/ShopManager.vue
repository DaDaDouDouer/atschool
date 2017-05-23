<template>
  <div class="shop-manager">
    <v-card>
      <v-card-title>
        商铺管理
        <v-spacer></v-spacer>
        <v-text-field
          append-icon="search"
          label="搜索"
          single-line
          hide-details
          v-model="conditions.keyword"
          @keyup.enter.native="getShopList"
        ></v-text-field>
      </v-card-title>
      <v-data-table
          :headers="headers"
          v-model="shopList"
          hide-actions
          no-data-text="没有数据"
        >
        <template slot="items" scope="props">
          <td class="text-xs-center">{{ props.item.name }}</td>
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
  name: 'shop-manager',
  mounted () {
    this.getShopList()
  },
  data () {
    return {
      headers: [{
        text: '商铺名'
      }, {
        text: '操作'
      }],
      shopList: [],
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
      'getShopByAdmin',
      'deleteShopByAdmin'
    ]),
    getShopList () {
      return this.getShopByAdmin(this.conditions).then(({shopList, pageCount}) => {
        this.shopList = shopList
        this.pageCount = pageCount
      })
    },
    remove (id) {
      this.deleteShopByAdmin(id).then(data => {
        alert('删除商铺成功！')
        return this.getShopList()
      })
    }
  },
  watch: {
    'conditions.pageNo': function (val, oldVal) {
      this.getShopList()
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.shop-manager tr th {
  text-align: center!important;
}
</style>

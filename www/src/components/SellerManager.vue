<template>
  <div class="seller-manager">
    <v-card>
      <v-card-title>
        卖家管理
        <v-spacer></v-spacer>
        <v-text-field
          append-icon="search"
          label="搜索"
          single-line
          hide-details
          v-model="conditions.keyword"
          @keyup.enter.native="getSellerList"
        ></v-text-field>
      </v-card-title>
      <v-data-table
          :headers="headers"
          v-model="sellerList"
          hide-actions
          no-data-text="没有数据"
        >
        <template slot="items" scope="props">
          <td class="text-xs-center">{{ props.item.username }}</td>
          <td class="text-xs-center">{{ new Date(props.item.createTime).toLocaleDateString() }}</td>
          <td class="text-xs-center">
            <v-btn small primary dark slot="activator" @click.native="remove(props.item.id)">删除</v-btn>
            <a :href="'#/update-seller?id=' + props.item.id">
              <v-btn small primary dark slot="activator" >修改</v-btn>
            </a>
            <a href="#/add-seller">
              <v-btn small primary dark slot="activator" >添加</v-btn>
            </a>
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
  name: 'seller-manager',
  mounted () {
    this.getSellerList()
  },
  data () {
    return {
      headers: [{
        text: '用户名'
      }, {
        text: '创建时间'
      }, {
        text: '操作'
      }],
      sellerList: [],
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
      'getSellerByAdmin',
      'deleteSellerByAdmin'
    ]),
    getSellerList () {
      return this.getSellerByAdmin(this.conditions).then(({sellerList, pageCount}) => {
        this.sellerList = sellerList
        this.pageCount = pageCount
      })
    },
    remove (id) {
      this.deleteSellerByAdmin(id).then(data => {
        alert('删除卖家成功！')
        return this.getSellerList()
      })
    }
  },
  watch: {
    'conditions.pageNo': function (val, oldVal) {
      this.getSellerList()
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.seller-manager tr th {
  text-align: center!important;
}
</style>

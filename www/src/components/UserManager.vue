<template>
  <div class="user-manager">
    <v-card>
      <v-card-title>
        用户管理
        <v-spacer></v-spacer>
        <v-text-field
          append-icon="search"
          label="搜索"
          single-line
          hide-details
          v-model="conditions.keyword"
          @keyup.enter.native="getUserList"
        ></v-text-field>
      </v-card-title>
      <v-data-table
          :headers="headers"
          v-model="userList"
          hide-actions
          no-data-text="没有数据"
        >
        <template slot="items" scope="props">
          <td class="text-xs-center">{{ props.item.username }}</td>
          <td class="text-xs-center">{{ new Date(props.item.createTime).toLocaleDateString() }}</td>
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
  name: 'user-manager',
  mounted () {
    this.getUserList()
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
      userList: [],
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
      'getUserByAdmin',
      'deleteUserByAdmin'
    ]),
    getUserList () {
      return this.getUserByAdmin(this.conditions).then(({userList, pageCount}) => {
        this.userList = userList
        this.pageCount = pageCount
      })
    },
    remove (id) {
      this.deleteUserByAdmin(id).then(data => {
        alert('删除普通用户成功！')
        return this.getUserList()
      })
    }
  },
  watch: {
    'conditions.pageNo': function (val, oldVal) {
      this.getUserList()
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.user-manager tr th {
  text-align: center!important;
}
</style>

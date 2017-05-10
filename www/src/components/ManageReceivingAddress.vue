<template>
  <div class='manage-receiving-address'>
    <v-dialog v-model='isVisibility'>
      <v-btn primary dark slot='activator'>添加收货地址</v-btn>
      <v-card>
        <v-card-row>
          <v-card-title>添加收货地址</v-card-title>
        </v-card-row>
        <v-card-row>
          <v-card-text>
            <v-container fluid>
              <v-text-field label='收货地址' v-model="address" />
            </v-container>
          </v-card-text>
        </v-card-row>
        <v-card-row actions>
          <v-btn class='blue--text darken-1' flat @click.native='isVisibility = false'>取消</v-btn>
          <v-btn class='blue--text darken-1' flat @click.native='submit'>添加</v-btn>
        </v-card-row>
      </v-card>
    </v-dialog>
    <v-data-table
        :headers='headers'
        v-model='addressList'
        hide-actions
        class='elevation-1'
      >
      <template slot='items' scope='props'>
        <td>{{ props.item.address }}</td>
        <td><v-btn small primary dark @click.native='deleteById(props.item.id)'>删除</v-btn></td>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'manage-receiving-address',
  mounted () {
    this.getReceivingAddress()
  },
  data () {
    return {
      headers: [{
        text: '地址'
      }, {
        text: '操作'
      }],
      addressList: [],
      isVisibility: false,
      address: ''
    }
  },
  methods: {
    ...mapActions([
      'getUserInfo',
      'addAddress',
      'deleteAddress'
    ]),
    getReceivingAddress () {
      this.getUserInfo().then((userInfo) => {
        this.addressList = userInfo.deliveryAddresses
      })
    },
    submit () {
      if (!this.address) {
        return
      }

      this.addAddress(this.address).then((data) => {
        this.isVisibility = false
        this.getReceivingAddress()
      })
    },
    deleteById (id) {
      this.deleteAddress(id).then((data) => {
        this.getReceivingAddress()
      })
    }
  }
}
</script>

<!-- Add 'scoped' attribute to limit CSS to this component only -->
<style>
.manage-receiving-address th, .manage-receiving-address td{
  text-align: center!important;
}
</style>

<template>
  <div class="personal-center">
    <v-row>
      <v-col xs3>
        <div v-for="button in buttonGroup">
          <a :href="'#/' + button.path">
            <v-btn block dark large class="teal" >{{button.name}}</v-btn>
          </a>
        </div>
      </v-col>
      <v-col xs9>
        <router-view></router-view>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: 'personal-center',
  data () {
    return {
      buttonGroup: [{
        name: '我的订单',
        path: 'my-order'
      }, {
        name: '管理收货地址',
        path: 'manage-receiving-address'
      }, {
        name: '修改密码',
        path: 'change-password'
      }]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

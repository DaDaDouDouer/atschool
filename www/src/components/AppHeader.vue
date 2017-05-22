<template>
  <v-toolbar-items style="width: 100%;">
    <v-toolbar-item style="margin-right: 70%;">
      <router-link to="/" class="link">二手交易平台</router-link>
    </v-toolbar-item>
    <v-toolbar-item>
      <router-link to="/login" class="link">登录</router-link>
    </v-toolbar-item>
    <v-toolbar-item>
      <router-link to="/sign-up" class="link">注册</router-link>
    </v-toolbar-item>
    <v-toolbar-item>
      <router-link to="/my-order" class="link">个人中心</router-link>
    </v-toolbar-item>
    <v-toolbar-item>
      <router-link to="/cart" class="link">购物车</router-link>
    </v-toolbar-item>
  </v-toolbar-items>
</template>

<script>
export default {
  name: 'app-header',
  data () {
    return {
      header: 'header'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.link {
  color: #fff;
  text-decoration: none;
}
</style>

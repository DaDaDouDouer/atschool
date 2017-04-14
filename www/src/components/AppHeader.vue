<template>
  <v-toolbar-items>
    <v-toolbar-item>
      <router-link to="/personal-center" class="link">个人中心</router-link>
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

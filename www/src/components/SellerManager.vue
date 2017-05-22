<template>
  <v-container class="seller-manager">
    seller-manager
  </v-container>
</template>

<script>

export default {
  name: 'seller-manager',
  data () {
    return {
      headers: {
        name: '卖家名'
      },
      sellerList: [{
        name: '123123',
        isShowDialog: false
      }, {
        name: '345345',
        isShowDialog: false
      }]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

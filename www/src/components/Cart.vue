<template>
<div class="cart">
  <table>
    <thead>
      <tr>
        <th><v-checkbox v-bind:id="'checkbox' + index" filled class="text-xs-center" label="全选"></v-checkbox></th>
        <th v-for="header in headers" v-text="header"></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td v-for="goods in goodsList">
          <v-checkbox v-bind:id="'checkbox' + index" filled class="text-xs-center"></v-checkbox>
        </td>
        <td>{goods}</td>
        <td>
          <v-btn icon="icon">
            <v-icon>edit</v-icon>
          </v-btn>
        </td>
      </tr>
    </tbody>
  </table>
</div>
</template>

<script>
export default {
  name: 'cart',
  data () {
    return {
      headers: [
        '商品信息',
        '单价',
        '数量',
        '金额',
        '操作'
      ],
      goodsList: [1, 2, 3, 4]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

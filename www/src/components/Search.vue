<template>
<div class="search">
  <v-text-input id="test3" name="test3" placeholder="搜索" v-model="searchInfo.keyword"></v-text-input>
  <v-btn v-bind:loading="loading3" @click.native="search" class="blue-grey white--text">
    搜索
    <v-icon right>cloud_upload</v-icon>
  </v-btn>
</div>
</template>

<script>
export default {
  name: 'search',
  data () {
    return {
      searchInfo: {
        keyword: '',
        pageNo: ''
      }
    }
  },
  methods: {
    search () {
      this.$store.dispatch('goodsSearch', this.searchInfo)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

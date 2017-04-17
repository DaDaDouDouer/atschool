<template>
<div class="search">
  <v-row>
    <v-col xs5 offset-xs3>
      <v-text-field id="test3" name="test3" placeholder="搜索" class="input-group--focused" v-model="conditions.keyword"></v-text-field>
    </v-col>
    <v-col xs1 mt-1>
      <v-btn v-bind:loading="loading3" @click.native="search" class="green white--text">
        搜索
        <v-icon right>search</v-icon>
      </v-btn>
    </v-col>
  </v-row>
</div>
</template>

<script>
export default {
  name: 'search',
  data () {
    return {
      conditions: {
        keyword: '',
        pageNo: ''
      }
    }
  },
  methods: {
    search () {
      this.$store.dispatch('goodsSearch', this.conditions)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

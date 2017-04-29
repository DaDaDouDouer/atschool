<template>
<div class="search">
  <v-row>
    <v-col xs5 offset-xs3>
      <v-text-field id="test3" name="test3" placeholder="搜索" class="input-group--focused" v-model="conditions.keyword"></v-text-field>
    </v-col>
    <v-col xs1 mt-1>
      <v-btn @click.native="search" class="green white--text">
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
  props: ['keyword'],
  data () {
    return {
      conditions: {
        keyword: this.keyword || ''
      }
    }
  },
  methods: {
    search () {
      localStorage.setItem('keyword', this.conditions.keyword)
      this.$store.dispatch('goodsSearch', this.conditions)
    }
  },
  watch: {
    conditions: {
      handler: function (val, oldVal) {
        this.$emit('keywordChange', val.keyword)
      },
      deep: true
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

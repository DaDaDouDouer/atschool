<template>
  <div class="search-result">
    <div v-if="bookList && bookList.length > -1">
      {{ bookList }}
    </div>
    <div v-else>
      搜索结果为空
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'search-result',
  beforeCreate () {
    let conditions = null

    try {
      conditions = JSON.parse(this.$route.query.q)
    } catch (error) {
      console.error(error)
      conditions = null
    }

    if (conditions !== null) {
      this.$store.dispatch('getBooks', conditions)
    }
    debugger
    console.log(this.$route)
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  computed: mapState({
    bookList (state) {
      return state.book.bookList
    }
  })
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

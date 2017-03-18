<template>
  <div class="search-result">
    {{ bookList }}
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'search-result',
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

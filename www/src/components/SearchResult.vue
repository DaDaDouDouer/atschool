<template>
  <div class="search-result">
    <div class="filter">

    </div>
    <div v-if="bookList && bookList.length > 0">
      <v-container>
        <v-row>
          <v-col xs3 v-for="book in bookList">
            <v-card horizontal>
              <v-card-row :img="book.imgUrl" height="200px" class="row"></v-card-row>
              <v-card-column width="100px">
                <v-card-row class="grey--text">
                  <v-card-text>
                    <h4>{{book.name}}</h4>
                    <strong class="red--text">￥{{book.price}}</strong>
                    <div>还有{{book.count}}本</div>
                  </v-card-text>
                </v-card-row>
              </v-card-column>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
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
.book-item {
  list-style: none;
  margin: 10px;
}

.row {
  flex: 0 1 60%!important;
}
</style>

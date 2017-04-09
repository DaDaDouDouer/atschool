<template>
<div class="index">
  <search></search>
  <div class="menu-container">
    <div v-for="(menu, menuName) in menus">
      <v-menu transition="v-slide-x-transition" bottom right>
        <v-btn primary dark slot="activator" class="deep-orange">
          {{ menuName }}
        </v-btn>
        <v-list style="position: relation; left: 190px">
          <v-list-item v-for="menuItem in menu" @click="search">
            <v-list-tile>
              <v-list-tile-title :id="menuItem.id">{{ menuItem.name }}</v-list-tile-title>
            </v-list-tile>
          </v-list-item>
        </v-list>
      </v-menu>
    </div>
  </div>
  <div class="ad-container">
    <v-carousel>
      <v-carousel-item v-for="item in items" v-bind:src="item" />
    </v-carousel>
  </div>
  <div class="recommend-book">

  </div>
</div>
</template>

<script>
import { mapState } from 'vuex'
import Search from './Search'

export default {
  name: 'index',
  components: { Search },
  mounted () {
    this.$store.dispatch('getAllBookTypes')
  },
  data () {
    return {
      index: 'index',
      items: [1, 2, 3, 4]
    }
  },
  computed: mapState({
    menus (state) {
      return state.book.bookTypes
    }
  }),
  methods: {
    search (e) {
      this.$store.dispatch('goodsSearch', {types: [{id: e.target.id}]})
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.menu-container {
  display: block;
}

.menu-container .menu__content {
  left: 210px!important;
}

.menu-container .menu__activator {
    margin-bottom: -11px;
}
</style>

<template>
<v-container class="index">
  <search></search>
  <v-row class="menu-container">
    <v-col xs2>
      <h5 class="text-center">图书分类</h5>
      <div v-for="menu in menus">
        <v-menu transition="v-slide-x-transition" bottom right class="index-block">
          <v-btn block primary dark slot="activator" class="deep-orange">
            {{ menu.name }}
          </v-btn>
          <v-list style="position: relation; left: 190px">
            <v-list-item v-for="menuItem in menu.subTypes" @click="search">
              <v-list-tile>
                <v-list-tile-title :id="menuItem.id">{{ menuItem.name }}</v-list-tile-title>
              </v-list-tile>
            </v-list-item>
          </v-list>
        </v-menu>
      </div>
    </v-col>
    <v-col xs10>
      <v-carousel>
        <v-carousel-item v-for="item in items" v-bind:src="item" />
      </v-carousel>
    </v-col>
  </v-row>
  <!-- <div class="ad-container">
    <h4></h4>
    <v-divider/>
  </div> -->
  <div class="recommend-book">
    <h4>推荐书籍</h4>
    <v-divider/>
  </div>
</v-container>
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
  left: 300px!important;
}

.menu-container .menu__activator {
    margin-bottom: -11px;
}

.index-block {
  width: 100%;
}

.text-center {
  text-align: center;
}
</style>

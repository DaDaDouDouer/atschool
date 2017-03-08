<template>
<div class="index">
  <search></search>
  <div class="menu-container">
    <div v-for="menu in menus">
      <v-menu transition="v-slide-x-transition" bottom right>
        <v-btn primary dark slot="activator" class="deep-orange">
          Slide X Transition
        </v-btn>
        <v-list style="position: relation; left: 190px">
          <v-list-item v-for="menuItem in menu">
            <v-list-tile>
              <v-list-tile-title>{{ menuItem }}</v-list-tile-title>
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
import Search from './Search'

export default {
  name: 'index',
  components: { Search },
  mounted () {
    this.$store.dispatch('getAllBookTypes').then(data => {
      console.log(data)
    })
  },
  data () {
    return {
      index: 'index',
      menus: [[1, 2, 3, 4, 5], [1, 2, 3, 4, 5], [1, 2, 3, 4, 5], [1, 2, 3, 4, 5]],
      items: [1, 2, 3, 4]
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

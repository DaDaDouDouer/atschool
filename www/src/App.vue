<template>
  <v-app top-toolbar footer>
    <header>
      <v-toolbar class="blue">
        <v-toolbar-logo></v-toolbar-logo>
        <app-header></app-header>
      </v-toolbar>
    </header>
    <main>
      <v-content>
        <router-view></router-view>
      </v-content>
    </main>
    <v-footer class="blue"><app-footer class="blue"></app-footer></v-footer>
  </v-app>
</template>

<script>
import AppHeader from 'components/AppHeader'
import AppFooter from 'components/AppFooter'

export default {
  components: { AppHeader, AppFooter },
  name: 'app'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>

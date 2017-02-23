<template>
  <v-app top-toolbar footer>
    <header>
      <v-toolbar>
        <v-toolbar-logo></v-toolbar-logo>
        <app-header></app-header>
      </v-toolbar>
    </header>
    <main>
      <v-content>
        <v-container>
          <router-view></router-view>
        </v-container>
      </v-content>
    </main>
    <v-footer><app-footer></app-footer></v-footer>
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

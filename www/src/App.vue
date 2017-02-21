<template>
  <v-app top-toolbar footer>
    <header>
      <v-toolbar>
        <v-toolbar-logo>logo</v-toolbar-logo>
      </v-toolbar>
    </header>
    <main>
      <v-content>
        <v-container>
          <router-view></router-view>
        </v-container>
      </v-content>
    </main>
    <v-footer>&copy 2017</v-footer>
  </v-app>
</template>

<script>
export default {
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

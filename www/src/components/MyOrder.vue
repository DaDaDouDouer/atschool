<template>
  <div class="my-order">
    my-order
    {{order}}
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'my-order',
  mounted () {
    this.getUserOrder().then((order) => {
      this.order = order
    })
  },
  data () {
    return {
      order: null
    }
  },
  methods: {
    ...mapActions([
      'getUserOrder'
    ])
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

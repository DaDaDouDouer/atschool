<template>
  <div class="seller">
    <v-row>
      <v-col xs2>
        <v-sidebar :value="true" height="auto">
          <v-list dense>
            <template v-for="(item,i) in itemGroup">
              <v-list-group v-if="item.items">
                <v-list-item slot="item">
                  <v-list-tile :href="'#/' + item.path" ripple>
                    <v-list-tile-title v-text="item.title" />
                    <v-list-tile-action>
                      <v-icon>keyboard_arrow_down</v-icon>
                    </v-list-tile-action>
                  </v-list-tile>
                </v-list-item>
                <v-list-item v-for="(subItem,i) in item.items" :key="i">
                  <v-list-tile :href="'#/' + subItem.path" ripple>
                    <v-list-tile-title v-text="subItem.title" />
                  </v-list-tile>
                </v-list-item>
              </v-list-group>
              <v-subheader v-else-if="item.header" v-text="item.header" />
              <v-divider v-else-if="item.divider" light />
              <v-list-item v-else>
                <v-list-tile :href="'#/' + item.path" ripple>
                  <v-list-tile-title v-text="item.title" />
                </v-list-tile>
              </v-list-item>
            </template>
          </v-list>
        </v-sidebar>
      </v-col>
      <v-col xs10>
        <router-view></router-view>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: 'seller',
  data () {
    return {
      itemGroup: [{
        header: '卖家管理'
      }, {
        title: '商品管理',
        path: 'seller-goods'
      }, {
        title: '商铺管理',
        path: 'seller-shop'
      }, {
        title: '订单管理',
        path: 'seller-order'
      }, {
        title: '查看商品评论',
        path: 'evaluation'
      }]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.seller {
  margin: 0 10px;
}
</style>

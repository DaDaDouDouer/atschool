<template>
<v-container v-if="shopId" class="shop">
  <search></search>
  <v-row class="menu-container">
    <h4>热门活动</h4>
    <v-col xs12>
      <v-carousel>
        <v-carousel-item v-for="item in shopData.carouselObj" :src="item.url" />
      </v-carousel>
    </v-col>
  </v-row>
  <div class="recommend-book">
    <h4>推荐书籍</h4>
    <v-divider/>
    <v-row style="margin-top:50px;">
      <v-col xs3 v-for="book in shopData.recommand">
        <v-card   horizontal>
          <v-card-row :img="book.imgUrl" @click.native="redirectToGoodsDetail(book.id)" height="200px" class="row pointer"></v-card-row>
          <v-card-column width="100px">
            <v-card-row class="grey--text">
              <v-card-text>
                <h6>{{book.name}}</h6>
                <strong class="red--text">￥{{book.price}}</strong>
                <div>销量：{{book.via}}</div>
                <div>还有{{book.count}}本</div>
                <div>
                  商铺：<a :href="'#/shop?id=' + book.sellerId">{{book.sellername}}</a>
                </div>
              </v-card-text>
            </v-card-row>
          </v-card-column>
        </v-card>
      </v-col>
    </v-row>
  </div>
</v-container>
<div v-else>
  没有该商铺
</div>
</template>

<script>
import { mapActions } from 'vuex'
import Search from './Search'

export default {
  name: 'shop',
  components: { Search },
  mounted () {
    this.shopId = this.$route.query.id
    this.getShopBySellerId(this.shopId).then(shopData => {
      this.shopData = shopData
    })
  },
  data () {
    return {
      shopId: '',
      shopData: {}
    }
  },
  methods: {
    ...mapActions([
      'getShopBySellerId'
    ])
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

.shop-block {
  width: 100%;
}

.text-center {
  text-align: center;
}

.recommend-book {
  margin: 50px 0 100px 0;
}

.book-item {
  list-style: none;
  margin: 10px;
}

.row {
  flex: 0 1 60%!important;
}
</style>

<template>
  <v-container class="goods-detail">
    <!-- {{goodsDetail}} -->
    <div class="goods-info">
      <v-card v-if="goodsDetail" horizontal>
        <v-card-column class="row">
          <img :src="goodsDetail.imgUrl" :alt="goodsDetail.name" class="goods-img">
        </v-card-column>
        <v-card-column>
          <v-card-row height="500px">
            <v-card-text>
              <v-row>
                <v-col xs12>
                  <h3>{{goodsDetail.name}}</h3>
                </v-col>
                <v-col xs3>
                  作者
                </v-col>
                <v-col xs9>
                  {{goodsDetail.realGoods.author}}
                </v-col>
                <v-col xs3>
                  ISBN
                </v-col>
                <v-col xs9>
                  {{goodsDetail.realGoods.isbn}}
                </v-col>
                <v-col xs3>
                  价格
                </v-col>
                <v-col xs9>
                  ￥{{goodsDetail.price}}
                </v-col>
                <v-col xs3>
                  销量
                </v-col>
                <v-col xs9>
                  {{goodsDetail.via}}
                </v-col>
                <v-col xs3>
                  数量
                </v-col>
                <v-col xs9>
                  <v-icon large class="blue--text text--darken-2 pointer" @click.native="(goodsCount < goodsDetail.count) && (goodsCount++)">add</v-icon>
                  <span style="line-height: 49px;">{{goodsCount}}</span>
                  <v-icon large class="blue--text text--darken-2 pointer" @click.native="(goodsCount > 1) && (goodsCount--)">remove</v-icon>
                </v-col>
                <v-col xs12>
                  <v-btn light primary @click.native="createOrder({[goodsDetail.id]: goodsCount})">立即购买</v-btn>
                  <v-btn light primary @click.native="addCartItem({goodsId: goodsDetail.id, goodsCount})">加入购物车</v-btn>
                </v-col>
              </v-row>
            </v-card-text>
          </v-card-row>
        </v-card-column>
      </v-card>
    </div>

    <div class="other">
      <v-tabs id="mobile-tabs-7">
        <v-tab-item
          v-for="(title, index) in tabsTitle"
          :href="'tabs-' + index"
          slot="activators"
        >
          {{title}}
        </v-tab-item>
        <v-tab-content
          v-for="(title, index) in tabsTitle"
          :id="'tabs-' + index"
          slot="content"
        >
          <v-card>
            <v-card-text>{{title}}</v-card-text>
          </v-card>
        </v-tab-content>
      </v-tabs>
    </div>
  </v-container>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'goods-detail',
  mounted () {
    let id = this.$route.query.id
    if (id !== null) {
      this.getGoodsDetail(id).then((goodsDetail) => {
        this.goodsDetail = goodsDetail
      })
    }
  },
  data () {
    return {
      goodsDetail: null,
      goodsCount: 1,
      tabsTitle: [
        '书籍详情',
        '评论'
      ]
    }
  },
  computed: {
  },
  methods: {
    ...mapActions([
      'getGoodsDetail',
      'createOrder',
      'addCartItem'
    ])
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.goods-info dd, .goods-info dt {
  float: left;
}

.row {
  flex: 0 1 50%!important;
}

.goods-img {
  width: 90%;
  margin: 5%;
}

</style>

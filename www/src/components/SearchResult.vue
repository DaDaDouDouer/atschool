<template>
  <v-container class="search-result">
    <search @keywordChange="keywordChange" :keyword="allConditions.keyword"></search>
    <div class="filter">
      <v-row>
        <v-col xs1 mt-3>类型：</v-col>
        <v-col xs11>
          <v-btn small primary v-for="bookType in bookTypes" @click.native="searchByTypes">
            <span :id="bookType.id">{{bookType.name}}</span>
          </v-btn>
        </v-col>
      </v-row>
      <v-row>
        <v-col xs1 mt-4>价格：</v-col>
        <v-col xs1><v-text-field single-line label="最小值" v-model="allConditions.conditions.minPrice" type="number"/></v-col>
        <v-col xs1 mt-4>-</v-col>
        <v-col xs1><v-text-field single-line label="最大值" v-model="allConditions.conditions.maxPrice" type="number"/></v-col>
        <v-col xs1 mt-3><v-btn small primary @click.native="search">确认</v-btn></v-col>
      </v-row>
      <v-row>
        <v-col xs12><v-btn-toggle :options="sortData" @input="sortResult"></v-btn-toggle></v-col>
      </v-row>
    </div>

    <div v-if="bookList && bookList.length > 0">
      <v-container>
        <v-row>
          <v-col xs3 v-for="book in bookList">
            <v-card   horizontal>
              <v-card-row :img="book.imgUrl" @click.native="redirectToGoodsDetail(book.id)" height="200px" class="row pointer"></v-card-row>
              <v-card-column width="100px">
                <v-card-row class="grey--text">
                  <v-card-text>
                    <h4>{{book.name}}</h4>
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
        <v-pagination :length.number="pageCount" v-model="allConditions.pageNo" @input="search"/>
      </v-container>
    </div>
    <div v-else>
      搜索结果为空
    </div>
  </v-container>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import Search from './Search'

export default {
  name: 'search-result',
  components: { Search },
  beforeMounted () {
    // 获取关键字
    // this.allConditions.keyword = localStorage.getItem('keyword')
  },
  mounted () {
    // 渲染数据
    this.renderData()
    // 获取关键字
    // this.allConditions.keyword = localStorage.getItem('keyword')
    // 获取书的分类
    this.$store.dispatch('getAllBookTypes')
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      sortData: [
        { text: '价格升序', icon: 'arrow_upward', value: 'priceOrder_asc' },
        { text: '价格降序', icon: 'arrow_downward', value: 'priceOrder_desc' },
        { text: '销量升序', icon: 'arrow_upward', value: 'viaOrder_asc' },
        { text: '销量降序', icon: 'arrow_downward', value: 'viaOrder_desc' }
      ],
      // 搜索条件
      allConditions: {
        keyword: localStorage.getItem('keyword') || '',
        types: [],
        pageNo: 1,
        conditions: {
          maxPrice: '',
          minPrice: '',
          sort: ''
        }
      }
    }
  },
  methods: {
    ...mapActions([
      'redirectToGoodsDetail'
    ]),
    searchByTypes (e) {
      this.allConditions.types = [{id: e.target.id}]
      this.search()
    },
    sortResult (sortCondations) {
      this.allConditions.conditions.sort = sortCondations
      this.search()
    },
    keywordChange (keyword) {
      this.allConditions.keyword = keyword
    },
    search () {
      this.$store.dispatch('goodsSearch', this.allConditions)
    },
    renderData () {
      let conditions = null

      // 防止路由参数出错
      try {
        conditions = JSON.parse(this.$route.query.q)
      } catch (error) {
        console.error(error)
        conditions = null
      }

      if (conditions !== null) {
        this.$store.dispatch('getBooks', conditions)
      }
    }
  },
  computed: mapState({
    bookList (state) {
      return state.book.bookList
    },
    pageCount (state) {
      return state.book.pageCount
    },
    bookTypes (state) {
      return state.book.bookTypes
    },
    filterData (state) {
      return state.book.bookTypes.map((bookType) => {
        return {
          text: bookType.name,
          value: bookType.id
        }
      })
    }
  }),
  watch: {
    // 如果路由有变化，会再次执行该方法
    '$route': 'renderData',
    // 如果 conditions 变化，则搜索商品
    conditions: {
      handler: function (val, oldVal) {
        this.$store.dispatch('goodsSearch', val)
      },
      deep: true
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.book-item {
  list-style: none;
  margin: 10px;
}

.row {
  flex: 0 1 60%!important;
}

.pointer {
  cursor: pointer;
}
</style>

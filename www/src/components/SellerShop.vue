<template>
  <div class="seller-shop">
    <div v-if="isNewSeller">
      <v-col xs6 offset-xs3>
        <v-card>
          <v-card-row class="blue darken-1 title">
            <v-card-title>
              <span class="white--text">新建店铺</span>
              <v-spacer></v-spacer>
            </v-card-title>
          </v-card-row>
          <v-card-text class="input" v-for='(input, index) in formItems'>
            <v-text-field
              v-model="form[input.name]"
              :id="input.index"
              :name="input.name"
              :type="input.type"
              :label="input.label"
              :placeholder="input.placeholder"
            ></v-text-field>
          </v-card-text>
          </v-card-text>
          <v-card-text>
            <div class="text-xs-center">
              <v-btn primary dark @click.native="submit">确认</v-btn>
            </div>
          </v-card-text>
        </v-card>
      </v-col>
    </div>
    <div v-else>
      <h5>商铺首页轮播管理</h5>
      <v-divider/>
      <table class="table">
        <thead>
          <tr>
            <th v-for="header in headers">
              {{header.text}}
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item, index) in carouselList">
            <td class="text-xs-center">{{ ++index }}</td>
            <td class="text-xs-center">{{ item.desc }}</td>
            <td class="text-xs-center">{{ item.url }}</td>
            <td class="text-xs-center">
              <v-btn small primary dark slot="activator" @click.native="remove(props.item.id)">删除</v-btn>
              <v-btn small primary dark slot="activator" @click.native="remove(props.item.id)">添加</v-btn>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'seller-shop',
  mounted () {
    this.getShop().then(data => {
      if (!data) {
        this.isNewSeller = true
      } else {
        this.carouselList = data.carouselObj
      }
    })
  },
  data () {
    return {
      isNewSeller: false,
      formItems: [
        {
          name: 'name',
          type: 'text',
          label: '店铺名',
          placeholder: '请输入店铺名'
        }
      ],
      form: {
        name: ''
      },
      headers: [{
        text: '索引'
      }, {
        text: '轮播描述'
      }, {
        text: '图片链接'
      }, {
        text: '操作'
      }],
      carouselList: []
    }
  },
  methods: {
    ...mapActions([
      'getShop',
      'addShop'
    ]),
    submit () {
      this.addShop(this.form.name).then(data => {
        location.reload()
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.seller-shop tr th {
  text-align: center!important;
}
</style>

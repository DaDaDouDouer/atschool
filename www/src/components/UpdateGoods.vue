<template>
  <div v-if="!form.id" class="text-xs-center">
    <h4 style="margin-top: 100px">商品不存在</h4>
  </div>
  <v-card v-else class="update-goods">
    <v-card-row class="blue darken-1 title">
      <v-card-title>
        <span class="white--text">修改商品</span>
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
      <v-btn primary dark @click.native="submit">修改</v-btn>
    </v-card-text>
  </v-card>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'update-goods',
  mounted () {
    let id = this.$route.query.id
    this.form.id = id
  },
  data () {
    return {
      formItems: [
        {
          name: 'price',
          type: 'text',
          label: '价格',
          placeholder: '请输入价格'
        },
        {
          name: 'count',
          type: 'text',
          label: '数量',
          placeholder: '请输入数量'
        }
      ],
      form: {
        id: '',
        price: '',
        count: ''
      }
    }
  },
  methods: {
    ...mapActions([
      'updateGoodsBySeller'
    ]),
    submit () {
      this.updateGoodsBySeller(this.form).then(data => {
        alert('修改商品成功！')
        this.form.price = ''
        this.form.count = ''
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.update-goods {
  width: 500px;
  margin: auto;
  margin-top: 30px;
  font-size: 16px;
  text-align: center;
}

.title {
  margin-bottom: 30px;
}

.input {
  width: 400px;
  margin: auto;
}
</style>

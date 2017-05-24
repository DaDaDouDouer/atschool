<template>
  <v-card class="add-goods">
    <v-card-row class="blue darken-1 title">
      <v-card-title>
        <span class="white--text">添加书籍</span>
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
      <v-btn primary dark @click.native="submit">添加</v-btn>
    </v-card-text>
  </v-card>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'add-goods',
  data () {
    return {
      formItems: [
        {
          name: 'isbn',
          type: 'text',
          label: 'ISBN号',
          placeholder: '请输入ISBN号'
        },
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
        isbn: '',
        price: '',
        count: ''
      }
    }
  },
  methods: {
    ...mapActions([
      'addGoodsByIsbn'
    ]),
    submit () {
      this.addGoodsByIsbn(this.form).then(data => {
        if (data) {
          alert('添加商品成功！')
        } else {
          alert('获取不到书籍信息！')
        }

        this.form.isbn = ''
        this.form.price = ''
        this.form.count = ''
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.add-goods {
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

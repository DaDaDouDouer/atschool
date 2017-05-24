<template>
  <div class="add-carousel">
    <v-col xs8 offset-xs2>
    <v-card>
      <v-card-row class="blue darken-1 title">
        <v-card-title>
          <span class="white--text">添加轮播图片</span>
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
        <form method= "post" enctype ="multipart/form-data" @submit.prevent="submit">
          <input type ="file" name="file"/>
          <div class="text-xs-center">
            <v-btn primary dark type="submit">登录</v-btn>
          </div>
        </form>
      </v-card-text>
      </v-card-text>

    </v-card>
  </v-col>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import API from '../api'

export default {
  name: 'add-carousel',
  data () {
    return {
      formItems: [
        {
          name: 'desc',
          type: 'text',
          label: '图片描述',
          placeholder: '请输入图片描述'
        }
      ],
      form: {
        desc: '',
        url: ''
      }
    }
  },
  methods: {
    ...mapActions([
      'addCarousel'
    ]),
    submit (e) {
      let formData = new FormData(e.target)
      return API.file.upload(formData).then((data) => {
        this.form.url = data
        return this.addCarousel(this.form).then(data => {
          alert('添加轮播图片成功！')
          location.reload()
        })
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

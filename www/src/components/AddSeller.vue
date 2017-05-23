<template>
  <div class="add-seller">
    <v-col xs6 offset-xs3 style="margin-top:50px;">
      <v-card>
        <v-card-row class="blue darken-1 title">
          <v-card-title>
            <span class="white--text">添加卖家</span>
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
        <v-card-text class="text-xs-center">
          <v-btn primary dark @click.native="submit">添加卖家</v-btn>
        </v-card-text>
      </v-card>
    </v-col>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'add-seller',
  data () {
    return {
      formItems: [
        {
          name: 'username',
          type: 'text',
          label: '卖家名',
          placeholder: '请输入卖家名'
        },
        {
          name: 'password',
          type: 'password',
          label: '密码',
          placeholder: '请输入密码'
        }
      ],
      form: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    ...mapActions([
      'addSellerByAdmin'
    ]),
    submit () {
      this.addSellerByAdmin(this.form).then(data => {
        alert('添加卖家成功！')
        this.form.username = ''
        this.form.password = ''
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

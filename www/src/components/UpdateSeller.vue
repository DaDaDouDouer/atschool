<template>
  <div class="update-seller">
    <v-col xs6 offset-xs3 style="margin-top:50px;" v-if="form.id">
      <v-card>
        <v-card-row class="blue darken-1 title">
          <v-card-title>
            <span class="white--text">修改密码</span>
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
          <v-btn primary dark @click.native="submit">修改密码</v-btn>
        </v-card-text>
      </v-card>
    </v-col>
    <div v-else style="margin-top:100px;font-size: 20px; text-align: center;">
      卖家ID非法
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'update-seller',
  mounted () {
    this.form.id = this.$route.query.id
  },
  data () {
    return {
      formItems: [
        {
          name: 'password',
          type: 'password',
          label: '密码',
          placeholder: '请输入新密码'
        }
      ],
      form: {
        password: '',
        id: ''
      }
    }
  },
  methods: {
    ...mapActions([
      'updateSellerPasswordByAdmin'
    ]),
    submit () {
      this.updateSellerPasswordByAdmin(this.form).then(data => {
        alert('修改密码成功！')
        this.form.password = ''
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

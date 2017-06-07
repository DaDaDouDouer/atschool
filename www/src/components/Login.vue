<template>
  <v-card class="login">
    <v-card-row class="blue darken-1 title">
      <v-card-title>
        <span class="white--text">登录</span>
        <v-spacer></v-spacer>
      </v-card-title>
    </v-card-row>
    <v-card-text class="input">
      <v-row v-for='(input, index) in formItems'>
          <v-col xs12>
            <v-text-field
              v-model="form[input.name]"
              :id="input.index"
              :name="input.name"
              :type="input.type"
              :label="input.label"
              :placeholder="input.placeholder"
            ></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col xs8>
          <v-text-field
            v-model="form.checkCode"
            name="checkCode"
            type="text"
            label="验证码"
            placeholder="请输入验证码"
          ></v-text-field>
        </v-col>
        <v-col xs4>
          <img src="/auth/getCheckCode.do" alt="验证码">
        </v-col>
      </v-row>
      <v-row>
        <v-col xs3 offset-xs8>
          <v-dialog v-model="isShowDialog">
            <a herf="javascript:void(0);" style="cursor: pointer;" slot="activator">忘记密码</a>
            <!-- <v-btn primary light slot="activator">Open Dialog</v-btn> -->
            <v-card>
              <v-card-row>
                <v-card-title>找回密码</v-card-title>
              </v-card-row>
              <v-card-row>
                <v-card-text>
                  <v-text-field label="用户名" placeholder="请输入您的用户名" v-model="username" required></v-text-field>
                </v-card-text>
              </v-card-row>
              <v-card-row actions>
                <v-btn class="blue--text darken-1" flat @click.native="isShowDialog = false">取消</v-btn>
                <v-btn class="blue--text darken-1" flat @click.native="isShowDialog = false || resetPassword()">确认</v-btn>
              </v-card-row>
            </v-card>
          </v-dialog>
        </v-col>
      </v-row>
    </v-card-text>
    </v-card-text>
    <v-card-text>
      <v-btn primary dark @click.native="submit">登录</v-btn>
    </v-card-text>
  </v-card>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'login',
  data () {
    return {
      formItems: [
        {
          name: 'username',
          type: 'text',
          label: '用户名',
          placeholder: '请输入您的用户名'
        },
        {
          name: 'password',
          type: 'password',
          label: '密码',
          placeholder: '请输入您的密码'
        }
      ],
      form: {
        username: '',
        password: '',
        checkCode: ''
      },
      username: '',
      isShowDialog: false
    }
  },
  methods: {
    ...mapActions([
      'findPassword'
    ]),
    submit () {
      this.$store.dispatch('userLogin', this.form)
    },
    resetPassword () {
      this.findPassword(this.username)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.login {
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

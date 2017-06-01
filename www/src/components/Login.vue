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
          <img src="http://localhost:8080/auth/getCheckCode.do" alt="验证码">
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
      }
    }
  },
  methods: {
    submit () {
      this.$store.dispatch('userLogin', this.form)
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

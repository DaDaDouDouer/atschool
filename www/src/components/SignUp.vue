<template>
  <v-card class="sign-up">
    <v-card-row class="blue darken-1 title">
      <v-card-title>
        <span class="white--text">注册</span>
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
      <v-btn primary dark @click.native="submit">注册</v-btn>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  name: 'sign-up',
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
        },
        {
          name: 'repeatPassword',
          type: 'password',
          label: '重复密码',
          placeholder: '请再次输入您的密码'
        },
        {
          name: 'mail',
          type: 'email',
          label: '电子邮箱',
          placeholder: '请输入您的电子邮箱'
        }
      ],
      form: {
        username: '',
        password: '',
        mail: ''
      }
    }
  },
  methods: {
    submit () {
      delete this.form.repeatPassword
      this.$store.dispatch('userSignUp', this.form)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.sign-up {
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

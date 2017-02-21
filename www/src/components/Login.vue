<template>
  <v-card class="login">
    <v-card-row class="blue darken-1 title">
      <v-card-title>
        <span class="white--text">登录</span>
        <v-spacer></v-spacer>
      </v-card-title>
    </v-card-row>
    <v-card-text class="input">
      <v-text-input
        id="test3"
        name="test3"
        type="text"
        label="用户名"
        placeholder="请输入您的用户名"
      ></v-text-input>
    </v-card-text>
    <v-card-text class="input">
      <v-text-input
        id="test3"
        name="test3"
        type="password"
        label="密码"
        placeholder="请输入您的密码"
      ></v-text-input>
    </v-card-text>
    <v-card-text>
      <v-btn primary dark>登录</v-btn>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      login: 'login'
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

<template>
  <div class="change-password">
    <v-col xs10 offset-xs1>
      <v-card>
        <v-card-row class="blue darken-1 title">
          <v-card-title>
            <span class="white--text">更改密码</span>
            <v-spacer></v-spacer>
          </v-card-title>
        </v-card-row>
        <v-row row v-for='(input, index) in formItems'>
          <v-col xs2 offset-xs2>
            <v-subheader class="label">{{input.label}}</v-subheader>
          </v-col>
          <v-col xs5>
            <v-text-field
              v-model="fields[input.name]"
              :id="input.index"
              :name="input.name"
              :type="input.type"
              :label="input.placeholder"
              single-line
            ></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col xs2 offset-xs5>
            <v-btn block primary dark @click.native="submit">确认更改</v-btn>
          </v-col>
        </v-row>
      </v-card>
    </v-col>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'change-password',
  data () {
    return {
      formItems: [
        {
          name: 'oldPassword',
          type: 'password',
          label: '当前密码',
          placeholder: '请输入您当前的密码'
        },
        {
          name: 'newPassword',
          type: 'password',
          label: '新密码',
          placeholder: '请输入您新的密码'
        }
      ],
      fields: {
        oldPassword: null,
        newPassword: null
      }
    }
  },
  methods: {
    ...mapActions([
      'updatePassword'
    ]),
    submit () {
      this.updatePassword(this.fields).then((response) => {
        alert('修改密码成功！')
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.label {
  height: 66px;
}
</style>

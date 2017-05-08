<template>
  <div class="change-password">
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
        <v-btn block primary dark @click.native="updatePassword(fields)">确认更改</v-btn>
      </v-col>
    </v-row>
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
    ])
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.label {
  height: 66px;
}
</style>

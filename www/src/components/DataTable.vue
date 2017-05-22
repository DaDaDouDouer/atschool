<template>
  <div class="data-table">
    <v-row>
      <v-col xs12>
        <!-- search -->
        <v-text-field
          append-icon="search"
          label="搜索"
          single-line
          hide-details
        ></v-text-field>
      </v-col>
      <v-col xs12>

        <!-- table -->
        <table class="table">
          <thead>
            <th>
              <td v-for="header in headers">
                {{header}}
              </td>
            </th>
          </thead>
          <tbody>
            <tr v-for="(item, index) in list">
              <td v-for="(prop, key) in item">
                <span v-if="key in headers">
                  {{prop}}
                </span>
              </td>
              <td>
                <v-dialog v-model="item.isShowDialog">
                  <v-btn small primary dark class="btn-operation" slot="activator" @click.native="(currentDialogName = 'add')">添加</v-btn>
                  <v-btn small primary dark class="btn-operation" slot="activator" @click.native="(currentDialogName = 'update')">修改</v-btn>
                  <v-card>
                    <v-card-row>
                      <v-card-title>123123123</v-card-title>
                    </v-card-row>
                    <v-card-row>
                      <v-card-text>
                        <v-container fluid>
                          <v-text-field label="Email" v-model="email" required />
                        </v-container>
                      </v-card-text>
                    </v-card-row>
                    <v-card-row actions>
                      <v-btn class="blue--text darken-1" flat @click.native="(item.isShowDialog = false) || click(item.id)">取消</v-btn>
                      <v-btn class="blue--text darken-1" flat @click.native="(item.isShowDialog = false) || click(item.id)">确认</v-btn>
                    </v-card-row>
                  </v-card>
                </v-dialog>
                <v-btn small primary dark class="btn-operation" @click.native="(currentDialogName = 'remove') && click(item.id)">删除</v-btn>
              </td>
            </tr>
          </tbody>
        </table>
      </v-col>
      <v-col xs12>
        <!-- pagination -->
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: 'data-table',
  mounted () {
  },
  data () {
    return {
      email: '',
      currentDialogName: '',
      operationButtons: [{
        text: '增加',
        value: 'add'
      }, {
        text: '删除',
        value: 'remove'
      }, {
        text: '修改',
        value: 'update'
      }]
    }
  },
  props: {
    headers: {
      type: Object,
      default: {}
    },
    value: {
      type: Array,
      default: []
    },
    filter: {
      type: Function,
      default: () => true
    },
    operator: {
      type: Object,
      default: function () {
        return {}
      }
    }
  },
  computed: {
    list () {
      // 过滤掉不需要显示的属性
      return this.value.filter(this.filter)
    }
  },
  watch () {

  },
  methods: {
    click (id) {
      let functionName = this.currentDialogName
      this.operator[functionName] && this.operator[functionName](id)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.data-table table td{
  text-align: center;
}

.btn-operation {
  min-width: 0;
  margin: 2px;
}
</style>

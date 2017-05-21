<template>
  <div class="user-manager">
    <v-card>
      <v-card-title>
        用户管理
        <v-spacer></v-spacer>
        <v-text-field
          append-icon="search"
          label="搜索"
          single-line
          hide-details
          v-model="userName"
        ></v-text-field>
      </v-card-title>
      <v-data-table
          :headers="headers"
          v-model="userList"
          :search="userName"
          select-all
          no-data-text="没有数据"
          no-results-text="没有匹配的结果"
          rows-per-page-text="每页条数"
          :rows-per-page="10"
          :rows-per-page-items="[10, 20, 30]"
        >
        <template slot="items" scope="props">
          <td>
            <v-checkbox
              hide-details
              primary
              v-model="props.item.value"
            ></v-checkbox>
          </td>
          <td>
            <v-edit-dialog
              @open="props.item._name = props.item.name"
              @cancel="props.item.name = props.item._name || props.item.name"
              lazy
            > {{ props.item.name }}
              <v-text-field
                slot="input"
                label="Edit"
                v-bind:value="props.item.name"
                v-on:change="val => props.item.name = val"
                single-line counter="counter"
              ></v-text-field>
            </v-edit-dialog>
          </td>
          <td class="text-xs-right">{{ props.item.calories }}</td>
          <td class="text-xs-right">{{ props.item.fat }}</td>
          <td class="text-xs-right">{{ props.item.carbs }}</td>
          <td class="text-xs-right">{{ props.item.protein }}</td>
          <td class="text-xs-right">{{ props.item.sodium }}</td>
          <td class="text-xs-right">{{ props.item.calcium }}</td>
          <td>
            <v-edit-dialog
              class="text-xs-right"
              @open="props.item._iron = props.item.iron"
              @cancel="props.item.iron = props.item._iron || props.item.iron"
              large
              lazy
            >
              <div class="text-xs-right">{{ props.item.iron }}</div>
              <div slot="input" class="mt-3 title">Update Iron</div>
              <v-text-field
                slot="input"
                label="Edit"
                v-bind:value="props.item.iron"
                v-on:blur="val => props.item.iron = val"
                single-line
                counter
                autofocus
              ></v-text-field>
            </v-edit-dialog>
          </td>
        </template>
      </v-data-table>
    </v-card>
  </div>
</template>

<script>
export default {
  name: 'user-manager',
  data () {
    return {
      userName: '',
      headers: [{
        text: '用户名'
      }],
      userList: [{
        name: '123',
        value: false
      }, {
        name: '234',
        value: true
      }]
    }
  },
  methods: {
    search (e) {
      debugger
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

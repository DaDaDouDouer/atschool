<template>
  <div class="evaluation">
    <v-card>
      <v-card-title>
        查看评论
        <v-spacer></v-spacer>
      </v-card-title>
      <v-data-table
          :headers="headers"
          v-model="evaluationList"
          hide-actions
          no-data-text="没有数据"
        >
        <template slot="items" scope="props">
          <td class="text-xs-center">{{ props.item.username }}</td>
          <td class="text-xs-center">{{ props.item.content }}</td>
          <td class="text-xs-center">{{ new Date(props.item.createTime).toLocaleDateString() }}</td>
        </template>
      </v-data-table>
      <div class="text-xs-center">
        <v-pagination :length.number="pageCount" v-model="conditions.pageNo"></v-pagination>
      </div>
    </v-card>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'evaluation',
  mounted () {
    this.getEvaluationList()
  },
  data () {
    return {
      headers: [{
        text: '买家名'
      }, {
        text: '评论内容'
      }, {
        text: '评论时间'
      }],
      evaluationList: [],
      conditions: {
        pageNo: 1,
        limit: 20
      },
      pageCount: 0
    }
  },
  methods: {
    ...mapActions([
      'getAllEvaluation'
    ]),
    getEvaluationList () {
      return this.getAllEvaluation(this.conditions).then(({evaluationList, pageCount}) => {
        this.evaluationList = evaluationList
        this.pageCount = pageCount
      })
    }
  },
  watch: {
    'conditions.pageNo': function (val, oldVal) {
      this.getEvaluationList()
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.evaluation tr th {
  text-align: center!important;
}
</style>

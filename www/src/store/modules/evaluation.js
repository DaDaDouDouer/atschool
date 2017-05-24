import API from '../../api'

// initial state
const state = {}

// getters
const getters = {}

// actions
const actions = {
  getAllEvaluation ({commit, state}, conditions) {
    return API.evaluation.getAll(conditions).then(({data, other}) => {
      return {evaluationList: data, pageCount: other.pageAllCount}
    })
  },
  getEvaluationByGoodsId ({commit, state}, id) {
    return API.evaluation.getByGoodsId(id).then(({data}) => {
      return data
    })
  },
  addEvaluation ({commit, state}, evaluation) {
    return API.evaluation.add(evaluation).then((data) => {
      return data
    })
  }
}

// mutations
const mutations = {}

export default {
  state,
  getters,
  actions,
  mutations
}

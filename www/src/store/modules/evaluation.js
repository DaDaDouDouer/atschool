import API from '../../api'

// initial state
const state = {}

// getters
const getters = {}

// actions
const actions = {
  getAllEvaluation ({commit, state}, id) {
    return API.evaluation.getAll(id).then((evaluations) => {
      console.warn('evaluations', evaluations)
      return evaluations
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

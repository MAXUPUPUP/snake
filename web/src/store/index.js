import { createStore } from 'vuex'
import ModuleUser from './user'
import ModulePK from './pk'
import ModuleRecord from './record' //录播

export default createStore({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    user: ModuleUser,
    pk: ModulePK,
    record: ModuleRecord,
  }
})

import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    article:{
      articleId:0,
      authorName:'',
      articleName:'',
      articleMainPoint:'',
      articleBody:'',
      dateWritten:'',
      imageURL:'',
      tag:''
    },
    articles:[],
    comment:{
      commentId:0,
      reviewerName:'',
      commentBody:'',
      dateWritten:'',
      articleRating:'',
      articleId:0,
      commentHeader:''
    },
    comments:[],
  },
  mutations: {
    SET_CURRENT_ARTICLE(state, data){
      state.article=data;
    },
  },
  actions: {
  },
  modules: {
  }
})

import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  //create article model
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
    //create article array
    articles:[],
    //create comment model
    comment:{
      commentId:0,
      reviewerName:'',
      commentBody:'',
      dateWritten:'',
      articleRating:'',
      articleId:'',
      commentHeader:''
    },
    //create comment array
    comments:[],
  },
  //set current article
  mutations: {
    SET_CURRENT_ARTICLE(state, data){
      state.article=data;
    },
    //set current comment
    SET_CURRENT_COMMENT(state, data) {
      state.comment = data;
    },
    //set current comments
    SET_CURRENT_COMMENTS(state, data) {
      state.comments = data;
    },
  },
  actions: {
  },
  modules: {
  }
})

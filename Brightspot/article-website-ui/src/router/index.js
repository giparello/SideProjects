import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Article from '../views/Article.vue'
import NewArticleForm from '../views/NewArticleForm.vue'
Vue.use(VueRouter)



const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes:[
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {path:"/article/:id",
      name:"article",
      component: Article
  },
  {
    path:"/articleForm",
    name:"ArticleForm",
    component:NewArticleForm
  }
    
  ]
})

export default router

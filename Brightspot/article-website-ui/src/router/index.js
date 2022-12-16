import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Article from '../views/Article.vue'
import NewArticleForm from '../views/NewArticleForm.vue'
import TechArticles from '../views/TechArticles.vue'
import SportsArticles from '../views/SportsArticles.vue'
import FinanceArticles from '../views/FinanceArticles.vue'
import EntertainmentArticles from '../views/EntertainmentArticles.vue'
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
  },
  {
    path:"/techArticles",
    name: "TechArticles",
    component:TechArticles
  },
  {
    path:"/sportsArticles",
    name:"SportsArticles",
    component: SportsArticles
  },
  {
  path:"/financeArticles",
  name:"FinanceArticles",
  component:FinanceArticles
  },
  {
    path:"/entertainmentArticles",
    name:"EntertainmentArticles",
    component: EntertainmentArticles
  }
  ]
})

export default router

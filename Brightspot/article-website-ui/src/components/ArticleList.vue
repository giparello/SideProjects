<template>
  <section id="cards">
      <article class="article-card"
      v-for="article in articles" v-bind:key="article.articleId"
      v-on:click="viewArticleDetail(article.articleId)">

          <div class="info">
              <h2>{{article.articleName}}</h2>
              <p>{{article.articleMainPoint}}</p>
          </div>
          <img class="article-image" v-bind:src="article.imageURL"/>
          <div class="info">
              <p>{{article.articleBody}}</p>
          </div>
          <div class="info">
              <p>{{article.articleId}}</p>
              <p>{{article.authorName}}</p>
              <p>{{article.dateWritten}}</p>
          </div>
      </article>
  </section>
</template>

<script>
import articleService from '../services/articleService.js';
export default {
    name: 'article-list',
    data(){
        return{ articles: []
    };
    },
    methods: {
        viewArticleDetail(articleId){
            this.$router.push(`/article/${articleId}`)
        }
    },
    created(){
        articleService.getAllArticles().then( response =>{
            this.articles = response.data;
        });
    }
}
</script>

<style>

</style>
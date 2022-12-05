<template>
  <div>
      <h1>Articles</h1>

      <article>
          
          <ul class="customHeight" v-for="article in articles" v-bind:key="article.articleId">
              <li>
              <p>{{article.articleId}}</p>
              <h1>{{article.articleName}}</h1>
              <p>{{article.articleMainPoint}}</p>
              <p>{{article.authorName}}</p>
              <p class="row bottomGap">{{article.articleBody}}</p>
              <p class="dateHolder">{{article.dateWritten}}</p>
              </li>
          </ul>
      </article>
  </div>
</template>

<script>
import articleService from '../services/articleService.js';
export default {
    name: 'article-list',
    data(){
        return{ articles: []
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

/* Single column display for phones */
@media (max-width: 459px) {
  .archive {
    display: flex;
    flex-direction: column;
  }
}
</style>
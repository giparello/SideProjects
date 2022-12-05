<template>
  <div>
      <h1>Articles</h1>

      <article>
          
          <ul class="customHeight" v-for="article in articles" v-bind:key="article.articleId">
              <li class="article">
              <p>{{article.articleId}}</p>
              <h1>{{article.articleName}}</h1>
              <img> {{article.imageURL}}<img>
              <h4>{{article.articleMainPoint}}</h4>
              <p>{{article.authorName}}</p>
              <p class="row bottomGap">{{article.articleBody}}</p>
              <p class="dateHolder">{{article.dateWritten}}</p>
              <!--DECIDE IF YOU WANT TO ADD IMAGES OR NOT-->
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
article {
    display: grid;
    grid-template-columns: 1fr 740px 1fr;
    list-style: none;
}
article > * {
    grid-column: 2;
}
article > figure {
    grid-column: 1 / -1;
    margin: 20px 0;
}
/* Single column display for phones */
@media (max-width: 459px) {
  .archive {
    display: flex;
    flex-direction: column;
  }
}
</style>
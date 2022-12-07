<template>
  <div class="test">
      <h1>Articles</h1>
      <article>
          <ul class="entire-archive" v-for="article in articles" v-bind:key="article.articleId">
              <li class="article-container">
                  <div class="container">
                  <div class="body">
                    <h1 class="article-header">{{article.articleName}}</h1>
                    <div class="image">
                    <img v-bind:src="article.imageURL" class ="article-image"/>
                  </div>
                  <div class="information">
                    <p class="date-written">Date Written: {{article.dateWritten}}</p>
                    <p class="author-name">Author: {{article.authorName}}</p>
                    <p class="article-id">Article no. {{article.articleId}}</p>
                  </div>
                    <h2 class="article-subheader">{{article.articleMainPoint}}</h2>
                    <p class="article-body">{{article.articleBody}}</p>
                  </div>
                  </div>
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
.test{
    display: flex;
    flex-direction: column;
    border: solid green;
    width: 100%;
    margin: auto;
}
html{
    font-family: sans-serif;
    font-size: 14px;
}
li{
    list-style: none;
}
.container{
    display: flex;
    flex-direction: row;
    text-align: center;
    width: 80%;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    border: solid red;
    margin: auto;
    }
.article-image{
    width: 100%
}
.article-header{
    font-weight: bolder;
    font-size: 2rem;
}
.information{
    display: flex;
    flex-direction: row;
    justify-content: center;
    justify-content: space-around;

}

/* Single column display for phones */
@media (max-width: 459px) {
  .container {
    display: flex;
    flex-direction: column;
  }
}
</style>
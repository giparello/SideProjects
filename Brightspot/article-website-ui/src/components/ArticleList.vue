<template>
  <div>
      <h1>Articles</h1>
      <article>
          <ul class="entire-archive" v-for="article in articles" v-bind:key="article.articleId">
              <li class="article-container">
                  <div class="information">
                    <p class="date-written">Date Written: {{article.dateWritten}}</p>
                    <p class="author-name">Author: {{article.authorName}}</p>
                    <p class="article-id">Article no. {{article.articleId}}</p>
                  </div>
                  <div class="body">
                    <h1 class="article-header">{{article.articleName}}</h1>
                    <h2 class="article-subheader">{{article.articleMainPoint}}</h2>
                    <p class="article-body">{{article.articleBody}}</p>
                  </div>
                  <div class="image">
                    <img v-bind:src="article.imageURL" class ="article-image"/>
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
html{
    font-family: sans-serif;
    font-size: 10px;
}
.article-container{
    width: 90%;
    height: 1fr;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #eee;
    padding: 0 1.5rem;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}

.archive h1{
    letter-spacing: 1px;
    font-size: 50px;
    color: #6968aa;
    padding: 10px;
    border: 2px dashed #0181a0;
    text-transform: uppercase;
    display: inline-block;
    text-align: center;
    margin-top: 90px;
    margin-left: 375px;
}
.article-container{
    margin-top: 150px;
}
.article-image{
    width: 100%;
    position: relative;
    z-index: 1;
}
li{
    list-style: none;
}



/* Single column display for phones */
@media (max-width: 459px) {
  .archive {
    display: flex;
    flex-direction: column;
  }
}
</style>
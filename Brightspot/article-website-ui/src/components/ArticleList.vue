<template>
  <!--Create a list of article cards to display-->
  <section id="cards">
    <!--v-for loop to create a card for every article in the database-->
    <!--when clicked, send to article detail page-->
    <article
      class="article-card"
      v-for="article in articles"
      v-bind:key="article.articleId"
      v-on:click="viewArticleDetail(article.articleId)"
    >
      <!--display article information with data binding-->
      <div class="list-header">
        <h1 class="article-header" style="white-space: pre-wrap">
          {{ article.articleName }}
        </h1>
        <h3 class="article-mainpoint" style="white-space: pre-wrap">
          {{ article.articleMainPoint }}
        </h3>
        <!--article side information-->
        <div class="article-sideinfo">
          <p class="side-info">Author: {{ article.authorName }}</p>
          <p class="side-info">Topic: {{ article.tag }}</p>
          <p class="side-info">Date Written: {{ article.dateWritten }}</p>
        </div>
        <!--image-->
      </div>
      <img class="article-image" v-bind:src="article.imageURL" />
    </article>
  </section>
</template>

<script>
import articleService from "../services/articleService.js";
export default {
  //create array of articles
  name: "article-list",
  data() {
    return { articles: [] };
  },
  //create method for when clicked
  methods: {
    viewArticleDetail(articleId) {
      this.$router.push(`/article/${articleId}`);
    },
  },
  //get all the articles from the DB
  created() {
    articleService.getAllArticles().then((response) => {
      this.articles = response.data;
    });
  },
};
</script>

<style>
</style>
<template>
  <!--Lists out tech articles-->
  <section id="cards">
    <!--v-for to create a list of cards-->
    <article
      class="article-card"
      v-for="article in articles"
      v-bind:key="article.articleId"
      v-on:click="viewArticleDetail(article.articleId)"
    >
      <!--article info-->
      <div class="list-header">
        <h1 class="article-header" style="white-space: pre-wrap">
          {{ article.articleName }}
        </h1>
        <h3 class="article-mainpoint" style="white-space: pre-wrap">
          {{ article.articleMainPoint }}
        </h3>
        <div class="article-sideinfo">
          <p class="side-info">Author: {{ article.authorName }}</p>
          <p class="side-info">Topic: {{ article.tag }}</p>
          <p class="side-info">Date Written: {{ article.dateWritten }}</p>
        </div>
      </div>
      <!--article image-->
      <img class="article-image" v-bind:src="article.imageURL" />
    </article>
  </section>
</template>

<script>
import articleService from "../services/articleService.js";
export default {
  //array of articles
  name: "article-list",
  data() {
    return { articles: [] };
  },
  //method for when article is clicked
  methods: {
    viewArticleDetail(articleId) {
      this.$router.push(`/article/${articleId}`);
    },
  },
  //get all articles by tech tag
  created() {
    articleService.getArticleByTag("Tech").then((response) => {
      this.articles = response.data;
    });
  },
};
</script>

<style>
</style>
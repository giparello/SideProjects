<template>
  <section id="cards">
    <article
      class="article-card"
      v-for="article in articles"
      v-bind:key="article.articleId"
      v-on:click="viewArticleDetail(article.articleId)"
    >
      <div class="list-header">
        <h2 class="article-header">{{ article.articleName }}</h2>
        <p class="article-mainpoint">{{ article.articleMainPoint }}</p>
        <div class="article-sideinfo">
          <p class="side-info">Author: {{ article.authorName }}</p>
          <p class="side-info">Topic: {{ article.tag }}</p>
          <p class="side-info">Date Written: {{ article.dateWritten }}</p>
        </div>
      </div>

      <img class="article-image" v-bind:src="article.imageURL" />
    </article>
  </section>
</template>

<script>
import articleService from "../services/articleService.js";
export default {
  name: "article-list",
  data() {
    return { articles: [] };
  },
  methods: {
    viewArticleDetail(articleId) {
      this.$router.push(`/article/${articleId}`);
    },
  },
  created() {
    articleService.getAllArticles().then((response) => {
      this.articles = response.data;
    });
  },
};
</script>

<style>
.red {
  color: red;
}
</style>
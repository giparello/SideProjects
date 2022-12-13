<template>
  <section id="cards">
    <article
      class="article-card"
      v-for="article in articles"
      v-bind:key="article.articleId"
      v-on:click="viewArticleDetail(article.articleId)"
    >
      <div class="list-header">
        <h2>{{ article.articleName }}</h2>
        <p>{{ article.articleMainPoint }}</p>
      </div>
      <div class="article-sideinfo">
        <p>Author: {{ article.authorName }}</p>
      <p>Date Written: {{ article.dateWritten }}</p>
      <p>Topic: {{article.tag}}</p>
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
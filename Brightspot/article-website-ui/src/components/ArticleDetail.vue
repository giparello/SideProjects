<template>
  <div>
    <div id="page-header">
      <div class="article-info">
        <h1>{{ article.articleName }}</h1>
        <h4 class="article-mainpoint">{{ article.articleMainPoint }}</h4>
      </div>
    </div>
    <img class="article-image" v-bind:src="article.imageURL" />
    <div id="page-main">
      <div class="article-sideinfo">
        <h3 class="article-id">Article No.{{ article.articleId }}</h3>
        <h3 id="author" class="article-author">
          Author: {{ article.authorName }}
        </h3>
        <h3 id="date-written" class="article-date">
          Date Written:
          {{ article.dateWritten }}
        </h3>
        <h3>Topic: {{article.tag}}</h3>
      </div>
      <div>
      <p class="article-body">{{ article.articleBody }}</p>
      </div>
      <div>
      <h4 class="rating">Avg Rating and # of Comments here</h4>
      </div>
    </div>
  </div>
</template>

<script>
import articleService from "../services/articleService";
export default {
  name: "article-detail",
  methods: {
    retrieveArticle() {
      articleService
        .getArticle(this.$route.params.id)
        .then((response) => {
          this.$store.commit("SET_CURRENT_ARTICLE", response.data);
        })
        .catch((error) => {
          if (error.response && error.response.status === 404) {
            alert("Article not available");
          }
        });
    },
    data() {
      return {
        errorMsg: "",
      };
    },
  },
  created() {
    this.retrieveArticle();
  },
  computed: {
    article() {
      return this.$store.state.article;
    },
  },
};
</script>

<style>
</style>
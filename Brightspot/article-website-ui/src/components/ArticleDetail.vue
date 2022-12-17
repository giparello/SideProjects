<template>
  <!--OUTPUT DETAILS FROM AN INDIVIDUAL ARTICLE-->
  <div>
    <!--Article header-->
    <div id="page-header">
      <div class="article-info">
        <h1 class="article-header">{{ article.articleName }}</h1>
        <h3 class="article-mainpoint" style="white-space: pre-wrap">
          {{ article.articleMainPoint }}
        </h3>
      </div>
    </div>
    <!--Article image-->
    <img class="article-image" v-bind:src="article.imageURL" />
    <!--Main section of article-->
    <div id="page-main">
      <!--Side information-->
      <div class="article-sideinfo">
        <h3 class="side-info">Article No.{{ article.articleId }}</h3>
        <h3 id="author" class="side-info">Author: {{ article.authorName }}</h3>
        <h3 id="date-written" class="side-info">
          Date Written:
          {{ article.dateWritten }}
        </h3>
        <h3 class="side-info">Topic: {{ article.tag }}</h3>
      </div>
      <!--Article body-->
      <div>
        <p class="article-body" style="white-space: pre-wrap">
          {{ article.articleBody }}
        </p>
      </div>
      <div>
        <!--<h4 class="rating">Avg Rating and # of Comments here</h4> SEE IF YOU WANT TO ADD-->
      </div>
    </div>
  </div>
</template>

<script>
import articleService from "../services/articleService";
export default {
  name: "article-detail",
  methods: {
    //retrieve the article selected
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
  //establish the article
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
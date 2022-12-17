<template>
  <!--home page (list of articles)-->
  <div class="home">
    <article-list></article-list>
  </div>
</template>

<script>
import ArticleList from "../components/ArticleList.vue";
export default {
  name: "Home",
  components: {
    ArticleList,
  },
};
</script>

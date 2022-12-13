<template>
  <section class="page">
      <article-detail/>
      <h1 style="text-align:center">COMMENTS</h1>
      <comment-list></comment-list>
      <h2 style="text-align:center;background-color:white">More Articles:</h2>
      <article-list class="clicked-list"/>
      
  </section>
</template>

<script>
import ArticleDetail from '../components/ArticleDetail.vue'
import ArticleList from '../components/ArticleList.vue'
import CommentList from '../components/CommentList.vue'
export default {
  components: { ArticleDetail, ArticleList, CommentList },

}
</script>

<style>

</style>
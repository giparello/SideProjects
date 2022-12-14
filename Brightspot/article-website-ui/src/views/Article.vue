<template>
  <section class="page">
      <article-detail style="border:2px solid rgba(44, 171, 255, 0.3); "/>
      <h1 style="text-align:center; padding-top:20px; ">COMMENTS</h1>
      <new-comment style="text-align:center;" class="add-comment-section"></new-comment>
      <comment-list></comment-list>
      <h2 style="text-align:center;background-color:white; margin:20px">More Articles:</h2>
      <article-list class="clicked-list"/>
      
  </section>
</template>

<script>
import ArticleDetail from '../components/ArticleDetail.vue'
import ArticleList from '../components/ArticleList.vue'
import CommentList from '../components/CommentList.vue'
import NewComment from '../components/NewComment.vue'
export default {
  components: { ArticleDetail, ArticleList, CommentList, NewComment },

}
</script>

<style>

</style>
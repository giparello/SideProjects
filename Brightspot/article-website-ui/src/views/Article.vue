<template>
  <section class="page">
      <article-detail/>
      <article-list class="clicked-list"/>
  </section>
</template>

<script>
import ArticleDetail from '../components/ArticleDetail.vue'
import ArticleList from '../components/ArticleList.vue'
export default {
  components: { ArticleDetail, ArticleList },

}
</script>

<style>

</style>
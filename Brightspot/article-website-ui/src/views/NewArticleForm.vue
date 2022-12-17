<template>
  <!--view for the new article form-->
  <new-article class="newarticle"></new-article>
</template>

<script>
import NewArticle from "../components/NewArticle.vue";
export default {
  components: { NewArticle },
  name: "article-form",
};
</script>

<style>
.newarticle {
  display: flex;
  width: 100%;
}
</style>
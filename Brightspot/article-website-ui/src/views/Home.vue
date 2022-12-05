<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <article-list></article-list>
    <!--<HelloWorld msg="Welcome to Your Vue.js App"/>-->
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
import ArticleList from '../components/ArticleList.vue';
export default {
  name: 'Home',
  components: {
   // HelloWorld
   ArticleList
  }
}
</script>

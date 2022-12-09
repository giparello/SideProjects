<template>
  <div>
    <div id="page-header">
      <img v-bind:src="article.imageURL" />
      <div class="article-info">
          <h2>{{article.articleName }}</h2>
          <h4>{{article.articleMainPoint}}</h4>
          <h3 id="author"><i class="fa-solid fa-location-dot blue"></i> {{ article.articleId }}</h3>
        <h3><i class="fa-solid fa-phone blue"></i> {{ article.authorName }}</h3>
        <h3 id="hours"><i class="fa-solid fa-clock blue"></i>{{article.dateWritten}}</h3>
        
        <h4><i class="fa-solid fa-star"></i> Avg Rating and # of Comments here</h4>
      </div>
    </div>
    <div id="page-main">
      <h2>Our History</h2>
      <p>{{ this.$store.state.article.body }}</p>
    </div>
    
  </div>
</template>

<script>
import articleService from "../services/articleService"
export default {
    name:"brewery-detail",
    data(){
        return{
            errorMsg:""
        };
    },
    methods:{
        retrieveArticle(){
            articleService.getArticle(this.$route.params.id).then(response =>{
                this.$store.commit("SET_CURRENT_BREWERY", response.data);
            }).catch(error=>{
                if(error.response && error.response.status===404){
                    alert("Article not available");
                }
            });
        },
    },
    created(){
        this.retrieveArticle;
    },
    computed:{
        article(){
            return this.$store.state.article;
        },
    },
};
</script>

<style>

</style>
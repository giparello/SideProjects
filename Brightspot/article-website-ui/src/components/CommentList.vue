<template>
  <div>
      <section>
           
           <div class="add-commentbutton">
           <button class="add-commentbutton">ADD COMMENT</button>
           </div>
          <article class="comment-card"
          v-for="comment in comments"
          v-bind:key="comment.commentId"
          >
         
          <div class="comment-listinfo">
                <p>Reviwer Name: {{comment.reviewerName}}</p>
                <p>Date Posted: {{comment.dateWritten}}</p>
                <p>Rating: {{comment.articleRating}}/5</p>
            </div>
            <div class="comment-listheader">
                <h2>{{comment.commentHeader}}</h2>
            </div>
            
            <div class="comment-listbody">
                <p>{{comment.commentBody}}</p>
            </div>
            </article>

        </section>
        <div>
      </div>
  </div>
</template>

<script>
import commentService from "../services/commentService";
export default {
  name: "comment-list",
  data(){
      return{
          comments:[]
      };
  },
  methods: {
    viewCommentDetail(commentId){
        this.$router.push(`/comment/${commentId}`)
    },
},
created(){
    commentService.getCommentByArticleId(this.$route.params.id).then((response)=>{
        this.comments=response.data;
    });
},
};
</script>

<style>
</style>
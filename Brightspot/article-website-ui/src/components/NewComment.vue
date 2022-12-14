<template>
  <section class="form">
    <button v-on:click="displayForm()">Comment</button>
    <form v-show="showForm" @submit.prevent="addComment" class="form">
      <h1>Add a New Comment</h1>
      <div>
        <label class="sr-only">Name:</label>
        <input v-model="comment.name" placeholder="Name" type="text" />
      </div>
      <div>
        <label class="sr-only">Comment Body</label>
        <input v-model="comment.commentBody" placeholder="Comment Body" type="text" />
      </div>
      <div>
        <label class="sr-only">Article Rating</label>
        <input v-model="comment.articleRating" placeholder="Rating (1-5)" type="text" />
      </div>
      <label class="sr-only">Comment Header</label>
      <input v-model="comment.commentHeader" placeholder="Comment Header" type="text" />
      <div>
        <button type="submit" class="button">Submit</button>
        <button v-on:click.prevent="resetForm" class="button">Cancel</button>
        <p>{{this.comment.article_id}}</p>
      </div>
    </form>
  </section>
</template>

<script>
import commentService from "../services/commentService";
export default {
    methods:{
    addComment() {
      commentService.addNewComment(this.comment)
        .then((response) => {
          if (response.status ===201 || response.status===200) {
            this.$router.push(`/article/${this.$store.state.article.articleId}`)
          }
        })
        .catch((error) => {
          alert(error.response);
        });
    },
    resetForm() {
      this.showForm=false;
    },
    displayForm(){
      this.showForm=true;
    }
    },
  name: "new-comment",
  data() {
    return {
      message: "",
      showForm:false,
      comment: {
        article_id:this.$store.state.article.articleId,
        name: "",
        commentBody: "",
        articleRating: "",
        commentHeader: "",
      },
    };
  },
};
</script>

<style>
</style>
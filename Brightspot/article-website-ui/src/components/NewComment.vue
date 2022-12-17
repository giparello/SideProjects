<template>
  <!--create a form to leave a new comment-->
  <section class="comment-form">
    <!--button to click to open form-->
    <button class="form-button" v-show="!showForm" v-on:click="displayForm()">
      Add a new comment
    </button>
    <form v-show="showForm" @submit.prevent="addComment" class="form">
      <h1 class="add-comment-header">New Comment</h1>
      <div>
        <input
          class="text-input"
          v-model="comment.reviewerName"
          placeholder="Name"
          type="text"
        />
      </div>

      <input
        class="text-input"
        v-model="comment.commentHeader"
        placeholder="Comment Header"
        type="text"
      />
      <div>
        <input
          class="text-input"
          v-model="comment.commentBody"
          placeholder="Comment Body"
          type="text"
        />
      </div>
      <div>
        <label class="sr-only">Article Rating: </label>
        <select
          class="rating-input"
          v-model="comment.articleRating"
          placeholder="select"
          type="text"
        >
          <option></option>
          <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
        </select>
      </div>
      <!--submit and cancel buttons-->
      <div>
        <button type="submit" class="form-button">Submit</button>
        <button v-on:click.prevent="resetForm" class="form-button">
          Cancel
        </button>
      </div>
    </form>
  </section>
</template>

<script>
import commentService from "../services/commentService";
export default {
  methods: {
    //Method to add new comment and reset comment form
    addComment() {
      commentService
        .addNewComment(this.comment)
        .then((response) => {
          if (response.status === 201 || response.status === 200) {
            this.showForm = false;
            commentService.getAllComments;
            this.comment = {
              article_id: this.$store.state.article.articleId,
              reviewerName: "",
              commentBody: "",
              articleRating: "",
              commentHeader: "",
            };
          }
        })
        .catch((error) => {
          alert(error.response);
        });
    },
    //method to reset form
    resetForm() {
      this.showForm = false;
      this.comment = {
        article_id: this.$store.state.article.articleId,
        name: "",
        commentBody: "",
        articleRating: "",
        commentHeader: "",
      };
    },
    //method to display form
    displayForm() {
      this.showForm = true;
      this.comment = {
        article_id: this.$store.state.article.articleId,
        name: "",
        commentBody: "",
        articleRating: "",
        commentHeader: "",
      };
    },
  },
  //empty comment to be added
  name: "new-comment",
  data() {
    return {
      message: "",
      showForm: false,
      comment: {
        article_id: this.$store.state.article.articleId,
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
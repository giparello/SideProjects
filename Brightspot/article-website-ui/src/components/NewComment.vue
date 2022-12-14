<template>
  <section class="comment-form">
    <button class="form-button" v-on:click="displayForm()">Add a new comment</button>
    <form v-show="showForm" @submit.prevent="addComment" class="form">
      <h1 class="add-comment-header">Add a New Comment</h1>
      <div>
        <label class="sr-only">Name: </label>
        <input class="text-input" v-model="comment.reviewerName" placeholder="Name" type="text" />
      </div>
      <div>
        <label class="sr-only">Comment Body </label>
        <input class="text-input"
          v-model="comment.commentBody"
          placeholder="Comment Body"
          type="text"
        />
      </div>
      <div>
        <label class="sr-only">Article Rating: </label>
        <select
          v-model="comment.articleRating"
          placeholder="select"
          type="text"
        ><option></option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
      </div>
      <label class="sr-only">Comment Header: </label>
      <input
        v-model="comment.commentHeader"
        placeholder="Comment Header"
        type="text"
      />
      <div>
        <button type="submit" class="button">Submit</button>
        <button v-on:click.prevent="resetForm" class="button">Cancel</button>
        <p>{{ this.comment.article_id }}</p>
      </div>
    </form>
  </section>
</template>

<script>
import commentService from "../services/commentService";
export default {
  methods: {
    addComment() {
      commentService
        .addNewComment(this.comment)
        .then((response) => {
          if (response.status === 201 || response.status === 200) {
            this.showForm = false;
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
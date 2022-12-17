<template>
  <!--create a list of comments from the comments in the DB-->
  <div>
    <section class="card">
      <!--v-for loop to loop through card array and create comments-->
      <article
        class="comment-card"
        v-for="comment in comments"
        v-bind:key="comment.commentId"
      >
        <!--side info-->
        <div class="comment-listinfo">
          <p class="comment-inforating">Name: {{ comment.reviewerName }}</p>
          <p class="comment-inforating">
            Date Posted: {{ comment.dateWritten }}
          </p>
          <p class="comment-inforating">
            Rating: {{ comment.articleRating }}/5
          </p>
        </div>
        <!--comment header-->
        <div></div>
        <div class="comment-listheader">
          <h2>{{ comment.commentHeader }}</h2>
        </div>
        <!--comment body-->
        <div class="comment-listbody">
          <p>{{ comment.commentBody }}</p>
        </div>
      </article>
    </section>
    <div></div>
  </div>
</template>

<script>
import commentService from "../services/commentService";
export default {
  //get comment array
  name: "comment-list",
  data() {
    return {
      comments: [],
    };
  },
  //view a comment detail on click (future thing)
  methods: {
    viewCommentDetail(commentId) {
      this.$router.push(`/comment/${commentId}`);
    },
  },
  //get comments specific to the article
  created() {
    commentService
      .getCommentByArticleId(this.$route.params.id)
      .then((response) => {
        this.comments = response.data;
      });
  },
};
</script>

<style>
</style>
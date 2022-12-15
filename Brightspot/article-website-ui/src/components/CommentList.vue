<template>
  <div>
    <section class="card">
      <article
        class="comment-card"
        v-for="comment in comments"
        v-bind:key="comment.commentId"
      >
        <div class="comment-listinfo">
          <p class="comment-inforating">Name: {{ comment.reviewerName }}</p>
          <p class="comment-inforating">
            Date Posted: {{ comment.dateWritten }}
          </p>
          <p class="comment-inforating">
            Rating: {{ comment.articleRating }}/5
          </p>
        </div>
        <div></div>
        <div class="comment-listheader">
          <h2>{{ comment.commentHeader }}</h2>
        </div>

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
  name: "comment-list",
  data() {
    return {
      comments: [],
    };
  },
  methods: {
    viewCommentDetail(commentId) {
      this.$router.push(`/comment/${commentId}`);
    },
  },
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
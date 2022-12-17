<template>
  <!--create a comment detail page for (potentially) making comments clickable-->
  <div>
    <h1>{{ comment.commentBody }}</h1>
  </div>
</template>

<script>
import commentService from "../services/commentService";
export default {
  name: "comment-detail",
  methods: {
    //get specific comment
    retrieveComment() {
      commentService
        .getCommentByArticleId(this.$route.params.commentId)
        .then((response) => {
          this.$store.commit("SET_CURRENT_COMMENT", response.data);
        })
        .catch((error) => {
          if (error.response && error.response.status === 404) {
            alert("Comment not available");
          }
        });
    },
    data() {
      return {
        errorMsg: "",
      };
    },
  },
  //establish the comment
  created() {
    this.retrieveComment();
  },
  computed: {
    comment() {
      return this.$store.state.comment;
    },
  },
};
</script>

<style>
</style>
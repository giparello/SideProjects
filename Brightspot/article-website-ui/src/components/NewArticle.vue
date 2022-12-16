<template>
  <section class="article-form">
    <form @submit.prevent="addArticle" >
      <h1 class="add-article-header">New Article</h1>
      <div>
        <label class="sr-only"></label>
        <input
          class="article-text-input"
          v-model="article.authorName"
          placeholder="Author Name"
          type="text"
        />
      </div>
      <div>
        <label class="sr-only"></label>
        <input
          class="article-text-input"
          v-model="article.articleName"
          placeholder="Article Name"
          type="text"
        />
      </div>
      <label class="sr-only"></label>
      <input
        class="article-text-input"
        v-model="article.articleMainPoint"
        placeholder="Article Header"
        type="text"
      />
      <div>
        <label class="sr-only"></label>
        <textarea
          class="article-text-input new-article-body"
          v-model="article.articleBody"
          placeholder="Article Body"
          type="text"
        />
      </div>
      <div>
        <label class="sr-only"></label>
        <input
          class="article-text-input"
          v-model="article.dateWritten"
          placeholder="Date Written(YYYY-MM-DD)"
          type="text"
        />
      </div>
      <div>
        <label class="sr-only"></label>
        <input
          class="article-text-input"
          v-model="article.imageURL"
          placeholder="URL for an image"
          type="text"
        />
      </div>

      <label class="sr-only">Select a Tag </label>
      <select
        class="article-rating-input"
        v-model="article.tag"
        placeholder="select"
        type="text"
      >
        <option></option>
        <option>Tech</option>
        <option>Entertainment</option>
        <option>Sports</option>
        <option>Finance</option>
      </select>

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
import articleService from "../services/articleService";
export default {
  methods: {
    addArticle() {
      articleService
        .addNewArticle(this.article)
        .then((response) => {
          if (response.status === 201 || response.status === 200) {
            this.showForm = false;
            articleService.getAllArticles;
            this.article = {
              authorName: "",
              articleName: "",
              articleMainPoint: "",
              articleBody: "",
              dateWritten: "",
              imageURL: "",
              tag: "",
            };
          }
        })
        .catch((error) => {
          alert(error.response);
        });
    },
    resetForm() {
      this.showForm = false;
      this.article = {
        authorName: "",
        articleName: "",
        articleMainPoint: "",
        articleBody: "",
        dateWritten: "",
        imageURL: "",
        tag: "",
      };
    },
    displayForm() {
      this.showForm=!this.showForm
      this.article = {
        authorName: "",
        articleName: "",
        articleMainPoint: "",
        articleBody: "",
        dateWritten: "",
        imageURL: "",
        tag: "",
      };
    },
  },
  name: "new-article",
  data() {
    return {
      message: "",
      showForm: false,
      article: {
        authorName: "",
        articleName: "",
        articleMainPoint: "",
        articleBody: "",
        dateWritten: "",
        imageURL: "",
        tag: "",
      },
    };
  },
};
</script>

<style>
</style>
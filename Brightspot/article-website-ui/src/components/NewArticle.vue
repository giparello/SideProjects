<template>
  <!-- CREATE A FORM WHICH CAN ADD NEW ARTICLES-->
  <section class="article-form">
    <form @submit.prevent="addArticle">
      <h1 class="add-article-header">New Article</h1>
      <div>
        
        <input
          class="article-text-input"
          v-model="article.authorName"
          placeholder="Author Name"
          type="text"
        />
      </div>
      <div>
        
        <input
          class="article-text-input"
          v-model="article.articleName"
          placeholder="Article Name"
          type="text"
        />
      </div>
      
      <input
        class="article-text-input"
        v-model="article.articleMainPoint"
        placeholder="Article Header"
        type="text"
      />
      <div>
        
        <textarea
          class="article-text-input new-article-body"
          v-model="article.articleBody"
          placeholder="Article Body"
          type="text"
        />
      </div>
      <div>
        
        <input
          class="article-text-input"
          v-model="article.dateWritten"
          placeholder="Date Written(YYYY-MM-DD)"
          type="text"
        />
      </div>
      <div>
        
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
      <!--Submit and reset form buttons-->
      <div>
        <button type="submit" class="form-button">Submit</button>
        <button v-on:click.prevent="resetForm" class="form-button">
          Reset Form
        </button>
      </div>
    </form>
  </section>
</template>

<script>
import articleService from "../services/articleService";
export default {
  methods: {
    //METHOD TO ADD ARTICLE
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
    //METHOD TO RESET FORM
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
    //METHOD TO DISPLAY FORM, ALSO RESETS THE FORM
    displayForm() {
      this.showForm = !this.showForm;
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
  //DATA FOR A NEW ARTICLE
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
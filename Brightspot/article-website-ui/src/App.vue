<template>
  <!--create the main application-->
  <div>
    <!--header for every page-->
    <header>
      <!--page name-->
      <h1>
        <router-link v-bind:to="{ name: 'home' }">TechNews.com</router-link>
      </h1>
      <!-- nav bar with links to parts of site-->
      <nav>
        <div class="nav-links">
          <router-link class="header-link" v-bind:to="{ name: 'home' }"
            >Home</router-link
          >
          <router-link class="header-link" v-bind:to="{ name: 'TechArticles' }"
            >Tech</router-link
          >
          <router-link
            class="header-link"
            v-bind:to="{ name: 'EntertainmentArticles' }"
            >Entertainment</router-link
          >
          <router-link
            class="header-link"
            v-bind:to="{ name: 'SportsArticles' }"
            >Sports</router-link
          >
          <router-link
            class="header-link"
            v-bind:to="{ name: 'FinanceArticles' }"
            >Finance</router-link
          >
          <router-link
            class="header-link header-link-last"
            v-bind:to="{ name: 'ArticleForm' }"
            >Add New Article</router-link
          >
        </div>
      </nav>
    </header>
    <main>
      <router-view />
    </main>
  </div>
</template>

<style>
:root {
  --red: #fe1f3c;
  --white: rgb(0, 0, 0);
  --site-background-color: rgb(255, 255, 255);
  --page-header-font: Montserrat, sans-serif;
  --site-header-font: Ubuntu, sans-serif;
  --main-font: Roboto Slab, sans-serif;
  --info-background: rgba(0, 0, 0, 0.1);
  --nice-blue: rgba(44, 171, 255, 0.4);
}
* {
  padding: 0;
  margin: 0;
}
body {
  background-color: var(--site-background-color);
  font-family: var(--main-font);
}

/*****************************HEADER***************************** */
header {
  background-repeat: no-repeat;
  background-size: cover;
  height: 400px;
  position: relative;
}
header h1 {
  text-align: center;
  line-height: 200px;
  font-size: 6vw;
  font-family: var(--site-header-font);
  font-weight: 900;
}
header h1 a {
  color: var(--white);
  text-decoration: none;
}
/***************************NAV************************ */
nav {
  display: flex;
  justify-content: flex-end;
  color: white;
  padding: 20px;
}

nav div {
  display: flex;
  justify-content: center;
  gap: 5px;
}

nav a,
nav label,
#sort-options a {
  color: white;
}
.nav-links {
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  padding: 20px;
  border: solid black;
  background-color: black;
  box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
}
.header-link {
  color: white;
  text-decoration: none;
  text-align: center;
  width: 100%;
  height: 100%;
  border-left: solid white;
}
.header-link-last {
  border-right: solid white;
}
/****************************MAIN************************* */
main {
  margin-top: -70px;
  position: relative;
  z-index: 1;
}
#sort-options {
  display: flex;
  justify-content: flex-start;
  gap: 5px;
  color: white;
  margin: 0 50px;
}
.fa-star {
  color: var(--yellow);
}
/*****************************ARTICLE LIST CARDS****************** */
main #cards {
  display: flex;
  justify-content: center;
  justify-content: space-around;
  flex-wrap: wrap;
}
main #cards article {
  border: solid rgba(0, 0, 0, 0.377);
  background-color: white;
  text-align: center;
  display: block;
  margin: 10px;
  margin-bottom: 40px;
  width: 60%;
  height: 90%;
  box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
  position: relative;
  overflow: hidden;
  cursor: pointer;
  font-family: var(--page-header-font);
  border: 1px solid var(red);
}
.info {
  position: absolute;
  z-index: 2;
  padding: 0 5px;
  background-color: var(white);
  color: white;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  gap: 5px;
}
.info h2 {
  color: var(--white);
}
/*****************PAGE*******************/
.page {
  max-width: 90%;
  margin: 0 auto;
  background-color: white;
  box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
  position: relative;
  z-index: 1;
}
.page .header {
  display: flex;
  justify-content: space-around;
}
.page hr {
  margin: 10px 0;
  border: 2px solid black;
  border-radius: 10px;
}
.page p {
  margin: 15px 0;
}
#page-main {
  padding: 10px 20px;
}

/*******************FORMS********************/
.form {
  max-width: 600px;
  margin: 5px auto;
  margin-bottom: 10px;
  padding: 25px;
  border-radius: 20px;
  background-color: white;
  box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
}
.form-signin,
.form-register,
.form-article {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
}
.login h1,
.form h1 {
  text-align: center;
  font-size: 40px;
  font-family: var(--page-header-font);
}
.alert {
  margin: 5px 0;
  padding: 5px;
  border-radius: 5px;
}
.button {
  font-size: 15px;
  padding: 10px;
  border-radius: 5px;
  font-weight: bold;
  border: none;
  cursor: pointer;
  color: blue;
  background-color: var(--blue);
  text-decoration: none;
  margin: 10px;
}
.blue {
  color: blue;
  -webkit-text-stroke: 2px white;
}
.article-image {
  width: 100%;
  margin-bottom: -10px;
  position: relative;
  z-index: 1;
}

/*********************ARTICLE PAGE*******************/
#page-header {
  height: 100%;
}
.image-main {
  padding: 10px 20px;
}
#page-header img {
  width: 100%;
}
.article-info {
  text-align: center;
  background-color: white;
  color: black;
  padding: 20px;
  font-family: var(--page-header-font);
  font-size: 20px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  gap: 20px;
}

.article-sideinfo {
  font-size: 15px;
  font-family: var(--main-font);
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  margin: 10px;
}
.side-info {
  padding: 5px;
  background-color: rgba(44, 171, 255, 0.178);
  border: 2px solid rgba(44, 171, 255, 0.4);
  border-radius: 10px;
}
.article-rating {
  margin-bottom: 0px;
}
.article-mainpoint {
  margin: 10px;
  padding: 10px;
  text-align: center;
  border-top: solid var(--nice-blue);
  border-bottom: solid var(--nice-blue);
}
.article-body {
  text-align: center;
}
.rating {
  text-align: center;
}
.comment-link {
  font-size: 15px;
  font-family: var(--main-font);
  display: flex;
  flex-direction: row;
  justify-content: center;
}
.article-header {
  font-size: 45px;
  margin: 20px;
}

/************************ARTICLE LIST******************* */

.articleHeader {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.article {
  border-bottom: 5px solid var(--blue);
}
.article article {
  padding: 5px 0;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.article:last-child {
  border: none;
}

.article-info {
  display: block;
}
.article-image-container {
  border: none;
}
.article-image-container img {
  width: 200px;
  height: auto;
}
.article-btns {
  display: flex;
  justify-content: space-between;
}
.clicked-list {
  background-color: white;
}
/**************COMMENT-LIST**************/
.comment-card {
  border: solid rgba(0, 0, 0, 0.1);
  background-color: var(--info-background);
}
.comment-listinfo {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: flex-start;
  font-size: 15px;
  margin-left: 5px;
}
.comment-listheader {
  margin-left: 10px;
}
.comment-listbody {
  margin-left: 10px;
}
.add-commentbutton {
  display: flex;
  flex-direction: row;
  justify-content: center;
  padding: 5px;
}
.comment-info {
  padding: 3px;
  border: 2px solid rgba(44, 171, 255, 0.4);
  background-color: rgba(44, 171, 255, 0.4);
  border-radius: 10px;
}
.comment-inforating {
  width: 250px;
  border-left: solid var(--nice-blue);
  border-right: solid var(--nice-blue);
  padding: 10px;
  text-align: center;
}
.form-button {
  padding: 10px;
  border: 2px solid rgba(44, 171, 255, 0.4);
  background-color: rgba(44, 171, 255, 0.2);
  border-radius: 10px;
  margin: 20px;
}
.text-input {
  border: solid var(--nice-blue);
  border-radius: 5px;
  padding: 5px;
  margin: 5px;
}
/**************FINISHING TOUCHES************* */
.rating-input {
  border: solid var(--nice-blue);
  border-radius: 5px;
  padding: 5px;
  margin: 5px;
}
.article-body {
  text-align: center;
  font-size: 25px;
  border-top: solid var(--nice-blue);
  border-bottom: solid var(--nice-blue);
  padding: 20px;
}
.article-form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 80%;
}
.article-text-input {
  border: solid var(--nice-blue);
  border-radius: 5px;
  padding: 5px;
  margin: 5px;
  width: 500px;
}
.article-rating-input {
  border: solid var(--nice-blue);
  border-radius: 5px;
  padding: 5px;
  margin: 5px;
}
.new-article-body {
  height: 200px;
}
/***************DEVICE BREAKPOINTS************/
@media screen and (max-width: 900px) {
  .article-card {
    width: 90% !important;
  }
  .comment-card {
    text-align: center;
  }
  .article-form {
    width: 90%;
  }
  .article-text-input{
    width: 90%;
  }
  .nav-links{
    width: 90%;
  }
}
</style>

<template>
  <div>
    <header>
      <h1>
        <router-link v-bind:to="{ name: 'home' }">Article Website</router-link>
      </h1>
      <nav>
        <div class="nav-links">
          <router-link class="header-link" v-bind:to="{ name: 'home' }"
            >Home</router-link
          >
          <router-link class="header-link" v-bind:to="{ name: 'login' }"
            >Tech</router-link
          >
          <router-link class="header-link" v-bind:to="{ name: 'logout' }"
            >Medicine</router-link
          >
          <router-link class="header-link" v-bind:to="{ name: 'login' }"
            >Sports</router-link
          >
          <router-link class="header-link header-link-last" v-bind:to="{ name: 'logout' }"
            >Politics</router-link
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
.header-link-last{
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
  background-color: white;
  text-align: center;
  display: block;
  margin: 10px;
  width: 500px;
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

/*******************LOGIN/REGISTER/FORMS********************/
.form {
  max-width: 400px;
  margin: 0 auto;
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
.alert-danger {
  background-color: red;
  color: white;
}
.alert-success {
  background-color: green;
  color: white;
}
.button {
  font-size: 15px;
  padding: 10px;
  border-radius: 5px;
  font-weight: bold;
  border: none;
  cursor: pointer;
  color: white;
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

input[type="radio"] {
  display: none;
}

.radio-button {
  background-color: rgba(0, 0, 255, 0.5);
  padding: 5px 10px;
  border-radius: 5px;
  color: white;
  box-shadow: inset 0 -0.6em 0 -0.35em rgba(0, 0, 0, 0.17);
  cursor: pointer;
  margin: 0 5px;
}

input:checked + label {
  background-color: rgba(0, 0, 255, 1);
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
  text-align: center;
  justify-content: space-around;
  align-content:center;
}
.article-rating {
  margin-bottom: 0px;
}
.article-mainpoint {
  text-align: center;
}
.article-body {
  text-align: center;
}
.rating {
  text-align: center;
}
.comment-link{
  font-size: 15px;
  font-family: var(--main-font);
  display: flex;
  flex-direction: row;
  justify-content: center;
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
.clicked-list{
  background-color: white;
}
/**************COMMENT-LIST**************/
.comment-card{
  border:solid rgba(0, 0, 0, 0.1);
  background-color: var(--info-background);
}
.comment-listinfo{
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}
.add-commentbutton{
  padding: 5px;
}


/***************DEVICE BREAKPOINTS************/
@media screen and (max-width: 900px) {
  .article-card {
    width: 90% !important;
  }
}
</style>

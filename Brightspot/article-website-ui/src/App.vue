<template>
  <div id="app">
    <header>
    <nav>
      <div>
      <router-link to="/">Home</router-link> |
    </div>
    <main>
    <router-view/>
    </main>
    </nav>
    </header>
  </div>
</template>

<style>
:root{
    --red: #fe1f3c;
    --blue: rgb(255, 255, 255);
    --site-background-color: rgba(30,30,30,1);
    --page-header-font: Montserrat, sans-serif;
    --site-header-font: Ubuntu, sans-serif;
    --main-font: Roboto Slab, sans-serif;
    --info-background: rgba(0,0,0,0.5);
}
*{
  padding:0;
  margin:0;
}
body{
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
    line-height: 300px;
    font-size: 7vw;
    font-family: var(--site-header-font);
    font-weight: 900;
}
header h1 a {
    color: var(--yellow);
    text-decoration: none;
    
    text-shadow: 2px 2px black;
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
/****************************MAIN************************* */
main #cards {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
}
main #cards article {
    background-color: white;
    display: block;
    margin: 10px;
    width: 400px;
    height: 200px;
    box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
    position: relative;
    overflow: hidden;
    cursor: pointer;
    font-family: var(--page-header-font);
    border: 1px solid var(--yellow);
}
.info {
    position: absolute;
    z-index: 2;
    padding: 0 5px;
    background-color: var(--info-background);
    color: white;
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    gap: 5px;
}
.info h2 {
  color:var(--yellow);
}

/*****************************ARTICLE LIST CARDS****************** */
main #cards{
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
}
main #cards article{
  background-color: white;
  display: block;
  margin: 10px;
  width: 400px;
  height: 200px;
  box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
  position: relative;
  overflow: hidden;
  cursor: pointer;
  font-family: var(--page-header-font);
  border: 1px solid var(red);
}
.info{
  position: absolute;
  z-index: 2;
  padding: 0 5px;
  background-color: var(--info-background);
  color: white;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  gap: 5px;
}
.info h2{
  color: var(--red);
}
</style>

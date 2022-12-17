import axios from 'axios';
//establish the base URL
const http = axios.create({
    baseURL: "http://localhost:3000"
})
//use axios to connect with the API at endpoints
export default {
    getAllArticles() {
        return http.get('/article');
    },
    getArticle(articleId) {
        return http.get(`/article/${articleId}`)
    },
    addNewArticle(article) {
        return http.post(`/article`, article)
    },
    getArticleByTag(tag) {
        return http.get(`article/type/${tag}`)
    }
}
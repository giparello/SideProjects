import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
})

export default{
    getAllArticles(){
        return http.get('/article');
    },
    getArticle(articleId){
        return http.get(`/article/${articleId}`)
    },
    addNewArticle(article){
        return http.post(`/article`, article)
    },
    getArticleByTag(tag){
        return http.get(`article/type/${tag}`)
    }
}
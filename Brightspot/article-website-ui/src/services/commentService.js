import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
})

export default{
    getAllComments(){
        return http.get(`/comment`);
    },
    getCommentByArticleId(articleId){
        return http.get(`/comment/${articleId}`);
    },
    addNewComment(comment){
        return http.post(`/comment`, comment)
    }
}
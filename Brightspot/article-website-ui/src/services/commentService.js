import axios from 'axios';
//establish base URL
const http = axios.create({
    baseURL: "http://localhost:3000"
})
//use axios to link to API and endpoints
export default {
    getAllComments() {
        return http.get(`/comment`);
    },
    getCommentByArticleId(articleId) {
        return http.get(`/comment/${articleId}`);
    },
    addNewComment(comment) {
        return http.post(`/comment`, comment)
    }
}
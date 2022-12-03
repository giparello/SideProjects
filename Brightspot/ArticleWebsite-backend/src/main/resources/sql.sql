Begin Transaction;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS articles;
DROP TABLE IF EXISTS article_comments;
DROP TABLE IF EXISTS article_comment_FKs;



CREATE TABLE users(
    user_id serial,
	password varchar(255),
    role varchar (255),
	CONSTRAINT pk_user PRIMARY KEY (user_id)
);
CREATE TABLE article_comments (
    comment_id serial,
	reviewer_name varchar(255),
    comment_body varchar(255) ,
	date_written DATE,
   	article_rating int,
	CONSTRAINT pk_commentId PRIMARY KEY (comment_id)
);
CREATE TABLE articles(
	article_id serial,
	comment_id int,
	author_name varchar(255),
	article_body TEXT,
	date_written DATE,
	CONSTRAINT pk_articleId PRIMARY KEY (article_id)
);
CREATE TABLE article_comment_FKs(
	comment_id int,
	article_id int,
	FOREIGN KEY (comment_id) REFERENCES article_comments(comment_id),
	FOREIGN KEY (article_id) REFERENCES articles(article_id)
	);
COMMIT;

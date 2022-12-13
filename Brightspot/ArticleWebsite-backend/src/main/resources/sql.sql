Begin Transaction;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS article_comments;
DROP TABLE IF EXISTS articles;


CREATE TABLE users(
    user_id serial,
	password varchar(255),
    role varchar (255),
	CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE articles(
	article_id serial,
	author_name varchar(255),
	article_name varchar(255),
	article_main_point varchar(255),
	article_body TEXT,
	date_written DATE,
	image_URL TEXT,
	tag varchar(255),
	CONSTRAINT pk_articleId PRIMARY KEY (article_id)
);
CREATE TABLE article_comments (
    comment_id serial,
	reviewer_name varchar(255),
    comment_body varchar(255) ,
	date_written DATE,
   	article_rating int,
   	article_id int,
   	comment_header varchar(255),
	CONSTRAINT pk_commentId PRIMARY KEY (comment_id),
	CONSTRAINT fk_article_id FOREIGN KEY (article_id) REFERENCES articles (article_id)
);

COMMIT;

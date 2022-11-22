Begin Transaction;
DROP TABLE IF EXISTS friend;
DROP TABLE IF EXISTS users;



CREATE TABLE users(
    user_id serial,
	password varchar(255),
    role varchar (255),
	CONSTRAINT pk_user PRIMARY KEY (user_id)
);
CREATE TABLE friend (
    friend_id serial,
	user_id int,
    last_name varchar(255) ,
    first_name varchar(255) NOT NULL,
    phone_Number char(10),
    city varchar(255),
	last_time_called DATE,
	birthday DATE,
	life_events varchar (255),
	CONSTRAINT pk_friend PRIMARY KEY (friend_id),
	CONSTRAINT fk_userID FOREIGN KEY (user_id) REFERENCES users(user_id)
);
COMMIT;

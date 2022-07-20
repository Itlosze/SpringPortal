DROP TABLE IF EXISTS Writer;

CREATE TABLE Writer(
 id bigint auto_increment NOT NULL,
 name varchar(110), 
 age int,
 PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Content;

CREATE TABLE Content(
 id bigint auto_increment NOT NULL,
 title varchar(150), 
 text varchar(404),
 posted date,
 writer_id int,
 PRIMARY KEY (id)
);
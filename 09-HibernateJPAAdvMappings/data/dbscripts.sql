USE demodb;
  
-- DROP TABLE t_author;
CREATE TABLE t_author (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  firstName VARCHAR(50) NOT NULL,
  lastName VARCHAR(50) NOT NULL,
  gender VARCHAR(1),
  authorContactId INT,
  CONSTRAINT fk_authorContact FOREIGN KEY (authorContactId) REFERENCES t_author_contact(id)
);

-- DROP TABLE t_author_contact;
CREATE TABLE t_author_contact (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(100) NOT NULL,
  website VARCHAR(200)
);

-- DROP TABLE t_post;
CREATE TABLE t_post (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  content VARCHAR(1000) NOT NULL,
  authorId INT
);

-- DROP TABLE t_post_comment;
CREATE TABLE t_post_comment (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  comments VARCHAR(500) NOT NULL,
  authorId INT,
  postId INT NOT NULL,
  FOREIGN KEY (postId) REFERENCES t_post(id)
);
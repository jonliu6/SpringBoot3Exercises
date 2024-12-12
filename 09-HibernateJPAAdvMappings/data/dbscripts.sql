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

-- One-to-One relationship between Author and Author Contact
-- DROP TABLE t_author_contact;
CREATE TABLE t_author_contact (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(100) NOT NULL,
  website VARCHAR(200)
);

-- Many-To-One relationship between Post and Author
-- DROP TABLE t_post;
CREATE TABLE t_post (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  content VARCHAR(1000) NOT NULL,
  authorId INT,
  CONSTRAINT fk_author FOREIGN KEY (authorId) REFERENCES t_author(id)
);

-- One-to-Many between Post and Comments
-- DROP TABLE t_comment;
CREATE TABLE t_comment (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  comment VARCHAR(500) NOT NULL,
  postId INT,
  FOREIGN KEY (postId) REFERENCES t_post(id)
);

-- Many-to-Many between Posts and References - One Post have multiple References, and one Reference can be used in multiple Posts
-- DROP TABLE t_reference;
CREATE TABLE t_reference (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  referenceType VARCHAR(50),
  reference VARCHAR(1000)
);

-- DROP TABLE t_post_reference;
CREATE TABLE t_post_reference (
  postId INT,
  referenceId INT,
  CONSTRAINT pk_post_reference PRIMARY KEY (postId, referenceId)
);
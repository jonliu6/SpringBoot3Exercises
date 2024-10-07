USE demodb;

--DROP TABLE t_article;
CREATE TABLE t_article (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  title VARCHAR(500) NOT NULL,
  category VARCHAR(100) NOT NULL,
  content VARCHAR(2000)
);

-- DROP TABLE t_category;
CREATE TABLE t_category (
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  category VARCHAR(100) NOT NULL,
  parentId INT
);

INSERT INTO t_category (Category, ParentId)
  VALUES ('Programming',0);
INSERT INTO t_category (Category, ParentId)
  VALUES ('Database',0);
INSERT INTO t_category (Category, ParentId)
  VALUES ('Java',1);
INSERT INTO t_category (Category, ParentId)
  VALUES ('MySQL',2);

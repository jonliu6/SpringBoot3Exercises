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

-- The default Spring Security JDBC user and role tables. NOTE: table names and column names need to be the exact. authorities start with "ROLE_".
-- DROP TABLE users;
CREATE TABLE users (
  username VARCHAR(50) NOT NULL PRIMARY KEY,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL
);

INSERT INTO users (username, password, enabled)
  VALUES ('jon','{noop}test123',1);
INSERT INTO users (username, password, enabled)
  VALUES ('shirley','{noop}test123',1);
INSERT INTO users (username, password, enabled)
  VALUES ('alex','{noop}test123',1);

-- DROP TABLE authorities;
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  UNIQUE KEY idx_user_auth (username, authority),
  CONSTRAINT fk_auth_username FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO authorities (username, authority)
  VALUES ('jon','ROLE_READER');
INSERT INTO authorities (username, authority)
  VALUES ('shirley','ROLE_READER');
INSERT INTO authorities (username, authority)
  VALUES ('shirley','ROLE_CONTRIBUTOR');
INSERT INTO authorities (username, authority)
  VALUES ('alex','ROLE_READER');
INSERT INTO authorities (username, authority)
  VALUES ('alex','ROLE_CONTRIBUTOR');
INSERT INTO authorities (username, authority)
  VALUES ('alex','ROLE_ADMIN');

-- The following 2 custom tables are used by Spring Security JDBC authentication and authorization.
-- DROP TABLE t_user;
CREATE TABLE t_user (
  user_id VARCHAR(50) NOT NULL PRIMARY KEY,
  user_pass VARCHAR(100) NOT NULL,
  is_active VARCHAR(10) NOT NULL -- instead of TINYINT
);
INSERT INTO t_user (user_id, user_pass, is_active)
  VALUES ('jon','{bcrypt}$2a$10$2BT0peH2lTyVEdQRwiCbmeqJNn/ahVLlvcRboLm1tCbXL9hVsjhKG','ACTIVE');
INSERT INTO t_user (user_id, user_pass, is_active)
  VALUES ('nancy','{bcrypt}$2a$10$2BT0peH2lTyVEdQRwiCbmeqJNn/ahVLlvcRboLm1tCbXL9hVsjhKG','ACTIVE');
INSERT INTO t_user (user_id, user_pass, is_active)
  VALUES ('shirley','{bcrypt}$2a$10$2BT0peH2lTyVEdQRwiCbmeqJNn/ahVLlvcRboLm1tCbXL9hVsjhKG','DISABLED');
INSERT INTO t_user (user_id, user_pass, is_active)
  VALUES ('alex','{bcrypt}$2a$10$2BT0peH2lTyVEdQRwiCbmeqJNn/ahVLlvcRboLm1tCbXL9hVsjhKG','ACTIVE');

-- DROP TABLE t_role;
CREATE TABLE t_role (
  user_id VARCHAR(50) NOT NULL,
  user_role VARCHAR(50) NOT NULL,
  CONSTRAINT pk_uid_role PRIMARY KEY (user_id, user_role)
);
INSERT INTO t_role (user_id, user_role)
  VALUES ('jon','ROLE_READER');
INSERT INTO t_role (user_id, user_role)
  VALUES ('shirley','ROLE_READER');
INSERT INTO t_role (user_id, user_role)
  VALUES ('shirley','ROLE_CONTRIBUTOR');
INSERT INTO t_role (user_id, user_role)
  VALUES ('nancy','ROLE_READER');
INSERT INTO t_role (user_id, user_role)
  VALUES ('nancy','ROLE_CONTRIBUTOR');
INSERT INTO t_role (user_id, user_role)
  VALUES ('alex','ROLE_READER');
INSERT INTO t_role (user_id, user_role)
  VALUES ('alex','ROLE_CONTRIBUTOR');
INSERT INTO t_role (user_id, user_role)
  VALUES ('alex','ROLE_ADMIN');

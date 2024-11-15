DROP TABLE t_registered_user;
CREATE TABLE t_registered_user (
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  age INT,
  occupation VARCHAR(80),
  gender VARCHAR(30),
  email VARCHAR(100),
  postal_code VARCHAR(10),
  CONSTRAINT pk_registered_user PRIMARY KEY (email)
);
DROP TABLE IF EXISTS employee;
 
CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  age INT NOT NULL,
  gender VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS credentials;

CREATE TABLE credentials (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);

insert into credentials(user,password) values('admin','password@1');  
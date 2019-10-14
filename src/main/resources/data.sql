

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,

);

INSERT INTO users (name, password) VALUES
  ('Shermayne', '123456'),
  ('Florian', '123456');

DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250),
  email VARCHAR(250)
);

INSERT INTO user(name, email)
VALUES 
('Burdy', 'burdy.rsou@gmail.com'),
('Mehdi', 'mehdi@gmail.com'),
('Tiphaine', 'tiiji@gmail.com'),
('Samuel', 'samuel@gmail.com'),
('Lea', 'leamoui.sp@gmail.com'),
('Anne', 'annita.foi@gmail.com');

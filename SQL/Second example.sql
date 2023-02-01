

CREATE TABLE users (
userID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
username varchar(45) NOT NULL,
password varchar(45) NOT NULL,
fullname varchar (150) NOT NULL,
email varchar(45)
);
INSERT INTO users (username, password, fullname, email)
VALUES ('trumpwall', 'mexico', 'Donald Trump', 'maga@gmail.com');
INSERT INTO users (username, password, email, fullname) VALUES ('obama', 'Hawai', 'barack@gmail.com', 'BARACK OBAMA');
INSERT INTO users (username, password, fullname) VALUES ('biden', 'Hawai', 'BARACK OBAMA');

SELECT * FROM users;

DROP TABLE IF EXISTS users;

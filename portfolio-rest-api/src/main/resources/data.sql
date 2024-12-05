
-- In-memory database schema

CREATE TABLE IF NOT EXISTS `users` (
    `user_id` integer AUTO_INCREMENT  PRIMARY KEY,
    `name` varchar(100) ,
    `address` varchar(10) NOT NULL,
    `email_id` varchar(100) NOT NULL);

CREATE TABLE IF NOT EXISTS `portfolio` (
    `symbol` varchar(100) PRIMARY KEY,
    `quantity` integer NOT NULL,
    `invested` numeric(30,15) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `user_id` integer,
    FOREIGN KEY (user_id) REFERENCES users(user_id));

INSERT INTO users ( name, address,email_id) VALUES ('John Doe', 'USA', 'john.doe@gmail.com');

INSERT INTO portfolio (symbol, quantity,invested,created_at, user_id) VALUES ('IBM', 10, 100.00, {ts '2012-09-17 18:47:52.69'},1);
INSERT INTO portfolio (symbol, quantity,invested,created_at, user_id) VALUES ('NVDA', 4, 50.00, {ts '2012-09-17 18:47:52.69'},1);
INSERT INTO portfolio (symbol, quantity,invested,created_at, user_id) VALUES ('AIEV', 6, 25.30, {ts '2012-09-17 18:47:52.69'},1);
INSERT INTO portfolio (symbol, quantity,invested,created_at, user_id) VALUES ('GDSTW', 9, 200.30, {ts '2012-09-17 18:47:52.69'},1);
INSERT INTO portfolio (symbol, quantity,invested,created_at, user_id) VALUES ('APLT', 10, 120.30, {ts '2012-09-17 18:47:52.69'},1);
INSERT INTO portfolio (symbol, quantity,invested,created_at, user_id) VALUES ('ONMDW', 5, 130.30, {ts '2012-09-17 18:47:52.69'},1);
INSERT INTO portfolio (symbol, quantity,invested,created_at, user_id) VALUES ('CLRCR', 6, 30.30, {ts '2012-09-17 18:47:52.69'},1);
INSERT INTO portfolio (symbol, quantity,invested,created_at, user_id) VALUES ('PTIXW', 8, 300.30, {ts '2012-09-17 18:47:52.69'},1);
INSERT INTO portfolio (symbol, quantity,invested,created_at, user_id) VALUES ('BSLK', 3, 60.30, {ts '2012-09-17 18:47:52.69'},1);
INSERT INTO portfolio (symbol, quantity,invested,created_at, user_id) VALUES ('PRZO', 8, 50.30, {ts '2012-09-17 18:47:52.69'},1);

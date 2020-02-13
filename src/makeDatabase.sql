DROP DATABASE IF EXISTS bankbase;
DROP USER IF EXISTS 'bankbase'@'localhost';
CREATE USER 'bankbase' @'localhost' IDENTIFIED VIA mysql_native_password USING '12345678901234567890123456789012345678901';
GRANT USAGE ON *.* TO 'bankbase' @'localhost' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
CREATE DATABASE IF NOT EXISTS `bankbase`;
GRANT ALL PRIVILEGES ON `bankbase`.* TO 'bankbase' @'localhost';

use bankBase;
CREATE TABLE bankAccounts (
  id int NOT NULL AUTO_INCREMENT,
  naam VARCHAR(255) NOT NULL,
  pin int NOT NULL,
  cartNumber int NOT NULL,
  balance int,
  PRIMARY key (id)
);
INSERT INTO bankAccounts (naam, pin, cartNumber, balance)
VALUES
  ('testUser', 1, 1, 0);

CREATE TABLE transfers (
    userid int,
    amount int
);

INSERT INTO transfers(userid, amount) VALUES
(1, 100);

update bankAccounts set balance=100 where id = 1;
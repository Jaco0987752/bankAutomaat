DROP DATABASE IF EXISTS bankbase;
DROP USER IF EXISTS 'bankbase'@'localhost';
CREATE USER 'bankbase' @'localhost' IDENTIFIED VIA mysql_native_password USING '*HASHOFPASSWORDHERE';
GRANT USAGE ON *.* TO 'bankbase' @'localhost' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
CREATE DATABASE IF NOT EXISTS `bankbase`;
GRANT ALL PRIVILEGES ON `bankbase`.* TO 'bankbase' @'localhost';

use bankbase;

CREATE TABLE users(
  id int NOT NULL AUTO_INCREMENT,
  status ENUM('disabled','enabled','deleted') DEFAULT 'enabled',
  madeDate dateTime DEFAULT NOW(),
  foreName VARCHAR(50) NOT Null,
  lastName VARCHAR(50) NOT Null,
  digitalAddress VARCHAR(50),
  password longtext,
  PRIMARY key (id)
);

#test
INSERT INTO users (foreName, lastName, digitalAddress, password) VALUES
  ('testUser', 'userTest', 'testUser@test.com', 'password');

CREATE TABLE bankaccounts (
  id int NOT NULL AUTO_INCREMENT,
  accountname VARCHAR(50) NOT NULL,
  userid int,
  status ENUM('disabled','enabled','deleted') DEFAULT 'enabled',
  madeDate dateTime DEFAULT NOW(),
  description VARCHAR(255),
  balance int,
  pin int,
  loginFailures int DEFAULT 0,
  cartNumber int,
  PRIMARY key (id),
  FOREIGN KEY (userid) REFERENCES users(id)
  );

# Test
INSERT INTO bankaccounts (accountname, userid, balance,  description,  pin, cartNumber) VALUES
  ('testAccount',(select id from users where foreName = 'testUser'), 100, 'testAcount description',1,1);

CREATE TABLE banks (
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    status ENUM('disabled','enabled','deleted') DEFAULT 'disabled',
    PRIMARY key (id)
);

INSERT INTO banks(name, status) VALUES
('SELF', 'enabled');

CREATE TABLE transfers (  
    id int NOT NULL AUTO_INCREMENT,
    bank int,
    recieverBankaccountId int NOT NULL,
    amount int NOT NULL,
    senderAccountId int NOT NULL,
    date dateTime DEFAULT NOW(),
    description VARCHAR(255),
    PRIMARY key (id),
    FOREIGN KEY (recieverBankaccountId) REFERENCES users(id)
);

# Test
INSERT INTO transfers (recieverBankaccountId, bank, amount, senderAccountId, description) VALUES
(1, 1, 100, 1, 'testTransaction');

update bankaccounts set balance=100 where id = 1;

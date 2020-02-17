DROP DATABASE IF EXISTS bankbase;
DROP USER IF EXISTS 'bankbase'@'localhost';
CREATE USER 'bankbase' @'localhost' IDENTIFIED VIA mysql_native_password USING '*HASHOFPASSWORD86375B63421741C80E3E6564A0';
GRANT USAGE ON *.* TO 'bankbase' @'localhost' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
CREATE DATABASE IF NOT EXISTS `bankbase`;
GRANT ALL PRIVILEGES ON `bankbase`.* TO 'bankbase' @'localhost';

use bankbase;

CREATE TABLE users(
  id int NOT NULL AUTO_INCREMENT,
  status ENUM('disabled','enabled','deleted'),
  foreName VARCHAR(50) NOT Null,
  lastName VARCHAR(50) NOT Null,
  digitalAddress VARCHAR(50),
  passWord longtext,
  PRIMARY key (id)
);

#test
INSERT INTO users (foreName, lastName, digitalAddress, passWord) VALUES
  ('testUser', 'userTest', 'testUser@test.com', 'password');

CREATE TABLE bankaccounts (
  id int NOT NULL AUTO_INCREMENT,
  accountName VARCHAR(50) NOT NULL,
  userid int,
  status ENUM('disabled','enabled','deleted'),
  description VARCHAR(255),
  balance int,
  pin int,
  loginFailures int,
  cartNumber int,
  PRIMARY key (id)
);

# Test
INSERT INTO bankaccounts (accountName, userid, balance,  description,  pin, cartNumber) VALUES
  ('testAccount',(select id from users where foreName = 'testUser'), 100, 'testAcount description',1,1);

CREATE TABLE transfers (  
    id int NOT NULL AUTO_INCREMENT,
    recieverBankaccountId int NOT NULL,
    recieverUserId int NOT NULL,
    amount int NOT NULL,
    senderUserId int NOT NULL,
    senderAccountId int NOT NULL,
    status ENUM('awaiting','done','failed'),
    description VARCHAR(255),
    PRIMARY key (id)
);

# Test
INSERT INTO transfers (recieverBankaccountId, recieverUserId, amount, senderUserId, senderAccountId, description) VALUES
(1, 1, 100, 1, 1, 'testTransaction');

update bankaccounts set balance=100 where id = 1;

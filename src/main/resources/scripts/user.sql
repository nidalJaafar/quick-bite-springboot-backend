DROP DATABASE IF EXISTS `quick-bite-springboot-backend`;
DROP USER IF EXISTS 'quick-bite-springboot-admin'@'localhost';

CREATE DATABASE `quick-bite-springboot-backend`;
CREATE USER 'quick-bite-springboot-admin'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `quick-bite-springboot-backend`. * TO 'quick-bite-springboot-admin'@'localhost';
FLUSH PRIVILEGES;
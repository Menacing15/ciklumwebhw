# ciklumwebhw - ciklum web homework
To run the code firstly you need to create a database, use following commands: 
CREATE DATABASE ciklumtask; 
CREATE USER 'ciklumuser'@'localhost' IDENTIFIED BY '1234'; 
GRANT ALL PRIVILEGES ON ciklumtask.* TO 'ciklumuser'@'localhost'; 
CREATE TABLE ciklumtask.web(action varchar(255), data varchar(255);

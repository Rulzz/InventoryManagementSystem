--Database schema file for the production db.
--Currently, this will reset the MySQL database each time the program is ran.
--You will need to expand this schema to include any relevant tables.
DROP SCHEMA `ims`;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims`;

create table customers(
   id INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   PRIMARY KEY ( id )
);

create table items(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(255) NOT NULL,
   cost float(10,2) NOT NULL,
   PRIMARY KEY ( id )
);

create table orders(
   id INT NOT NULL,
   value float(10,2) NOT NULL,
   PRIMARY KEY ( id )
);

create table Order_Items(
   order_id INT NOT NULL,
   item_id INT NOT NULL,
   quantity INT NOT NULL,
   PRIMARY KEY ( order_id, item_id )
);
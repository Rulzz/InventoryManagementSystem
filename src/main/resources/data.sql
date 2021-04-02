--Database dummy-data file for the production db.
--Currently, this will be picked up by the MySQL database each time the program is ran, after being reset to the contents of your schema file.
--You will need to expand this file to include any relevant dummy-data.

INSERT INTO Customers (first_name, last_name) VALUES ('Raj', 'Inamdar');
INSERT INTO Customers (first_name, last_name) VALUES ('Julia', 'Roberts');
INSERT INTO Customers (first_name, last_name) VALUES ('Emma', 'Watson');
INSERT INTO Customers (first_name, last_name) VALUES ('Brad', 'Pitt');
INSERT INTO Customers (first_name, last_name) VALUES ('Tom', 'Hanks');


INSERT INTO Items (name, cost) VALUES ('Chair', 150.75);
INSERT INTO Items (name, cost) VALUES ('Table', 65);
INSERT INTO Items (name, cost) VALUES ('Laptop', 1200.50);
INSERT INTO Items (name, cost) VALUES ('Speaker', 90);
INSERT INTO Items (name, cost) VALUES ('TV', 675.25);

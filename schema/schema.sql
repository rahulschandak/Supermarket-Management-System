
DROP DATABASE IF EXISTS supermarketDB;
CREATE DATABASE supermarketDB;
use supermarketDB;

CREATE TABLE location (
	ID INT PRIMARY KEY AUTO_INCREMENT,
    StreetNo INT NOT NULL,
	StreetName varchar(100) NOT NULL,
	ZipCode INT NOT NULL,
    CONSTRAINT UNIQUE(StreetNo, StreetName, ZipCode)
);

CREATE TABLE supermarket (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	Name varchar(100) NOT NULL,
	LocationID INT NOT NULL,
	CONSTRAINT FOREIGN KEY (LocationID) REFERENCES location(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE customer (
	ID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName varchar(100) NOT NULL,
    LastName varchar(100),
    DOB DATE NOT NULL
);

CREATE TABLE customer_credentials (
	ID INT PRIMARY KEY,
    Username varchar(100) UNIQUE NOT NULL,
    UserPassword varchar(16) NOT NULL,
    CONSTRAINT FOREIGN KEY (ID) REFERENCES customer(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE orders (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    OrderDate DATE,
    Amount INT
);

CREATE TABLE product_categories (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName varchar(100) NOT NULL UNIQUE
);


CREATE TABLE product (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    ProductName varchar(100) UNIQUE NOT NULL,
    Category INT NOT NULL,
    AvailableQuantity INT NOT NULL DEFAULT 0 CHECK (AvailableQuantity >= 0),
    Price INT NOT NULL CHECK(Price > 0),
	CONSTRAINT FOREIGN KEY (Category) REFERENCES product_categories(ID) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE supermarket_products (
	SupermarketID int not null,
    ProductID int not null,
    PRIMARY KEY ( SupermarketID, ProductID),
	CONSTRAINT FOREIGN KEY (SupermarketID) REFERENCES supermarket(ID) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (ProductID) REFERENCES product(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE order_line_items (
    OrderID int NOT NULL,
    ProductID int NOT NULL,
    Quantity int NOT NULL,
    CONSTRAINT PRIMARY KEY (OrderID, ProductID),
	CONSTRAINT FOREIGN KEY (OrderID) REFERENCES orders(ID) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY (ProductID) REFERENCES product(ID) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT CHECK (Quantity >=0)
);


CREATE TABLE customer_orders ( 
	CustomerID INT NOT NULL,
    OrderID INT UNIQUE NOT NULL,
    SupermarketID int NOT NULL,
    CONSTRAINT PRIMARY KEY (CustomerID, OrderID, SupermarketID),
	CONSTRAINT FOREIGN KEY (CustomerID) REFERENCES customer(ID) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (OrderID) REFERENCES orders(ID) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY (SupermarketID) REFERENCES supermarket(ID) ON UPDATE CASCADE ON DELETE CASCADE
);



-- EMPLOYEE 

CREATE TABLE employee (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	SupermarketID INT DEFAULT 1,
    Name varchar(100) NOT NULL,
    StartDate DATE NOT NULL,
	EmployeeRole ENUM('Admin','InventoryManager','Regular'),
    CONSTRAINT FOREIGN KEY (SupermarketID) REFERENCES supermarket(ID) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE employee_credentials (
	ID INT PRIMARY KEY,
    Username varchar(1000) NOT NULL,
    UserPassword varchar(16) NOT NULL,
    CONSTRAINT FOREIGN KEY (ID) REFERENCES employee(ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE employee_workinghours (
	ID INT NOT NULL,
    Date DATE NOT NULL,
    LoginTime TIME NOT NULL,
    LogoutTime TIME NOT NULL,
    PRIMARY KEY(ID, DATE),
    CONSTRAINT FOREIGN KEY (ID) REFERENCES employee(ID) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT CHK_LOGOUTTIME CHECK (LogoutTime > LoginTime)
);




use supermarketDB;
DROP PROCEDURE IF EXISTS createEmployee;
DELIMITER //
CREATE PROCEDURE createEmployee(
    employeeName varchar(100),
    employeeDOB date,
	employeeRole VARCHAR(100),
	employeeUsername varchar(100),
    employeePassword varchar(16)
    )
BEGIN
	DECLARE count INT;
    DECLARE ID INT;
	SELECT EXISTS(SELECT 1 FROM employee_credentials WHERE Username = employeeUsername) into count;
	IF (count = 0) THEN
			INSERT INTO employee (Name, StartDate, EmployeeRole) VALUES (employeeName, employeeDOB, employeeRole);
			SELECT LAST_INSERT_ID() into ID;
			INSERT into employee_credentials(ID, Username, UserPassword) values (ID, employeeUsername, employeePassword);
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Username already exists';
    END IF;
END //


use supermarketDB;
DROP PROCEDURE IF EXISTS getEmployeeWorkingHours;
DELIMITER //
CREATE PROCEDURE getEmployeeWorkingHours(
    )
BEGIN
	select employee.ID, employee.Name, employee_workinghours.Date,
    employee_workinghours.LoginTime, employee_workinghours.LogoutTime from employee
    inner join employee_workinghours on employee.ID = employee_workinghours.ID;
END //

use supermarketDB;
DROP FUNCTION IF EXISTS isValidEmployee;
DELIMITER //
CREATE FUNCTION isValidEmployee
(
	employeeUsername varchar(100),
    employee_pwd varchar(16)
)
RETURNS INT
DETERMINISTIC READS SQL DATA
BEGIN
	DECLARE count INT;
    SELECT EXISTS(SELECT 1 FROM employee_credentials WHERE Username = employeeUsername and UserPassword = employee_pwd) into count;
    return count;
END //

use supermarketDB;
DROP FUNCTION IF EXISTS getEmployeeRole;
DELIMITER //
CREATE FUNCTION getEmployeeRole
(
	username varchar(100)
)
RETURNS VARCHAR(100)
DETERMINISTIC READS SQL DATA
BEGIN
	DECLARE EmpRole varchar(100);
    SELECT employee.EmployeeRole into EmpRole from employee
    inner join employee_credentials on employee.ID = employee_credentials.ID
    where employee_credentials.Username = username;
    return EmpRole;
END //

use supermarketDB;
DROP PROCEDURE IF EXISTS deleteEmployee;
DELIMITER //
CREATE PROCEDURE deleteEmployee(
	employeeID INT
    )
BEGIN
	DECLARE count INT;
	SELECT EXISTS(SELECT 1 FROM EMPLOYEE WHERE ID = employeeID) into count;
	IF (count = 1) THEN
			DELETE FROM EMPLOYEE WHERE (ID = employeeID);
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Employee does not exist';
    END IF;
END //

use supermarketDB;
DROP PROCEDURE IF EXISTS addWorkHours;
DELIMITER //
CREATE PROCEDURE addWorkHours(
    username varchar(100),
    Date DATE,
	loginTime TIME,
	logoutTime TIME
    )
BEGIN
	DECLARE employeeID INT;
    SELECT ID into employeeID from employee_credentials where employee_credentials.Username = username;
	INSERT INTO employee_workinghours VALUES (employeeID, Date, loginTime, logoutTime);
END; //

use supermarketDB;
DROP PROCEDURE IF EXISTS addNewProduct;
DELIMITER //
CREATE PROCEDURE addNewProduct(
    productName VARCHAR(100),
    productQuantity INT,
	productCategory INT,
    productPrice INT
)
BEGIN
	DECLARE count INT;
	SELECT EXISTS(SELECT 1 FROM product WHERE product.ProductName = productName) into count;
    If (count = 0) THEN
		INSERT INTO product(ProductName, Category, AvailableQuantity, Price) VALUES (productName, productCategory, productQuantity, productPrice);
	ELSE 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Product already exists';
	END IF;
END //

use supermarketDB;
DROP PROCEDURE IF EXISTS updateProductQuantity;
DELIMITER //
CREATE PROCEDURE updateProductQuantity(
    product_id INT,
    productQuantity INT
)
BEGIN
    UPDATE product
    set AvailableQuantity = productQuantity
    where ID = product_id;
	
END //

use supermarketDB;
DROP PROCEDURE IF EXISTS orderHistory;
DELIMITER //
CREATE PROCEDURE orderHistory
(
	username varchar(100)
)
BEGIN
    SELECT orders.* from customer_orders
    inner join customer_credentials on customer_orders.CustomerID = customer_credentials.ID
    inner join orders on customer_orders.OrderID = orders.ID
    where customer_credentials.Username = username;
END //

use supermarketDB;
DROP PROCEDURE IF EXISTS register;
DELIMITER //
CREATE PROCEDURE register
(
	username varchar(100),
	firstname varchar(100),
    lastname varchar(100),
    dob date,
    user_password varchar(16)
)
BEGIN
	DECLARE count INT;
    DECLARE ID INT;
	SELECT EXISTS(SELECT 1 FROM customer_credentials WHERE customer_credentials.Username = username) into count;
	IF(count = 0) THEN
		INSERT INTO customer (FirstName, LastName, DOB) VALUES (firstname, lastname, dob);
		SELECT LAST_INSERT_ID() into ID;
        SELECT ID;
        INSERT into customer_credentials(ID, Username, UserPassword) values (ID, username, user_password);
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Username already exists';
    END IF;
END //

DROP FUNCTION IF EXISTS isValidUser;
DELIMITER //
CREATE FUNCTION isValidUser
(
	username varchar(100),
    user_pwd varchar(16)
)
RETURNS INT
DETERMINISTIC READS SQL DATA
BEGIN
	DECLARE count INT;
    SELECT EXISTS(SELECT 1 FROM customer_credentials WHERE Username = username and UserPassword = user_pwd) into count;
    return count;
END //

use supermarketDB;
DROP PROCEDURE IF EXISTS orderDetails;
DELIMITER //
CREATE PROCEDURE orderDetails
(
	username varchar(100),
    order_id int
)
BEGIN
	DECLARE user_id INT;
    SELECT ID into user_id from customer_credentials where customer_credentials.Username = username;
    IF NOT EXISTS (SELECT * FROM customer_orders WHERE customer_orders.OrderID = order_id) THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid Order';
    END IF;
    IF NOT EXISTS (SELECT * FROM customer_orders WHERE OrderID = order_id and CustomerID = user_id) THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Order does not belong to the user';
    END IF;
    select product.ID, product.ProductName, order_line_items.Quantity, order_line_items.Quantity*product.Price Price,
    product_categories.CategoryName
    from order_line_items 
    inner join product on order_line_items.ProductID = product.ID
    inner join product_categories on product.Category = product_categories.ID
    where order_line_items.OrderID = order_id;
	
END //


use supermarketDB;
DROP PROCEDURE IF EXISTS getAllAvailableProducts;
DELIMITER //
CREATE PROCEDURE getAllAvailableProducts()
BEGIN
	SELECT product.ID, product.ProductName, product.AvailableQuantity Quantity,product.Price,
    product_categories.CategoryName from product 
    inner join product_categories on product.Category = product_categories.ID
    where product.AvailableQuantity > 0;
END //

use supermarketDB;
DROP PROCEDURE IF EXISTS getAllProducts;
DELIMITER //
CREATE PROCEDURE getAllProducts()
BEGIN
	SELECT product.ID, product.ProductName, product.AvailableQuantity Quantity, product.Price,
    product_categories.CategoryName from product 
    inner join product_categories on product.Category = product_categories.ID;
END //

use supermarketDB;
DROP FUNCTION IF EXISTS createOrder;
DELIMITER //
CREATE FUNCTION createOrder
(
	username varchar(100)
)
RETURNS INT
NO SQL
BEGIN
	DECLARE user_id INT;
    DECLARE order_id INT;
    SELECT ID into user_id from customer_credentials where customer_credentials.Username = username;
	INSERT INTO orders(OrderDate, Amount)
    values (CURDATE(), 0);
    SELECT LAST_INSERT_ID() into order_id;
    INSERT into customer_orders values(user_id, order_id,1);
    return order_id;
END //

use supermarketDB;
DROP PROCEDURE IF EXISTS addOrderItem;
DELIMITER //
CREATE PROCEDURE addOrderItem
(
	order_id int,
    product_id int,
    quantity int
)
BEGIN
	INSERT INTO order_line_items
    values (order_id, product_id, quantity);
END //

use supermarketDB;
DROP PROCEDURE IF EXISTS updateOrderItem;
DELIMITER //
CREATE PROCEDURE updateOrderItem
(
	order_id int,
    product_id int,
    quantity int
)
BEGIN
	UPDATE order_line_items
    SET Quantity = quantity
    where OrderID = order_id and ProductID = product_id;
END //

use supermarketDB;
DROP TRIGGER IF EXISTS on_order_create;
 DELIMITER //
 CREATE TRIGGER
 on_order_create
 AFTER INSERT ON
 order_line_items
 FOR EACH ROW
 BEGIN
 
    DECLARE product_id INT;
    DECLARE currentQuantity INT;
    DECLARE quantitySold INT;
    DECLARE orderID int;
    DECLARE currentAmount INT;
    DECLARE pricePerProduct INT;
    SELECT NEW.ProductID into product_id;
    SELECT NEW.Quantity into quantitySold;
    SELECT NEW.OrderID into orderID;
    
    SELECT AvailableQuantity into currentQuantity from product where product.ID = product_id;
    SELECT Amount into currentAmount from orders where orders.ID = orderID;
	SELECT Price into pricePerProduct from product where product.ID = product_id;
    
    if(currentQuantity <= 0) THEN
    		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You do not have enough quantity of the particular product to sell';
    END IF;
    update orders
    set Amount = currentAmount + (quantitySold *pricePerProduct)
    where orders.ID = orderID;
    update product
    set AvailableQuantity = currentQuantity - quantitySold
    where product.ID = product_id;
 END //


use supermarketDB;
DROP TRIGGER IF EXISTS on_order_delete;
 DELIMITER //
 CREATE TRIGGER
 on_order_delete
 AFTER DELETE ON
 order_line_items
 FOR EACH ROW
 BEGIN
    DECLARE product_id INT;
    DECLARE currentQuantity INT;
    DECLARE quantitySold INT;
    DECLARE orderID int;
    DECLARE currentAmount INT;
    DECLARE pricePerProduct INT;
    SELECT OLD.ProductID into product_id;
    SELECT OLD.quantity into quantitySold;
	SELECT OLD.OrderID into orderID;
	SELECT Amount into currentAmount from orders where orders.ID = orderID;
	SELECT Price into pricePerProduct from product where product.ID = product_id;
    SELECT AvailableQuantity into currentQuantity from product where product.ID = product_id;
    update orders
    set Amount = currentAmount - (quantitySold *pricePerProduct)
    where orders.ID = orderID;
    update product
    set AvailableQuantity = currentQuantity + quantitySold
    where product.ID = product_id;
 END //
 
use supermarketDB;
DROP TRIGGER IF EXISTS on_order_update;
 DELIMITER //
 CREATE TRIGGER
 on_order_update
 AFTER UPDATE ON
 order_line_items
 FOR EACH ROW
 BEGIN
    DECLARE product_id INT;
    DECLARE currentQuantity INT;
    DECLARE quantitySold INT;
    DECLARE orderID int;
    DECLARE currentAmount INT;
    DECLARE pricePerProduct INT;
	SELECT OLD.OrderID into orderID;
    SELECT OLD.ProductID into product_id;
    SELECT NEW.quantity - OLD.quantity into quantitySold;
    SELECT Amount into currentAmount from orders where orders.ID = orderID;
	SELECT Price into pricePerProduct from product where product.ID = product_id;
    SELECT AvailableQuantity into currentQuantity from product where product.ID = product_id;
    update orders
    set Amount = currentAmount + (quantitySold *pricePerProduct)
    where orders.ID = orderID;
    update product
    set AvailableQuantity = currentQuantity - quantitySold
    where product.ID = product_id;
 END //
 



-- 5 locations added in location table
INSERT INTO location(StreetNo, StreetName, ZipCode) VALUES(12, 'Street7', 02123);
INSERT INTO location(StreetNo, StreetName, ZipCode) VALUES(14, '5th Ave', 12411);
INSERT INTO location(StreetNo, StreetName, ZipCode) VALUES(15, '7922 Ave', 04234);
INSERT INTO location(StreetNo, StreetName, ZipCode) VALUES(5, '6th Ave', 02434);
INSERT INTO location(StreetNo, StreetName, ZipCode) VALUES(2, '23rd Ave', 43212);

-- insert into supermarket
INSERT INTO supermarket(Name, LocationID) VALUES('Supermarket1', 1);

-- 5 customers added in customer table
INSERT INTO customer(FirstName, LastName, DOB) VALUES ('John', 'Roy', '1995-01-01');
INSERT INTO customer(FirstName, LastName, DOB) VALUES ('Brad', 'Pitt', '1966-10-07');
INSERT INTO customer(FirstName, LastName, DOB) VALUES ('Chris', 'Connor', '1977-11-09');
INSERT INTO customer(FirstName, LastName, DOB) VALUES ('Mark', 'Joseph', '2000-12-01');
INSERT INTO customer(FirstName, LastName, DOB) VALUES ('Brian', 'Sharma', '1999-03-01');

-- 5 customer credentials added in customer_credentials table 
INSERT INTO customer_credentials VALUES (1, 'johnroy', 'johnroy');
INSERT INTO customer_credentials VALUES (2, 'userBrad', 'pwdBrad12');
INSERT INTO customer_credentials VALUES (3, 'userChris', 'pwdChris12');
INSERT INTO customer_credentials VALUES (4, 'userMark', 'pwdMark12');
INSERT INTO customer_credentials VALUES (5, 'userBrian', 'pwdMark12');

-- 5 orders added in orders table
INSERT INTO orders(OrderDate, Amount) VALUES 
('2022-08-01', 56),
('2022-01-01', 5),
('2022-09-11', 3000),
('2022-11-05', 4000),
('2022-11-15', 13000); 

-- 2 product categories added in product_categories table
INSERT INTO product_categories(CategoryName) VALUES ('Perishable');
INSERT INTO product_categories(CategoryName) VALUES ('Non Perishable');

-- Add products in the product table
INSERT INTO product(ProductName, Category, AvailableQuantity, Price) VALUES 
('Apple', 1, 15, 2),
('Mango', 1, 15, 2),
('Grapes', 1, 25, 4),
('Milk', 1, 5, 5),
('Books', 2, 15, 5),
('Pen', 2, 10, 5),
('Cap', 2, 30, 20),
('Laptop', 2, 25, 100),
('Oranges', 1, 20, 10);

INSERT INTO supermarket_products VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8), (1, 9); 

-- Add order line items
INSERT INTO order_line_items values 
(1, 1, 4),		-- order id, product id, quantity
(1, 2, 5),
(1, 3, 7), 
(1, 6, 2),
(2, 4, 1),
(3, 4, 2),
(3, 5, 11),
(4, 7, 6),
(5, 8, 3);

-- 5 customer orders added in customer_orders table
INSERT INTO customer_orders VALUES (1, 1, 1),		-- Customer (id) 1 places order (id) 1 at supermarket (id) 1
(1, 2, 1),		-- Customer (id) 1 places order (id) 2 - product 1 - at supermarket (id) 1
(2, 3, 1),
(3, 4, 1),
(4, 5, 1);

INSERT INTO employee (SupermarketId, Name, StartDate, EmployeeRole) VALUES (1, "Mark", "1997-02-03", 'Regular'),
(1, "John", "1962-02-03", 'Admin'),
(1, "Steve", "1964-02-03", 'Admin'),
(1, "Chris", "1987-02-03", 'InventoryManager'),
(1, "Christopher", "1988-02-03", 'Admin'),
(1, "Tom", "1964-02-03", 'Regular'),
(1, "Jen", "1995-02-03", 'Regular'),
(1, "Jerry", "1991-02-03", 'Regular');

INSERT INTO employee_credentials VALUES (1, "empMark", "empMark"),
(2, "johndavid", "johndavid"),
(3, "empSteve", "empSteve"),
(4, "chrisjoseph", "chrisjoseph"),
(5, "empChristopher", "empChristopher"),
(6, "empTom", "empTom"),
(7, "empJen", "empJen"),
(8, "jerryroy", "jerryroy");

INSERT INTO employee_workinghours VALUES (1, "2021-01-01", "09:00:00", "17:00:00"),
(2, "2021-02-03", "09:00:00", "17:00:00"),
(3, "2022-01-01", "09:00:00", "17:00:00"),
(1, "2021-02-03", "09:00:00", "17:00:00"),
(2, "2021-02-04", "09:00:00", "17:00:00"),
(3, "2022-01-02", "09:00:00", "17:00:00"),
(4, "2021-06-05", "09:00:00", "17:00:00"),
(5, "2021-02-04", "09:00:00", "17:00:00"),
(3, "2022-02-02", "09:00:00", "17:00:00"),
(1, "2021-06-05", "09:00:00", "17:00:00");










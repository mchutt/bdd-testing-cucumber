-- Insert the user into the Users table
INSERT INTO Users (username, password, firstname, lastname, zipcode)
VALUES 
('standard_user', 'secret_sauce', 'John', 'Doe', '12345'),
('visual_user', 'secret_sauce', 'Mark', 'Smith', 'E543'),
('standard_user', 'secret_sauce', 'Paul', 'Doe', '12345'),
('standard_user', 'secret_sauce', 'Mike', 'Doe', 'A3244');

-- Insert the products as orders for the user (assuming the user ID is 1)
INSERT INTO UserOrders (user_id, product_name)
VALUES 
(1, 'Sauce Labs Backpack'),
(1, 'Sauce Labs Fleece Jacket'),
(2, 'Sauce Labs Onesie'),
(2, 'Test.allTheThings() T-Shirt (Red)'),
(3, 'Sauce Labs Onesie');


INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');

INSERT INTO `items` (`type`, `name`, `description`, `cost`) VALUES 
('Ice cream', 'Strawberry ice cream', 'Classic strawberry flavoured ice cream', 2.99);

INSERT INTO `orders` (`customer_id`, `date_placed`) VALUES (1, TO_DATE('2/4/2022', 'DD/MM/YYYY')), (1, TO_DATE('3/4/2022', 'DD/MM/YYYY'));

INSERT INTO `orderitems` (`order_id`, `item_id`, `quantity`) VALUES (1, 1, 3);
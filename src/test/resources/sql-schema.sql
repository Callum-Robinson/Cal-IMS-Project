DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `items`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `orderitems`;


CREATE TABLE IF NOT EXISTS `customers` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(64) NOT NULL,
    `surname` VARCHAR(64) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(40) NOT NULL,
    `name` VARCHAR(40) NOT NULL,
    `description` VARCHAR(256),
    `cost` DECIMAL(4,2) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `orders` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `customer_id` BIGINT NOT NULL,
    `date_placed` DATE DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`)
);


CREATE TABLE IF NOT EXISTS `orderitems` (
    `order_id` BIGINT NOT NULL,
    `item_id` BIGINT NOT NULL,
    `quantity` INT DEFAULT 1,
    PRIMARY KEY (`order_id`, `item_id`),
    FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`),
    FOREIGN KEY (`item_id`) REFERENCES `items`(`id`)
);
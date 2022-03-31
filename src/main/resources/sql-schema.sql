drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(64) NOT NULL,
    `surname` VARCHAR(64) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(40) NOT NULL,
    `name` VARCHAR(40) NOT NULL,
    `description` VARCHAR(256),
    `cost` DECIMAL(4,2) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11) NOT NULL,
    `date_placed` DATE DEFAULT(DATE(CURRENT_TIMESTAMP)),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`)
);


CREATE TABLE IF NOT EXISTS `ims`.`orderitems` (
    `order_id` BIGINT NOT NULL,
    `item_id` BIGINT NOT NULL,
    `quantity` INT DEFAULT (1),
    PRIMARY KEY (`order_id`, `item_id`),
    FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`),
    FOREIGN KEY (`item_id`) REFERENCES `items`(`id`)
);
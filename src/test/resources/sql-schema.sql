DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `items`;

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

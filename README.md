<?xml version="1.0" encoding="UTF-8" ?>
<!--
<configuration>
    <include resource="org/springframework/boot/logging/logback/base.xml"/>
    <logger name="org.springframework" level="INFO"/>
    <logger name="com.venkat" level="TRACE"/>
</configuration>-->

CREATE TABLE `my_eapp`.`products` (
`product_id` INT NOT NULL AUTO_INCREMENT,
`product_name` VARCHAR(45) NULL,
`model_year` INT NULL,
`list_price` DECIMAL(10,2) NULL,
PRIMARY KEY (`product_id`));


CREATE TABLE `my_eapp`.`customers` (
`customer_id` INT NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(50) NULL,
`last_name` VARCHAR(50) NULL,
`phone` VARCHAR(12) NULL,
`email` VARCHAR(45) NULL,
`street` VARCHAR(45) NULL,
`city` VARCHAR(45) NULL,
`state` VARCHAR(45) NULL,
`zip_code` VARCHAR(45) NULL,
PRIMARY KEY (`customer_id`),
UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
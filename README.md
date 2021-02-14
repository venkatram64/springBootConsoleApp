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
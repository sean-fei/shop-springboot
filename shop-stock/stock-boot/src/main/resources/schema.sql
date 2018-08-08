DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`(  
  `stock_id` VARCHAR(32) NOT NULL,
  `stock_balance` INT NOT NULL,
  `product_id` VARCHAR(32) NOT NULL,
  `version_id` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

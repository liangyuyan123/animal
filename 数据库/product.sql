/*
Navicat MySQL Data Transfer

Source Server         : design
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : animal

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2019-11-10 16:27:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  `product_price` decimal(10,2) DEFAULT NULL,
  `product_account` int(11) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_image` varchar(255) DEFAULT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.24 : Database - logindemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`logindemo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `logindemo`;

/*Table structure for table `user` */

CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_account` varchar(20) NOT NULL COMMENT '账号',
  `user_password` varchar(255) NOT NULL COMMENT '密码',
  `user_role` varchar(10) NOT NULL COMMENT '角色',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `user_email` varchar(20) DEFAULT NULL COMMENT '邮件',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_account`,`user_password`,`user_role`,`user_phone`,`user_email`) values 
(1,'user1','$2a$10$nZdwNNjna9iDQYrXh6Ms2ua/4wpNvfHlEADl5SZPnsCsK6eZ6OlmG','user','13011111111','aaa@qq.com'),
(2,'admin','$2a$10$nZdwNNjna9iDQYrXh6Ms2ua/4wpNvfHlEADl5SZPnsCsK6eZ6OlmG','admin','13011111111','aaa@qq.com'),
(3,'user2','$2a$10$U/Utmq8vww/aviNA1TyAA.s6ZPQODIJ.rErwglSEmrKIE1mp5AZPu','user','13011111111','aaa@aaa.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

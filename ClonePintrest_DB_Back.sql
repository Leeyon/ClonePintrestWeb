/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.19 : Database - clonepintrest
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`clonepintrest` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `clonepintrest`;

/*Table structure for table `appphoto` */

DROP TABLE IF EXISTS `appphoto`;

CREATE TABLE `appphoto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `smallPhotoPath` varchar(150) NOT NULL,
  `bigPhotoPath` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `appphoto` */

/*Table structure for table `appuser` */

DROP TABLE IF EXISTS `appuser`;

CREATE TABLE `appuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `pass` varchar(40) NOT NULL,
  `displayName` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `appuser` */

/*Table structure for table `appuserphoto` */

DROP TABLE IF EXISTS `appuserphoto`;

CREATE TABLE `appuserphoto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `photoId` int(11) NOT NULL,
  `isOwner` tinyint(1) NOT NULL,
  `isPublic` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `appuserphoto` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
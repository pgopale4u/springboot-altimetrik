/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.17-log : Database - emp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`emp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `emp`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_no` char(5) NOT NULL,
  `dept_name` varchar(40) NOT NULL,
  `dept_description` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dept_no` (`dept_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`dept_no`,`dept_name`,`dept_description`) values 
(1,'D0001','Customer Service','Customer Service Operation Services'),
(2,'D0002','Development','Development Services'),
(3,'D0003','Finance','Finance Services');

/*Table structure for table `dept_project` */

DROP TABLE IF EXISTS `dept_project`;

CREATE TABLE `dept_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_no` varchar(5) NOT NULL,
  `proj_no` varchar(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dept_no` (`dept_no`,`proj_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `dept_project` */

insert  into `dept_project`(`id`,`dept_no`,`proj_no`) values 
(1,'D0001','P0001'),
(4,'D0001','P0002'),
(5,'D0002','P0001'),
(6,'D0002','P0002');

/*Table structure for table `emp_dept` */

DROP TABLE IF EXISTS `emp_dept`;

CREATE TABLE `emp_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_no` varchar(5) NOT NULL,
  `dept_no` varchar(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `emp_no` (`emp_no`,`dept_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `emp_dept` */

insert  into `emp_dept`(`id`,`emp_no`,`dept_no`) values 
(1,'E0001','D0001'),
(2,'E0001','D0002'),
(3,'E0002','D0001'),
(4,'E0002','D0002'),
(5,'E0003','D0001');

/*Table structure for table `emp_project` */

DROP TABLE IF EXISTS `emp_project`;

CREATE TABLE `emp_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_no` varchar(5) NOT NULL,
  `proj_no` varchar(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `emp_no` (`emp_no`,`proj_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `emp_project` */

insert  into `emp_project`(`id`,`emp_no`,`proj_no`) values 
(2,'E0001','P0002'),
(3,'E0002','P0001'),
(4,'E0002','P0002');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_no` char(5) NOT NULL,
  `emp_fname` varchar(40) DEFAULT NULL,
  `emp_lname` varchar(40) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `emp_no` (`emp_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`emp_no`,`emp_fname`,`emp_lname`,`gender`) values 
(1,'E0001','Georgi','Facello','M'),
(2,'E0002','Bezalel','Simmel','F');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proj_no` char(5) NOT NULL,
  `proj_name` varchar(40) DEFAULT NULL,
  `proj_desc` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `proj_no` (`proj_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`id`,`proj_no`,`proj_name`,`proj_desc`) values 
(1,'P0001','HMS','Health management System'),
(2,'P0002','EMS','Employee management System');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

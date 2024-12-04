/*
SQLyog Community Edition- MySQL GUI v7.01 
MySQL - 5.0.27-community-nt : Database - 010hospitalinfo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`010hospitalinfo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `010hospitalinfo`;

/*Table structure for table `doctorsdetails` */

DROP TABLE IF EXISTS `doctorsdetails`;

CREATE TABLE `doctorsdetails` (
  `id` int(11) NOT NULL auto_increment,
  `doctorname` varchar(100) default NULL,
  `specialization` varchar(100) default NULL,
  `availability` varchar(100) default NULL,
  `education` varchar(100) default NULL,
  `operation` varchar(100) default NULL,
  `about` longtext,
  `hospitalname` varchar(100) default NULL,
  `phonenumber` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `otp` varchar(100) default NULL,
  `emailid` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `doctorsdetails` */

insert  into `doctorsdetails`(`id`,`doctorname`,`specialization`,`availability`,`education`,`operation`,`about`,`hospitalname`,`phonenumber`,`password`,`otp`,`emailid`) values (1,'a','aaaa','a','a','a','a','a','8655221446',NULL,NULL,NULL),(2,'b','f','f','f','h','k','b','8655221446',NULL,NULL,NULL),(3,'ningesh1406','m','m','m','m','m','m','93216426621','ningesh1406','4742','ningesh1406@gmail.com');

/*Table structure for table `hospitallist` */

DROP TABLE IF EXISTS `hospitallist`;

CREATE TABLE `hospitallist` (
  `hospitalname` varchar(100) default NULL,
  `location` varchar(100) default NULL,
  `machines` varchar(100) default NULL,
  `facility` varchar(100) default NULL,
  `doctors` varchar(100) default NULL,
  `staffs` varchar(1000) default NULL,
  `beds` varchar(20) default NULL,
  `operations` varchar(1000) default NULL,
  `lattitude` varchar(1000) default NULL,
  `longitude` varchar(1000) default NULL,
  `phonenumber` varchar(1000) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hospitallist` */

insert  into `hospitallist`(`hospitalname`,`location`,`machines`,`facility`,`doctors`,`staffs`,`beds`,`operations`,`lattitude`,`longitude`,`phonenumber`) values ('fortis mulund','Mulund Goregaon Link Rd','ventilator,robotic arm','eye specialist,dialysis','doctora,doctorb,doctorc','staffa,staffb,staffc,staffd','55','Eye specialist 2 ,kidney 2 ','19.1621','72.9420',NULL),('avdhut hospital','airoli','ventilator,robotic arm','eye specialist,dialysis','doctora,doctorb,doctorc','staffa,staffb,staffc,staffd','55','Eye specialist','19.157934','70.124992',NULL),('fortis','airoli',NULL,'eye specialist,dialysis',NULL,NULL,'55','ot1,ot2,ot3','19.157934','72.993477','9004670813');

/*Table structure for table `imagesofuser` */

DROP TABLE IF EXISTS `imagesofuser`;

CREATE TABLE `imagesofuser` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(1000) default NULL,
  `imagename` varchar(1000) default NULL,
  `dateofdoc` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `imagesofuser` */

insert  into `imagesofuser`(`id`,`username`,`imagename`,`dateofdoc`) values (1,'a','a@20200911_132049.jpg','2020-09-11 13:20:51'),(2,'a','a@20200911_194820.jpg','2020-09-11 19:48:21');

/*Table structure for table `multipleappointment` */

DROP TABLE IF EXISTS `multipleappointment`;

CREATE TABLE `multipleappointment` (
  `username` varchar(100) default NULL,
  `emailid` varchar(100) default NULL,
  `phonenumber` varchar(100) default NULL,
  `doctor` varchar(100) default NULL,
  `specialization` varchar(100) default NULL,
  `date` varchar(100) default NULL,
  `time` varchar(100) default NULL,
  `status` varchar(100) default NULL,
  `id` int(11) NOT NULL auto_increment,
  `statusbyuser` varchar(100) default 'Pending',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `multipleappointment` */

insert  into `multipleappointment`(`username`,`emailid`,`phonenumber`,`doctor`,`specialization`,`date`,`time`,`status`,`id`,`statusbyuser`) values ('a',NULL,NULL,'doctorname','','11/9/2020','11:44','pending',1,'Pending'),('a',NULL,NULL,'a','','11/9/2020','23:33','pending',2,'Pending');

/*Table structure for table `specialistdetails` */

DROP TABLE IF EXISTS `specialistdetails`;

CREATE TABLE `specialistdetails` (
  `id` int(11) NOT NULL auto_increment,
  `doctorname` varchar(100) default NULL,
  `specialization` varchar(100) default NULL,
  `availability` varchar(100) default NULL,
  `education` varchar(100) default NULL,
  `operation` varchar(100) default NULL,
  `about` longtext,
  `hospitalname` varchar(100) default NULL,
  `phonenumber` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `specialistdetails` */

insert  into `specialistdetails`(`id`,`doctorname`,`specialization`,`availability`,`education`,`operation`,`about`,`hospitalname`,`phonenumber`) values (1,'a','k','a','a','a','a','a','8655221446'),(2,'b','f','f','f','h','k','b','9004670813');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(255) default NULL,
  `emailid` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `type` varchar(255) default NULL,
  `mobilenumber` varchar(255) default NULL,
  `OTP` varchar(255) default NULL,
  `path` varchar(1000) default NULL,
  `hashcode` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`username`,`emailid`,`password`,`type`,`mobilenumber`,`OTP`,`path`,`hashcode`) values ('a','ningesh1406@gmail.com','b','user','8655221446','','','');

/*Table structure for table `userconcern` */

DROP TABLE IF EXISTS `userconcern`;

CREATE TABLE `userconcern` (
  `id` int(11) NOT NULL auto_increment,
  `subject` varchar(1000) default NULL,
  `concern` longtext,
  `username` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `userconcern` */

insert  into `userconcern`(`id`,`subject`,`concern`,`username`) values (1,'this  is tough','i am in trouble','a'),(2,'hi','hi','a');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;

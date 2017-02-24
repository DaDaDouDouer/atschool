/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.24-log : Database - graduate_design
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `graduate_design`;

/*Table structure for table `tab_book` */

DROP TABLE IF EXISTS `tab_book`;

CREATE TABLE `tab_book` (
  `id` varchar(36) NOT NULL,
  `name` varchar(36) NOT NULL,
  `author` varchar(36) DEFAULT NULL,
  `isbn` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tab_book` */

insert  into `tab_book`(`id`,`name`,`author`,`isbn`) values ('11','C','daf','53426436'),('12','Java','ytutre','6744533'),('13','C++','fbds','465743'),('14','PHP','dsafsd','3214577');

/*Table structure for table `tab_cart_item` */

DROP TABLE IF EXISTS `tab_cart_item`;

CREATE TABLE `tab_cart_item` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  `goods_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tab_cart_item` */

insert  into `tab_cart_item`(`id`,`user_id`,`goods_id`) values ('11','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','1'),('12','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','2');

/*Table structure for table `tab_delivery_address` */

DROP TABLE IF EXISTS `tab_delivery_address`;

CREATE TABLE `tab_delivery_address` (
  `id` varchar(36) NOT NULL,
  `user_info_id` varchar(36) NOT NULL,
  `address` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tab_delivery_address` */

insert  into `tab_delivery_address`(`id`,`user_info_id`,`address`) values ('57de927e-e760-468f-b5d2-d61b5827bc56','2','江苏省南京市栖霞区文苑路南京邮电大学'),('6abd4f8d-3a79-4fb7-b573-add4f449d32c','1','nju'),('ae226d0c-27cf-4c32-ac4a-b96ac37ac2ab','2','山西省大同市御东新区大同大学');

/*Table structure for table `tab_goods` */

DROP TABLE IF EXISTS `tab_goods`;

CREATE TABLE `tab_goods` (
  `id` varchar(36) NOT NULL,
  `real_goods_id` varchar(36) NOT NULL,
  `seller_id` varchar(36) NOT NULL,
  `link_table` varchar(36) NOT NULL,
  `name` varchar(36) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `count` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tab_goods` */

insert  into `tab_goods`(`id`,`real_goods_id`,`seller_id`,`link_table`,`name`,`price`,`count`) values ('1','11','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','tab_book','C',321.2,3),('2','12','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','tab_book','Java',432.4,9),('3','13','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','tab_book','C++',439.2,3),('4','14','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','tab_book','PHP',32.6,4);

/*Table structure for table `tab_user` */

DROP TABLE IF EXISTS `tab_user`;

CREATE TABLE `tab_user` (
  `id` varchar(36) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tab_user` */

insert  into `tab_user`(`id`,`password`,`username`,`create_time`) values ('0cc95799-4660-4758-9f7e-0053187eac7a','123','ba','2017-03-17 10:22:22'),('17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','sdf','sad','2017-02-15 00:00:00'),('3b07f71d-50c7-4861-a25d-b598093bf861','98','happy','2017-02-17 00:00:00');

/*Table structure for table `tab_user_info_in_market` */

DROP TABLE IF EXISTS `tab_user_info_in_market`;

CREATE TABLE `tab_user_info_in_market` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tab_user_info_in_market` */

insert  into `tab_user_info_in_market`(`id`,`user_id`) values ('1','0cc95799-4660-4758-9f7e-0053187eac7a'),('2','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab'),('3','3b07f71d-50c7-4861-a25d-b598093bf861');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

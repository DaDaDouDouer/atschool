-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: graduate_design
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tab_admin`
--

DROP TABLE IF EXISTS `tab_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_admin` (
  `id` varchar(36) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_admin`
--

LOCK TABLES `tab_admin` WRITE;
/*!40000 ALTER TABLE `tab_admin` DISABLE KEYS */;
INSERT INTO `tab_admin` VALUES ('ad1','12345','admin','2017-03-17 09:35:33');
/*!40000 ALTER TABLE `tab_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_book`
--

DROP TABLE IF EXISTS `tab_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_book` (
  `id` varchar(36) NOT NULL,
  `name` varchar(36) NOT NULL,
  `author` varchar(36) DEFAULT NULL,
  `isbn` varchar(36) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_book`
--

LOCK TABLES `tab_book` WRITE;
/*!40000 ALTER TABLE `tab_book` DISABLE KEYS */;
INSERT INTO `tab_book` VALUES ('11','C','daf','53426436','http://evgetgif.qiniudn.com/C-language-book-2.jpg'),('12','Java','ytutre','6744533','http://cdn.jingkao.net/group1/M00/7B/49/rBoMg1MznqaAExOPAABoZrRB6Qg184.jpg'),('13','C++','fbds','465743','http://img3x0.ddimg.cn/4/25/22910980-1_w_1.jpg'),('14','PHP','dsafsd','3214577','http://img3x9.ddimg.cn/94/4/21127189-1_w_2.jpg');
/*!40000 ALTER TABLE `tab_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_cart_item`
--

DROP TABLE IF EXISTS `tab_cart_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_cart_item` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  `goods_id` varchar(36) NOT NULL,
  `goods_count` int(16) NOT NULL,
  `is_selected` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_cart_item`
--

LOCK TABLES `tab_cart_item` WRITE;
/*!40000 ALTER TABLE `tab_cart_item` DISABLE KEYS */;
INSERT INTO `tab_cart_item` VALUES ('31f96e10-802b-4bd1-b40d-903eeafb5d07','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','1',12,0),('69ba6683-911c-4ae8-8a25-0ba7129123fc','0cc95799-4660-4758-9f7e-0053187eac7a','3',3,0),('799d15ce-151b-4816-95e3-4c8c03f7683b','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','2',5,1);
/*!40000 ALTER TABLE `tab_cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_delivery_address`
--

DROP TABLE IF EXISTS `tab_delivery_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_delivery_address` (
  `id` varchar(36) NOT NULL,
  `user_info_id` varchar(36) NOT NULL,
  `address` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_delivery_address`
--

LOCK TABLES `tab_delivery_address` WRITE;
/*!40000 ALTER TABLE `tab_delivery_address` DISABLE KEYS */;
INSERT INTO `tab_delivery_address` VALUES ('57de927e-e760-468f-b5d2-d61b5827bc56','2','江苏省南京市栖霞区文苑路南京邮电大学'),('6abd4f8d-3a79-4fb7-b573-add4f449d32c','1','nju'),('ae226d0c-27cf-4c32-ac4a-b96ac37ac2ab','2','山西省大同市御东新区大同大学');
/*!40000 ALTER TABLE `tab_delivery_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_evaluation`
--

DROP TABLE IF EXISTS `tab_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_evaluation` (
  `id` varchar(36) NOT NULL,
  `goods_id` varchar(36) NOT NULL,
  `content` varchar(256) NOT NULL,
  `create_time` datetime NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_evaluation`
--

LOCK TABLES `tab_evaluation` WRITE;
/*!40000 ALTER TABLE `tab_evaluation` DISABLE KEYS */;
INSERT INTO `tab_evaluation` VALUES ('6d91f93f-2102-4833-846a-0226a5cbbb6f','3','sdftt65676yut','2017-02-24 18:59:08','0cc95799-4660-4758-9f7e-0053187eac7a'),('8f4b6144-6da8-4d60-b0aa-5a70a5ec3915','','111111是短发当时的分隔符','2017-02-24 19:27:11','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab');
/*!40000 ALTER TABLE `tab_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_goods`
--

DROP TABLE IF EXISTS `tab_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_goods` (
  `id` varchar(36) NOT NULL,
  `real_goods_id` varchar(36) NOT NULL,
  `seller_id` varchar(36) NOT NULL,
  `link_table` varchar(36) NOT NULL,
  `name` varchar(36) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `count` int(32) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `via` int(16) DEFAULT NULL COMMENT '销量',
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_goods`
--

LOCK TABLES `tab_goods` WRITE;
/*!40000 ALTER TABLE `tab_goods` DISABLE KEYS */;
INSERT INTO `tab_goods` VALUES ('1','11','31c0d96d-0e94-4a52-8648-9c39009d5a72','tab_book','C',321.2,0,'http://evgetgif.qiniudn.com/C-language-book-2.jpg',4,'a new desp2'),('2','12','31c0d96d-0e94-4a52-8648-9c39009d5a72','tab_book','Java',432.4,4,'http://cdn.jingkao.net/group1/M00/7B/49/rBoMg1MznqaAExOPAABoZrRB6Qg184.jpg',13,NULL),('3','13','31c0d96d-0e94-4a52-8648-9c39009d5a72','tab_book','C++',439.2,2,'http://img3x0.ddimg.cn/4/25/22910980-1_w_1.jpg',6,NULL),('4','14','31c0d96d-0e94-4a52-8648-9c39009d5a72','tab_book','PHP',32.6,4,'http://img3x9.ddimg.cn/94/4/21127189-1_w_2.jpg',2,NULL);
/*!40000 ALTER TABLE `tab_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_goods_type`
--

DROP TABLE IF EXISTS `tab_goods_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_goods_type` (
  `id` varchar(36) NOT NULL,
  `name` varchar(127) NOT NULL,
  `base_name` varchar(127) NOT NULL,
  `link_table` varchar(36) NOT NULL,
  `base_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_goods_type`
--

LOCK TABLES `tab_goods_type` WRITE;
/*!40000 ALTER TABLE `tab_goods_type` DISABLE KEYS */;
INSERT INTO `tab_goods_type` VALUES ('003b30d2-e5fa-483c-b5b8-be1e77df1e3b','东野圭吾','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('033ca669-2619-4c3f-9f4a-c646096e2f7f','励志','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('03f25997-aaa8-494e-a654-604278d9f466','游记','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('049ba8b2-d9f9-430a-ba8a-14a4986ff686','健康','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('04b6b9b6-9496-455e-b8b8-dc178cb27520','张小娴','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('077f7f90-b89a-4e7a-ad81-ad66c0878d1f','诗歌','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab','default_type','default_type_base','tab_book','default_type_base_id'),('0daa8ecc-1729-42c4-b30e-82ec2cc6b11a','军事','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('0e7bd811-5a5f-4bfa-a8fb-f1ac146e81e0','人文','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('0f3ff0d4-cec8-498d-8b09-3781c3089f40','手工','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('10f8201a-b9f0-4990-bbac-45bb12d67e00','经济','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('111','计算机','测试类型','tab_book','d3cfd92d-b5ab-4c57-8e26-3ad943c1ae2d'),('112','呵呵','测试类型','tab_book','d3cfd92d-b5ab-4c57-8e26-3ad943c1ae2d'),('113','编程','测试类型','tab_book','d3cfd92d-b5ab-4c57-8e26-3ad943c1ae2d'),('1157224b-0230-43ee-b2ec-869b6efb40d7','当代文学','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('141133b6-bc9e-4606-a128-7f5780d60a7f','创业','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('143ad49f-a0f8-4c76-85dd-5b263c7310d4','思想','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('15c575a6-54eb-4e3c-9175-953e0811405e','推理小说','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('185186de-8846-4e73-8d34-0d3d201ae606','港台','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('1ad9a30d-668f-47d8-832b-619c4761fc97','历史','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('1b36735b-ae26-4116-ad54-3df61edcc8cf','科幻小说','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('1d6199a1-1ae1-4834-bcc5-179f4395a56d','日本文学','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('1d77b307-2f22-44e8-83e9-2c9518ee8e9a','魔幻','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('21b5f2cc-9992-4fbb-a024-6527821ead81','艺术史','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('22320c98-3182-4b32-9fe4-124638844152','家居','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('240c7466-1ca4-4447-ae8a-8878c27dcd8e','投资','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('246f256d-4712-4471-8f92-66337d210441','青春','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('24c29fc5-c27a-48bb-b3cb-f246183a2456','落落','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('25e1afca-005c-4531-baa3-73801a328c9c','哲学','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('276b82a8-057b-4f55-93fd-834d7e8a2ee1','中国文学','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('292c4e43-817a-4793-bc6d-625cc4d79c41','考古','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('2b6d94d3-3147-4c3e-af2d-218ad039509a','绘本','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('2d68a4b4-625c-4ada-b190-2c2da991374a','散文','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('2d895ac9-b0be-49c2-aac4-2cadfc259cfe','漫画','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('304d81a0-8b6a-46ce-b14d-6946c024623a','互联网','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('30af9825-ad3a-45ba-8b3b-ee21f4fe4f46','心理学','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('33266469-8e1a-4eab-9aa1-e89d2ff75d59','幾米','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('35ea6f59-5541-4703-b35b-a39bf4e09c66','灵修','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('36d6f99f-19df-403a-be4b-b5b08c3a4151','戏剧','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('3a49c3d9-67e1-4f0a-8cc8-a064a9e27315','中国历史','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('3ac549f5-0192-4edf-b29c-07fe0b0fa12a','社会学','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('3f12cdd5-158c-4cc7-b74c-1df8fc28c1c9','宗教','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('415008e8-aa8c-431c-8ef2-37be9b7e814c','亦舒','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('4291f34e-5678-4ec1-9380-d341599f0828','近代史','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('4499cea0-234c-4ff1-be11-1dd3aac59e55','web','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('44f31e93-343a-4137-919f-ddcb82e0c3e9','商业','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('484136ac-d2df-40b6-9ec8-0582dfbf7788','神经网络','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('4861995a-9579-4727-ba3b-ac35628e7f98','经典','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('4d9ca2f7-c352-4dfc-88b5-c3c9427ecb24','金庸','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('4ec8c9e8-5adb-4db6-9bf6-fec80740a950','艺术','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('4eca8d84-ba1e-4cc2-aeae-c4af75fe5d4b','电影','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('4f279c46-f647-4db1-bada-6e67ace8bd9d','情感','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('502acc6a-8b5f-4abb-ade6-3b6e508606f4','儿童文学','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('520c0d1c-cfcf-47a2-8ada-dc34388073b5','随笔','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('524ffe58-70db-42e7-a7d5-012c39c2f55b','UCD','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('5764bc27-0e4a-45b0-b468-7deb8de297c0','回忆录','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('593b15f0-afb7-4bc1-a398-705448381c36','美术','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('5b22a6f5-93ae-4d6d-a734-fce915919af1','管理','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('5bf18c92-9d2c-49c8-b4dc-2bb7a1560d39','摄影','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('617544a4-b66c-499c-806a-46654779bc33','广告','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('632aa313-dcb2-42e5-837d-2ceb6868419f','理财','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('6473de85-da29-4955-adb6-c11d520f575f','三毛','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('6772fa35-ad47-4749-b13e-5fd9d21960f2','社会','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('680bae7f-4fd4-498b-9d48-381c4d1aa6d6','数学','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('697b495b-5619-419c-806c-4cbfc2b01398','诗词','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('6cd1c66c-d954-478a-9003-c92a432877af','悬疑','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('707fc5bb-fd7d-479f-b507-f1a86607d6ba','钱钟书','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('708fffc8-bfea-40e4-8ffc-34c0ea18a1dc','小说','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('7229e0ce-06f8-4924-a19b-63cc749fe153','米兰·昆德拉','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('73d23e3d-6976-400e-8f78-d6feaade048a','外国名著','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('73e454b1-2f45-4adf-8b36-682077fb9062','外国文学','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('74aaa2e8-a787-406f-b8c5-3fee143b8343','名著','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('74e57ab4-85b3-407b-8c4c-82f73839c245','郭敬明','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('7829be60-736b-47de-9ccd-fa29d0465b59','程序','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('79af0274-c22b-4c9b-b39e-730c085d1b20','经济学','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('79b16b32-f0f9-41d7-9c26-868beefae689','余华','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('7b15aa00-8678-475c-a9ab-cfd161601d98','安妮宝贝','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('7b6dea76-07d9-4d29-80e5-96e9c5fbd4a0','武侠','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('7d2b4f95-34e7-4905-b573-e006c0b2d178','交互设计','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('7eb638ee-6515-408f-a9b9-c36f240c4f4b','张悦然','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('80488c3b-3dfc-432d-804e-32c53d97d750','文学','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('87b77bcb-8a77-4c2d-a265-59bda1aefcba','佛教','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('8a358065-8cb1-4c20-8371-72eceab2e7bd','算法','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('8a51e566-3988-4b97-ad29-d31121d6e021','几米','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('8c4bd436-03be-4f65-91eb-f04b24d54f43','杜拉斯','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('8dac57da-42fe-4fd2-984d-efc3c30b9d47','沧月','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('8e7cde4c-a741-4172-b17e-55b1519e8b2f','UE','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('8f9f27ce-b52a-438f-83fa-0f0739f4bf72','高木直子','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('94072111-e9be-4bdc-b45c-2570164f0717','自由主义','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('9467607a-f15d-45e5-9d5b-c96772c96a6b','穿越','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('94fb388d-4fe3-42ef-94a5-5ab8ef2ebb26','二战','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('9667d083-0915-46aa-a9ef-2ac03b181689','建筑','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('96d36ae5-99c2-4a0b-877d-135db2d8417e','奇幻','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('97928845-c396-4caf-b5ab-e4c374c36cb7','音乐','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('98209c14-98ae-4a15-8ddb-0337d0a6fb27','古龙','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('982bcb7b-a74b-4436-bdcd-8b127739f795','国学','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('9a11a46d-d638-44b3-a0de-a09394efbdde','编程','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('9aeb58fb-6f34-4442-a0f7-97f41708838f','王小波','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('9ba4778e-7c71-44f7-ba50-46088d38587b','女性','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('9e4381c6-9bba-44dc-9ca1-e1a5e42fdad8','职场','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('9ed4ba3f-a98c-4cf6-88f7-dffad866742e','营销','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('9f506bbe-2dc7-4d00-9cbb-0bf175753809','人物传记','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('a0a7d635-e10b-48bf-9ab1-058f5bca6a0b','交互','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('a2531013-ea7d-48af-8dbc-e2d9a97b16c2','生活','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('a3178e1d-825b-40e9-935f-59582ccc5669','推理','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('a8988fb5-452a-4138-8a9e-d9c873fae100','校园','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('a8f3bc58-34ad-45c0-8595-3531053da61b','通信','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('a911c04d-bd2e-4cb9-8e6e-f3509fb3416a','设计','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('ad633ffe-5271-4151-ac57-bc33246f09ef','日本漫画','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('b44c741c-f8a9-42e8-bcd1-11c629498e50','阿加莎·克里斯蒂','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('bb76c0da-2013-4138-93df-39d6953e83f8','传记','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('bde0692f-aa43-4c3c-90a2-bee89c871f84','旅行','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('bed5fdf5-f5ba-4055-9f57-13c3f431f7ae','科普','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('bef920c2-161e-4967-8153-167e3f95c5b8','美食','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('c018ac35-5c7b-4268-9818-90a1ef976c5c','青春文学','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('c04f1237-b7b8-4861-a50f-cb3530a7c702','韩寒','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('c560d7c9-8bc4-46c8-a229-07a1df5de351','两性','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('c600cdff-6b4b-489a-b9c5-b592d22a6119','鲁迅','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('c608684c-376f-474d-8c7d-c439644aa357','轻小说','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('c7f703c4-7f13-422b-9660-f27ad2ac3f10','爱情','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('c80c1fcc-0dbf-4ed6-ab82-ae60eed033b9','金融','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('ca47a76f-3a3b-4107-ad53-e251423b5a87','网络小说','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('ce9798a2-1672-4d6f-9605-945f63674d99','成长','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('cea1f347-7240-47f8-8e34-8dd1277e9d9a','人际关系','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('d20d5009-ee30-4257-b50d-c7424dcf66fe','科幻','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('d49794b4-411f-4764-a0e5-304047aea76d','企业史','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('d581fd78-dc78-4cb8-9aab-cd3a95f7d257','用户体验','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('d7a6306c-1ac3-402a-bc51-3114e56fe1c1','绘画','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('d8148b83-dd35-44d4-bf2f-abe4e6844b02','自助游','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('d82d86c2-c23f-47c6-895f-e4d4a799fc39','养生','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('debea85e-eba9-409b-b5a9-d176d7b3c898','股票','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('df99c357-8245-4df3-8437-e53f6d6078e9','J.K.罗琳','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('e3921721-188a-4812-ae59-2899fe2caef9','杂文','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('e80c0128-503c-4583-b2b9-f7a410d7c360','文化','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('e87aea44-ec6b-476c-b50e-9c4c398f4124','村上春树','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('ec078bd6-9a30-4258-8f31-9d521d6f1556','科学','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('ed1ebb77-e527-4b9e-b972-46f3e96ab0f1','古典文学','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('eefc61af-b885-47d3-b227-dfd37638eb50','心理','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('f10041d0-b185-48b9-a0e3-d51608e02ba9','童话','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('f355670c-7858-4253-8738-07f3d28e426d','耽美','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('f4617468-4464-446b-a4eb-d78a6545d008','科技','科技','tab_book','e620629d-b8a6-48f4-acca-ac3d1206bcd2'),('f8008d41-2fbd-4547-bb86-e1b8e9e69bca','策划','经管','tab_book','8546b3fd-2b62-4f72-a21f-466c7a55357a'),('f885e3c7-54a6-4917-8908-8ee901f93a13','政治','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('f9e2df16-d159-4d26-a8d6-01f39a568cbe','言情','流行','tab_book','995b0fc6-49bf-4b59-b312-22e0ed37dee7'),('fa0a64a3-6bc2-4f52-9b03-896a8b14387c','茨威格','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4'),('fba145db-6b02-4e7f-b15a-8e7195da1afe','教育','生活','tab_book','75a603ec-f804-4fad-9155-fe160c7b3eb0'),('fe0ca170-8175-490a-a89c-0438d16d5279','政治学','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('ff0d757e-15fd-4644-96bc-5b908aea37f1','西方哲学','文化','tab_book','b03fb7ed-cfc8-4d76-b16a-ef8d5fb44a8d'),('fffac939-79b2-4822-9328-6dd07761950e','张爱玲','文学','tab_book','0715952c-dc40-46a8-9462-1a477ec857e4');
/*!40000 ALTER TABLE `tab_goods_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_goods_type_rel`
--

DROP TABLE IF EXISTS `tab_goods_type_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_goods_type_rel` (
  `id` varchar(36) NOT NULL,
  `goods_id` varchar(36) NOT NULL,
  `type_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_goods_type_rel`
--

LOCK TABLES `tab_goods_type_rel` WRITE;
/*!40000 ALTER TABLE `tab_goods_type_rel` DISABLE KEYS */;
INSERT INTO `tab_goods_type_rel` VALUES ('q1','1','111'),('q10','3','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('q11','4','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('q2','2','111'),('q4','4','111'),('q5','1','112'),('q6','2','113'),('q7','2','112'),('q8','1','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('q9','2','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab');
/*!40000 ALTER TABLE `tab_goods_type_rel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_order`
--

DROP TABLE IF EXISTS `tab_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_order` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  `seller_id` varchar(36) NOT NULL,
  `status` int(16) NOT NULL,
  `address` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_order`
--

LOCK TABLES `tab_order` WRITE;
/*!40000 ALTER TABLE `tab_order` DISABLE KEYS */;
INSERT INTO `tab_order` VALUES ('ad259009-d18a-42e6-898b-8f79d14da0bd','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab',1000,NULL),('b496bf63-e15c-4ba9-944b-b45b7916f94d','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','31c0d96d-0e94-4a52-8648-9c39009d5a72',1000,'jia');
/*!40000 ALTER TABLE `tab_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_order_item`
--

DROP TABLE IF EXISTS `tab_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_order_item` (
  `id` varchar(36) NOT NULL,
  `order_id` varchar(36) NOT NULL,
  `goods_id` varchar(36) NOT NULL,
  `goods_count` int(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_order_item`
--

LOCK TABLES `tab_order_item` WRITE;
/*!40000 ALTER TABLE `tab_order_item` DISABLE KEYS */;
INSERT INTO `tab_order_item` VALUES ('16929d98-b345-4ccd-b50e-f10f8d4ff740','b496bf63-e15c-4ba9-944b-b45b7916f94d','2',1),('9c95ae7c-d2d3-48e2-8e2d-877669b89e6f','b496bf63-e15c-4ba9-944b-b45b7916f94d','1',1),('c51f00d9-1a47-464a-96e5-bbd8e10734b1','ad259009-d18a-42e6-898b-8f79d14da0bd','3',1),('fb653ed2-f8e3-4346-9bdb-bc9f9279d0f1','ad259009-d18a-42e6-898b-8f79d14da0bd','2',1);
/*!40000 ALTER TABLE `tab_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_seller`
--

DROP TABLE IF EXISTS `tab_seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_seller` (
  `id` varchar(36) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_seller`
--

LOCK TABLES `tab_seller` WRITE;
/*!40000 ALTER TABLE `tab_seller` DISABLE KEYS */;
INSERT INTO `tab_seller` VALUES ('31c0d96d-0e94-4a52-8648-9c39009d5a72','Njupt@123','njuptseller','2017-02-27 14:41:19'),('5f97d096-0c09-4906-bc26-c556c772e4a4','12345','asellader','2017-02-27 14:42:43');
/*!40000 ALTER TABLE `tab_seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_shop`
--

DROP TABLE IF EXISTS `tab_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_shop` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `seller_id` varchar(36) NOT NULL,
  `img_url` varchar(36) DEFAULT NULL,
  `recommand_str` varchar(1023) DEFAULT NULL,
  `carousel_str` varchar(1023) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_shop`
--

LOCK TABLES `tab_shop` WRITE;
/*!40000 ALTER TABLE `tab_shop` DISABLE KEYS */;
INSERT INTO `tab_shop` VALUES ('e13cd0fa-225f-42d6-a970-ade9ba412f5b','two shop','31c0d96d-0e94-4a52-8648-9c39009d5a72',NULL,'3','1 2 4'),('f2a24593-b857-4ca9-84c1-48f351434ebd','two b','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab',NULL,NULL,NULL);
/*!40000 ALTER TABLE `tab_shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_user`
--

DROP TABLE IF EXISTS `tab_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_user` (
  `id` varchar(36) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_user`
--

LOCK TABLES `tab_user` WRITE;
/*!40000 ALTER TABLE `tab_user` DISABLE KEYS */;
INSERT INTO `tab_user` VALUES ('0cc95799-4660-4758-9f7e-0053187eac7a','123','ba','2017-03-17 10:22:22'),('17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','Njupt@123','njuptuser','2017-02-15 00:00:00'),('3b07f71d-50c7-4861-a25d-b598093bf861','98','happy','2017-02-17 00:00:00'),('921c0989-9654-439f-800a-978144c1c2f1','12345','ba23r','2017-02-27 14:18:59'),('981f806c-41bb-45df-a0da-d00a65a5707e','123','admin2','2017-05-04 15:48:41'),('996fd11b-817c-4419-9272-7c1e7a3f57b0','12345','bar','2017-02-27 13:29:00');
/*!40000 ALTER TABLE `tab_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_user_info_in_market`
--

DROP TABLE IF EXISTS `tab_user_info_in_market`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_user_info_in_market` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_user_info_in_market`
--

LOCK TABLES `tab_user_info_in_market` WRITE;
/*!40000 ALTER TABLE `tab_user_info_in_market` DISABLE KEYS */;
INSERT INTO `tab_user_info_in_market` VALUES ('1','0cc95799-4660-4758-9f7e-0053187eac7a'),('2','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab'),('3','3b07f71d-50c7-4861-a25d-b598093bf861');
/*!40000 ALTER TABLE `tab_user_info_in_market` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-08 15:35:07

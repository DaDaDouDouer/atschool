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
-- Table structure for table `tab_book_type`
--

DROP TABLE IF EXISTS `tab_book_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_book_type` (
  `id` varchar(36) NOT NULL,
  `name` varchar(127) NOT NULL,
  `base_name` varchar(127) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_book_type`
--

LOCK TABLES `tab_book_type` WRITE;
/*!40000 ALTER TABLE `tab_book_type` DISABLE KEYS */;
INSERT INTO `tab_book_type` VALUES ('01c9986d-7308-4b3d-ae4b-9a0c1e64810d','亦舒','流行'),('0454166e-cb8d-4e9c-9f43-72cdacfebad6','生活','生活'),('04694823-54a9-4aaa-b0a9-a12fd075ab41','诗歌','文学'),('056be475-ce79-4017-8f4a-c5a06ebd0cd3','幾米','流行'),('0866f160-e1f4-457d-80ca-bb5e82ef5687','数学','文化'),('09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab','default_book_type','default_book_type_base'),('0ebe39f6-42c5-46df-9dee-e8153d0bbd3a','编程','科技'),('0fed293c-a1a4-40ce-a9af-57b6b8a1f6e0','成长','生活'),('111','计算机','测试类型'),('112','编程','测试类型'),('113','呵呵','测试类型'),('12cd42bc-bafe-4529-8068-cd9bb52fc7a0','经济学','经管'),('16a9e73a-7f51-48d9-aeaa-ebd5672c67df','回忆录','文化'),('1738425b-689f-45d3-a7c1-e29b450bafc2','西方哲学','文化'),('1afb2e31-a398-4d9d-893f-794052e9e95e','用户体验','科技'),('1b1b7f4e-2ba7-46a1-a280-e7b89e252f3d','落落','流行'),('1d980314-b759-40af-a092-f759386ae184','金庸','流行'),('1e2aa32d-1dff-4d3f-bf09-0196eb0ddbd1','政治学','文化'),('200dfc69-7cb9-41f5-b5ae-f448298eec72','设计','文化'),('215e3c7e-b411-4641-9b29-021c662d9b18','国学','文化'),('216e94d6-02d9-498d-ae08-190ca22ad88f','情感','生活'),('21fc5955-5408-4eaa-a372-5ed1db0a8720','推理小说','流行'),('243d3db7-9bac-4a4f-9c23-03f5ac163962','摄影','生活'),('2578ad9c-6be4-497e-9bcb-477b1b7d4cbc','UCD','科技'),('27993863-fd35-4a50-8b1b-8fc29e7866e9','穿越','流行'),('2a662cbe-7b3c-45a6-a587-bafd9c28608f','日本文学','文学'),('2b2ee323-cda0-4af3-b550-ae024cd07ad2','策划','经管'),('2d0a2230-29c3-47fb-a699-2b1b22f2dbfa','理财','经管'),('2e4ac3f6-b575-4749-bfca-1bb4e1d20df8','灵修','生活'),('31e3a3a6-7fb0-4854-abd1-65387ce0e62a','J.K.罗琳','流行'),('31f0aa55-3f07-423e-be8f-b7f2262e343f','建筑','文化'),('328de2a0-ac5d-45dc-a4f3-6146a9370442','两性','生活'),('32bc0bee-0100-4273-be2e-c7d0985f9898','武侠','流行'),('3342fb9f-f9a4-46e9-a3b3-bc14b278ce69','茨威格','文学'),('37252fb2-3714-4a25-9cd1-181c089f7dba','科幻','流行'),('38f9c8da-9bda-493f-bad8-22ad2dca649d','营销','经管'),('3999cd79-33e7-4adc-8c92-d7729eacb6a8','女性','生活'),('3ad31fd3-24af-4ea2-8325-15552bb674b0','钱钟书','文学'),('3f1fcd41-6b1c-48dd-b7d4-d509ef888114','佛教','文化'),('3f5efea0-0046-4fde-bb90-73962cce1be7','当代文学','文学'),('445d9967-465c-4ddf-bee9-ae17f60bab4f','健康','生活'),('488d1b53-3762-4cbd-b2fc-a4b043939d00','自由主义','文化'),('4a6dc312-94dd-47d7-8fc1-f9572eea5078','名著','文学'),('4aa4fd0f-e4ea-4c73-880e-875d2ca31913','广告','经管'),('4ac3a600-aeee-4f5d-9804-6b99b622df8d','心理','生活'),('4ae74da0-c856-4655-b7ed-f075801fd2f2','股票','经管'),('4be6338b-714d-4ae9-a84a-3672f178b5a5','悬疑','流行'),('4c50870e-dd93-4df7-91aa-fea08e3e6ec6','三毛','流行'),('4d14339d-7588-4ac0-9871-ca97fbb9e9c2','张爱玲','文学'),('4da3e0ca-64fa-47ab-adb8-b8a5192169c0','音乐','文化'),('4ef8de0f-7e0a-47f3-8563-49a9ad4ef4a1','经济','经管'),('5088f4dc-e31c-420b-b307-66db5d321587','交互设计','科技'),('50ce13d1-8527-4296-aa92-54853bdbd800','教育','生活'),('51d40732-5bd4-4a3e-aa28-723cb1fc7b14','家居','生活'),('527255c4-6b7e-481e-9197-cde2cfd6c245','投资','经管'),('555c4723-41d1-4542-a601-2c3b2951f57d','日本漫画','流行'),('5bfc8652-23cc-4a84-9fe4-2b9ed99b4b11','神经网络','科技'),('5d898a92-1de3-4820-9f48-15442ae67a8a','人际关系','生活'),('5da98a00-02cd-4673-a025-358dd7c83c77','考古','文化'),('5fe6e201-2222-4cb6-9347-c7a081f030f9','商业','经管'),('602b9a5b-825d-4641-b10d-2405f6b8059b','绘本','流行'),('63d6264b-6d77-4853-a796-0436ff4bbf38','人文','文化'),('698a8a62-5437-46ad-b0a3-99c8a27a95d4','几米','流行'),('6ab9de31-c56e-4c27-b904-9d3069385284','手工','生活'),('716e0714-cd5b-424f-b94b-bf4a38889d08','东野圭吾','流行'),('71ea45ec-75a7-4e9f-aca6-524f622dc3b9','美术','文化'),('73902821-a0d8-4c0c-9532-52280364216b','外国文学','文学'),('75aef09d-92f0-43c1-991f-fb51d7f62df9','诗词','文学'),('77cd1820-8708-49e3-b228-32b214df0c6d','绘画','文化'),('786ad4d5-cd9e-4420-bc26-32967981f73d','通信','科技'),('797a9b4e-a484-46cd-8c88-b064fa0ba570','政治','文化'),('7a87a081-31a7-4213-9a63-c3f403d25d9e','网络小说','流行'),('7ed0e046-ae9e-4a40-853a-d76554eb11e5','传记','文化'),('7f3d8134-3b33-4a84-8c00-282d76a26ab2','校园','流行'),('82a463bd-8137-49ff-aeba-a90908232eea','小说','文学'),('82f4db1a-af5a-41b8-a522-cce5b886029e','鲁迅','文学'),('8523a342-bef9-4176-81a6-a052326e5a63','近代史','文化'),('877038fa-e836-4041-a1f9-695998457784','交互','科技'),('882c7a7b-23c6-422c-a026-863d58bebe3f','安妮宝贝','流行'),('884b3fd8-b059-4727-86a1-0c3d67cbb384','美食','生活'),('8cd98418-b478-4cce-9d93-0238c61051d4','社会学','文化'),('8ce7b736-2006-46c2-b6fd-2305df073ea0','经典','文学'),('8cfe412a-7cbd-41a9-acb7-7aa758131f2d','文学','文学'),('8f78ed20-bb64-4aed-9ff9-b5e783b31982','儿童文学','文学'),('91ca8ae3-cfdb-4512-b1d1-eca1f8422ce0','戏剧','文化'),('93ceb4d7-6a1e-478a-bf88-82d19ac878dd','艺术','文化'),('9490014e-ad26-4fe9-a66b-2225075bdcfc','青春','流行'),('968bb1b7-ddbc-4439-b0b4-5bb175974853','自助游','生活'),('98344807-48d0-429b-899f-d1dfd1208867','奇幻','流行'),('988fbca8-586d-4d85-b7ef-c8e7157162b5','科幻小说','流行'),('9961e6a1-eae9-4900-91aa-b9e4b408932c','王小波','文学'),('9e31effb-2df3-4c7b-b016-6f5e495cf38b','旅行','生活'),('9f845498-84bb-4fef-bfe1-c1580c4a47df','米兰·昆德拉','文学'),('a159252e-bf23-49d7-9db1-3793359ad3d9','电影','文化'),('a326a620-b472-4604-8f1d-b39f60eafdda','沧月','流行'),('a8331d62-4f3a-424c-8da4-8a1a4359dd02','推理','流行'),('ae8b1e57-5adf-435d-b620-03516036d187','杂文','文学'),('aeebcb9f-cb90-4476-9492-6e239f8c4195','军事','文化'),('b240c716-6cd6-4899-905a-77f1e4028681','青春文学','流行'),('b5079d6f-521d-4802-a55e-4d10fee434ef','耽美','流行'),('b65fbc6b-3028-45ca-a281-e2d0c5bb649f','艺术史','文化'),('b7a98288-aa91-4f7d-89ff-92b36d9c22fd','村上春树','文学'),('b7c4ca69-0a6a-43f8-9d33-f9133b2c9d04','魔幻','流行'),('ba8aa993-1408-42a1-a0c0-b2af0ace652b','哲学','文化'),('ba8b8f61-5d08-4f73-8d98-277a6d90db58','随笔','文学'),('ba92379d-970e-4584-b089-44b464552d92','港台','文学'),('bb464353-03f9-4c5b-8b40-2535d6197c87','爱情','生活'),('be3f99f6-e564-4b25-9ab2-b9c21380e5e8','中国历史','文化'),('c4e4d7a4-9f6f-4840-bbb0-a7c3ff206281','企业史','经管'),('c5aa4756-7335-4931-956f-0a86e0ef8aa2','职场','生活'),('c9b5fa62-1609-4a7a-9037-c1d0e7acdedf','二战','文化'),('caaa41e5-3617-4488-9419-8572584964d6','漫画','流行'),('cd2a847a-4bb0-4293-8995-166b50e949c7','文化','文化'),('cd865794-dbd8-4b44-86fa-74b0867b8c81','思想','文化'),('cdf9b999-7a2a-42f3-a07f-bf256c2d091c','科学','科技'),('ce17cca2-c5ec-4f2c-9d2a-abcc6af3fe5f','高木直子','流行'),('cfc5975a-131f-4c42-984f-70f3b0aa696c','科技','科技'),('cfd04f17-2926-40cd-8506-4af401b47c60','外国名著','文学'),('d24c6adc-a4be-4c6a-af37-f049dfd2ea95','科普','科技'),('d3275f05-3d0b-4ce6-8ea5-5781608c0716','散文','文学'),('d420334a-f2b4-4fab-87ec-79bc40d955d7','张小娴','流行'),('d79472d0-316e-4170-93f5-50a479c6f1a7','中国文学','文学'),('d8e7cac4-c0c2-422f-83ec-710a994101f5','古典文学','文学'),('da8af9b2-daba-4b0b-b817-007ec0470891','童话','文学'),('dac99b85-0d2f-4bf3-b585-a955cf56c02c','人物传记','文化'),('dbafefcc-4ec6-49b5-8bdf-8027887fc1f7','余华','文学'),('dc75cab9-b116-496e-b1ae-27f499d2b5b8','郭敬明','流行'),('dd981fb1-9e5f-464a-8462-38f489ac9368','创业','经管'),('de26ce09-aedb-4a4d-bd43-ba111575d952','杜拉斯','文学'),('dfcb7fb4-9c70-4576-9653-5e174f4bbf75','算法','科技'),('e374a3c8-16dc-4ba8-b433-0ff30959a1cd','言情','流行'),('e5de4806-3bb2-4331-b688-0a5edc2cb939','游记','生活'),('e5f0eb54-8559-4e95-88f0-250eb1d9cfc1','励志','生活'),('e671db3e-8128-480e-9eb0-5f7375642bc3','韩寒','流行'),('e786d516-ae26-4de8-8011-c3b5ce73b841','web','科技'),('ebd08792-69b1-4027-9a13-f416aeb6a5df','轻小说','流行'),('ef4e6a48-471b-4a17-8edb-6b368efbd785','宗教','文化'),('f0ea39f1-8416-4173-868d-83f64f93a03a','阿加莎·克里斯蒂','流行'),('f3c04025-c0a5-487a-bbb4-3a7007ad8a9e','UE','科技'),('f4f9b62a-d3d8-4f06-8583-05f972298c12','金融','经管'),('f6745765-3447-47e4-8adf-7b26223212e2','养生','生活'),('f722b91e-2a76-461c-99df-4c8535291ab5','管理','经管'),('f87d9ad8-fab0-4181-a1cc-8c4cb845216d','历史','文化'),('fa13c1fe-d95a-46c6-ae78-cb86915bc173','互联网','科技'),('fb76d048-34cf-4185-b333-3002498ff834','古龙','流行'),('fbfbcf22-2873-49c1-937e-bbcab8100977','张悦然','流行'),('fca3f5cb-f89d-4b05-bd65-007c2ff8cc53','心理学','文化'),('ffbd18a6-c831-4219-b9a0-9790dbffbb54','社会','文化');
/*!40000 ALTER TABLE `tab_book_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_book_type_rel`
--

DROP TABLE IF EXISTS `tab_book_type_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_book_type_rel` (
  `id` varchar(36) NOT NULL,
  `book_id` varchar(36) NOT NULL,
  `book_type_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_book_type_rel`
--

LOCK TABLES `tab_book_type_rel` WRITE;
/*!40000 ALTER TABLE `tab_book_type_rel` DISABLE KEYS */;
INSERT INTO `tab_book_type_rel` VALUES ('q1','11','111'),('q10','13','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('q11','14','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('q2','12','111'),('q4','14','111'),('q5','11','112'),('q6','12','113'),('q7','12','112'),('q8','11','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('q9','12','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab');
/*!40000 ALTER TABLE `tab_book_type_rel` ENABLE KEYS */;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_cart_item`
--

LOCK TABLES `tab_cart_item` WRITE;
/*!40000 ALTER TABLE `tab_cart_item` DISABLE KEYS */;
INSERT INTO `tab_cart_item` VALUES ('52d1d71f-22ec-47c6-9d6c-8546f2b5ca4c','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','3',3),('69ba6683-911c-4ae8-8a25-0ba7129123fc','0cc95799-4660-4758-9f7e-0053187eac7a','3',3);
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_goods`
--

LOCK TABLES `tab_goods` WRITE;
/*!40000 ALTER TABLE `tab_goods` DISABLE KEYS */;
INSERT INTO `tab_goods` VALUES ('1','11','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','tab_book','C',321.2,1,'http://evgetgif.qiniudn.com/C-language-book-2.jpg'),('2','12','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','tab_book','Java',432.4,5,'http://cdn.jingkao.net/group1/M00/7B/49/rBoMg1MznqaAExOPAABoZrRB6Qg184.jpg'),('3','13','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','tab_book','C++',439.2,2,'http://img3x0.ddimg.cn/4/25/22910980-1_w_1.jpg'),('4','14','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','tab_book','PHP',32.6,4,'http://img3x9.ddimg.cn/94/4/21127189-1_w_2.jpg');
/*!40000 ALTER TABLE `tab_goods` ENABLE KEYS */;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_order`
--

LOCK TABLES `tab_order` WRITE;
/*!40000 ALTER TABLE `tab_order` DISABLE KEYS */;
INSERT INTO `tab_order` VALUES ('92b5b1e2-c3b0-4ac8-bf1c-7204e3b67b0c','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','31c0d96d-0e94-4a52-8648-9c39009d5a72',1000),('ad259009-d18a-42e6-898b-8f79d14da0bd','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab',1000);
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
INSERT INTO `tab_order_item` VALUES ('34f6ec8d-a855-40d3-b271-3a720b6f23dd','92b5b1e2-c3b0-4ac8-bf1c-7204e3b67b0c','1',2),('68f72aea-9893-4fa1-aab5-9851b8a7ea3f','92b5b1e2-c3b0-4ac8-bf1c-7204e3b67b0c','2',3),('c51f00d9-1a47-464a-96e5-bbd8e10734b1','ad259009-d18a-42e6-898b-8f79d14da0bd','3',1),('fb653ed2-f8e3-4346-9bdb-bc9f9279d0f1','ad259009-d18a-42e6-898b-8f79d14da0bd','2',1);
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
INSERT INTO `tab_seller` VALUES ('31c0d96d-0e94-4a52-8648-9c39009d5a72','12345','sel','2017-02-27 14:41:19'),('5f97d096-0c09-4906-bc26-c556c772e4a4','12345','asellader','2017-02-27 14:42:43');
/*!40000 ALTER TABLE `tab_seller` ENABLE KEYS */;
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
INSERT INTO `tab_user` VALUES ('0cc95799-4660-4758-9f7e-0053187eac7a','123','ba','2017-03-17 10:22:22'),('17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','Njupt@123','njuptuser','2017-02-15 00:00:00'),('3b07f71d-50c7-4861-a25d-b598093bf861','98','happy','2017-02-17 00:00:00'),('921c0989-9654-439f-800a-978144c1c2f1','12345','ba23r','2017-02-27 14:18:59'),('996fd11b-817c-4419-9272-7c1e7a3f57b0','12345','bar','2017-02-27 13:29:00');
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

-- Dump completed on 2017-03-19  9:32:24

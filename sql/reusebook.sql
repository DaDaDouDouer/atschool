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
  `description` varchar(2047) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_book`
--

LOCK TABLES `tab_book` WRITE;
/*!40000 ALTER TABLE `tab_book` DISABLE KEYS */;
INSERT INTO `tab_book` VALUES ('063863f4-615b-4575-a49e-20e04ed64874','敏捷革命：提升个人创造力与企业效率的全新协作模式','[美] 杰夫·萨瑟兰 ','9787508671437','https://img3.doubanio.com/mpic/s29413786.jpg','有一种神奇的项目管理方法：\n张小龙用它来开发QQ邮箱，管理微信团队；\n京东、华为、中兴都在进行内部学习；\nHBO的热剧《硅谷》将它搬上荧幕\n通用电气利用它加速实现了“数字行业公司”的转型\nTwitter利用它来开发各项新功能\n它帮助美国国家公共广播电台创新节目\n助力美国联邦调查局开发虚拟案件档案系统\n这套方法就叫作Scrum，被誉为“管理学的诺贝尔奖”，在全球掀起了一场敏捷革命。\n--------------------\n1. “Scrum之父”萨瑟兰博士精华作品。\nScrum被誉为“管理学的诺贝尔奖”，在全球掀起了一场敏捷革命，微信、京东、华为、通用电气、Twitter、FBI一致采用的管理方法。本书由Scrum创始人写就，深入浅出地讲解了敏捷管理的精髓。\n2. 改变未来工作的高效管理方法。\n敏捷是一场关于适者生存的进化。未来工作的复杂性和创新性都会有巨大的提升，从而对于团队的定义、时间的规划、效率的测算，以及产品价值的发掘都会有颠覆性的改变。《敏捷革命》指导你如何用新型管理方式，适应未来，并且提升组织绩效，发挥个人创造力。\n3.全球顶级企业实干派与管理研究者一致推崇的管理变革。\n《精益创业》作者埃里克•莱斯、Twitter首席技术官亚当•梅辛格、哈佛商学院教授竹内弘高等众多大咖推荐。Twitter首席技术官直言：“我在Twitter大大小小的开发项目中都采用了Scrum。”\n“关于敏捷开发我特别希望大家能够多去做一些尝试……敏捷带来一个最好的心理感受是什么呢？我们今天可以想一些与众不同的点子，然后我们可以很快就看到效果，因为我们可以很快把它上线了，然后可以去验证，如果不对就下线，如果还有改进余地，下个星期再去改它……这是一个能够持续实现你的想法的过程。”\n——张小龙\n----------------------------\n在项目管理中，我们通常会制定好详细的计划，对每一个阶段都进行严格的评审，当前一阶段的工作完成得足够好，才进入下一步。这种流程进度缓慢，开发过程往往滞后于计划，造成预算超支。并且最终制造出的产品也可能不符合用户变化的需求，或已经跟不上技术的发展。\n为了规避这些缺陷，萨瑟兰博士发明了Scrum方法。与自上而下的命令式工作流程不同，Scrum是一套具有不断进化与自我修正能力的系统，让团队像机器人一样根据外界反馈进行调整。这套系统强调团队的高度透明性及密切的协同作业，通过精简内部成员之间的信息流，提高效率，实现高水平的业绩。\nScrum不仅是科技行业开发新软件和新产品的主要方式，还能够帮助你的公司改变固有的工作方式、创新方式、规划方式以及思考方式。'),('11','C','daf','53426436','http://evgetgif.qiniudn.com/C-language-book-2.jpg',NULL),('12','Java','ytutre','6744533','http://cdn.jingkao.net/group1/M00/7B/49/rBoMg1MznqaAExOPAABoZrRB6Qg184.jpg',NULL),('13','C++','fbds','465743','http://img3x0.ddimg.cn/4/25/22910980-1_w_1.jpg',NULL),('14','PHP','dsafsd','3214577','http://img3x9.ddimg.cn/94/4/21127189-1_w_2.jpg',NULL),('2c9fa6ed-9ec9-475c-8dd0-836047e2d936','观看的方法：如何解读视觉材料','[英] 吉莉恩·罗斯 ','9787562468462','https://img1.doubanio.com/mpic/s29426007.jpg','-编辑推荐-\n•本书是近二十年来，视觉研究方法领域的权威著作。就它企图对研究视觉材料的各式各样的方法进行全面而系统的讨论和评价而言，本书依然独一无二。\n•本书第3版，增加了对受众研究、民族志、照片文档、照片引谈、摄影小品，以及视觉伦理研究等视觉方法的讨论，展示了视觉研究及其方法的不断发展的本质。\n•书中穿插的大量关于数字媒体的内容，亦是新版的一大亮点。\n-内容简介-\n本书坚定地专注于研究方法而不是媒体。书中的主体章节，每一章都会讨论一种可用于诠释视觉材料的方法，而每一章要用何种视觉材料来探究这种方法，则取决于它是否最能体现这种方法的步骤、长处和不足。本书要做的就是深度探讨每一种方法。\n第1章是对用来理解视觉文化各种不同理论方法的概览，同时也探究了一些关于无处不在的数字影像所造成的差异问题。\n在第2章中，作者精心制作了一个指导读者使用她提出的“批判性视觉方法论”的实用性框架。\n第3章详细解释了本书的结构，这将有助于读者从随后讨论方法的章节中有所斩获。\n从第4章到第10章均专注于处理既有影像的方法，如内容分析、符号学、精神分析和话语分析等。\n第11章比前一版更为细致地专注于另外一些研究视觉影像的方法，这些方法旨在处理为解答研究的问题而制作的视觉影像。\n视觉伦理学是第3版中全新的一章。研究活动中的伦理学关乎研究者的行为。它关注他们研究中自身的诚实和坚定性，以及他们正在与什么材料，或跟谁一起展开研究如此这般的关系问题。'),('2f365f00-aaad-4768-a003-0c8816b93bf3','七杀简史','[牙买加] 马龙·詹姆斯 ','9787559400239','https://img3.doubanio.com/mpic/s29408611.jpg','这是七次杀戮的故事，是一个时代罪恶、暴力、秘密的编年史。\n牙买加，1976 年12 月3 日，大选在即。\n七名枪手闯入一位国民级雷鬼歌手家中疯狂扫射——歌手原定于两天后举办一场和平演唱会。歌手逃过一劫，但身受重伤，枪手则全部逃逸。\n这一扑朔迷离的真实事件，将通过76个虚构角色之口重现。贫民窟的孩子、毒贩、枪手、《滚石》杂志记者、妓女、黑帮老大、中情局特工，甚至鬼魂…开始诉说。\n“走进一个局面，你要么拿着注射器，要么拿着枪。有些东西你能治好，有些东西你必须打死。”\n“贫民窟里有一种孩子每天都要奔向大海，只为了一头扎进某个地方然后忘记一切。”\n“你慢慢地会喜欢上永不改变的少数几样东西。”\n“音乐不会带走疼痛，但只要音乐开始播放，我感受到的就不再是疼痛，而是节奏。”\n“我疯狂战斗，直到厌倦为止。”'),('3b2e071d-203d-4ca4-b1fb-c253d20e6764','半落','[日] 横山秀夫 ','9787530668887','https://img3.doubanio.com/mpic/s29383726.jpg','“谁是真凶”模式走投无路之时，两本对时代产生了巨大影响的书，拯救了日本推理小说：一是东野圭吾的《恶意》，一是横山秀夫的《半落》\n·\n审讯好比读书，嫌疑人就是书里的主角。他们不会主动从故事里走出来。一个疏忽，他们的秘密就将永远封存。\n他是我多年的同事，一个受人尊敬的前辈。\n一 年前，他的儿子病死。两天前儿子忌日的时候，他亲手掐死了妻子。他对犯罪事实供认不讳，可问题是对于“案发后两天”发生的事，他始终一言不吐。陷入了不完全招供的“半落”状态。\n他其实完全没有了后顾之忧，他既可以以死谢罪，也可以亡命天涯，可是他为何选择自首，选择去监狱度过余生，甚至死刑？\n两天里发生了什么，值得他如此守护？\n_________________________________________\n◆日本超级畅销书，比东野圭吾更受编剧欢迎的日本作家、书店畅销天王横山秀夫高水准代表作\n◆“这本推理小说了不起”第1名，《周刊文春》推理小说BEST10第1名，改编电影荣获“日本奥斯卡”最佳影片奖\n◆一个改变你人生观的故事：一个人走到半生，也许一无所有，也许满 身泥泞，甚至凄凉坎坷，但总有一个羁绊是走下去的理由，《半落》也许给出了最好的理由\n◆这个故事有多好，就像东野圭吾《新参者》那么好。我从中读到的不是精密的仪器说明书，而是裸露的电线，一组一组，精心而真切，真切而有能量。不愧为改变日本推理小说走向的伟大小说，可谓“一笔入魂”。——鹦鹉史航'),('4062d47c-e2b1-4f6e-b2d8-f25ee03f2bb1','不成问题的问题','老舍 ','9787201115177','https://img3.doubanio.com/mpic/s29413380.jpg','【内容简介】\n老舍《不成问题的问题》原载1943年《大公报》，故事发生在抗战重庆树华农场，农场管理者丁场长管理能力不行，但哄人能力一流，精通人情世故，在他治理下，大家整日偷鸡打牌，混日子。树华农场颓势一片，冒牌青年艺术家秦妙斋也掺和进来。留学归来尤主任接管农场后，开始整治作风，大家感到了自律和科学带来的愉悦……\n全书收录《不成问题的问题》、《微神》、《断魂枪》、《月牙儿》、《我这一辈子》五篇，篇篇皆为经典中的经典。\n【编辑推荐】\n中国老舍研究会推荐\n改编电影斩获金马奖最佳改编剧本、最佳男主角，北京电影学院青年制片厂官方授权合作\n【名人推荐】\n我发现老舍小说中的深度、激情和幽默都是世界性的、超越国界的。\n——诺贝尔文学奖得主、法国作家勒·克莱齐奥\n据我接触到的文学情报，目前全世界得到公认的中国新文学家也只有沈从文与老舍。\n——朱光潜\n老舍是市民文学的代表，独特的下层生活经验，使得老舍对北京市民的性格和生活有着深入的了解和体会，老舍作品中的爱与恨同市民社会中的爱与恨是一致的。\n——陈思和\n老舍显然已经认定，在一个病态社会里，要改善无产阶级的处境就得要集体行动；如果这个阶级有人要用自己的力量来求发展，只突然加速他自己的灭亡而已……毫无疑问，老舍是把社会批判当做小说里不可缺少的一部分。\n——夏志清\n老舍与钱钟书，沈从文不同，49年后他以自己的民间性，底层性，世俗性与主流意识形态达成默契。现在还有谁，具有老舍那极端的笔墨情趣呢？——章诒和\n江湖人怎么说话，看看老舍的《断魂枪》就知道了。——宁财神（编剧）\n毫无疑问，老舍的《断魂枪》，是中国现代文学史上最优秀的武侠短篇小说——严锋（复旦大学中文系教授）\n读老舍《月牙儿》，写得真好。老舍还就是老舍啊。尽管后来有些御用之作，他的写作才能还是不容小觑。——李银河\n完全是被书里贯彻的那种温柔敦厚打动：那种乱世里，明知道个人完全无能为力，明明看透了人性里所有的坏和脏，却仍然温柔凝视，不舍不弃，肃穆庄严。——绿妖（作家）\n（《月牙儿》）这是老舍最有新意的创造之一，至少这个小说整体叙事话语充分践行了德勒兹和米勒所谓的“重复与差异”战术，比诸茨威格《一个陌生女人的来信》有过之而无不及。——肖涛（文学评论家）'),('5cdd98ca-8e4c-4c77-8f2b-63d68a95083d','龙族Ⅲ','江南 ','9787549220632','https://img3.doubanio.com/mpic/s27174422.jpg','日本海沟深处发现龙类遗迹，卡塞尔王牌专员组恺撒、楚子航、路明非在身深潜过程中遭遇龙类袭击。三人组挣扎逃离险境，试图联络本部，却发现遭到整个日本分部的背叛与追杀。千鹤町街头，三人与暴走族赤备狭路相逢，掀起疯狂的对决。死里逃生后，三人流落到歌舞伎町著名牛郎店高天原，开始了 牛郎生涯。与此同时，因日本分部的叛离，校长昂热孤身一人来到东京，与自己昔日的弟子犬山贺兵刃相见，卡塞尔学院与蛇岐八家彻底决裂！\n而对于牛郎三人组来说，高天原是个完美的庇护所，恺撒和楚子航迅速俘获了大量粉丝，成为高天原镇店之宝。为了复仇并找到蛇岐八家的秘密，他们决定夜探源氏重工！大厦里危机重重，日本分部的追杀，死侍的进攻，三人组力透重围，终于闯入了密室，并看到大量神秘壁画，龙族历史由此揭开。\n全新的龙族文化，全新的阅读体验。请细细品读最好看的热血幻想小说——《龙族Ⅲ黑月之潮》中集。');
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
INSERT INTO `tab_cart_item` VALUES ('04aeefa2-249b-4f73-8fcb-68e5e23984df','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','1',0,1),('98f08ed1-6626-4ee9-aca8-3d8295006d85','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','2',0,1),('9c142036-8a5b-4721-84f8-34a672130c56','0cc95799-4660-4758-9f7e-0053187eac7a','3',2,1);
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
INSERT INTO `tab_delivery_address` VALUES ('57de927e-e760-468f-b5d2-d61b5827bc56','2','江苏省南京市栖霞区文苑路南京邮电大学'),('9eb86ebf-f93a-41ab-ad44-56414d4222b7','2','山西省大同市御东新区大同大学'),('c5e978c5-ad4f-42ac-ad92-ee612bf6027a','1','nanyou');
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
  `user_name` varchar(255) NOT NULL,
  `seller_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_evaluation`
--

LOCK TABLES `tab_evaluation` WRITE;
/*!40000 ALTER TABLE `tab_evaluation` DISABLE KEYS */;
INSERT INTO `tab_evaluation` VALUES ('6d91f93f-2102-4833-846a-0226a5cbbb6f','3','sdftt65676yut','2017-02-24 18:59:08','0cc95799-4660-4758-9f7e-0053187eac7a','ba','njuptseller'),('a48fee1c-0893-403b-a7f6-54a3c95a63ef','1','新加的评论','2017-05-22 11:16:36','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','njuptuser','njuptseller');
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
  `sellername` varchar(127) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_goods`
--

LOCK TABLES `tab_goods` WRITE;
/*!40000 ALTER TABLE `tab_goods` DISABLE KEYS */;
INSERT INTO `tab_goods` VALUES ('0f9b77a2-01a7-46e0-ac57-42a5ee4cd28e','2c9fa6ed-9ec9-475c-8dd0-836047e2d936','586c450b-1d91-48af-8e1b-a12b8edfe03c','tab_book','观看的方法：如何解读视觉材料',88,9,'https://img1.doubanio.com/mpic/s29426007.jpg',0,'-编辑推荐-\n•本书是近二十年来，视觉研究方法领域的权威著作。就它企图对研究视觉材料的各式各样的方法进行全面而系统的讨论和评价而言，本书依然独一无二。\n•本书第3版，增加了对受众研究、民族志、照片文档、照片引谈、摄影小品，以及视觉伦理研究等视觉方法的讨论，展示了视觉研究及其方法的不断发展的本质。\n•书中穿插的大量关于数字媒体的内容，亦是新版的一大亮点。\n-内容简介-\n本书坚定地专注于研究方法而不是媒体。书中的主体章节，每一章都会讨论一种可用于诠释视觉材料的方法，而每一章要用何种视觉材料来探究这种方法，则取决于它是否最能体现这种方法的步骤、长处和不足。本书要做的就是深度探讨每一种方法。\n第1章是对用来理解视觉文化各种不同理论方法的概览，同时也探究了一些关于无处不在的数字影像所造成的差异问题。\n在第2章中，作者精心制作了一个指导读者使用她提出的“批判性视觉方法论”的实用性框架。\n第3章详细解释了本书的结构，这将有助于读者从随后讨论方法的章节中有所斩获。\n从第4章到第10章均专注于处理既有影像的方法，如内容分析、符号学、精神分析和话语分析等。\n第11章比前一版更为细致地专注于另外一些研究视觉影像的方法，这些方法旨在处理为解答研究的问题而制作的视觉影像。\n视觉伦理学是第3版中全新的一章。研究活动中的伦理学关乎研究者的行为。它关注他们研究中自身的诚实和坚定性，以及他们正在与什么材料，或跟谁一起展开研究如此这般的关系问题。','index'),('1','11','31c0d96d-0e94-4a52-8648-9c39009d5a72','tab_book','C',321.2,0,'http://evgetgif.qiniudn.com/C-language-book-2.jpg',4,'a new desp2','njuptseller'),('2','12','31c0d96d-0e94-4a52-8648-9c39009d5a72','tab_book','Java',432.4,3,'http://cdn.jingkao.net/group1/M00/7B/49/rBoMg1MznqaAExOPAABoZrRB6Qg184.jpg',13,NULL,'njuptseller'),('25f3d373-23fa-45d5-97db-b51537f78b00','4062d47c-e2b1-4f6e-b2d8-f25ee03f2bb1','586c450b-1d91-48af-8e1b-a12b8edfe03c','tab_book','不成问题的问题',29,6,'https://img3.doubanio.com/mpic/s29413380.jpg',0,'【内容简介】\n老舍《不成问题的问题》原载1943年《大公报》，故事发生在抗战重庆树华农场，农场管理者丁场长管理能力不行，但哄人能力一流，精通人情世故，在他治理下，大家整日偷鸡打牌，混日子。树华农场颓势一片，冒牌青年艺术家秦妙斋也掺和进来。留学归来尤主任接管农场后，开始整治作风，大家感到了自律和科学带来的愉悦……\n全书收录《不成问题的问题》、《微神》、《断魂枪》、《月牙儿》、《我这一辈子》五篇，篇篇皆为经典中的经典。\n【编辑推荐】\n中国老舍研究会推荐\n改编电影斩获金马奖最佳改编剧本、最佳男主角，北京电影学院青年制片厂官方授权合作\n【名人推荐】\n我发现老舍小说中的深度、激情和幽默都是世界性的、超越国界的。\n——诺贝尔文学奖得主、法国作家勒·克莱齐奥\n据我接触到的文学情报，目前全世界得到公认的中国新文学家也只有沈从文与老舍。\n——朱光潜\n老舍是市民文学的代表，独特的下层生活经验，使得老舍对北京市民的性格和生活有着深入的了解和体会，老舍作品中的爱与恨同市民社会中的爱与恨是一致的。\n——陈思和\n老舍显然已经认定，在一个病态社会里，要改善无产阶级的处境就得要集体行动；如果这个阶级有人要用自己的力量来求发展，只突然加速他自己的灭亡而已……毫无疑问，老舍是把社会批判当做小说里不可缺少的一部分。\n——夏志清\n老舍与钱钟书，沈从文不同，49年后他以自己的民间性，底层性，世俗性与主流意识形态达成默契。现在还有谁，具有老舍那极端的笔墨情趣呢？——章诒和\n江湖人怎么说话，看看老舍的《断魂枪》就知道了。——宁财神（编剧）\n毫无疑问，老舍的《断魂枪》，是中国现代文学史上最优秀的武侠短篇小说——严锋（复旦大学中文系教授）\n读老舍《月牙儿》，写得真好。老舍还就是老舍啊。尽管后来有些御用之作，他的写作才能还是不容小觑。——李银河\n完全是被书里贯彻的那种温柔敦厚打动：那种乱世里，明知道个人完全无能为力，明明看透了人性里所有的坏和脏，却仍然温柔凝视，不舍不弃，肃穆庄严。——绿妖（作家）\n（《月牙儿》）这是老舍最有新意的创造之一，至少这个小说整体叙事话语充分践行了德勒兹和米勒所谓的“重复与差异”战术，比诸茨威格《一个陌生女人的来信》有过之而无不及。——肖涛（文学评论家）','index'),('3','13','31c0d96d-0e94-4a52-8648-9c39009d5a72','tab_book','C++',439.2,2,'http://img3x0.ddimg.cn/4/25/22910980-1_w_1.jpg',6,NULL,'njuptseller'),('4','14','31c0d96d-0e94-4a52-8648-9c39009d5a72','tab_book','PHP',32.6,4,'http://img3x9.ddimg.cn/94/4/21127189-1_w_2.jpg',2,NULL,'njuptseller'),('4c1ae8aa-8331-4513-b111-3924a63727db','5cdd98ca-8e4c-4c77-8f2b-63d68a95083d','586c450b-1d91-48af-8e1b-a12b8edfe03c','tab_book','龙族Ⅲ',25,1,'https://img3.doubanio.com/mpic/s27174422.jpg',0,'日本海沟深处发现龙类遗迹，卡塞尔王牌专员组恺撒、楚子航、路明非在身深潜过程中遭遇龙类袭击。三人组挣扎逃离险境，试图联络本部，却发现遭到整个日本分部的背叛与追杀。千鹤町街头，三人与暴走族赤备狭路相逢，掀起疯狂的对决。死里逃生后，三人流落到歌舞伎町著名牛郎店高天原，开始了 牛郎生涯。与此同时，因日本分部的叛离，校长昂热孤身一人来到东京，与自己昔日的弟子犬山贺兵刃相见，卡塞尔学院与蛇岐八家彻底决裂！\n而对于牛郎三人组来说，高天原是个完美的庇护所，恺撒和楚子航迅速俘获了大量粉丝，成为高天原镇店之宝。为了复仇并找到蛇岐八家的秘密，他们决定夜探源氏重工！大厦里危机重重，日本分部的追杀，死侍的进攻，三人组力透重围，终于闯入了密室，并看到大量神秘壁画，龙族历史由此揭开。\n全新的龙族文化，全新的阅读体验。请细细品读最好看的热血幻想小说——《龙族Ⅲ黑月之潮》中集。','index'),('97a858ab-fd31-4fbd-aac8-953eb4487f4e','5cdd98ca-8e4c-4c77-8f2b-63d68a95083d','31c0d96d-0e94-4a52-8648-9c39009d5a72','tab_book','龙族Ⅲ',12.2,10,'https://img3.doubanio.com/mpic/s27174422.jpg',0,'日本海沟深处发现龙类遗迹，卡塞尔王牌专员组恺撒、楚子航、路明非在身深潜过程中遭遇龙类袭击。三人组挣扎逃离险境，试图联络本部，却发现遭到整个日本分部的背叛与追杀。千鹤町街头，三人与暴走族赤备狭路相逢，掀起疯狂的对决。死里逃生后，三人流落到歌舞伎町著名牛郎店高天原，开始了 牛郎生涯。与此同时，因日本分部的叛离，校长昂热孤身一人来到东京，与自己昔日的弟子犬山贺兵刃相见，卡塞尔学院与蛇岐八家彻底决裂！\n而对于牛郎三人组来说，高天原是个完美的庇护所，恺撒和楚子航迅速俘获了大量粉丝，成为高天原镇店之宝。为了复仇并找到蛇岐八家的秘密，他们决定夜探源氏重工！大厦里危机重重，日本分部的追杀，死侍的进攻，三人组力透重围，终于闯入了密室，并看到大量神秘壁画，龙族历史由此揭开。\n全新的龙族文化，全新的阅读体验。请细细品读最好看的热血幻想小说——《龙族Ⅲ黑月之潮》中集。','njuptseller'),('cb058263-a01e-411c-b6f9-7700eead5122','3b2e071d-203d-4ca4-b1fb-c253d20e6764','586c450b-1d91-48af-8e1b-a12b8edfe03c','tab_book','半落',39,4,'https://img3.doubanio.com/mpic/s29383726.jpg',0,'“谁是真凶”模式走投无路之时，两本对时代产生了巨大影响的书，拯救了日本推理小说：一是东野圭吾的《恶意》，一是横山秀夫的《半落》\n·\n审讯好比读书，嫌疑人就是书里的主角。他们不会主动从故事里走出来。一个疏忽，他们的秘密就将永远封存。\n他是我多年的同事，一个受人尊敬的前辈。\n一 年前，他的儿子病死。两天前儿子忌日的时候，他亲手掐死了妻子。他对犯罪事实供认不讳，可问题是对于“案发后两天”发生的事，他始终一言不吐。陷入了不完全招供的“半落”状态。\n他其实完全没有了后顾之忧，他既可以以死谢罪，也可以亡命天涯，可是他为何选择自首，选择去监狱度过余生，甚至死刑？\n两天里发生了什么，值得他如此守护？\n_________________________________________\n◆日本超级畅销书，比东野圭吾更受编剧欢迎的日本作家、书店畅销天王横山秀夫高水准代表作\n◆“这本推理小说了不起”第1名，《周刊文春》推理小说BEST10第1名，改编电影荣获“日本奥斯卡”最佳影片奖\n◆一个改变你人生观的故事：一个人走到半生，也许一无所有，也许满 身泥泞，甚至凄凉坎坷，但总有一个羁绊是走下去的理由，《半落》也许给出了最好的理由\n◆这个故事有多好，就像东野圭吾《新参者》那么好。我从中读到的不是精密的仪器说明书，而是裸露的电线，一组一组，精心而真切，真切而有能量。不愧为改变日本推理小说走向的伟大小说，可谓“一笔入魂”。——鹦鹉史航','index'),('f153ace2-8783-4dc7-b6cb-55f320b43a38','063863f4-615b-4575-a49e-20e04ed64874','586c450b-1d91-48af-8e1b-a12b8edfe03c','tab_book','敏捷革命：提升个人创造力与企业效率的全新协作模式',69,2,'https://img3.doubanio.com/mpic/s29413786.jpg',0,'有一种神奇的项目管理方法：\n张小龙用它来开发QQ邮箱，管理微信团队；\n京东、华为、中兴都在进行内部学习；\nHBO的热剧《硅谷》将它搬上荧幕\n通用电气利用它加速实现了“数字行业公司”的转型\nTwitter利用它来开发各项新功能\n它帮助美国国家公共广播电台创新节目\n助力美国联邦调查局开发虚拟案件档案系统\n这套方法就叫作Scrum，被誉为“管理学的诺贝尔奖”，在全球掀起了一场敏捷革命。\n--------------------\n1. “Scrum之父”萨瑟兰博士精华作品。\nScrum被誉为“管理学的诺贝尔奖”，在全球掀起了一场敏捷革命，微信、京东、华为、通用电气、Twitter、FBI一致采用的管理方法。本书由Scrum创始人写就，深入浅出地讲解了敏捷管理的精髓。\n2. 改变未来工作的高效管理方法。\n敏捷是一场关于适者生存的进化。未来工作的复杂性和创新性都会有巨大的提升，从而对于团队的定义、时间的规划、效率的测算，以及产品价值的发掘都会有颠覆性的改变。《敏捷革命》指导你如何用新型管理方式，适应未来，并且提升组织绩效，发挥个人创造力。\n3.全球顶级企业实干派与管理研究者一致推崇的管理变革。\n《精益创业》作者埃里克•莱斯、Twitter首席技术官亚当•梅辛格、哈佛商学院教授竹内弘高等众多大咖推荐。Twitter首席技术官直言：“我在Twitter大大小小的开发项目中都采用了Scrum。”\n“关于敏捷开发我特别希望大家能够多去做一些尝试……敏捷带来一个最好的心理感受是什么呢？我们今天可以想一些与众不同的点子，然后我们可以很快就看到效果，因为我们可以很快把它上线了，然后可以去验证，如果不对就下线，如果还有改进余地，下个星期再去改它……这是一个能够持续实现你的想法的过程。”\n——张小龙\n----------------------------\n在项目管理中，我们通常会制定好详细的计划，对每一个阶段都进行严格的评审，当前一阶段的工作完成得足够好，才进入下一步。这种流程进度缓慢，开发过程往往滞后于计划，造成预算超支。并且最终制造出的产品也可能不符合用户变化的需求，或已经跟不上技术的发展。\n为了规避这些缺陷，萨瑟兰博士发明了Scrum方法。与自上而下的命令式工作流程不同，Scrum是一套具有不断进化与自我修正能力的系统，让团队像机器人一样根据外界反馈进行调整。这套系统强调团队的高度透明性及密切的协同作业，通过精简内部成员之间的信息流，提高效率，实现高水平的业绩。\nScrum不仅是科技行业开发新软件和新产品的主要方式，还能够帮助你的公司改变固有的工作方式、创新方式、规划方式以及思考方式。','index'),('fa153415-520d-471f-a56f-ca1faa9cdf7d','2f365f00-aaad-4768-a003-0c8816b93bf3','586c450b-1d91-48af-8e1b-a12b8edfe03c','tab_book','七杀简史',128,5,'https://img3.doubanio.com/mpic/s29408611.jpg',0,'这是七次杀戮的故事，是一个时代罪恶、暴力、秘密的编年史。\n牙买加，1976 年12 月3 日，大选在即。\n七名枪手闯入一位国民级雷鬼歌手家中疯狂扫射——歌手原定于两天后举办一场和平演唱会。歌手逃过一劫，但身受重伤，枪手则全部逃逸。\n这一扑朔迷离的真实事件，将通过76个虚构角色之口重现。贫民窟的孩子、毒贩、枪手、《滚石》杂志记者、妓女、黑帮老大、中情局特工，甚至鬼魂…开始诉说。\n“走进一个局面，你要么拿着注射器，要么拿着枪。有些东西你能治好，有些东西你必须打死。”\n“贫民窟里有一种孩子每天都要奔向大海，只为了一头扎进某个地方然后忘记一切。”\n“你慢慢地会喜欢上永不改变的少数几样东西。”\n“音乐不会带走疼痛，但只要音乐开始播放，我感受到的就不再是疼痛，而是节奏。”\n“我疯狂战斗，直到厌倦为止。”','index');
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
INSERT INTO `tab_goods_type_rel` VALUES ('1ad23e4a-73be-428b-9a33-78f775842292','fa153415-520d-471f-a56f-ca1faa9cdf7d','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('30486d89-a831-49f6-9b97-f064daf9de19','25f3d373-23fa-45d5-97db-b51537f78b00','276b82a8-057b-4f55-93fd-834d7e8a2ee1'),('37e2140d-97df-43a9-a86e-61b654f20da8','0f9b77a2-01a7-46e0-ac57-42a5ee4cd28e','4ec8c9e8-5adb-4db6-9bf6-fec80740a950'),('464e0b73-9b41-44e3-8127-d3db4d41c0de','fa153415-520d-471f-a56f-ca1faa9cdf7d','80488c3b-3dfc-432d-804e-32c53d97d750'),('47a82eb4-07a0-4b44-b08a-9034e96f8b7e','cb058263-a01e-411c-b6f9-7700eead5122','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('5e1cc505-1631-4645-abf6-4fbbebbeca16','25f3d373-23fa-45d5-97db-b51537f78b00','4861995a-9579-4727-ba3b-ac35628e7f98'),('6370cf01-49ea-48c2-b97d-0ede063e9abd','cb058263-a01e-411c-b6f9-7700eead5122','15c575a6-54eb-4e3c-9175-953e0811405e'),('64eefe2a-8531-48d5-a9c5-91a27fe89b15','0f9b77a2-01a7-46e0-ac57-42a5ee4cd28e','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('65ef92f3-6a35-4496-8415-1c9699850e4c','25f3d373-23fa-45d5-97db-b51537f78b00','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('789db532-6adc-40c8-b378-998316de1497','cb058263-a01e-411c-b6f9-7700eead5122','708fffc8-bfea-40e4-8ffc-34c0ea18a1dc'),('7e6a74f1-f040-48df-9a4a-7ffc9960258a','cb058263-a01e-411c-b6f9-7700eead5122','1d6199a1-1ae1-4834-bcc5-179f4395a56d'),('870f6f07-7354-4363-8c00-44ab030fa221','f153ace2-8783-4dc7-b6cb-55f320b43a38','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('9d02c57a-1943-46cd-96cd-94689f3ed304','0f9b77a2-01a7-46e0-ac57-42a5ee4cd28e','3ac549f5-0192-4edf-b29c-07fe0b0fa12a'),('b3f94c4e-978d-4ff1-a3a4-f596d20f6a19','0f9b77a2-01a7-46e0-ac57-42a5ee4cd28e','fe0ca170-8175-490a-a89c-0438d16d5279'),('b5941c9b-bb3e-4744-a6af-df34c509bda1','f153ace2-8783-4dc7-b6cb-55f320b43a38','5b22a6f5-93ae-4d6d-a734-fce915919af1'),('c6848a6c-22f7-4285-bc42-2aa4cea595c1','0f9b77a2-01a7-46e0-ac57-42a5ee4cd28e','21b5f2cc-9992-4fbb-a024-6527821ead81'),('d2284cfd-36ca-4fb3-bfb3-6544e7451e12','f153ace2-8783-4dc7-b6cb-55f320b43a38','44f31e93-343a-4137-919f-ddcb82e0c3e9'),('d83b24bd-9036-4969-a14d-95bd1418cb42','fa153415-520d-471f-a56f-ca1faa9cdf7d','73e454b1-2f45-4adf-8b36-682077fb9062'),('dbef32f3-ad41-408b-b892-0e511331eda3','cb058263-a01e-411c-b6f9-7700eead5122','6cd1c66c-d954-478a-9003-c92a432877af'),('ea5aeb4c-a0cf-45d9-9bee-9b308ca0df83','fa153415-520d-471f-a56f-ca1faa9cdf7d','708fffc8-bfea-40e4-8ffc-34c0ea18a1dc'),('fa1fd63b-5a97-43ae-b18c-8181dc337363','cb058263-a01e-411c-b6f9-7700eead5122','a3178e1d-825b-40e9-935f-59582ccc5669'),('q1','1','111'),('q10','3','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('q11','4','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('q2','2','111'),('q4','4','111'),('q5','1','112'),('q6','2','113'),('q7','2','112'),('q8','1','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab'),('q9','2','09vc8c86-e8ca-hjc7-96f3-f1a4kd4804ab');
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
  `address` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `total_price` double DEFAULT '0' COMMENT '总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_order`
--

LOCK TABLES `tab_order` WRITE;
/*!40000 ALTER TABLE `tab_order` DISABLE KEYS */;
INSERT INTO `tab_order` VALUES ('0306ef42-f64a-4512-960d-095d139981cc','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','31c0d96d-0e94-4a52-8648-9c39009d5a72','jia','2017-05-11 09:47:10',1186),('ad259009-d18a-42e6-898b-8f79d14da0bd','17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','31c0d96d-0e94-4a52-8648-9c39009d5a72','xuexiao','2017-05-10 23:51:21',134);
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
  `status` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_order_item`
--

LOCK TABLES `tab_order_item` WRITE;
/*!40000 ALTER TABLE `tab_order_item` DISABLE KEYS */;
INSERT INTO `tab_order_item` VALUES ('3974de48-a93f-4e82-943b-ebbdfd676343','0306ef42-f64a-4512-960d-095d139981cc','2',2,1000),('c51f00d9-1a47-464a-96e5-bbd8e10734b1','ad259009-d18a-42e6-898b-8f79d14da0bd','3',1,1000),('dcb47ad6-1b73-4cf1-a652-41a6b32102da','0306ef42-f64a-4512-960d-095d139981cc','1',1,1000),('fb653ed2-f8e3-4346-9bdb-bc9f9279d0f1','ad259009-d18a-42e6-898b-8f79d14da0bd','2',1,1000);
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
INSERT INTO `tab_seller` VALUES ('31c0d96d-0e94-4a52-8648-9c39009d5a72','Njupt@123','njuptseller','2017-02-27 14:41:19'),('586c450b-1d91-48af-8e1b-a12b8edfe03c','index','index','2017-05-23 10:16:45'),('5f97d096-0c09-4906-bc26-c556c772e4a4','12345','asellader','2017-02-27 14:42:43');
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
  `carousel_str` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_shop`
--

LOCK TABLES `tab_shop` WRITE;
/*!40000 ALTER TABLE `tab_shop` DISABLE KEYS */;
INSERT INTO `tab_shop` VALUES ('9e297ad2-2609-4a11-8294-3c97d990ddec','still a shop','5f97d096-0c09-4906-bc26-c556c772e4a4',NULL,NULL,NULL),('b2e58fd1-41e0-460c-ad90-347c8f4c9709','首页','586c450b-1d91-48af-8e1b-a12b8edfe03c',NULL,'fa153415-520d-471f-a56f-ca1faa9cdf7d 4c1ae8aa-8331-4513-b111-3924a63727db cb058263-a01e-411c-b6f9-7700eead5122','[{\"url\":\"/file/pic/get.do?picId=d2af8318-3bee-4e79-8568-184c75a43324.jpg\",\"desc\":\"啊一个\"},{\"url\":\"/file/pic/get.do?picId=49f127a1-6e20-44a7-bdf5-3ea500df334d.jpg\",\"desc\":\"大佛寺大佛寺地方\"},{\"url\":\"/file/pic/get.do?picId=e8d177f8-0d1b-4c51-945c-7fe4c7b8e92c.JPG\",\"desc\":\"走近科学\"},{\"url\":\"/file/pic/get.do?picId=e23276bc-683b-4fdc-ad38-e00a89bcc645.jpg\",\"desc\":\"赵春晖\"}]'),('e13cd0fa-225f-42d6-a970-ade9ba412f5b','two shop','31c0d96d-0e94-4a52-8648-9c39009d5a72',NULL,'2 3 4','[{\"url\":\"/file/pic/get.do?picId=d95842ed-2463-4204-b83a-527bbbde5c5c.jpg\",\"desc\":\"是描述\"},{\"desc\":\"\"}]');
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
INSERT INTO `tab_user` VALUES ('0cc95799-4660-4758-9f7e-0053187eac7a','1234','ba','2017-03-17 10:22:22'),('17718c86-e8ca-4a9d-96f3-f1a4a3da04ab','Njupt@123','njuptuser','2017-02-15 00:00:00'),('3b07f71d-50c7-4861-a25d-b598093bf861','98','happy','2017-02-17 00:00:00'),('921c0989-9654-439f-800a-978144c1c2f1','12345','ba23r','2017-02-27 14:18:59'),('981f806c-41bb-45df-a0da-d00a65a5707e','123','admin2','2017-05-04 15:48:41'),('996fd11b-817c-4419-9272-7c1e7a3f57b0','12345','bar','2017-02-27 13:29:00');
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

-- Dump completed on 2017-05-25 10:33:01

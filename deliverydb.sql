-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: deliverydb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer` int NOT NULL,
  `shipper` int NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `content` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_com_user_idx` (`customer`),
  KEY `fk_com_ship_idx` (`shipper`),
  CONSTRAINT `fk_com_ship` FOREIGN KEY (`shipper`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_com_user` FOREIGN KEY (`customer`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,28,26,'2022-06-26 00:00:00','tuyetvoi'),(2,28,27,'2022-06-26 11:11:00','ngon'),(37,27,30,'2022-09-02 17:57:15','giao hàng nhanh'),(40,26,30,'2022-09-02 20:18:52','giao hàng nhanh x4');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer` int NOT NULL,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dilivery_address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `get_address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(2222) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_user_idx` (`customer`),
  CONSTRAINT `fk_product_user` FOREIGN KEY (`customer`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,'san pham 1','200','2022-08-10 00:00:00','ON','ssdfd','fdssdf','https://i1-dulich.vnecdn.net/2021/07/16/2-1626444940.jpg?w=0&h=0&q=100&dpr=2&fit=crop&s=GdpJnWaNQO_98jsWySh9cA','sản pham de vo can than van chuyen'),(2,1,'san pham 2','250','2022-08-10 00:00:00','ON','ưqee','eqw','https://i1-dulich.vnecdn.net/2021/07/16/2-1626444940.jpg?w=0&h=0&q=100&dpr=2&fit=crop&s=GdpJnWaNQO_98jsWySh9cA',NULL),(3,2,'san pham 3','270','2022-08-10 00:00:00','ON','dsfd','fdsfs','https://i1-dulich.vnecdn.net/2021/07/16/2-1626444940.jpg?w=0&h=0&q=100&dpr=2&fit=crop&s=GdpJnWaNQO_98jsWySh9cA',NULL),(4,2,'san pham 4','340','2022-08-10 00:00:00','ON','dsfd','fdsfs','https://i1-dulich.vnecdn.net/2021/07/16/2-1626444940.jpg?w=0&h=0&q=100&dpr=2&fit=crop&s=GdpJnWaNQO_98jsWySh9cA',NULL),(6,26,'cai ban nho','2000','2022-08-27 00:00:00','ACCEPT','dong thanh hoc mion','q12 tphcm','https://res.cloudinary.com/dvkt3pe95/image/upload/v1661573762/cjgvqvfwiwpn08z9dlqd.jpg','san pham kha cong kenh'),(7,26,'chair','20000','2022-09-02 00:00:00','ON','q1','q3','https://res.cloudinary.com/dvkt3pe95/image/upload/v1662084057/cyvbbaecczf8fxz9ldus.png','ghe do choi'),(8,33,'chair2','30000','2022-09-02 00:00:00','ACCEPT','123/34 Ấp 5, Đông Thạnh, Hóc Môn','57/12 Phường 3 , Quận 7','https://res.cloudinary.com/dvkt3pe95/image/upload/v1662111066/o46rz9m2yfux1y7ugy2l.jpg','Sản phẩm cồng kềnh');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_shipper`
--

DROP TABLE IF EXISTS `product_shipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_shipper` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shipper` int NOT NULL,
  `product` int NOT NULL,
  `cost` int NOT NULL,
  `created_date` date NOT NULL,
  `updated_date` date DEFAULT NULL,
  `active` int DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_shipper_idx` (`shipper`),
  KEY `fk_product_idx` (`product`),
  CONSTRAINT `fk_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_shipper` FOREIGN KEY (`shipper`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_shipper`
--

LOCK TABLES `product_shipper` WRITE;
/*!40000 ALTER TABLE `product_shipper` DISABLE KEYS */;
INSERT INTO `product_shipper` VALUES (1,30,1,222222,'2022-08-29','2022-08-29',0),(5,30,6,23000,'2022-08-30','2022-08-30',0),(6,32,6,2000,'2022-08-30','2022-08-30',2),(10,32,8,25000,'2022-09-02','2022-09-02',2);
/*!40000 ALTER TABLE `product_shipper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer` int NOT NULL,
  `shipper` int NOT NULL,
  `rate` int NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rate_cus_idx` (`customer`),
  KEY `fk_rate_shipper_idx` (`shipper`),
  CONSTRAINT `fk_rate_cus` FOREIGN KEY (`customer`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_rate_shipper` FOREIGN KEY (`shipper`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,26,30,3,'2022-08-28 18:14:43','2022-08-29 10:49:10'),(2,26,32,4,'2022-08-28 21:13:00','2022-08-28 21:35:40'),(3,28,30,4,'2022-08-29 11:49:49','2022-08-29 11:54:48');
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `active` bit(1) DEFAULT b'1',
  `created_date` date NOT NULL,
  `avatar` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `userRole` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shipper_idx` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nguyen','dung','dung@gmail.com','333','user1','$2a$10$dejM63z2jH2Q5gfEGjKVxO6b3wp8DkwsQDUoV.zQCjYJJ1Ni4gWqi',_binary '','2022-06-26','https://res.cloudinary.com/dvkt3pe95/image/upload/v1662172326/mwje5icq51yvf2y4njnw.jpg','ADMIN'),(2,'nguiyen','dung2','dung2@gmail.com','234','user2','$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','2022-06-26','https://res.cloudinary.com/dvkt3pe95/image/upload/v1662172326/mwje5icq51yvf2y4njnw.jpg','CUSTOMER'),(26,'nguyyen','A3','email3@gmail.com','0377641604','thanhdung1','$2a$10$Izth5sOh41dPDQLsqlas0..9OsUVa5Y.lOAUtCywrHW4geNsU95be',_binary '','2022-08-17','https://res.cloudinary.com/dvkt3pe95/image/upload/v1662172326/mwje5icq51yvf2y4njnw.jpg','CUSTOMER'),(27,'nguyyen','A','email2@gmail.com','0377641604','thanhdung23','$2a$10$dejM63z2jH2Q5gfEGjKVxO6b3wp8DkwsQDUoV.zQCjYJJ1Ni4gWqi',_binary '','2022-08-17','https://res.cloudinary.com/dvkt3pe95/image/upload/v1662172326/mwje5icq51yvf2y4njnw.jpg','CUSTOMER'),(28,'nguyyen','A','email@gmail.com','0377641604','thanhdung2','$2a$10$fIFgHZpypc.DTOjYXh.axe1uE8sduvguZZiAdnnr4CLq2bgKm/Crq',_binary '','2022-08-17','https://res.cloudinary.com/dvkt3pe95/image/upload/v1662172326/mwje5icq51yvf2y4njnw.jpg','CUSTOMER'),(30,'Nguyen','Thanh','nguyenthanh@gmail.com','0377641604','thanhdung1455','$2a$10$hd5eogMMBbxkXSBZiRSCqONqkpcGyYYDze0mnTgRE53QYBs3hvTT.',_binary '','2022-08-18','https://res.cloudinary.com/dvkt3pe95/image/upload/v1662172326/mwje5icq51yvf2y4njnw.jpg','SHIPPER'),(31,'nguyyen','A3','email3@gmail.com','0377641604','thanhdung143223','$2a$10$q0tstuUvPVr.F4IHPK9G/.RDelCJJGD7JcTCek0WnBuXVSNniSVX2',_binary '','2022-08-18','https://res.cloudinary.com/dvkt3pe95/image/upload/v1662172326/mwje5icq51yvf2y4njnw.jpg','CUSTOMER'),(32,'nguyyen','A','email@gmail.com','0377641604','thanhdung13434','$2a$10$u5el9GS2ATcwfOmB7s3kH.yGezdzR3wcTR5fswS/AHr0YsG0Q2Nyu',_binary '','2022-08-18','https://res.cloudinary.com/dvkt3pe95/image/upload/v1662172326/mwje5icq51yvf2y4njnw.jpg','SHIPPER'),(33,'Custom','1','email3@gmail.com','0377641604','cus1','$2a$10$F7BmYvnq7USBQ9CaUexE6OBir/4IuyIylBVmoPAZrQF6sD47G18Gm',_binary '','2022-09-02','https://res.cloudinary.com/dvkt3pe95/image/upload/v1662110947/f1yzkczgbcknhskii3c2.jpg','SHIPPER'),(35,'Custom','3','email3@gmail.com','0377641604','cus3','$2a$10$IBmddad8gppWb9SQ0tOAwuwVbLoU561m6qeQPCfJMohfrPUZNzFZ2',_binary '','2022-09-03','https://res.cloudinary.com/dvkt3pe95/image/upload/v1662194260/l5u5megmp9tvzgjhuobj.jpg','CUSTOMER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_shipper`
--

DROP TABLE IF EXISTS `user_shipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_shipper` (
  `id` int NOT NULL,
  `identity` int NOT NULL,
  `address` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dob` date NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_shipper`
--

LOCK TABLES `user_shipper` WRITE;
/*!40000 ALTER TABLE `user_shipper` DISABLE KEYS */;
INSERT INTO `user_shipper` VALUES (30,322455543,'fdsfsdfd','2001-03-24'),(32,322455543,'Dong thaÌ£nh','2001-03-23'),(33,322455543,'Dong thanh','2001-03-23');
/*!40000 ALTER TABLE `user_shipper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-04 14:10:42

CREATE DATABASE  IF NOT EXISTS `siscontrole` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `siscontrole`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: siscontrole
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `clicod` int NOT NULL AUTO_INCREMENT,
  `clinome` varchar(45) NOT NULL,
  `clicpf` varchar(45) NOT NULL,
  `clitelefone` varchar(45) NOT NULL,
  `cliemail` varchar(45) DEFAULT NULL,
  `clicep` varchar(45) NOT NULL,
  `clilogadouro` varchar(45) NOT NULL,
  `clinumero` varchar(45) NOT NULL,
  `clicomplemento` varchar(45) NOT NULL,
  `clibairro` varchar(45) DEFAULT NULL,
  `climunicipio` varchar(45) NOT NULL,
  `cliestado` varchar(45) NOT NULL,
  `debito` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`clicod`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (3,'adenilson ','543.543.543.-54','(54) 3 5435-4353','345435','43543-543','34534','5345','43543','5435','43543','5',19.30),(4,'amilton','435.435.435.-43','(43) 5 3454-3534','34534543','43543-543','4534534','543','5435','435','43543','5',0.00),(5,'Benigo','435.435.435.-43','(43) 5 4354-3543','345345','34543-543','5435','345','4353','4543','54354','3',11.30),(6,'Caio','456.456.456.-54','(45) 6 4565-4645','456456456','34543-543','654','6546546456','645645','6546','456456','45665',4.40),(7,'jorge','456.456.456.-54','(45) 6 4565-4645','435435435','43543-543','43543','5435','435','435','43543','543',NULL),(8,'Aurelio','456.456.456.-54','(45) 6 4565-4645','4354354','34534-543','4354','3543','543','543','5435','3',3.10),(9,'aademils','543.543.534.-53','(34) 5 3453-4543','5345345','34543-543','5345345','43534','5345345','43534','5345','345',135.20),(10,'COMPRAS A VISTA','000.000.000.-00','(00) 0 0000-0000','0000000000000','00000-000','00000000','00000','0000000','00000000000','0000000','0000000',15.50),(11,'Joâo Carlos Souza','465.465.465.-46','(46) 5 4654-6546','gfdgfdgfdg','65464-365','34543543','545','435','43543543','5345435','435435',7.00),(12,'jailton Santos Souza','435.435.435.-43','(34) 5 4354-3543','345345435','34543-543','543543','543','54354','35435435','43543','5345345',0.00),(13,'jailton de araujo santos','543.543.543.-54','(34) 5 4354-3543','43543543','45435-435','34543','5435','43543543','5435','54353534','5345435',46.20);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `forcodigo` int NOT NULL AUTO_INCREMENT,
  `fornome` varchar(100) NOT NULL,
  `forcnpj` varchar(40) DEFAULT NULL,
  `fortelefone` varchar(30) DEFAULT NULL,
  `forfax` varchar(60) DEFAULT NULL,
  `foremail` varchar(100) DEFAULT NULL,
  `forsite` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`forcodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'Ambev','34.543.534/5435-43','(43) - 5 4354-3543','345345','435','435345435'),(2,'Multi-frios','53.454.353/2454-35','(54) - 3 5342-5345','234523534543','435234543','2345345'),(3,'Fumeiro','12.123.123/1223-11','(45) - 3 4543-5435','435345435','fdg','43534');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamentos`
--

DROP TABLE IF EXISTS `pagamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamentos` (
  `idpagamentos` int NOT NULL AUTO_INCREMENT,
  `clicod` int NOT NULL,
  `usucod` int NOT NULL,
  `datapagamento` date NOT NULL,
  `valorpagamento` decimal(5,2) NOT NULL,
  PRIMARY KEY (`idpagamentos`),
  KEY `clicod_idx` (`clicod`),
  KEY `usucod_idx` (`usucod`),
  CONSTRAINT `clicod` FOREIGN KEY (`clicod`) REFERENCES `cliente` (`clicod`),
  CONSTRAINT `usucod` FOREIGN KEY (`usucod`) REFERENCES `usuario` (`usucodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamentos`
--

LOCK TABLES `pagamentos` WRITE;
/*!40000 ALTER TABLE `pagamentos` DISABLE KEYS */;
INSERT INTO `pagamentos` VALUES (1,12,11,'2021-11-05',2.00),(2,12,11,'2021-11-05',1.80),(3,13,11,'2021-11-08',5.00),(4,6,11,'2021-11-08',4.90),(5,6,11,'2021-11-08',5.00),(6,6,11,'2021-11-08',2.00),(7,13,11,'2021-11-08',2.00),(8,13,11,'2021-11-08',2.00),(9,13,11,'2021-11-08',1.00),(10,6,11,'2021-11-08',3.00),(11,9,11,'2021-11-08',20.00),(12,9,11,'2021-11-08',10.00),(13,5,11,'2021-11-08',14.30),(14,8,11,'2021-11-09',60.00),(15,4,11,'2021-11-11',10.20),(16,13,11,'2021-11-12',10.00),(17,6,11,'2021-11-15',10.00),(18,11,11,'2021-11-29',20.00),(19,13,11,'2021-12-02',5.00),(20,13,11,'2021-12-09',5.00);
/*!40000 ALTER TABLE `pagamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `pedcod` int NOT NULL AUTO_INCREMENT,
  `peddata` date NOT NULL,
  `clicod` int NOT NULL,
  `usucodigo` int NOT NULL,
  `ped_valor_total` decimal(5,2) DEFAULT NULL,
  `forma_de_pagamento` varchar(45) DEFAULT NULL,
  `pedido_comentario` text,
  PRIMARY KEY (`pedcod`),
  KEY `ped_clicod_idx` (`clicod`),
  CONSTRAINT `ped_clicod` FOREIGN KEY (`clicod`) REFERENCES `cliente` (`clicod`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2021-09-23',10,11,9.80,NULL,NULL),(2,'2021-09-23',7,11,35.80,NULL,NULL),(3,'2021-10-22',10,11,30.70,NULL,NULL),(4,'2021-10-22',5,11,17.90,NULL,NULL),(5,'2021-10-22',8,11,16.70,NULL,NULL),(6,'2021-10-23',10,11,15.40,NULL,NULL),(7,'2021-10-23',9,11,11.00,NULL,NULL),(8,'2021-10-23',9,11,11.00,NULL,NULL),(9,'2021-10-23',9,11,9.70,NULL,NULL),(10,'2021-10-24',9,11,10.40,NULL,NULL),(11,'2021-10-24',9,11,12.10,NULL,NULL),(12,'2021-10-24',9,13,11.60,NULL,NULL),(13,'2021-10-26',9,11,16.20,NULL,NULL),(14,'2021-10-26',12,11,16.20,NULL,NULL),(15,'2021-10-26',12,11,10.40,NULL,NULL),(16,'2021-10-26',12,11,4.70,NULL,NULL),(17,'2021-10-26',12,11,4.70,NULL,NULL),(18,'2021-10-26',12,11,5.20,NULL,NULL),(19,'2021-10-26',8,11,14.00,NULL,NULL),(20,'2021-10-26',12,11,10.90,'Debito',NULL),(21,'2021-10-26',13,11,15.00,'Credito',NULL),(22,'2021-10-27',3,11,11.50,'Debito',NULL),(23,'2021-10-27',13,11,13.70,'Credito',NULL),(24,'2021-10-28',9,11,10.40,'Debito',NULL),(25,'2021-10-28',9,11,15.00,'Debito',NULL),(26,'2021-11-08',13,11,11.60,'Debito',NULL),(27,'2021-11-08',6,11,14.90,'Debito',NULL),(28,'2021-11-08',9,11,52.70,'Debito',NULL),(29,'2021-11-08',13,11,10.90,'Credito',NULL),(30,'2021-11-08',13,11,19.70,'Debito','Quem pegou foi o joãosinho'),(31,'2021-11-08',5,11,14.30,'Debito','Quem pegou foi o Joãosinho'),(32,'2021-11-08',10,11,15.50,'Debito',''),(33,'2021-11-09',8,11,63.10,'Debito',''),(34,'2021-11-09',3,11,19.30,'Debito','Quem pegou foi o joazinho'),(35,'2021-11-11',4,11,10.20,'Debito',''),(36,'2021-11-12',5,11,1.00,'Debito','Quem pegou foi joazinho'),(37,'2021-11-15',6,11,14.40,'Debito','Qume pegou foi joazinho'),(38,'2021-11-18',5,11,10.30,'Debito',''),(39,'2021-11-29',11,11,27.00,'Debito','João pegou'),(40,'2021-12-02',9,11,12.00,'Debito',''),(41,'2021-12-02',9,11,24.00,'Debito',''),(42,'2021-12-02',9,11,24.00,'Debito',''),(43,'2021-12-02',9,11,21.00,'Debito',''),(44,'2021-12-02',9,11,31.50,'Debito',''),(45,'2022-01-19',13,11,44.90,'Debito',''),(46,'2022-02-25',9,11,18.00,'Credito','');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_item`
--

DROP TABLE IF EXISTS `pedido_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_item` (
  `pedcod` int DEFAULT NULL,
  `procod` varchar(100) DEFAULT NULL,
  `pedproquantidade` int NOT NULL,
  KEY `pedido_item_pedcod_idx` (`pedcod`),
  KEY `pedido_item_procod` (`procod`),
  CONSTRAINT `pedido_item_pedcod` FOREIGN KEY (`pedcod`) REFERENCES `pedido` (`pedcod`),
  CONSTRAINT `pedido_item_procod` FOREIGN KEY (`procod`) REFERENCES `produto` (`procodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_item`
--

LOCK TABLES `pedido_item` WRITE;
/*!40000 ALTER TABLE `pedido_item` DISABLE KEYS */;
INSERT INTO `pedido_item` VALUES (1,'7891000242483',1),(1,'7898904869815',1),(1,'4545465',1),(2,'4545465',1),(2,'45255',1),(2,'7891000242483',1),(2,'7898904869815',1),(2,'45255',1),(2,'4545465',1),(2,'7898904869815',1),(2,'7891000242483',1),(2,'4545465',1),(3,'45255',1),(3,'7898904869815',1),(3,'45255',1),(3,'7891000242483',1),(3,'4545465',1),(3,'4545465',1),(3,'7898904869815',1),(4,'45255',1),(4,'45255',1),(4,'7891000242483',1),(4,'45255',1),(5,'45255',1),(5,'45255',1),(5,'7891000242483',1),(5,'4545465',1),(6,'7891000242483',1),(6,'45255',1),(6,'4545465',1),(6,'4654654654',1),(7,'7898904869815',1),(7,'7891000242483',1),(7,'45255',1),(8,'7898904869815',1),(8,'45255',1),(8,'7891000242483',1),(9,'7898904869815',1),(9,'4654654654',1),(9,'7891000242483',1),(10,'4545465',1),(10,'45255',1),(11,'45255',1),(11,'7891000242483',1),(11,'45255',1),(12,'45255',1),(12,'45255',1),(17,'7898904869815',1),(18,'7891000242483',1),(18,'7898904869815',1),(19,'7898904869815',1),(19,'7898904869815',1),(19,'4545465',1),(20,'45255',1),(20,'4545465',1),(20,'7891000242483',1),(21,'4545465',1),(21,'45255',1),(21,'4545465',1),(22,'7891000242483',1),(22,'7898904869815',1),(22,'45255',1),(22,'7891000242483',1),(23,'4545465',1),(23,'4654654654',1),(23,'4545465',1),(24,'4545465',1),(24,'45255',1),(25,'4545465',1),(25,'4545465',1),(25,'45255',1),(26,'45255',1),(26,'45255',1),(27,'45255',1),(27,'4654654654',1),(27,'4545465',1),(28,'7898904869815',1),(28,'45255',10),(29,'7891000242483',1),(29,'45255',1),(29,'4545465',1),(30,'7898904869815',1),(30,'4654654654',1),(30,'45255',1),(30,'7898904869815',1),(31,'4654654654',1),(31,'4545465',1),(31,'7891000242483',1),(31,'7898904869815',1),(32,'4654654654',1),(32,'7898904869815',1),(32,'7891000242483',1),(32,'45255',1),(33,'4545465',1),(33,'7891000242483',1),(33,'45255',10),(34,'7898904869815',1),(34,'7891000242483',1),(34,'4654654654',1),(34,'4545465',1),(34,'7891000242483',1),(34,'4654654654',1),(35,'7896849106583',1),(35,'7896035990088',1),(36,'7891000242483',1),(36,'7891000242483',1),(37,'4545465',1),(37,'7891000242483',1),(37,'4545465',1),(37,'7896035990088',1),(37,'7891000242483',1),(38,'7891000242483',1),(38,'4545465',1),(38,'7891000242483',1),(38,'7896035990088',1),(38,'7891000242483',1),(39,'45255',1),(39,'7896849106583',1),(39,'4545465',1),(39,'4545465',1),(40,'7896849106583',1),(41,'7896849106583',2),(42,'7896849106583',2),(43,'5566546',2),(44,'5566546',3),(45,'45255',1),(45,'5566546',1),(45,'5566546',1),(45,'5566546',1),(45,'5645645',1),(46,'45255',1),(46,'5645645',1),(46,'4545465',1);
/*!40000 ALTER TABLE `pedido_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `procodigo` varchar(100) NOT NULL,
  `forcod` int NOT NULL,
  `pronome` varchar(100) NOT NULL,
  `prodescricao` text,
  `prounidademedida` varchar(45) DEFAULT NULL,
  `provalorunitario` float NOT NULL,
  `proquantidade` int NOT NULL,
  PRIMARY KEY (`procodigo`),
  KEY `forcod_idx` (`forcod`),
  CONSTRAINT `pro_forcod` FOREIGN KEY (`forcod`) REFERENCES `fornecedor` (`forcodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES ('45255',1,'Coca Cola','L','L',5.8,2),('4545465',1,'Doce de Leite no kl','g','g',4.6,7),('4654654654',1,'Biscoito','comida','g',4.5,0),('5566546',3,'fgfd','regr','regr',10.5,35),('5645645',1,'Rapadura','G','G',7.6,2),('7891000242483',1,'Caldo de Galinha','Alimeto','g',0.5,0),('7896035990088',2,'tapioca','Comida','g',4.2,0),('7896849106583',2,'Caderno 12 Materias','g','g',12,5),('7898904869815',1,'Tek Bond','Cola','g',4.7,0);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `usucodigo` int NOT NULL AUTO_INCREMENT,
  `usunome` varchar(45) NOT NULL,
  `usulogin` varchar(45) NOT NULL,
  `ususenha` varchar(45) NOT NULL,
  `ususetor` varchar(45) NOT NULL,
  PRIMARY KEY (`usucodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'jailton','jailton','123','CAIXA'),(10,'jailton de araujo Santos','jailton','456','ADMINISTRADOR'),(11,'jailton araujo Santos','jailton','123','ADMINISTRADOR'),(13,'Gerlane Da silva Santana','gerla','123','ADMINISTRADOR'),(14,'mario souza ricardo','mario','741','CAIXA'),(15,'joão vitor','jvitor','123','CAIXA');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-18 23:31:42

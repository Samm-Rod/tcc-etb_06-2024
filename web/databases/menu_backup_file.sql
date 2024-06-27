-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: localhost    Database: menu_db
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
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
  `id` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) NOT NULL,
  `mesas_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cliente_mesas1_idx` (`mesas_id`),
  CONSTRAINT `fk_cliente_mesas1` FOREIGN KEY (`mesas_id`) REFERENCES `mesas` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (5,'1234567891',9),(6,'9876543211',10),(7,'4567893218',11),(8,'3698521475',12);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `dataNasc` date DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `loginAdm_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_funcionario_loginAdm1_idx` (`loginAdm_id`),
  CONSTRAINT `fk_funcionario_loginAdm1` FOREIGN KEY (`loginAdm_id`) REFERENCES `loginadm` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (10,'Jose da Silva','1999-05-04','00000000','9999-9999','000001','jose123',NULL),(11,'Paulo Cezar','1998-08-05','111111111','1111-1111','000002','paulo123',NULL),(12,'Luiz Alves','1996-03-11','22222222222','2222-2222','000003','luiz123',NULL);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `valor` double NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `arqImg` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (4,'Pizza calabresa',36.5,'Calabresa, cebola, queijo','pizza calabresa.jpg'),(5,'Pizza Portuguesa',36.5,'presunto, ovos, mussarela e ervilha','pizza portuguesa.jpg'),(6,'Pizza marguerita',36.5,'tomate, queijo mussarela e manjericao','pizza_1.jpg');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginadm`
--

DROP TABLE IF EXISTS `loginadm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loginadm` (
  `id` int NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginadm`
--

LOCK TABLES `loginadm` WRITE;
/*!40000 ALTER TABLE `loginadm` DISABLE KEYS */;
/*!40000 ALTER TABLE `loginadm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesas`
--

DROP TABLE IF EXISTS `mesas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mesas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numMesa` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesas`
--

LOCK TABLES `mesas` WRITE;
/*!40000 ALTER TABLE `mesas` DISABLE KEYS */;
INSERT INTO `mesas` VALUES (9,1),(10,2),(11,3),(12,4),(13,5),(14,6),(15,7);
/*!40000 ALTER TABLE `mesas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamentos`
--

DROP TABLE IF EXISTS `pagamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamentos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipoPag` varchar(45) NOT NULL,
  `valor` double NOT NULL,
  `cliente_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pagamentos_cliente1_idx` (`cliente_id`),
  CONSTRAINT `fk_pagamentos_cliente1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamentos`
--

LOCK TABLES `pagamentos` WRITE;
/*!40000 ALTER TABLE `pagamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `funcionario_id` int DEFAULT NULL,
  `mesas_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pedidos_funcionario_idx` (`funcionario_id`),
  KEY `fk_pedidos_mesas1_idx` (`mesas_id`),
  CONSTRAINT `fk_pedidos_funcionario` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_pedidos_mesas1` FOREIGN KEY (`mesas_id`) REFERENCES `mesas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (3,10,NULL),(4,10,NULL),(5,10,NULL),(6,10,NULL),(7,10,NULL),(8,10,NULL),(9,10,NULL),(11,10,NULL),(12,10,NULL),(13,10,NULL),(14,10,NULL),(15,10,NULL),(23,10,NULL),(24,10,NULL);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos_item`
--

DROP TABLE IF EXISTS `pedidos_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos_item` (
  `item_id` int DEFAULT NULL,
  `pedidos_id` int DEFAULT NULL,
  `qtd` int DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `arqImg` varchar(128) DEFAULT NULL,
  `total` double DEFAULT NULL,
  KEY `fk_item_has_pedidos_pedidos1_idx` (`pedidos_id`),
  KEY `fk_item_has_pedidos_item1_idx` (`item_id`),
  CONSTRAINT `fk_item_has_pedidos_item1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_item_has_pedidos_pedidos1` FOREIGN KEY (`pedidos_id`) REFERENCES `pedidos` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos_item`
--

LOCK TABLES `pedidos_item` WRITE;
/*!40000 ALTER TABLE `pedidos_item` DISABLE KEYS */;
INSERT INTO `pedidos_item` VALUES (5,5,3,36.5,'Pizza Portuguesa',NULL,NULL),(6,4,2,36.5,'Pizza calabresa',NULL,NULL),(5,15,2,36.5,'Pizza marguerita',NULL,NULL),(5,23,1,36.5,'Pizza marguerita',NULL,NULL),(5,24,4,36.5,'Pizza marguerita',NULL,NULL);
/*!40000 ALTER TABLE `pedidos_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-19  3:58:46

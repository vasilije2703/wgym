CREATE DATABASE  IF NOT EXISTS `wgym` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `wgym`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: wgym
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `hrana`
--

DROP TABLE IF EXISTS `hrana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hrana` (
  `id` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  `kalorije` decimal(7,2) DEFAULT '0.00',
  `proteini` decimal(7,2) DEFAULT '0.00',
  `ugljeni_hidrati` decimal(7,2) DEFAULT '0.00',
  `seceri` decimal(7,2) DEFAULT '0.00',
  `vlakna` decimal(7,2) DEFAULT '0.00',
  `masti` decimal(7,2) DEFAULT '0.00',
  `kolicina_gram` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `hrana_chk_1` CHECK ((`kalorije` >= 0)),
  CONSTRAINT `hrana_chk_2` CHECK ((`proteini` >= 0)),
  CONSTRAINT `hrana_chk_3` CHECK ((`ugljeni_hidrati` >= 0)),
  CONSTRAINT `hrana_chk_4` CHECK ((`seceri` >= 0)),
  CONSTRAINT `hrana_chk_5` CHECK ((`vlakna` >= 0)),
  CONSTRAINT `hrana_chk_6` CHECK ((`masti` >= 0)),
  CONSTRAINT `hrana_chk_7` CHECK ((`kolicina_gram` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hrana`
--

LOCK TABLES `hrana` WRITE;
/*!40000 ALTER TABLE `hrana` DISABLE KEYS */;
INSERT INTO `hrana` VALUES (1,'Piletina',120.00,22.50,0.00,0.00,0.00,2.62,100.00),(2,'Riža',360.00,6.61,79.34,0.00,1.40,0.58,100.00),(3,'Junetina',276.00,14.97,0.00,0.00,0.00,23.52,100.00),(5,'Šargarepa',41.00,0.90,9.58,4.74,2.80,0.24,100.00),(6,'Brokoli',34.00,2.82,6.64,1.70,2.60,0.37,100.00),(7,'Spanać',23.00,2.86,3.63,0.42,2.20,0.39,100.00),(8,'Paradajz',18.00,0.88,3.89,2.63,1.20,0.20,100.00),(9,'Krastavac',15.00,0.65,3.63,1.67,0.50,0.11,100.00),(10,'Karfiol',25.00,1.92,5.00,1.91,2.00,0.28,100.00),(11,'Celer',16.00,0.70,3.00,1.34,1.60,0.17,100.00),(12,'Zelena salata',14.00,1.36,2.87,0.78,1.30,0.15,100.00),(13,'Tikvica',17.00,1.21,3.11,2.50,1.00,0.32,100.00),(14,'Patlidžan',25.00,1.01,5.88,3.53,3.00,0.18,100.00),(15,'Kupus',25.00,1.28,5.80,3.20,2.50,0.10,100.00),(16,'Kelj',49.00,4.28,8.75,2.26,3.60,0.93,100.00),(17,'Prokelj',43.00,3.38,8.95,2.20,3.80,0.30,100.00),(18,'Zeleni pasulj',31.00,1.83,7.13,3.26,3.40,0.22,100.00),(19,'Bundeva',26.00,1.00,6.50,2.76,0.50,0.10,100.00),(20,'Kukuruz',86.00,3.22,19.02,6.26,2.70,1.20,100.00),(21,'Blitva',19.00,1.80,3.74,1.10,1.60,0.10,100.00),(22,'Rukola',25.00,2.58,3.65,2.05,1.60,0.66,100.00),(23,'Tikva',20.00,1.00,4.50,2.00,1.20,0.10,100.00),(24,'Paprika',31.00,1.00,6.00,4.20,2.10,0.30,100.00),(25,'Svinjetina',242.00,27.00,0.00,0.00,0.00,14.00,100.00),(26,'Ćuretina',135.00,30.00,0.00,0.00,0.00,1.00,100.00),(27,'Teletina',150.00,22.00,0.00,0.00,0.00,7.00,100.00),(28,'Mlevena govedina',250.00,26.00,0.00,0.00,0.00,17.00,100.00),(29,'Slanina',541.00,37.00,1.43,0.00,0.00,42.00,100.00),(30,'Kulen',455.00,22.00,1.00,0.50,0.00,40.00,100.00),(31,'Čajna kobasica',420.00,25.00,1.00,0.00,0.00,36.00,100.00),(32,'Mortadela',311.00,16.00,1.20,0.50,0.00,27.00,100.00),(33,'Pečenica',265.00,32.00,0.50,0.00,0.00,15.00,100.00),(34,'Dimljena šunka',145.00,20.00,1.50,0.50,0.00,6.00,100.00),(35,'Kuvana šunka',120.00,18.00,1.00,0.50,0.00,4.00,100.00),(36,'Pačetina',337.00,27.00,0.00,0.00,0.00,25.00,100.00),(37,'Ovčetina',294.00,25.00,0.00,0.00,0.00,21.00,100.00),(38,'Jagnjetina',294.00,25.00,0.00,0.00,0.00,21.00,100.00),(39,'Guska',161.00,22.80,0.00,0.00,0.00,7.10,100.00),(40,'Kengurovo meso',98.00,22.00,0.00,0.00,0.00,1.30,100.00),(41,'Konjsko meso',133.00,21.00,0.00,0.00,0.00,4.00,100.00),(42,'Ovsene pahuljice',389.00,16.90,66.30,0.99,10.60,6.90,100.00),(43,'Kukuruzne pahuljice',357.00,7.50,84.00,8.00,3.30,0.40,100.00),(44,'Pirinač (beli, sirov)',360.00,6.70,79.30,0.10,1.30,0.50,100.00),(45,'Kinoa',368.00,14.10,64.20,0.90,7.00,6.10,100.00),(46,'Heljda',343.00,13.30,71.50,0.90,10.00,3.40,100.00),(47,'Proso',378.00,11.00,73.00,1.20,8.50,4.20,100.00),(48,'Ječam',354.00,12.50,73.50,0.80,17.30,2.30,100.00),(49,'Amarant',371.00,13.60,65.20,1.70,6.70,7.00,100.00),(50,'Raž',335.00,10.30,76.00,1.10,15.10,1.60,100.00),(51,'Pšenica',339.00,13.70,71.20,0.40,12.20,2.50,100.00),(52,'Musli',375.00,10.00,67.00,8.00,8.50,7.00,100.00),(53,'Čia semenke',486.00,16.50,42.10,0.00,34.40,30.70,100.00),(54,'Lanene semenke',534.00,18.30,28.90,1.50,27.30,42.20,100.00),(55,'Sezam',573.00,17.70,23.40,0.30,11.80,49.70,100.00),(56,'Kukuruzni griz (palenta)',370.00,8.10,79.10,0.60,2.30,1.00,100.00),(57,'Zobeno brašno',379.00,13.20,68.00,0.50,10.60,6.50,100.00),(58,'Pirinčane pahuljice',381.00,7.00,85.00,1.50,1.00,0.60,100.00),(59,'Mešavina žitarica (integralna)',385.00,12.00,70.00,5.00,9.00,7.00,100.00),(60,'Jabuka',52.00,0.30,13.80,10.40,2.40,0.20,100.00),(61,'Banana',89.00,1.10,22.80,12.20,2.60,0.30,100.00),(62,'Narandža',47.00,0.90,11.80,9.40,2.40,0.10,100.00),(63,'Kivi',61.00,1.10,14.70,8.90,3.00,0.50,100.00),(64,'Jagode',32.00,0.70,7.70,4.90,2.00,0.30,100.00),(65,'Borovnice',57.00,0.70,14.50,10.00,2.40,0.30,100.00),(66,'Maline',52.00,1.20,11.90,4.40,6.50,0.60,100.00),(67,'Ananas',50.00,0.50,13.10,9.90,1.40,0.10,100.00),(68,'Grožđe',69.00,0.70,18.10,15.50,0.90,0.20,100.00),(69,'Lubenica',30.00,0.60,7.60,6.20,0.40,0.20,100.00),(70,'Dinja',34.00,0.80,8.20,7.90,0.90,0.20,100.00),(71,'Kajsija',48.00,1.40,11.10,9.20,2.00,0.40,100.00),(72,'Breskva',39.00,0.90,9.50,8.40,1.50,0.30,100.00),(73,'Šljiva',46.00,0.70,11.40,9.90,1.40,0.30,100.00),(74,'Trešnja',50.00,1.00,12.20,8.50,1.60,0.30,100.00),(75,'Smokva (sveža)',74.00,0.80,19.20,16.30,2.90,0.30,100.00),(76,'Mango',60.00,0.80,14.90,13.70,1.60,0.40,100.00),(77,'Avokado',160.00,2.00,8.50,0.70,6.70,14.70,100.00),(78,'Limun',29.00,1.10,9.30,2.50,2.80,0.30,100.00),(79,'Mandarina',53.00,0.80,13.30,10.60,1.80,0.30,100.00),(80,'Jaje ',143.00,12.60,0.70,0.40,0.00,9.90,100.00),(81,'Mleko',61.00,3.20,4.80,5.10,0.00,3.30,100.00),(82,'Jogurt',61.00,3.50,4.70,4.70,0.00,3.30,100.00),(83,'Kefir',41.00,3.60,4.60,4.60,0.00,1.00,100.00),(84,'Pavlaka',193.00,2.40,3.00,3.00,0.00,20.00,100.00),(85,'Maslac',717.00,0.80,0.10,0.10,0.00,81.00,100.00),(86,'Margarin',717.00,0.20,0.00,0.00,0.00,81.00,100.00),(87,'Sir (gauda)',356.00,25.00,2.20,0.10,0.00,30.00,100.00),(88,'Sir (edamer)',331.00,24.00,1.50,0.00,0.00,27.00,100.00),(89,'Feta sir',264.00,14.20,4.10,4.10,0.00,21.30,100.00),(90,'Mladi sir (nemasni)',98.00,11.00,3.40,3.40,0.00,4.30,100.00),(91,'Parmezan',431.00,38.00,4.10,0.90,0.00,29.00,100.00),(92,'Mozzarella',280.00,18.00,2.20,1.00,0.00,21.00,100.00),(93,'Puter od kikirikija',588.00,25.00,20.00,9.00,6.00,50.00,100.00),(94,'Bademi',579.00,21.00,22.00,4.40,12.50,50.00,100.00),(95,'Orasi',654.00,15.20,13.70,2.60,6.70,65.20,100.00),(96,'Lešnici',628.00,15.00,17.00,4.30,10.00,61.00,100.00),(97,'Indijski orah',553.00,18.00,30.00,5.90,3.30,44.00,100.00),(98,'Pistacije',562.00,20.00,28.00,7.70,10.00,45.00,100.00),(99,'Pekan orah',691.00,9.20,14.00,4.00,10.60,72.00,100.00),(100,'Brazilski orah',659.00,14.00,12.00,2.30,7.50,67.00,100.00),(101,'Makadamija',718.00,7.90,13.80,4.60,8.60,76.00,100.00);
/*!40000 ALTER TABLE `hrana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `korisnik` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) NOT NULL,
  `prezime` varchar(100) NOT NULL,
  `email` varchar(254) DEFAULT NULL,
  `password_hash` varchar(128) DEFAULT NULL,
  `visina` int DEFAULT NULL,
  `tezina` decimal(5,2) DEFAULT NULL,
  `datum_rodjenja` date DEFAULT NULL,
  `uloga_id` int NOT NULL,
  `teretana_pib` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `uloga_id` (`uloga_id`),
  KEY `fk_korisnik_teretana` (`teretana_pib`),
  CONSTRAINT `fk_korisnik_teretana` FOREIGN KEY (`teretana_pib`) REFERENCES `teretana` (`pib`) ON DELETE SET NULL,
  CONSTRAINT `korisnik_ibfk_1` FOREIGN KEY (`uloga_id`) REFERENCES `uloga` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (13,'Petar','Petrović','petar.petrovic@example.com','{bcrypt}$2a$10$991XrZsoKvZaPcvekYKxvusPfMScqCWJBA5oSKwkWH6PZrJfINJDi',180,75.50,'1995-05-10',2,NULL),(14,'Vasilije','Jovanovic','vasilije123@gmail.com','{bcrypt}$2a$10$URjK/AIAT4i0pGvyEC5zau.HSNifcMDED3Ntbf2VperAapLSThk96',183,78.00,'2003-03-27',2,NULL),(15,'Marko','Markovic','marko123@gmail.com','{bcrypt}$2a$10$ptb3hSm3SH4XY27umfti9uZmCaih4mpBpBVdElurU6K05sK6jU1Ni',190,95.00,'2000-01-01',1,NULL),(16,'Jovan','Jovanovic','jj@gmail.com','{bcrypt}$2a$10$rvHZnvgvuFnNxMmcj/2M9.DTr7wjAZr9v.BRRjzIh2lw1TIMsnOw.',175,70.00,'2002-01-01',2,NULL),(17,'Janko','Jankovic','janko@gmail.com','{bcrypt}$2a$10$92deDDARPs6rmo7vapSmDuo4AkaiuD9tknQsqFOxj8tADP1J9gluS',180,80.00,'1985-11-21',3,112233445);
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obrok`
--

DROP TABLE IF EXISTS `obrok`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `obrok` (
  `id` int NOT NULL AUTO_INCREMENT,
  `datum` date NOT NULL,
  `hrana_id` int NOT NULL,
  `korisnik_id` int NOT NULL,
  `kolicina_gram` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hrana_id` (`hrana_id`),
  KEY `korisnik_id` (`korisnik_id`),
  CONSTRAINT `obrok_ibfk_1` FOREIGN KEY (`hrana_id`) REFERENCES `hrana` (`id`),
  CONSTRAINT `obrok_ibfk_2` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obrok`
--

LOCK TABLES `obrok` WRITE;
/*!40000 ALTER TABLE `obrok` DISABLE KEYS */;
INSERT INTO `obrok` VALUES (3,'2025-05-16',1,13,150),(4,'2025-05-16',2,13,100),(5,'2025-05-16',6,13,80),(6,'2025-05-17',42,13,60),(7,'2025-05-17',61,13,120),(8,'2025-05-16',3,14,180),(9,'2025-05-16',5,14,100),(10,'2025-05-17',80,14,150),(11,'2025-05-17',29,14,50),(12,'2025-05-17',26,15,170),(13,'2025-05-17',12,15,70),(14,'2025-05-18',82,15,200),(15,'2025-05-18',60,15,150),(16,'2025-05-16',25,16,160),(17,'2025-05-16',15,16,120),(18,'2025-05-18',28,16,150),(19,'2025-05-18',8,16,100),(20,'2025-05-17',1,17,130),(21,'2025-05-17',45,17,90),(22,'2025-05-18',90,17,100),(23,'2025-05-18',9,17,80);
/*!40000 ALTER TABLE `obrok` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teretana`
--

DROP TABLE IF EXISTS `teretana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teretana` (
  `pib` int NOT NULL,
  `naziv` varchar(100) DEFAULT NULL,
  `adresa` varchar(100) DEFAULT NULL,
  `grad` varchar(100) DEFAULT NULL,
  `drzava` varchar(100) DEFAULT NULL,
  `clanarina_eur` int DEFAULT '0',
  `vlasnik_id` int NOT NULL,
  PRIMARY KEY (`pib`),
  KEY `vlasnik_id` (`vlasnik_id`),
  CONSTRAINT `teretana_ibfk_1` FOREIGN KEY (`vlasnik_id`) REFERENCES `korisnik` (`id`),
  CONSTRAINT `chk_pib_range` CHECK ((`pib` between 100000000 and 999999999)),
  CONSTRAINT `teretana_chk_2` CHECK ((`clanarina_eur` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teretana`
--

LOCK TABLES `teretana` WRITE;
/*!40000 ALTER TABLE `teretana` DISABLE KEYS */;
INSERT INTO `teretana` VALUES (101020304,'Athletic Gym','Ul. Bratstva i Jedinstva 77','Podgorica','Crna Gora',28,16),(112233445,'Star Fitness','Bulevar Džordža Vašingtona 57','Podgorica','Crna Gora',35,16),(123456789,'Soko Gym - Stari Aerodrom','Bulevar Josipa Broza Tita bb','Podgorica','Crna Gora',30,13),(556677889,'Go Gym Fitness Centar','Ul. 4. jula bb','Podgorica','Crna Gora',25,13),(987654321,'Capital Fitness Centar','Cetinjski Put bb, The Capital Plaza','Podgorica','Crna Gora',45,14),(998877665,'World Class Fitness - Delta City','Cetinjski Put bb, Delta City','Podgorica','Crna Gora',50,14);
/*!40000 ALTER TABLE `teretana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tip_treninga`
--

DROP TABLE IF EXISTS `tip_treninga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tip_treninga` (
  `id` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tip_treninga`
--

LOCK TABLES `tip_treninga` WRITE;
/*!40000 ALTER TABLE `tip_treninga` DISABLE KEYS */;
INSERT INTO `tip_treninga` VALUES (1,'trening snage'),(2,'kardio'),(3,'trening sa tegovima'),(4,'trening sa sopstvenom tezinom'),(6,'HIIT (Visokointenzivni intervalni trening)'),(7,'Joga'),(8,'Pilates'),(9,'Funkcionalni trening'),(10,'CrossFit'),(11,'Trening izdržljivosti'),(12,'Pliometrijski trening'),(13,'Kalistenika');
/*!40000 ALTER TABLE `tip_treninga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transakcija`
--

DROP TABLE IF EXISTS `transakcija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transakcija` (
  `id` int NOT NULL AUTO_INCREMENT,
  `iznos` decimal(7,2) DEFAULT NULL,
  `teretana_pib` int NOT NULL,
  `clan_id` int NOT NULL,
  `datum` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teretana_pib` (`teretana_pib`),
  KEY `clan_id` (`clan_id`),
  CONSTRAINT `transakcija_ibfk_1` FOREIGN KEY (`teretana_pib`) REFERENCES `teretana` (`pib`),
  CONSTRAINT `transakcija_ibfk_2` FOREIGN KEY (`clan_id`) REFERENCES `korisnik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transakcija`
--

LOCK TABLES `transakcija` WRITE;
/*!40000 ALTER TABLE `transakcija` DISABLE KEYS */;
INSERT INTO `transakcija` VALUES (4,35.00,112233445,17,'2025-04-01'),(5,35.00,112233445,17,'2025-05-01'),(6,28.00,101020304,17,'2025-03-01');
/*!40000 ALTER TABLE `transakcija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trening`
--

DROP TABLE IF EXISTS `trening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trening` (
  `id` int NOT NULL AUTO_INCREMENT,
  `datum` date NOT NULL,
  `clan_id` int NOT NULL,
  `tip_treninga_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tip_treninga_id` (`tip_treninga_id`),
  KEY `clan_id` (`clan_id`),
  CONSTRAINT `trening_ibfk_1` FOREIGN KEY (`tip_treninga_id`) REFERENCES `tip_treninga` (`id`),
  CONSTRAINT `trening_ibfk_2` FOREIGN KEY (`clan_id`) REFERENCES `korisnik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trening`
--

LOCK TABLES `trening` WRITE;
/*!40000 ALTER TABLE `trening` DISABLE KEYS */;
INSERT INTO `trening` VALUES (4,'2025-05-10',17,1),(5,'2025-05-11',17,2),(6,'2025-05-12',17,3),(7,'2025-05-13',17,6),(8,'2025-05-14',17,9),(9,'2025-05-15',17,10),(10,'2025-05-16',17,4),(11,'2025-05-17',17,7),(12,'2025-05-18',17,11),(13,'2025-05-18',17,8),(14,'2025-05-15',14,1),(15,'2025-05-17',14,3),(16,'2025-05-18',14,2);
/*!40000 ALTER TABLE `trening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uloga`
--

DROP TABLE IF EXISTS `uloga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uloga` (
  `id` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uloga`
--

LOCK TABLES `uloga` WRITE;
/*!40000 ALTER TABLE `uloga` DISABLE KEYS */;
INSERT INTO `uloga` VALUES (1,'admin'),(2,'vlasnik'),(3,'clan');
/*!40000 ALTER TABLE `uloga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'wgym'
--

--
-- Dumping routines for database 'wgym'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-18 16:43:07

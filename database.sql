-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: lnh
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admission_type_table`
--

DROP TABLE IF EXISTS `admission_type_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admission_type_table` (
  `add_id` int(11) NOT NULL AUTO_INCREMENT,
  `admission_type` varchar(45) NOT NULL,
  PRIMARY KEY (`add_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `antibiotic_type_table`
--

DROP TABLE IF EXISTS `antibiotic_type_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `antibiotic_type_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `antibiotic_type_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comorbids_table`
--

DROP TABLE IF EXISTS `comorbids_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comorbids_table` (
  `com_id` int(11) NOT NULL AUTO_INCREMENT,
  `comorbids_type` varchar(45) NOT NULL,
  PRIMARY KEY (`com_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `daywisecheckup`
--

DROP TABLE IF EXISTS `daywisecheckup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `daywisecheckup` (
  `nouseid` int(11) NOT NULL AUTO_INCREMENT,
  `hospno` varchar(30) NOT NULL,
  `day` int(11) DEFAULT NULL,
  `hr` int(11) DEFAULT NULL,
  `sbp` int(11) DEFAULT NULL,
  `dbp` int(11) DEFAULT NULL,
  `map` int(11) DEFAULT NULL,
  `temp` int(11) DEFAULT NULL,
  `rr` int(11) DEFAULT NULL,
  `gcs` int(11) DEFAULT NULL,
  `rass` int(11) DEFAULT NULL,
  `delirium` varchar(5) DEFAULT NULL,
  `painscore` int(11) DEFAULT NULL,
  `ph` double DEFAULT NULL,
  `paco2` int(11) DEFAULT NULL,
  `pao` int(11) DEFAULT NULL,
  `flo2` double DEFAULT NULL,
  `hco3` int(11) DEFAULT NULL,
  `baseexcess` double DEFAULT NULL,
  `urea` int(11) DEFAULT NULL,
  `creatinine` double DEFAULT NULL,
  `na` int(11) DEFAULT NULL,
  `k` double DEFAULT NULL,
  `cl` int(11) DEFAULT NULL,
  `hb` double DEFAULT NULL,
  `hct` double DEFAULT NULL,
  `plateletes` double DEFAULT NULL,
  `wbc` double DEFAULT NULL,
  `ptinr` double DEFAULT NULL,
  `fibrinog` double DEFAULT NULL,
  `ddimer` double DEFAULT NULL,
  `mg` double DEFAULT NULL,
  `po4` double DEFAULT NULL,
  `ca` double DEFAULT NULL,
  `caion` double DEFAULT NULL,
  `bilirubin` double DEFAULT NULL,
  `alt` int(11) DEFAULT NULL,
  `ast` int(11) DEFAULT NULL,
  `alkphos` int(11) DEFAULT NULL,
  `ggt` int(11) DEFAULT NULL,
  `amylase` int(11) DEFAULT NULL,
  `lipase` int(11) DEFAULT NULL,
  `albumen` double DEFAULT NULL,
  `ldh` int(11) DEFAULT NULL,
  `cpk` int(11) DEFAULT NULL,
  `trop1` double DEFAULT NULL,
  `bnp` int(11) DEFAULT NULL,
  `lactate` double DEFAULT NULL,
  `pct` double DEFAULT NULL,
  `crp` double DEFAULT NULL,
  `bsrmin` int(11) DEFAULT NULL,
  `bsrmax` int(11) DEFAULT NULL,
  `spotUSodium` double DEFAULT NULL,
  `dvtpropylaxis` varchar(100) DEFAULT NULL,
  `dialysis` varchar(5) DEFAULT NULL,
  `vasopressors` varchar(5) DEFAULT NULL,
  `norepinephrine` double DEFAULT NULL,
  `dobutamine` double DEFAULT NULL,
  `dopamine` double DEFAULT NULL,
  `epinephrine` double DEFAULT NULL,
  `phenylephrine` double DEFAULT NULL,
  `steriodsld` varchar(5) DEFAULT NULL,
  `ventilate` varchar(5) DEFAULT NULL,
  `mode` varchar(50) DEFAULT NULL,
  `vt` double DEFAULT NULL,
  `ps` int(11) DEFAULT NULL,
  `peep` int(11) DEFAULT NULL,
  `ppeak` int(11) DEFAULT NULL,
  `pplat` int(11) DEFAULT NULL,
  `cstat` int(11) DEFAULT NULL,
  `ETTcuffpress` int(11) DEFAULT NULL,
  `weaning` varchar(5) DEFAULT NULL,
  `extubniv` varchar(5) DEFAULT NULL,
  `tpiece` varchar(5) DEFAULT NULL,
  `fluidbalance` varchar(5) DEFAULT NULL,
  `urineOutput` int(11) DEFAULT NULL,
  `otherlosses` int(11) DEFAULT NULL,
  `outputTotal` int(11) DEFAULT NULL,
  `intakeTotal` int(11) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `cumbalance` int(11) DEFAULT NULL,
  `IVFluids` varchar(5) DEFAULT NULL,
  `crystalloid` varchar(50) DEFAULT NULL,
  `colloid` varchar(50) DEFAULT NULL,
  `bloodPRCBS` int(11) DEFAULT NULL,
  `plateletunit` int(11) DEFAULT NULL,
  `ffps` int(11) DEFAULT NULL,
  `complicat` varchar(5) DEFAULT NULL,
  `Aline` varchar(5) DEFAULT NULL,
  `cvpmin` int(11) DEFAULT NULL,
  `cvpmax` int(11) DEFAULT NULL,
  `route` varchar(15) DEFAULT NULL,
  `formula` varchar(15) DEFAULT NULL,
  `dopplr` varchar(45) DEFAULT NULL,
  `pocus` varchar(45) DEFAULT NULL,
  `tracheal` varchar(100) DEFAULT NULL,
  `bloodPeripheral` varchar(100) DEFAULT NULL,
  `urine` varchar(100) DEFAULT NULL,
  `csf` varchar(100) DEFAULT NULL,
  `peritoneal` varchar(100) DEFAULT NULL,
  `wound` varchar(100) DEFAULT NULL,
  `bloodCvp` varchar(100) DEFAULT NULL,
  `others` varchar(100) DEFAULT NULL,
  `othersOrg` varchar(500) DEFAULT NULL,
  `cal` double DEFAULT NULL,
  `Protein` double DEFAULT NULL,
  `Sofa` int(11) DEFAULT NULL,
  `pbyf` float DEFAULT NULL,
  `PAO2` float DEFAULT NULL,
  `gradient` float DEFAULT NULL,
  `cryoppt` int(11) DEFAULT NULL,
  PRIMARY KEY (`nouseid`)
) ENGINE=InnoDB AUTO_INCREMENT=1675 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `org`
--

DROP TABLE IF EXISTS `org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `org` (
  `hospno` varchar(50) NOT NULL,
  `org_value` varchar(50) DEFAULT NULL,
  `org_name` varchar(45) DEFAULT NULL,
  `day` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `org_type_table`
--

DROP TABLE IF EXISTS `org_type_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `org_type_table` (
  `id` int(11) NOT NULL,
  `org_type_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `patient_admission_type`
--

DROP TABLE IF EXISTS `patient_admission_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `patient_admission_type` (
  `hospno` varchar(50) NOT NULL,
  `patient_admission_type_id` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `patient_antibiotic_table`
--

DROP TABLE IF EXISTS `patient_antibiotic_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `patient_antibiotic_table` (
  `hospno` varchar(30) NOT NULL,
  `patient_antibiotic_value` varchar(45) DEFAULT NULL,
  `day` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `patient_comorbid`
--

DROP TABLE IF EXISTS `patient_comorbid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `patient_comorbid` (
  `hospno` varchar(50) NOT NULL,
  `patient_comorbid_id` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `patientinfo`
--

DROP TABLE IF EXISTS `patientinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `patientinfo` (
  `hospno` varchar(30) NOT NULL,
  `doaInHosp` date DEFAULT NULL,
  `doaInIcu` date DEFAULT NULL,
  `time` varchar(10) DEFAULT NULL,
  `code` varchar(15) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `bmi` double DEFAULT NULL,
  `admittedfrom` varchar(15) DEFAULT NULL,
  `LOS` int(11) DEFAULT NULL,
  `pdiagnosis` varchar(500) DEFAULT NULL,
  `surgery` varchar(500) DEFAULT NULL,
  `surgerydate` date DEFAULT NULL,
  `redodate` date DEFAULT NULL,
  `ICUoutcome` varchar(15) DEFAULT NULL,
  `dodischarge` date DEFAULT NULL,
  `sdiagnosis` varchar(500) DEFAULT NULL,
  `redo` varchar(100) DEFAULT NULL,
  `lifeSustainingTherapyWithdrawn` varchar(10) DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `reAdmission` varchar(45) DEFAULT NULL,
  `reasonofreadmission` varchar(100) DEFAULT NULL,
  `readmissionDate` date DEFAULT NULL,
  `hospOutcome` varchar(50) DEFAULT NULL,
  `ApacheII` int(11) DEFAULT NULL,
  `SAPS` int(11) DEFAULT NULL,
  `qSOFA` int(11) DEFAULT NULL,
  `nutritionriskscore` int(11) DEFAULT NULL,
  `DOD` date DEFAULT NULL,
  `airwaytype` varchar(15) DEFAULT NULL,
  `intubationat` varchar(15) DEFAULT NULL,
  `extubation` date DEFAULT NULL,
  `extubationtime` varchar(11) DEFAULT NULL,
  `reintubation` date DEFAULT NULL,
  `selfextubation` varchar(10) DEFAULT NULL,
  `vent` varchar(45) DEFAULT NULL,
  `ventilationdays` int(11) DEFAULT NULL,
  `vap` varchar(10) DEFAULT NULL,
  `cvpdays` int(11) DEFAULT NULL,
  `clabsi` varchar(10) DEFAULT NULL,
  `complications` varchar(100) DEFAULT NULL,
  `pcauseofdeath` varchar(45) DEFAULT NULL,
  `Brainscan` varchar(15) DEFAULT NULL,
  `repeatscan` varchar(15) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `Escore` int(11) DEFAULT NULL,
  `Mscore` int(11) DEFAULT NULL,
  `Bscore` int(11) DEFAULT NULL,
  `Rscore` int(11) DEFAULT NULL,
  `totalscore` int(11) DEFAULT NULL,
  PRIMARY KEY (`hospno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'lnh'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-21  3:36:37

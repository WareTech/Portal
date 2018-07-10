DROP DATABASE WareTech_ClubTech;
CREATE DATABASE WareTech_ClubTech;

CREATE TABLE `employee` (
  `EMP_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `EMP_NAME` varchar(45) DEFAULT NULL,
  `EMP_HIRE_DATE` datetime DEFAULT NULL,
  `EMP_SALARY` decimal(11,4) DEFAULT NULL,
  PRIMARY KEY (`EMP_ID`)
);

CREATE TABLE `Player` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `dni` varchar(45) DEFAULT NULL,
  `birthdate` varchar(8) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `key` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);



CREATE TABLE `Note` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `playerId` bigint(19) DEFAULT NULL,
  `date` varchar(12) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Suscription` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `period` varchar(8) DEFAULT NULL,
  `amount` decimal(11,4) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Payment` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `playerId` bigint(19) NOT NULL ,
  `suscriptionId` bigint(19) DEFAULT NULL,
  `amount` decimal(11,4) DEFAULT NULL,
  PRIMARY KEY (`id`)
);




CREATE TABLE `specialty` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `statusId` VARCHAR(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE `skill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `statusId` VARCHAR(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);


CREATE TABLE `developer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `specialtyId` int DEFAULT NULL,
  `statusId` VARCHAR(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_developer_specialtyId` (`specialtyId`),
  CONSTRAINT `fk_developer_specialtyId` FOREIGN KEY (`specialtyId`) REFERENCES `specialty` (`id`)
);

CREATE TABLE `devskill` (
  `devId` int NOT NULL,
  `skillId` int NOT NULL,
  `statusId` VARCHAR(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`devId`,`skillId`)
);


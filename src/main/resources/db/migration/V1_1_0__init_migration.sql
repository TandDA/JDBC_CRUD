CREATE TABLE `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `specialty` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `statusId` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_specialty_statusId` (`statusId`),
  CONSTRAINT `fk_specialty_statusId` FOREIGN KEY (`statusId`) REFERENCES `status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `skill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `statusId` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_skill_statusId` (`statusId`),
  CONSTRAINT `fk_skill_statusId` FOREIGN KEY (`statusId`) REFERENCES `status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `developer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `specialtyId` int DEFAULT NULL,
  `statusId` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_developer_specialtyId` (`specialtyId`),
  KEY `fk_developer_statusId` (`statusId`),
  CONSTRAINT `fk_developer_specialtyId` FOREIGN KEY (`specialtyId`) REFERENCES `specialty` (`id`),
  CONSTRAINT `fk_developer_statusId` FOREIGN KEY (`statusId`) REFERENCES `status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `devskill` (
  `devId` int NOT NULL,
  `skillId` int NOT NULL,
  `statusId` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`devId`,`skillId`),
  KEY `fk_devSkill_statusId` (`statusId`),
  CONSTRAINT `fk_devSkill_statusId` FOREIGN KEY (`statusId`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE DATABASE  IF NOT EXISTS `akademik_directory`
CHARACTER SET utf8;
USE `akademik_directory`;

DROP TABLE IF EXISTS `galerija`;
DROP TABLE IF EXISTS `jelo`;

CREATE TABLE `jelo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vrsta_jela` varchar(45) not null,
  `naziv_jela` varchar(45) not null,
  `cijena` double not null,
  `slika` varchar(256) not null, 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

create table `galerija` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`slika` varchar(256) not null, 
`jelo_id` int(11) default null ,
PRIMARY KEY (`id`),

KEY `FK_JELO_ID_idx` (`jelo_id`) , 
CONSTRAINT `FK_JELO` 
FOREIGN KEY (`jelo_id`) 
REFERENCES `jelo` (`id`) 
  
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;


CREATE TABLE `users` (
   `username` varchar(50) NOT NULL,
   `password` char(68) NOT NULL,
   `enabled` tinyint(1) NOT NULL,
	PRIMARY KEY (`username`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 
CREATE TABLE `authorities` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `username` varchar(50) default NULL,
  `authority` varchar(50) NOT NULL,
   primary key (`id`) ,
   
   KEY `FK_USER_idx` (`username`),
  CONSTRAINT `FK_USER` FOREIGN KEY (`username`) 
  REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO `jelo` 
VALUES 
(1,'pica','Vegeterijana' , 7 , 'https://i.imgur.com/foiFFNi.png'),
(2,'pica','Pica sa zeljem' , 8.5 ,'https://i.imgur.com/mZ6DwnT.png'),
(3,'pica','Margarita' , 7 , 'https://i.imgur.com/QnUlH3o.png'),
(4,'pica','Pica Akademik' , 13 , 'https://i.imgur.com/wfl8ZaR.png'),
(5,'pasta','Pasta sa fasiranom govedinom' , 12 , 'https://i.imgur.com/DU710N8.png'),
(6,'pasta','Pasta sa povrćem' , 8 , 'https://i.imgur.com/AaASPea.png'),
(7,'pasta','Pasta sa teletinom' , 15 , 'https://i.imgur.com/BjEbBpq.png'),
(8,'pasta','Pasta sa sirom i gljivama' , 8 , 'https://i.imgur.com/CciZuQc.png'),
(9,'palačinka','Vocne palačinke' , 5 , 'https://i.imgur.com/qBdHcN4.png'),
(10,'palačinka','Palačinka sa evrokremom' , 6 , 'https://i.imgur.com/H6RXBUy.png'),
(11,'palačinka','Američke palačinke sa jagodama' , 7 , 'https://i.imgur.com/4xvdc0m.png'),
(12,'palačinka','Američke palačinke' , 11 , 'https://i.imgur.com/K6Cg0vt.png'),
(13,'sendvič','Burger sa pomfritom' , 8 , 'https://i.imgur.com/sKBhtYL.png'),
(14,'sendvič','Sendvič sa pršutom' , 6 , 'https://i.imgur.com/5H6rtuf.png'),
(15,'sendvič','Sendvič sa šunkom i sirom' , 5 , 'https://i.imgur.com/KNWfXxZ.png'),
(16,'sendvič','Posni sendvič sa paradajzom' , 5 , 'https://i.imgur.com/EShds2M.png');

INSERT INTO `users` 
VALUES 
('branko','$2a$10$DRMxQ4hWk2QQX7kit/xNUuxGj5mTRC.6/QFQSPKIRmol/XwocXC.i',1);


INSERT INTO `authorities` 
VALUES 
(1,'branko','ROLE_EMPLOYEE'),
(2,'branko','ROLE_MANAGER'),
(3,'branko','ROLE_ADMIN');

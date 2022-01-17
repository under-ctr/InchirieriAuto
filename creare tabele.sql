CREATE TABLE `angajat` (
  `id_angajat` int NOT NULL,
  `Nume` varchar(45) NOT NULL,
  `Prenume` varchar(45) NOT NULL,
  `Salar` int NOT NULL,
  `Data_angajare` date NOT NULL,
  `Data_concediere` date DEFAULT NULL,
  PRIMARY KEY (`id_angajat`),
  UNIQUE KEY `idangajat_UNIQUE` (`id_angajat`)
) ;

CREATE TABLE `autoturisme` (
  `Nr_Inmatriculare` varchar(7) NOT NULL,
  `Marca` varchar(45) NOT NULL,
  `Model` varchar(45) NOT NULL,
  `An` int NOT NULL,
  `Carburant` varchar(45) NOT NULL,
  `Consum` int NOT NULL,
  `Pret` int NOT NULL,
  `id_supraveghetor` int NOT NULL,
  suma_produs int DEFAULT '0',
  PRIMARY KEY (`Nr_Inmatriculare`),
  UNIQUE KEY `Nr Inmatriculare_UNIQUE` (`Nr_Inmatriculare`),
  KEY `fk_superior_idx` (`id_supraveghetor`),
  CONSTRAINT `fk_superior` FOREIGN KEY (`id_supraveghetor`) REFERENCES `angajat` (`id_angajat`)
) ;

CREATE TABLE `autoutilitare` (
  `Nr_Inmatriculare` varchar(7) NOT NULL,
  `Marca` varchar(45) NOT NULL,
  `Model` varchar(45) NOT NULL,
  `An` int NOT NULL,
  `Carburant` varchar(45) NOT NULL,
  `Consum` int NOT NULL,
  `Pret` int NOT NULL,
  `id_supraveghetor` int NOT NULL,
  PRIMARY KEY (`Nr_Inmatriculare`),
  UNIQUE KEY `Nr Inmatriculare_UNIQUE` (`Nr_Inmatriculare`),
  KEY `fk_superior_idx` (`id_supraveghetor`),
  CONSTRAINT `fk_a_duba` FOREIGN KEY (`id_supraveghetor`) REFERENCES `angajat` (`id_angajat`)
) ;

CREATE TABLE `client` (
  `CNP` varchar(14) NOT NULL,
  `Nume` varchar(45) NOT NULL,
  `Prenume` varchar(45) NOT NULL,
  PRIMARY KEY (`CNP`),
  UNIQUE KEY `CNP_UNIQUE` (`CNP`)
);


CREATE TABLE `contract` (
  `nr_contract` int NOT NULL AUTO_INCREMENT,
  `cnp_client` varchar(14) NOT NULL,
  `nr_masina` varchar(7) DEFAULT NULL,
  `perioada` int NOT NULL,
  `pret_final` int ,
  `nr_duba` varchar(7) DEFAULT NULL,
  `nr_speciala` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`nr_contract`),
  UNIQUE KEY `idcontract_UNIQUE` (`nr_contract`),
  KEY `fk_masin_idx` (`nr_masina`),
  KEY `fk_client_idx` (`cnp_client`),
  CONSTRAINT `fk_client` FOREIGN KEY (`cnp_client`) REFERENCES `client` (`CNP`),
  CONSTRAINT `fk_duba` FOREIGN KEY (`nr_duba`) REFERENCES `autoutilitare` (`Nr_Inmatriculare`),
  CONSTRAINT `fk_masin` FOREIGN KEY (`nr_masina`) REFERENCES `autoturisme` (`Nr_Inmatriculare`),
  CONSTRAINT `fk_speciala` FOREIGN KEY (`nr_speciala`) REFERENCES `evenimente_speciale` (`Nr_Inmatriculare`)
) ;



CREATE TABLE `evenimente_speciale` (
  `Nr_Inmatriculare` varchar(7) NOT NULL,
  `Tip_vehicol` varchar(45) NOT NULL,
  `Pret` int NOT NULL,
  `id_supraveghetor` int NOT NULL,
  PRIMARY KEY (`Nr_Inmatriculare`),
  UNIQUE KEY `Nr_Inmatriculare_UNIQUE` (`Nr_Inmatriculare`),
  KEY `fk_a_speciala_idx` (`id_supraveghetor`),
  CONSTRAINT `fk_a_speciala` FOREIGN KEY (`id_supraveghetor`) REFERENCES `angajat` (`id_angajat`) 
) ;

CREATE TABLE `reducere` (
  `perioada_min` int NOT NULL,
  `perioada_max` int NOT NULL,
  `reducere` int NOT NULL
) ;

CREATE TABLE `proiect`.`istoric_inchirieri` (
  `CNP` VARCHAR(14) NULL,
  `data_inchiriere` DATE NULL,
  `numar_zile` INT NULL,
  `data_retur` DATE NULL);
  
  
  CREATE TABLE `proiect`.`login` (
  `idlogin` INT NOT NULL auto_increment,
  `username` VARCHAR(45) NULL,
  `parola` VARCHAR(45) NULL,
  PRIMARY KEY (`idlogin`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);



ALTER TABLE `proiect`.`contract` 
ADD COLUMN `valuta` VARCHAR(45) NULL AFTER `nr_speciala`;

ALTER TABLE `proiect`.`autoturisme` 
ADD COLUMN `suma_produsa` INT NULL AFTER `id_supraveghetor`;


CREATE TABLE IF NOT EXISTS `campagnes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `reference` INT(10) DEFAULT NULL,
  `libelle` VARCHAR(255) DEFAULT NULL,
  `objectif_financement` DOUBLE DEFAULT 0,
  `financement_debut` DATETIME NOT NULL,
  `financement_fin` DATETIME DEFAULT NULL,
  `parts_disponible` INT(10) DEFAULT 0,
  `pourcent_parts` DOUBLE DEFAULT 0,
  `medias_url` VARCHAR(255) DEFAULT NULL,
  `doc_projet_path` VARCHAR(255) DEFAULT NULL,
  `projet_id` BIGINT DEFAULT NULL,

  PRIMARY KEY (`id`),
  CONSTRAINT `fk_campagnes_projets`
    FOREIGN KEY (`projet_id`) REFERENCES `projets` (`id`)
    ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE `campagnes` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `reference` int(10) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `objectif_financement` DOUBLE DEFAULT 0,
  `date_debut` DATETIME DEFAULT NULL,
  `date_fin` DATETIME DEFAULT NULL,
  `parts_disponible` int(10) DEFAULT 0,
  `pourcent_parts` DOUBLE DEFAULT 0,
  `medias` VARCHAR(255) DEFAULT NULL,
  `doc_projet_path` VARCHAR(255) DEFAULT NULL,
  `projet_id` int(10),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_campagnes_projets` FOREIGN KEY (`projet_id`) REFERENCES `projets` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

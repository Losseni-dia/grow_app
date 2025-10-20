CREATE TABLE `parts` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre_parts` INT DEFAULT 0,
  `pourcent_equity` DOUBLE DEFAULT 0,
  `valeur_initiale` DOUBLE DEFAULT 0,
  `statut_part` ENUM('ACTIF', 'INACTIF', 'REVENDU') DEFAULT 'ACTIF',
  `investissement_id` BIGINT DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_parts_investissements` FOREIGN KEY (`investissement_id`) REFERENCES `investissements`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `dividendes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `montant_par_part` DOUBLE DEFAULT 0,
  `statut_dividende` ENUM('ANNUEL', 'SEMESTRIEL', 'TRIMESTRIEL') DEFAULT NULL,
  `moyen_paiement` ENUM('BANCONTACT', 'ORANGEMONEY', 'WAVE', 'VISA', 'MOBILEMONEY') DEFAULT NULL,
  `date_paiement` DATETIME DEFAULT NULL,
  `part_id` BIGINT DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_dividendes_parts` FOREIGN KEY (`part_id`) REFERENCES `parts`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

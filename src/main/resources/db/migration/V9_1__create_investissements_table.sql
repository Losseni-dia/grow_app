CREATE TABLE IF NOT EXISTS `investissements` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `montant` DOUBLE DEFAULT 0,
  `date` DATETIME DEFAULT NULL,
  `moyen_paiement` ENUM('BANCONTACT', 'ORANGEMONEY', 'WAVE', 'VISA', 'MOBILEMONEY') DEFAULT NULL,
  `frais` DOUBLE DEFAULT 0,
  `campagne_id` BIGINT DEFAULT NULL,
  `investisseur_id` BIGINT DEFAULT NULL,

  PRIMARY KEY (`id`),
  CONSTRAINT `fk_investissements_campagnes`
    FOREIGN KEY (`campagne_id`) REFERENCES `campagnes` (`id`)
    ON DELETE SET NULL,
  CONSTRAINT `fk_investissements_investisseurs`
    FOREIGN KEY (`investisseur_id`) REFERENCES `investisseurs` (`id`)
    ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
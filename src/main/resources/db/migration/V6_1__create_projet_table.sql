CREATE TABLE `projets` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(60) NOT NULL,
  `description` TEXT,
  `valuation` DOUBLE DEFAULT 0,
  `secteur` VARCHAR(60) DEFAULT NULL,
  `roi_projete` DOUBLE DEFAULT 0,
  `statut_projet` ENUM('FINANCEMENT_EN_COURS', 'FINANCE', 'ACTIF') DEFAULT NULL,
`business_plan` VARCHAR(60) DEFAULT NULL,
  `porteur_projet_id` int(10) DEFAULT NULL,
  `site_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_projets_porteur` FOREIGN KEY (`porteur_projet_id`) REFERENCES `porteur_projets` (`id`) ON DELETE SET NULL,
  CONSTRAINT `fk_projets_site` FOREIGN KEY (`site_id`) REFERENCES `siteprojets` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

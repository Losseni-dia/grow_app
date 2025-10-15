CREATE TABLE `projets` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` TEXT COLLATE utf8mb4_unicode_ci,
  `valuation` DOUBLE DEFAULT 0,
  `secteur` VARCHAR(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `roi_projete` DOUBLE DEFAULT 0,
  `statut_projet` VARCHAR(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `business_plan` VARCHAR(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `porteur_projet_id` int(10) DEFAULT NULL,
  `site_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_projets_porteur` FOREIGN KEY (`porteur_projet_id`) REFERENCES `porteur_projets` (`id`) ON DELETE SET NULL,
  CONSTRAINT `fk_projets_site` FOREIGN KEY (`site_id`) REFERENCES `siteprojets` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

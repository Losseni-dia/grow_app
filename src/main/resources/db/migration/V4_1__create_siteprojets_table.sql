CREATE TABLE `siteprojets` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresse` VARCHAR(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contact` VARCHAR(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `responsable` VARCHAR(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `localite_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_siteprojets_localites`
    FOREIGN KEY (`localite_id`) REFERENCES `localites` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


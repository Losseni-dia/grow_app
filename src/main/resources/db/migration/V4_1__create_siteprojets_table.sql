CREATE TABLE `siteprojets` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `localite_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_siteprojets_localites`
    FOREIGN KEY (`localite_id`) REFERENCES `localites`(`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

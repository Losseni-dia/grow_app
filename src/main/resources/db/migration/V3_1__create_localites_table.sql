-- V3__create_localites.sql
CREATE TABLE `localites` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `code_postal` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pays_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_localites_pays`
    FOREIGN KEY (`pays_id`) REFERENCES `pays` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

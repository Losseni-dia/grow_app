-- V1__create_pays.sql
CREATE TABLE `pays` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

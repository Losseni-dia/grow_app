CREATE TABLE `investisseurs` (
  `id` int(10) NOT NULL,
  `portefeuille_total` DOUBLE DEFAULT 0,
  `diaspora` BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_investisseurs_users` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

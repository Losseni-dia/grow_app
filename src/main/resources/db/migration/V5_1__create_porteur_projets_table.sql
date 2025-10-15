CREATE TABLE `porteur_projets` (
  `id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_porteurprojets_users` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

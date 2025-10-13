INSERT INTO `users` 
(`id`, `login`, `password`, `firstname`, `lastname`, `email`, `langue`, `pays`, `role`, `created_at`)
VALUES
(1, 'losseni', '$2a$12$izsxQzyJCcscAcPpZmX5J.xWHQvRlk5UT0Epf.UTzVT9huzMvb46.', 'Losseni', 'Dia', 'losseni.dia@example.com', 'fr', 'Belgique', 'ADMIN', NOW()),
(2, 'nahawa', '$2a$12$izsxQzyJCcscAcPpZmX5J.xWHQvRlk5UT0Epf.UTzVT9huzMvb46.', 'Nahawa', 'Kone', 'nahawa.kone@example.com', 'en', 'France', 'PARTENAIRE', NOW());

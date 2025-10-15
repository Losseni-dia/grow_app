INSERT INTO `users` 
(`id`, `login`, `password`, `firstname`, `lastname`, `email`, `langue`, `pays`, `role`, `created_at`)
VALUES
(1, 'losseni', '$2a$12$izsxQzyJCcscAcPpZmX5J.xWHQvRlk5UT0Epf.UTzVT9huzMvb46.', 'Losseni', 'Dia', 'losseni.dia@example.com', 'fr', 'Belgique', 'ADMIN', NOW()),
(2, 'nahawa', '$2a$12$izsxQzyJCcscAcPpZmX5J.xWHQvRlk5UT0Epf.UTzVT9huzMvb46.', 'Nahawa', 'Kone', 'nahawa.kone@example.com', 'en', 'France', 'PARTENAIRE', NOW()),
(3, 'johnsmith', '$2a$12$hash3value', 'John', 'Smith', 'john.smith@example.com', 'en', 'USA', 'INVESTISSEUR', NOW()),
(4, 'mariedupont', '$2a$12$hash4value', 'Marie', 'Dupont', 'marie.dupont@example.com', 'fr', 'France', 'PORTEUR', NOW()),
(5, 'lucas', '$2a$12$hash5value', 'Lucas', 'Brown', 'lucas.brown@example.com', 'en', 'Canada', 'INVESTISSEUR', NOW()),
(6, 'sara', '$2a$12$hash6value', 'Sara', 'Johnson', 'sara.johnson@example.com', 'en', 'USA', 'PARTENAIRE', NOW()),
(7, 'chen', '$2a$12$hash7value', 'Chen', 'Li', 'chen.li@example.com', 'zh', 'Chine', 'ADMIN', NOW()),
(8, 'amelie', '$2a$12$hash8value', 'Amelie', 'Martin', 'amelie.martin@example.com', 'fr', 'Belgique', 'PORTEUR', NOW());

INSERT INTO `campagnes` (
  reference, libelle, objectif_financement,
  financement_debut, financement_fin,
  parts_disponible, pourcent_parts,
  medias_url, doc_projet_path, projet_id
) VALUES
(1, 'Campagne GrowZ', 1000000.0,
 '2025-01-15 08:00:00', '2025-06-15 18:00:00',
 1000, 10.0,
 'video1.mp4,doc1.pdf', '/docs/BusinessPlanGrowZ.pdf', 1),

(2, 'Campagne BelleAir', 2000000.0,
 '2025-02-20 09:00:00', '2025-08-20 17:00:00',
 1500, 15.0,
 'video2.mp4', '/docs/BusinessPlanBelleAir.pdf', 2),

(3, 'Campagne Third', 1500000.0,
 '2025-03-10 08:30:00', '2025-09-10 18:00:00',
 1200, 12.5,
 'video3.mp4', '/docs/BusinessPlanThird.pdf', 1),
(4, 'Campagne Fourth', 500000.0,
 '2025-04-01 07:00:00', '2025-10-01 17:00:00',
 800, 8.0,
 'video4.mp4', '/docs/BusinessPlanFourth.pdf', 3),
 (5, 'Campagne Fifth', 750000.0,
 '2025-05-05 08:15:00', '2025-11-05 18:15:00',
 900, 9.0,
 'video5.mp4,doc5.pdf', '/docs/BusinessPlanFifth.pdf', 2);
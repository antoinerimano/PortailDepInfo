
-- -----------------------------------------------------
-- Data for table `projetportailspringdb`.`Utilisateur`
-- -----------------------------------------------------
START TRANSACTION;
USE `projetportailspringdb`;
INSERT INTO `projetportailspringdb`.`Utilisateur` (`id_utilisateur`, `code_permanent`, `date_naissance`, `nom`,  `prenom`, `username`,`password`) VALUES (1,2138934,'2023-12-12','Doe','John','anonymo','pass1234');
INSERT INTO `projetportailspringdb`.`Utilisateur` (`id_utilisateur`, `code_permanent`, `date_naissance`, `nom`,  `prenom`, `username`,`password`) VALUES (2,3450923,'2021-09-01','Doe','Jane','anonyma','pass1234');
INSERT INTO `projetportailspringdb`.`Utilisateur` (`id_utilisateur`, `code_permanent`, `date_naissance`, `nom`,  `prenom`, `username`,`password`) VALUES (3,2145637,'1923-11-22','Dimitrescu','Alcina','bigMom','pass1234');
INSERT INTO `projetportailspringdb`.`Utilisateur` (`id_utilisateur`, `code_permanent`, `date_naissance`, `nom`,  `prenom`, `username`,`password`) VALUES (4,1378453,'2004-11-01','Lukas','Peter','The Lonely','pass1234');
INSERT INTO `projetportailspringdb`.`Utilisateur` (`id_utilisateur`, `code_permanent`, `date_naissance`, `nom`,  `prenom`, `username`,`password`) VALUES (5,9845,'1993-01-24','Sims','Jonathan','The Eye','pass1234');
INSERT INTO `projetportailspringdb`.`Utilisateur` (`id_utilisateur`, `code_permanent`, `date_naissance`, `nom`,  `prenom`, `username`,`password`) VALUES (6,1192,'1993-07-10','Blackwood','Martin','The Spiral','pass1234');
INSERT INTO `projetportailspringdb`.`Utilisateur` (`id_utilisateur`, `code_permanent`, `date_naissance`, `nom`,  `prenom`, `username`,`password`) VALUES (7,2387,'1993-01-04','Lacoursiere','Gabriel','Apep','pass1234');
INSERT INTO `projetportailspringdb`.`Utilisateur` (`id_utilisateur`, `code_permanent`, `date_naissance`, `nom`,  `prenom`, `username`,`password`) VALUES (8,8077,'1999-11-19','Ahamada','Dini','Cuboid','pass1234');
COMMIT;


-- -----------------------------------------------------
-- Data for table `projetportailspringdb`.`Etudiant`
-- -----------------------------------------------------
START TRANSACTION;
USE `projetportailspringdb`;
INSERT INTO `projetportailspringdb`.`Etudiant` (`id_etudiant`, `codep`, `ancien`, `programme`, `type`) VALUES (1, 2138934 ,1 , 'programmation', 'normal');
INSERT INTO `projetportailspringdb`.`Etudiant` (`id_etudiant`, `codep`, `ancien`, `programme`, `type`) VALUES (2, 3450923 ,1 , 'programmation', 'tuteur');
INSERT INTO `projetportailspringdb`.`Etudiant` (`id_etudiant`, `codep`, `ancien`, `programme`, `type`) VALUES (3, 2145637 ,0 , 'reseautique', 'normal');
INSERT INTO `projetportailspringdb`.`Etudiant` (`id_etudiant`, `codep`, `ancien`, `programme`, `type`) VALUES (4, 1378453 ,1 , 'reseautique', 'etudiantdifficulte');
COMMIT;


-- -----------------------------------------------------
-- Data for table `projetportailspringdb`.`Professeur`
-- -----------------------------------------------------
START TRANSACTION;
USE `projetportailspringdb`;
INSERT INTO `projetportailspringdb`.`Professeur` (`id_professeur`, `codep`, `departement`) VALUES (1, 9845, 'programmation');
INSERT INTO `projetportailspringdb`.`Professeur` (`id_professeur`, `codep`, `departement`) VALUES (2, 1192, 'reseautique');
INSERT INTO `projetportailspringdb`.`Professeur` (`id_professeur`, `codep`, `departement`) VALUES (3, 2387, 'reseautique');
INSERT INTO `projetportailspringdb`.`Professeur` (`id_professeur`, `codep`, `departement`) VALUES (4, 8077, 'programmation');
COMMIT;


-- -----------------------------------------------------
-- Data for table `projetportailspringdb`.`Projet`
-- -----------------------------------------------------
START TRANSACTION;
USE `projetportailspringdb`;
INSERT INTO `projetportailspringdb`.`Projet` (`id_projet`, `codep`, `date_de_creation`, `nom_projet`, `description`, `etudiants_participants`, `lien`, `lien_img`, `nom_cour`, `note`, `professeur_superviseur`, `profil_programme`) VALUES (1, 2138934, '2023-03-22', 'tictactoe', 'lotsa X lotsa O','2138934,1378453', 'www.git.com/not_sus/tictactoe','test.png' ,'PRO-A23-RO', 0, 'ahamada','programmation');
INSERT INTO `projetportailspringdb`.`Projet` (`id_projet`, `codep`, `date_de_creation`, `nom_projet`, `description`, `etudiants_participants`, `lien`, `lien_img`, `nom_cour`, `note`, `professeur_superviseur`, `profil_programme`) VALUES (2, 2145637, '2023-03-22', 'securityTest', 'Doxxing Heisenberg',NULL, 'www.git.com/not_sus/securityTest','test.png' ,'SEC-A20-LO', 0, 'lacoursiere','reseautique');
INSERT INTO `projetportailspringdb`.`Projet` (`id_projet`, `codep`, `date_de_creation`, `nom_projet`, `description`, `etudiants_participants`, `lien`, `lien_img`, `nom_cour`, `note`, `professeur_superviseur`, `profil_programme`) VALUES (3, 1378453, '2023-03-22', 'borealis', 'Taking away the ozone layer of the earth','2138934', 'www.git.com/not_sus/borealis','test.png' ,'SEC-A20-LO', 10, 'lacoursiere','reseautique');
INSERT INTO `projetportailspringdb`.`Projet` (`id_projet`, `codep`, `date_de_creation`, `nom_projet`, `description`, `etudiants_participants`, `lien`, `lien_img`, `nom_cour`, `note`, `professeur_superviseur`, `profil_programme`) VALUES (4, 3450923, '2023-03-22', 'calculator', 'numbers and stuff','2138934,2145637', 'www.git.com/not_sus/calculator','test.png' ,'PRO-A23-RO', 10, 'ahamada','programmation');

COMMIT;


-- -----------------------------------------------------
-- Data for table `projetportailspringdb`.`NoteCour`
-- -----------------------------------------------------
START TRANSACTION;
USE `projetportailspringdb`;
INSERT INTO `projetportailspringdb`.`NoteCour` (`id_notecours`, `code_cour`, `codep`, `date_de_creation`, `lien`, `nom_note_cour`) VALUES (1, 'PRO-A23-RO',8077,'2023-03-22','www.git.com','CommentPython101');
INSERT INTO `projetportailspringdb`.`NoteCour` (`id_notecours`, `code_cour`, `codep`, `date_de_creation`, `lien`, `nom_note_cour`) VALUES (2, 'PWA-H23-RO',9845,'2023-03-22','www.git.com','Java pour les nuls');
INSERT INTO `projetportailspringdb`.`NoteCour` (`id_notecours`, `code_cour`, `codep`, `date_de_creation`, `lien`, `nom_note_cour`) VALUES (3, 'RAD-A21-PT',1192,'2023-03-22','www.git.com','OS Windows 101');
INSERT INTO `projetportailspringdb`.`NoteCour` (`id_notecours`, `code_cour`, `codep`, `date_de_creation`, `lien`, `nom_note_cour`) VALUES (4, 'RAD-A21-PW',1192,'2023-03-22','www.git.com','OS Ubuntu 101');
INSERT INTO `projetportailspringdb`.`NoteCour` (`id_notecours`, `code_cour`, `codep`, `date_de_creation`, `lien`, `nom_note_cour`) VALUES (5, 'PRO-H10-RO',2387,'2023-03-22','www.git.com','SQL injection pour les nuls');

COMMIT;



-- -----------------------------------------------------
-- Data for table `projetportailspringdb`.`Tuteur`
-- -----------------------------------------------------
START TRANSACTION;
USE `projetportailspringdb`;
INSERT INTO `projetportailspringdb`.`Tuteur` (`id_tuteur`, `choix`, `codep`, `cour`, `disponibilite`, `type_rencontre`, `visibilite`) VALUES (1,NULL, 3450923, 'PRO-H27-PR','2023-05-15', 'enLigne', 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `projetportailspringdb`.`EtudiantDifficulte`
-- -----------------------------------------------------
START TRANSACTION;
USE `projetportailspringdb`;
INSERT INTO `projetportailspringdb`.`etudiant_difficulte` (`id_etudiant_difficulte`, `choix`, `codep`, `cour`, `description`, `disponibilite`, `type_rencontre`) VALUES (1,NULL, 1378453, 'PRO-H27-PR','bad with everything, pls help','2023-05-15', 'enLigne');

COMMIT;
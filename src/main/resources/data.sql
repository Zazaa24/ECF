INSERT INTO avis (pseudo,commentaire,est_visible)
VALUES
('Jean-francois','C nul', false),
('Arthur','Meilleur journée de ma vie',true),
('Lilye','Il n''y a pas d''ecureuil',true),
('Sophie','Zoo très propre, ombragé.
Nombreux bancs et quelques tables de pique-nique.
Beaucoup d''animaux et une zone de contact pour approcher les lamas.
Compter 2h à 3h de visite.',true),
('Thomas','Une infrastructure tres bien organisée au plan de la signalisation. Des prix d’entrée très attractifs.
Beaucoup de sortes d’animaux, bien présentés.
Une belle plaine de jeux pour les enfants.
Deux pièges marketing, a l’entrée des photographes, a la sortie le magasin à peluches représentant les animaux du Zoo ou il est impossible de ne pas acheter. Mais bon…
Les petits enfants se sont amusés comme des fous , c’est le plus important.',true),
('Camille','Vraiment surpris positivement ! Le zoo était très propre et très bien entretenu , les animaux sont vraiment visible et on l''air heureux et en bonne santé.
J''ai été étonné en voyant que le zoo est enfaîte assez grand , les animations de nourrissage et d''explications sont vraiment interressantes et amusantes .',true);

INSERT INTO habitat(nom,description,commentaire_habitat)
VALUES
('Savane','La savane est une formation végétale propre aux régions chaudes, caractérisée par la dominance des hautes herbes.
Elle se trouve principalement dans les régions tropicales où il y a une longue saison sèche.
On distingue différents types de savanes en fonction de la densité du peuplement végétal : la savane boisée, la savane arborée, la savane arbustive et la savane herbeuse',
'Nous pouvons trouvé dans cette habitat des animaux tel que les lions,les girafes,les éléphants mais aussi les ours.'),
('Jungle','Une jungle est une formation végétale arborée qui prospère sous un climat chaud et humide, avec une courte saison sèche1. Elle est caractéristique des régions de mousson,
notamment en Asie du Sud-Est et en Inde.',
'On peut trouvé dans cette habitat des espèces comme les panthére noire, le python de séba.'),
('Marais',' un marais est une couche d’eau stagnante, en général peu profonde, et envahie par la végétation aquatique ou herbacée. C’est une zone humide.
La végétation des marais est constituée d’espèces adaptées au milieu humide. Sa composition varie selon la hauteur de l’eau, l’importance des périodes d’assèchement et le taux de salinité',
'On peut trouvé dans cette habitat des éspéces comme les alligator ou les salamandres');

INSERT INTO race("label")
VALUES
('Eléphant'),
('Girafe'),
('Lion'),
('Ours'),
('Alligator'),
('Python de séba'),
('Panthére noire'),
('Salamandre');

INSERT INTO "role"("label")
VALUES
('Administrateur'),
('Veterinaire'),
('Employe');



INSERT INTO utilisateur(username,"password",prenom,nom,role_id)
VALUES
('Admin@gmail.com','1234','Jean','Lemoine',1),
('Healer@hotmail.com','1234','Sabrina','Spicy',2),
('Alex@gmail.com','1234','Alexandre','Moli',3),
('Linou@free.fr','1234','Nathalie','Brebis',3),
('Eugé@orange.com','1234','Eugénie','BERREVYLLE',2),
('Sieg@gmail.com','1234','Nathan','Dufour',3),
('Holy@hotmail.com','1234','Paul','Bonnet',3);

INSERT INTO animal(prenom,etat,race_id,habitat_id)
VALUES
('Ronflex','Endormi',1,1),
('Longcou','En pleine forme',2,1),
('Simbad','En repas',3,1),
('Balou','Malade',4,1),
('Alli','En repas',5,3),
('Toto','En pleine forme',6,2),
('Titi','Malade',8,3),
('Bou','Endormi',7,2);

INSERT INTO alimentation(nourriture_propose,quantite,"date","time",utilisateur_id,animal_id)
VALUES
('Plante et ecorce','150kg','2024-06-20','10:20:20',3,1),
('Bourgeon et feuille','60kg','2024-06-20','10:20:20',3,2),
('Viande','7kg','2024-06-20','10:20:20',3,3),
('Ecorce d''arbre et noix','15kg','2024-06-20','10:20:20',3,4),
('Viande','250g','2024-06-20','10:20:20',3,8),
('Larve d''insecte','60g','2024-06-20','10:20:20',3,7),
('Viande','5kg','2024-06-20','10:20:20',3,6),
('Viande','5kg','2024-06-20','10:20:20',3,5);


INSERT INTO service(nom,description)
VALUES
('Restauration','Un petit creux?Venez profité de nos restaurant mis a votre disposition.'),
('Visite des habitats','Venez découvrir nos animaux avec un guide,il vous expliquera tout ce qu''il y a savoir sur les habitats et leur animaux.'),
('Visite du zoo en petit train','Grace a notre train mis a votre disposition,vous pourez avoir une vue global sur le zoo.');

INSERT INTO horaire(jour,heure,ordre)
VALUES
('Lundi','10h a 17h',1),
('Mardi','10h a 17h',2),
('Mercredi','10h a 17h',3),
('Jeudi','10h a 17h',4),
('Vendredi','10h a 17h',5),
('Samedi','9h a 18h',6),
('Dimanche','9h a 17h',7);




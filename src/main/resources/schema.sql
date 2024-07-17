DROP TABLE IF EXISTS avis CASCADE;
DROP TABLE IF EXISTS "role" CASCADE;
DROP TABLE IF EXISTS service CASCADE;
DROP TABLE IF EXISTS alimentation CASCADE;
DROP TABLE IF EXISTS rapport_veterinaire CASCADE;
DROP TABLE IF EXISTS image CASCADE;
DROP TABLE IF EXISTS animal CASCADE;
DROP TABLE IF EXISTS habitat CASCADE;
DROP TABLE IF EXISTS race CASCADE;
DROP TABLE IF EXISTS utilisateur CASCADE;
DROP TABLE IF EXISTS horaire CASCADE;


CREATE TABLE avis (
    id SERIAL PRIMARY KEY  NOT NULL,
    pseudo VARCHAR(50) NOT NULL,
    commentaire VARCHAR(500),
	est_visible BOOLEAN
);


CREATE TABLE race (
    id SERIAL PRIMARY KEY  NOT NULL,
    "label" VARCHAR(50) NOT NULL
);

CREATE TABLE service (
    id SERIAL PRIMARY KEY  NOT NULL,
    nom VARCHAR(50) NOT NULL,
    description VARCHAR(500)
);

CREATE TABLE "role" (
    id SERIAL PRIMARY KEY NOT NULL,
    "label" VARCHAR(50) NOT NULL
);


CREATE TABLE habitat (
    id SERIAL PRIMARY KEY  NOT NULL,
    nom VARCHAR(50) NOT NULL,
    description VARCHAR(500),
    commentaire_habitat VARCHAR(500)
);

CREATE TABLE utilisateur (
	id SERIAL PRIMARY KEY NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    "password" VARCHAR(50) NOT NULL,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    role_id INTEGER NOT NULL,
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES "role"(id) ON DELETE CASCADE
);

CREATE TABLE animal (
    id SERIAL PRIMARY KEY  NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    etat VARCHAR(500) NOT NULL,
    race_id INTEGER NOT NULL,
    habitat_id INTEGER NOT NULL,
    CONSTRAINT fk_race FOREIGN KEY (race_id) REFERENCES race(id) ON DELETE CASCADE,
    CONSTRAINT fk_habitat FOREIGN KEY (habitat_id) REFERENCES habitat(id) ON DELETE CASCADE
);

CREATE TABLE rapport_veterinaire (
    id SERIAL PRIMARY KEY  NOT NULL,
    "date" DATE NOT NULL,
	"time" TIME NOT NULL,
   	"detail" VARCHAR(500) NOT NULL,
    utilisateur_id INTEGER NOT NULL,
    animal_id INTEGER NOT NULL,
	alimentation_id INTEGER NOT NULL,
    CONSTRAINT fk_utilisateur FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id) ON DELETE CASCADE,
    CONSTRAINT fk_animal FOREIGN KEY (animal_id) REFERENCES animal(id) ON DELETE CASCADE
);


CREATE TABLE alimentation (
    id SERIAL PRIMARY KEY NOT NULL,
    nourriture_propose VARCHAR(50),
    quantite VARCHAR(50) NOT NULL,
	"date" DATE NOT NULL,
	"time" TIME NOT NULL,
	utilisateur_id INTEGER NOT NULL,
	rapport_id INTEGER,
	animal_id INTEGER NOT NULL,
	CONSTRAINT fk_utilisateur FOREIGN KEY(utilisateur_id) REFERENCES utilisateur(id) ON DELETE CASCADE,
	CONSTRAINT fk_rapport FOREIGN KEY(rapport_id) REFERENCES rapport_veterinaire(id) ON DELETE CASCADE,
	CONSTRAINT fk_animal FOREIGN KEY(animal_id) REFERENCES animal(id) ON DELETE CASCADE
);

CREATE TABLE image (
    id SERIAL PRIMARY KEY  NOT NULL,
    image_data BYTEA,
	habitat_id INTEGER,
	animal_id INTEGER,
	CONSTRAINT fk_habitat FOREIGN KEY (habitat_id) REFERENCES habitat(id) ON DELETE CASCADE,
	CONSTRAINT fk_animal FOREIGN KEY (habitat_id) REFERENCES animal(id) ON DELETE CASCADE
);

CREATE TABLE horaire (
	id SERIAL PRIMARY KEY NOT NULL,
	jour VARCHAR(50) NOT NULL,
	heure VARCHAR(50) NOT NULL,
	ordre INTEGER NOT NULL
);

ALTER TABLE rapport_veterinaire
ADD CONSTRAINT fk_alimentation FOREIGN KEY(alimentation_id) REFERENCES alimentation(id) ON DELETE CASCADE;
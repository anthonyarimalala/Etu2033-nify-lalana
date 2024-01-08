\c postgres;
DROP DATABASE nify;

CREATE DATABASE nify;
\c nify;

CREATE TABLE personne(
    id_personne SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255)
);

INSERT INTO personne(nom, prenom) VALUES
    ('Uzumaki', 'Naruto'),
    ('Uchiha', 'Sasuke'),
    ('Hatake', 'Kakashi'),
    ('Haruno', 'Sakura');

CREATE TABLE dent(
    id_dent INTEGER PRIMARY KEY
);

INSERT INTO dent(id_dent) values(1);
INSERT INTO dent(id_dent) values(2);
INSERT INTO dent(id_dent) values(3);
INSERT INTO dent(id_dent) values(4);
INSERT INTO dent(id_dent) values(5);
INSERT INTO dent(id_dent) values(6);
INSERT INTO dent(id_dent) values(7);
INSERT INTO dent(id_dent) values(8);
INSERT INTO dent(id_dent) values(9);
INSERT INTO dent(id_dent) values(10);
INSERT INTO dent(id_dent) values(11);
INSERT INTO dent(id_dent) values(12);
INSERT INTO dent(id_dent) values(13);
INSERT INTO dent(id_dent) values(14);
INSERT INTO dent(id_dent) values(15);
INSERT INTO dent(id_dent) values(16);

INSERT INTO dent(id_dent) values(21);
INSERT INTO dent(id_dent) values(22);
INSERT INTO dent(id_dent) values(23);
INSERT INTO dent(id_dent) values(24);
INSERT INTO dent(id_dent) values(25);
INSERT INTO dent(id_dent) values(26);
INSERT INTO dent(id_dent) values(27);
INSERT INTO dent(id_dent) values(28);
INSERT INTO dent(id_dent) values(29);
INSERT INTO dent(id_dent) values(30);
INSERT INTO dent(id_dent) values(31);
INSERT INTO dent(id_dent) values(32);
INSERT INTO dent(id_dent) values(33);
INSERT INTO dent(id_dent) values(34);
INSERT INTO dent(id_dent) values(35);
INSERT INTO dent(id_dent) values(36);

CREATE TABLE cout(
    id_cout SERIAL PRIMARY KEY,
    id_dent INTEGER REFERENCES dent(id_dent),
    traitement FLOAT,
    enlevement FLOAT,
    remplacement FLOAT,
    nettoyage FLOAT,
    prior_beaute INTEGER,
    prior_sante INTEGER
);

-- molaires
INSERT INTO cout(id_dent, enlevement, traitement, remplacement, nettoyage, prior_beaute, prior_sante) VALUES
    (1, 25000, 30000, 40000, 15000, 10, 101),
    (2, 25000, 30000, 40000, 15000, 20, 101),
    (3, 25000, 30000, 40000, 15000, 60, 11),

    (14, 25000, 30000, 40000, 15000, 60, 11),
    (15, 25000, 30000, 40000, 15000, 20, 101),
    (16, 25000, 30000, 40000, 15000, 10, 101),

    (21, 25000, 30000, 40000, 15000, 10, 100),
    (22, 25000, 30000, 40000, 15000, 20, 100),
    (23, 25000, 30000, 40000, 15000, 60, 90),

    (34, 25000, 30000, 40000, 15000, 60, 90),
    (35, 25000, 30000, 40000, 15000, 20, 100),
    (36, 25000, 30000, 40000, 15000, 10, 100);

    

-- pre-molaires
INSERT INTO cout(id_dent, enlevement, traitement, remplacement, nettoyage, prior_beaute, prior_sante) VALUES
    (4, 20000, 25000, 35000, 10000, 70, 11),
    (5, 20000, 25000, 35000, 10000, 80, 11),

    (12, 20000, 25000, 35000, 10000, 80, 11),
    (13, 20000, 25000, 35000, 10000, 70, 11),

    (24, 20000, 25000, 35000, 10000, 70, 80),
    (25, 20000, 25000, 35000, 10000, 80, 70),

    (32, 20000, 25000, 35000, 10000, 80, 70),
    (33, 20000, 25000, 35000, 10000, 70, 80);

-- canines
INSERT INTO cout(id_dent, enlevement, traitement, remplacement, nettoyage, prior_beaute, prior_sante) VALUES
    (6, 15000, 20000, 30000, 10000, 90, 11),
    (11, 15000, 20000, 30000, 10000, 90, 11),
    (26, 15000, 20000, 30000, 10000, 90, 60),
    (31, 15000, 20000, 30000, 10000, 90, 60);


-- incisives
INSERT INTO cout(id_dent, enlevement, traitement, remplacement, nettoyage, prior_beaute, prior_sante) VALUES
    (7, 10000, 15000, 25000, 10000, 100, 11),
    (8, 10000, 15000, 25000, 10000, 100, 11),
    (9, 10000, 15000, 25000, 10000, 100, 11),
    (10, 10000, 15000, 25000, 10000, 100, 11),

    (27, 10000, 15000, 25000, 10000, 100, 20),
    (28, 10000, 15000, 25000, 10000, 100, 10),
    (29, 10000, 15000, 25000, 10000, 100, 10),
    (30, 10000, 15000, 25000, 10000, 100, 20);

-- INSERT INTO cout(id_dent, enlevement, traitement, remplacement, nettoyage, prior_beaute, prior_sante) VALUES
--     (1, 25000, 30000, 40000, 15000, 10, 100),
--     (2, 25000, 30000, 40000, 15000, 20, 100),
--     (3, 25000, 30000, 40000, 15000, 60, 10),

--     (4, 20000, 25000, 35000, 10000, 70, 10),
--     (5, 20000, 25000, 35000, 10000, 80, 10),

--     (6, 15000, 20000, 30000, 10000, 90, 10),

--     (7, 10000, 15000, 25000, 10000, 100, 10),
--     (8, 10000, 15000, 25000, 10000, 100, 10),
--     (9, 10000, 15000, 25000, 10000, 100, 10),
--     (10, 10000, 15000, 25000, 10000, 100, 10),

--     (11, 15000, 20000, 30000, 10000, 90, 10),

--     (12, 20000, 25000, 35000, 10000, 80, 10),
--     (13, 20000, 25000, 35000, 10000, 70, 10),

--     (14, 25000, 30000, 40000, 15000, 60, 10),
--     (15, 25000, 30000, 40000, 15000, 20, 100),
--     (16, 25000, 30000, 40000, 15000, 10, 100),

--     (21, 25000, 30000, 40000, 15000, 10, 100),
--     (22, 25000, 30000, 40000, 15000, 20, 100),
--     (23, 25000, 30000, 40000, 15000, 60, 90),

--     (24, 20000, 25000, 35000, 10000, 70, 80),
--     (25, 20000, 25000, 35000, 10000, 80, 70),

--     (26, 15000, 20000, 30000, 10000, 90, 60),

--     (27, 10000, 15000, 25000, 10000, 100, 20),
--     (28, 10000, 15000, 25000, 10000, 100, 10),
--     (29, 10000, 15000, 25000, 10000, 100, 10),
--     (30, 10000, 15000, 25000, 10000, 100, 20),

--     (31, 15000, 20000, 30000, 10000, 90, 60),

--     (32, 20000, 25000, 35000, 10000, 80, 70),
--     (33, 20000, 25000, 35000, 10000, 70, 80),
    
--     (34, 25000, 30000, 40000, 15000, 60, 90),
--     (35, 25000, 30000, 40000, 15000, 20, 100),
--     (36, 25000, 30000, 40000, 15000, 10, 100);

CREATE TABLE etat(
    id_etat INTEGER PRIMARY KEY,
    etat VARCHAR(255),
    couleur VARCHAR(255)
);

INSERT INTO etat VALUES
    (0, 'Banga', 'gray'),
    (1, 'Simba be', 'red'),
    (2, 'Simba be', 'red'),
    (3, 'Simba be', 'red'),
    (4, 'Simba', 'orange'),
    (5, 'Simba', 'orange'),
    (6, 'Simba', 'orange'),
    (7, 'Simba', 'orange'),
    (8, 'Diovina fotsiny', 'yellow'),
    (9, 'Diovina fotsiny', 'yellow'),
    (10, 'Ao Tsara', 'none');

CREATE TABLE dentition(
    id_dentition SERIAL PRIMARY KEY,
    id_personne INTEGER REFERENCES personne(id_personne) NOT NULL,
    id_dent INTEGER REFERENCES dent(id_dent),
    etat INTEGER REFERENCES etat(id_etat) NOT NULL
);

INSERT INTO dentition(id_personne, id_dent, etat) VALUES
    (1, 1, 10),
    (1, 2, 10),
    (1, 3, 10),
    (1, 4, 10),
    (1, 5, 5),
    (1, 6, 10),
    (1, 7, 10),
    (1, 8, 10),
    (1, 9, 10),
    (1, 10, 10),
    (1, 11, 5),
    (1, 12, 10),
    (1, 13, 10),
    (1, 14, 10),
    (1, 15, 10),
    (1, 16, 5),
    (1, 21, 10),
    (1, 22, 10),
    (1, 23, 5),
    (1, 24, 10),
    (1, 25, 10),
    (1, 26, 10),
    (1, 27, 5),
    (1, 28, 10),
    (1, 29, 0),
    (1, 30, 10),
    (1, 31, 10),
    (1, 32, 10),
    (1, 33, 10),
    (1, 34, 10),
    (1, 35, 10),
    (1, 36, 10);


INSERT INTO dentition(id_personne, id_dent, etat) VALUES
    (2, 1, 10),
    (2, 2, 10),
    (2, 3, 10),
    (2, 4, 10),
    (2, 5, 10),
    (2, 6, 5),
    (2, 7, 5),
    (2, 8, 5),
    (2, 9, 0),
    (2, 10, 10),
    (2, 11, 5),
    (2, 12, 10),
    (2, 13, 10),
    (2, 14, 10),
    (2, 15, 10),
    (2, 16, 5),
    (2, 21, 10),
    (2, 22, 10),
    (2, 23, 5),
    (2, 24, 10),
    (2, 25, 10),
    (2, 26, 10),
    (2, 27, 5),
    (2, 28, 10),
    (2, 29, 10),
    (2, 30, 10),
    (2, 31, 10),
    (2, 32, 10),
    (2, 33, 10),
    (2, 34, 10),
    (2, 35, 10),
    (2, 36, 10);


INSERT INTO dentition(id_personne, id_dent, etat) VALUES
    (3, 1, 10),
    (3, 2, 10),
    (3, 3, 10),
    (3, 4, 10),
    (3, 5, 10),
    (3, 6, 10),
    (3, 7, 10),
    (3, 8, 10),
    (3, 9, 10),
    (3, 10, 10),
    (3, 11, 10),
    (3, 12, 10),
    (3, 13, 10),
    (3, 14, 10),
    (3, 15, 10),
    (3, 16, 5),
    (3, 21, 5),
    (3, 22, 5),
    (3, 23, 5),
    (3, 24, 10),
    (3, 25, 10),
    (3, 26, 10),
    (3, 27, 5),
    (3, 28, 10),
    (3, 29, 5),
    (3, 30, 10),
    (3, 31, 10),
    (3, 32, 10),
    (3, 33, 10),
    (3, 34, 10),
    (3, 35, 10),
    (3, 36, 10);


INSERT INTO dentition(id_personne, id_dent, etat) VALUES
    (4, 1, 0),
    (4, 2, 0),
    (4, 3, 10),
    (4, 4, 10),
    (4, 5, 5),
    (4, 6, 10),
    (4, 7, 10),
    (4, 8, 10),
    (4, 9, 10),
    (4, 10, 10),
    (4, 11, 5),
    (4, 12, 10),
    (4, 13, 10),
    (4, 14, 10),
    (4, 15, 10),
    (4, 16, 5),
    (4, 21, 10),
    (4, 22, 10),
    (4, 23, 5),
    (4, 24, 10),
    (4, 25, 10),
    (4, 26, 10),
    (4, 27, 5),
    (4, 28, 10),
    (4, 29, 0),
    (4, 30, 10),
    (4, 31, 10),
    (4, 32, 10),
    (4, 33, 10),
    (4, 34, 10),
    (4, 35, 0),
    (4, 36, 0);


        

CREATE VIEW v_dentition AS
SELECT 
        d.id_dentition,
        p.id_personne,
        p.nom,
        p.prenom,
        d.id_dent,
        e.id_etat,
        e.etat,
        e.couleur,
        c.traitement,
        c.enlevement,
        c.remplacement,
        c.nettoyage,
        c.prior_beaute,
        c.prior_sante
    FROM dentition d
    JOIN personne p ON d.id_personne = p.id_personne
    JOIN etat e ON d.etat = e.id_etat
    JOIN cout c ON d.id_dent = c.id_dent;



--SELECT * FROM v_dentition WHERE id_personne=4 AND id_etat!=100 AND ((traitement<=100000 AND id_etat != 0) OR remplacement <= 100000) ORDER BY prior_beaute DESC;

0       banga:          remplacement
1-3     tsy reparable:  enlevement + remplacement
4-7     reparable:      traitement
8-9     maloto:         nettoyage
10      parfait
















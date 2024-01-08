
DROP TABLE pk_rn;
DROP TABLE cout_rn;
DROP TABLE rn;

CREATE TABLE rn(
    rn VARCHAR(15) PRIMARY KEY,
    designation VARCHAR(255),
    nb_pk INTEGER
);

CREATE TABLE cout_rn(
    id_cout SERIAL PRIMARY KEY,
    rn VARCHAR(15) REFERENCES rn(rn),
    enlevement FLOAT,
    remplacement FLOAT,
    traitement FLOAT,
    nettoyage FLOAT
);

CREATE TABLE pk_rn(
    id_pk_rn SERIAL PRIMARY KEY,
    rn VARCHAR(15) REFERENCES rn(rn),
    pk INTEGER,
    etat INTEGER DEFAULT 10,
    priorite integer
);


CREATE VIEW v_pk_rn AS
SELECT
        prn.id_pk_rn,
        rn.designation,
        prn.rn,
        prn.pk,
        prn.etat,
        prn.priorite,
        crn.enlevement,
        crn.remplacement,
        crn.traitement,
        crn.nettoyage
    FROM pk_rn prn
    JOIN cout_rn crn ON prn.rn = crn.rn
    JOIN rn ON prn.rn = rn.rn
    ORDER BY id_pk_rn;


-- UPDATE pk_rn SET etat='' WHERE 1<=pk AND pk<=10 AND rn='RN1';

UPDATE cout_rn SET enlevement=1000, remplacement=1100, traitement=1200, nettoyage=1300 WHERE id_cout != '-1';









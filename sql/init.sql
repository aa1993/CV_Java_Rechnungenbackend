GRANT ALL PRIVILEGES ON *.* TO 'springuser';

CREATE DATABASE IF NOT EXISTS Rechnungen;
CREATE USER IF NOT EXISTS 'springuser'@'%' IDENTIFIED BY 'test123';
GRANT ALL PRIVILEGES ON Rechnungen.* TO 'springuser'@'%';
FLUSH PRIVILEGES;

USE Rechnungen;

CREATE TABLE Kunde (
  kundennummer int(8) NOT NULL AUTO_INCREMENT,
  vorname char(60) NOT NULL,
  nachname char(60) NOT NULL,
  strasse char(40) NOT NULL,
  hausnummer int(11) NOT NULL,
  plz int(11) NOT NULL,
  ort char(40) NOT NULL,
  PRIMARY KEY (kundennummer)
);

CREATE TABLE Rechnung (
  rechnungsnummer int(8) NOT NULL AUTO_INCREMENT,
  kundennummer int(8) NOT NULL ,
  rechnungsdatum date NOT NULL,
  bezahlt ENUM('bezahlt', 'unbezahlt'),
  PRIMARY KEY (rechnungsnummer),
  FOREIGN KEY (kundennummer) REFERENCES Kunde(kundennummer)
);

CREATE TABLE Produkt(
  artikelnummer int(8) NOT NULL AUTO_INCREMENT,
  produktname char(60) NOT NULL,
  preis double NOT NULL,
  PRIMARY KEY (artikelnummer)
);

CREATE TABLE enthaelt (
  rechnungsnummer int(8) NOT NULL,
  artikelnummer int(8) NOT NULL,
  anzahl int(11) NOT NULL,
  PRIMARY KEY (rechnungsnummer,artikelnummer),
  KEY rechnungsnummer (rechnungsnummer),
  KEY artikelnummer (artikelnummer),
  FOREIGN KEY (rechnungsnummer) REFERENCES Rechnung(rechnungsnummer),
  FOREIGN KEY (artikelnummer) REFERENCES Produkt(artikelnummer)
);


INSERT INTO Kunde(vorname, nachname, strasse, hausnummer, plz, ort) values
('Andreas', 'Metzger', 'Krementzstr.', 5, 50931, 'Köln'),
('Sandra', 'Schmidt', 'Ludwigsburger Str.', 21, 50739, 'Köln'),
('Christian', 'Ebersbacher', 'Thorwaldsenstr.', 12, 51103, 'Köln'),
('Brigitte', 'Theiss', 'Zehntstr.', 6, 51065, 'Köln'),
('Daniela', 'Beich', 'Sigwinstr.', 158, 51061, 'Köln'),
('Stefan', 'Hahn', 'Wilhelm-Schreiber-Str.', 46, 50827, 'Köln');

INSERT INTO Produkt(produktname, preis) values
('Mehl', 2.39),
('Milch', 0.99),
('Eier 10er', 1.69),
('Butter', 2.15),
('Zucker', 1.39),
('Salz', 1.9),
('Paprikapulver', 1.99),
('Pfeffer', 2.49),
('Sahne', 1.2),
('Tomaten', 2.59),
('Gurken', 1.35),
('Eisbergsalat', 1.69),
('Zwiebel', 1.59),
('Kartoffel', 1.8),
('Apfel', 3.49),
('Birnen', 2.69),
('Bananen', 1.35),
('Wasser', 1.09),
('Bleistift', 0.79),
('Radiergummi', 1.03),
('Kugelschreiber', 1.99),
('Heft', 0.26);

INSERT INTO Rechnung(kundennummer, rechnungsdatum, bezahlt) values
(1, '2023-10-01', 'unbezahlt'),
(3, '2023-10-03', 'unbezahlt'),
(4, '2023-10-03', 'unbezahlt'),
(6, '2023-10-05', 'unbezahlt'),
(2, '2023-10-10', 'unbezahlt'),
(1, '2023-10-13', 'unbezahlt'),
(5, '2023-10-13', 'unbezahlt'),
(4, '2023-10-20', 'unbezahlt'),
(2, '2023-10-25', 'unbezahlt'),
(5, '2023-10-27', 'unbezahlt'),
(4, '2023-10-30', 'unbezahlt');

INSERT INTO enthaelt(rechnungsnummer, artikelnummer, anzahl) values
(1,1,2),
(1,2,4),
(1,3,1),
(1,4,3),
(1,5,1),
(1,6,1),
(1,7,1),
(1,8,1),
(1,18,2),
(6,19,4),
(6,20,2),
(6,21,2),
(6,22,3),
(5,10,3),
(5,11,4),
(5,12,6),
(5,13,7),
(5,18,5),
(9,1,4),
(9,2,4),
(9,3,2),
(9,4,3),
(9,5,1),
(9,6,1),
(9,7,1),
(9,8,1),
(9,9,3),
(9,10,2),
(9,11,4),
(9,12,2),
(9,13,2),
(9,14,3),
(9,15,3),
(9,16,1),
(9,17,2),
(9,18,6),
(2,1,1),
(2,4,4),
(2,5,3),
(2,6,2),
(3,6,1),
(3,10,1),
(3,11,2),
(3,12,1),
(3,13,1),
(3,14,1),
(3,17,5),
(3,18,3),
(8,1,3),
(8,2,2),
(8,14,2),
(11,3,5),
(11,8,3),
(11,11,2),
(11,13,1),
(11,15,4),
(7,3,2),
(7,4,4),
(10,1,5),
(10,6,6),
(10,10,7),
(10,13,8),
(10,19,1),
(10,21,2),
(4,1,3),
(4,2,4),
(4,3,2),
(4,4,3),
(4,5,2),
(4,6,1),
(4,9,2),
(4,15,3);

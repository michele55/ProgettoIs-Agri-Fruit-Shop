DROP DATABASE IF EXISTS azienda1;
CREATE DATABASE azienda1;

DROP USER IF EXISTS 'tsw'@'localhost';
CREATE USER 'tsw'@'localhost' IDENTIFIED BY 'adminadmin';
GRANT ALL ON azienda1.* TO 'tsw'@'localhost';
USE azienda1;

DROP TABLE IF EXISTS azienda;
CREATE TABLE azienda (
  nome           varchar(20)    not NULL,
  citta           varchar(20)    not NULL,
  numdipendenti  int            not NULL,
  PIVA           varchar(16)    not NULL,
  primary key (PIVA)
);

DROP TABLE IF EXISTS  dipendenti;








DROP TABLE IF EXISTS ruolo;


DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria (
categ varchar(15) not null,
primary key(categ)
);

DROP TABLE IF EXISTS utente;
CREATE TABLE utente (
  nome    varchar(50)  not NULL,
  cognome varchar(50) not NULL,
  indirizzo varchar(30)          not NULL,
  citta varchar(50) not NULL,
  provincia varchar(50) not NULL,
  ncivico int(4) not null,
  cap int(5) not null,
  codice_fiscale      varchar(16)           not NULL,
  email    varchar(35)  not NULL,
  pwd       varchar(255)   not NULL,
  ruolo		varchar(255) not NULL,
   
  primary key (codice_fiscale)
 
);

DROP TABLE IF EXISTS amministratore;
CREATE TABLE amministratore (
 nome      varchar(35) not NULL,
 cognome varchar (35) not NULL,
  email    varchar(35)  not NULL,
  pwd       varchar(255)   not NULL,
  ruolo		varchar(255) not NULL,
   
  primary key (email)
 
);
DROP TABLE IF EXISTS ordine;
CREATE TABLE ordine (
numero   int   not NULL AUTO_INCREMENT ,
codice_fiscale    varchar(16) not NULL,
totale         double not NULL,
stato         varchar(35) not NULL,
 primary key (numero),
 
 foreign key (codice_fiscale) references utente(codice_fiscale)
 ON DELETE CASCADE
);

DROP TABLE IF EXISTS prodotto;
CREATE TABLE prodotto (
 prezzo      float         not NULL,
 nomep        varchar(10) not NULL,
 SSN         varchar(9)     not NULL,
 disponibilità int(5)   not NULL,
 descrizione varchar(50) not NULL,
 categ varchar(10) not null,
 idfoto varchar(30) not null,
  primary key (SSN),
  foreign key (categ) references categoria(categ)
  ON delete cascade
);

DROP TABLE IF EXISTS composto;
CREATE TABLE composto (
quantita int not null,
SSN      varchar(9) not NULL,
numero   int not NULL,
foreign key (SSN) references prodotto(SSN),
foreign key (numero) references ordine(numero)
ON delete cascade
);


 


DROP TABLE IF EXISTS spedizione;
CREATE TABLE spedizione (
 ID           int     not NULL auto_increment,
 numero   int not NULL,
 modalitaspedizione varchar(15) not null,
 costospedizione int not null,
 citta varchar(50) not null,
 provincia varchar(50) not null,
 cap int(5) not null,
  via varchar(50) not null,
  civico int(5) not null,
 primary key (ID),
  foreign key (numero) references ordine(numero)
);

DROP TABLE IF EXISTS pagamento;
CREATE TABLE pagamento (
 ID           int     not NULL auto_increment,
 num_pag      int  not NULL,
 modalitapagamento varchar(15) not null,
 primary key (ID),
 foreign key (num_pag) references spedizione(ID)
 );

DROP TABLE IF EXISTS fattura;
CREATE TABLE fattura (
 data        date     not NULL,
num_pag     int    not NULL,
numero      int auto_increment     not NULL,
primary key (numero),
foreign key (num_pag) references pagamento(num_pag)
);

INSERT INTO azienda VALUES
('Azienda&co','Napoli',1000,'IT12359971632');
INSERT INTO categoria VALUES
('ortaggi');
INSERT INTO categoria VALUES
('frutta');
INSERT INTO categoria VALUES
('FruttaSecca');
INSERT INTO categoria VALUES
('vino');
INSERT INTO categoria VALUES
('olio');
INSERT INTO categoria VALUES
('semi');
INSERT INTO categoria VALUES
('verdura');





INSERT INTO utente VALUES
('Michele','Russo','via lambiase','Calitri','Avellino','44','84013','RSSNNM00b19A509k','alex@gmail.com',sha1('cavese12'),'Utente');
INSERT INTO amministratore VALUES
('Mario','Rossi','amm1mario@gmail.com',sha1('admin'),'Amministratore');
















INSERT INTO prodotto VALUES
(3,'pomodoro',654008935,10,'pomodorino giallo','ortaggi','pomodorinogiallo');
INSERT INTO prodotto VALUES
(1,'patata',125987635,5,'patate novelle','ortaggi','patate');
INSERT INTO prodotto VALUES
(3,'melanzane',539512508,100,'melanzana cima di viola','ortaggi','melanzana');
INSERT INTO prodotto VALUES
(2,'lattuga',147963258,20,'lattuga iceberg','ortaggi','lattuga');
INSERT INTO prodotto VALUES
(4,'uva',159638257,33,'uva armonera del Cilento','frutta','uva');
INSERT INTO prodotto VALUES
(2,'Lenticchie',159638267,50,'Lenticchie Bio','semi','lenticchie');







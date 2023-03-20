drop database if exists orange_event_lm_23; 
create database orange_event_lm_23; 
use orange_event_lm_23; 

create table client (
	idclient int (3) not null auto_increment,
	nom varchar(50), 
	prenom varchar(50), 
	email varchar(50), 
	adresse varchar(50), 
	tel varchar(20), 
	primary key (idclient)
);
create table technicien (
	idtechnicien int (3) not null auto_increment,
	nom varchar(50), 
	prenom varchar(50), 
	email varchar(50),
	mdp varchar(50), 
	qualification varchar(100), 
	tel varchar(20), 
	primary key (idtechnicien)
);
create table intervention (
	idinter int(3) not null auto_increment, 
	description text, 
	dateinter date, 
	prix float(5.2), 
	idclient int(3) not null, 
	idtechnicien int(3) not null,
	primary key (idinter), 
	foreign key (idclient) references client(idclient), 
	foreign key (idtechnicien) references technicien(idtechnicien)
); 

insert into technicien values 
(null, "Clara", "Neal","a@gmail.com", "123", "technicien", 
	"345678"); 



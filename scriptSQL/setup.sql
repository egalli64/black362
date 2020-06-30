
use black362;


-- cleanup and control if tables exist   
drop table if exists dishList;
drop table if exists dishes;
drop table if exists bookings;
drop table if exists users;
drop table if exists admins;


drop table if exists address;


create table users(
	user_id integer primary key auto_increment,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	birth_date date,
	email varchar(50) unique,
	telephone varchar(30), 
	username varchar(35) not null,
	password varchar(35) not null,
	city varchar(35),
	address varchar(30),
	postcode varchar(5)
);


create table admins(
	admin_id integer primary key auto_increment,
	username varchar(30) not null,
	password varchar(30) not null
);

create table bookings(
	booking_id integer primary key auto_increment,
	user_id  integer,
	status varchar(30),
	foreign key(user_id) references users (user_id)
);


create table dishes(
	dish_id integer primary key auto_increment,
	name varchar(50),
	prices decimal(5,2), 
	description varchar(500)
);

create table dishList(
	dishList_id integer primary key auto_increment,
	booking_id integer,
    dish_id integer,
	number_dish integer,
    foreign key(dish_id) references dishes (dish_id),
    foreign key(booking_id) references bookings (booking_id)
);
commit;




-- insert users
insert into users(first_name,last_name,birth_date,email,telephone,username,password,city,address,postcode) 
values ('Giuseppe','Conti',str_to_date('11-01-2000','%d-%m-%Y'),'Giuseppe99@hotmail.com','3229856956','GiuGiup','1234Giuseppe','Milano','Viale Lodovico Scarampo','20149');

insert into users(first_name,last_name,birth_date,email,telephone,username,password,city,address,postcode) 
values ('Francesco','Russo',str_to_date('03-11-1999','%d-%m-%Y'),'russoFra123.@hotmail.com','29856956','WinRuss','09451opq','Milano','Via Monte Rosa 91','20149');

insert into users(first_name,last_name,birth_date,email,telephone,username,password,city,address,postcode) 
values ('Federica','Testa',str_to_date('11-11-1999','%d-%m-%Y'),'Fede.red@yahoo.com','090192956','Fedeee','1234AAA','Milano','Via Breguzzo 2','20148');

insert into users(first_name,last_name,birth_date,email,telephone,username,password,city,address,postcode) 
values ('Claudia','Sacco',str_to_date('07-06-1984','%d-%m-%Y'),'Claudia.Sacco@gmail.com','3112984356','ClauuDia','live234599','Milano','Via Roma 41','20021');

insert into users(first_name,last_name,birth_date,email,telephone,username,password,city,address,postcode) 
values ('Luciano','Russo',str_to_date('13-09-1990','%d-%m-%Y'),'lucianoluciano.@hotmail.com','3111855579','luciaSalva','genovaApp','Genova','Via Prà 21','20149');

insert into users(first_name,last_name,birth_date,email,telephone,username,password,city,address,postcode) 
values ('Alessandra','Moro',str_to_date('21-08-1999','%d-%m-%Y'),'Ale-Moroo@yahoo.com','053092356','Aleyaya','ciaoTuvia12','Milano','Via Lampedusa 1','20141');

insert into users(first_name,last_name,birth_date,email,telephone,username,password,city,address,postcode) 
values ('Ilaria','De Luca',str_to_date('15-02-1996','%d-%m-%Y'),'IlariaSun@outlook.it','3124296881','sunSerra','ilailaila','Milano','Via Giacomo Antonini 13','20141');

insert into users(first_name,last_name,birth_date,email,telephone,username,password,city,address,postcode) 
values ('Guido','Grosso',str_to_date('25-05-1982','%d-%m-%Y'),'Giudo.GG@outlook.it','3337292118','FerrariF8','spider11','Milano','Via Virgilio Ferrari 121','20141');

insert into users(first_name,last_name,birth_date,email,telephone,username,password,city,address,postcode) 
values ('Mirko','Borgo',str_to_date('13-05-1998','%d-%m-%Y'),'MirkoB@outlook.it','3324593331','123456','123456','Milano','Via Europa 19','20141');

-- insert dishes
insert into dishes(name,prices,description) 
values ('Lasagne alla Bolognese','10.50','piatto tipico della gastronomia dell’Emilia Romagna, ingredienti fondamentali: pasta fresca all’uovo verde, ragù, manzo e di maiale e parmigiano grattugiato');

insert into dishes(name,prices,description) 
values ('tortellini','8',"I tortellini sono una pasta all'uovo ripiena, tipica di Bologna e di Modena");

insert into dishes(name,prices,description) 
values ('spaghetti alla carbonara','9',"preparato con ingredienti popolari e dal gusto intenso");

insert into dishes(name,prices,description) 
values ('tagliatelle al ragù','9',"la pasta all'uovo tipica del centro e nord Italia");

insert into dishes(name,prices,description) 
values ('crescentine','6',"Pasta lievitata e fritta");

insert into dishes(name,prices,description) 
values ('Cotoletta alla bolognese','9',"piatto molto saporito con una base di carrè di vitello impanato e guarnito con prosciutto crudo e formaggio grattugiato");
insert into dishes(name,prices,description) 
values ('polpette alla bolognese','8.60',"Le polpette contengono carne macinata, mortadella, uova e parmigiano");
insert into dishes(name,prices,description) 
values ('Friggione','4.00',"salsa a base di cipolle bianche e pomodori pelati");
insert into dishes(name,prices,description) 
values ('galantina','9.00',"insaccato a base di carne di pollo, arricchita di verdure, aromi e spezie, impastata con le uova e cotta nel brodo");
insert into dishes(name,prices,description) 
values ('torta di riso','6.00',"dolce più famoso della tradizione bolognese, a base riso e latte dalla consistenza morbidissima che si scioglie in bocca");
insert into dishes(name,prices,description) 
values ('risotto ai funghi','10.00',"il risotto a base di di funghi porcini, ricco di sapore e di una cremosità incredibile");
-- insert admins
insert into admins(username,password) 
values ('123456','123456');
insert into admins(username,password) 
values ('username','password');
-- insert bookings 
insert into bookings(user_id,status) values ('1','ordine concluso');
insert into bookings(user_id,status) values ('2','in preparazione');
insert into bookings(user_id,status) values ('2','ordine concluso');
insert into bookings(user_id,status) values ('4','in consegna');
insert into bookings(user_id,status) values ('5','in consegna');

-- insert dishList
insert into dishList(booking_id,dish_id,number_dish) values ('1','2','1');
insert into dishList(booking_id,dish_id,number_dish) values ('1','5','1');
insert into dishList(booking_id,dish_id,number_dish) values ('1','3','2');
insert into dishList(booking_id,dish_id,number_dish) values ('2','6','1');
insert into dishList(booking_id,dish_id,number_dish) values ('2','5','1');
insert into dishList(booking_id,dish_id,number_dish) values ('2','1','1');
insert into dishList(booking_id,dish_id,number_dish) values ('2','3','1');
insert into dishList(booking_id,dish_id,number_dish) values ('3','1','1');
insert into dishList(booking_id,dish_id,number_dish) values ('3','6','1');
insert into dishList(booking_id,dish_id,number_dish) values ('3','4','2');
insert into dishList(booking_id,dish_id,number_dish) values ('3','9','1');

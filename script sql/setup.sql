use restaurant;

-- cleanup
drop table if exists users;
drop table if exists admins;
drop table if exists bookings;
drop table if exists dishes;
drop table if exists address;


create table users(
	user_id integer primary key auto_increment,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	birth_date date,
	email varchar(50) unique,
	telephone int(30), 
	username varchar(35),
	password varchar(35),
	city varchar(35),
	address varchar(30),
	postcode integer
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
	dishList text,
	foreign key(user_id) references users (user_id)
);

create table dishes(
	dish_id integer primary key auto_increment,
	name varchar(30),
	prices double,
	description text
);
commit
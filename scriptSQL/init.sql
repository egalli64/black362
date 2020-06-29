
drop schema if exists restaurant;
drop user if exists restaurant;
create user restaurant identified by '12345678';
create schema restaurant;

--  run it with all privileges 
grant all privileges on restaurant.* to restaurant;
grant alter routine on restaurant.* to restaurant;



drop schema if exists black362;
drop user if exists black362;

create user black362 identified by 'password';
create schema black362;

--  run it with all privileges 
grant all privileges on black362.* to black362;
grant alter routine on black362.* to black362;


CREATE TABLE Event (
	id serial PRIMARY KEY,
	name varchar(30),
	date_time timestamptz,
	location varchar(50)
);


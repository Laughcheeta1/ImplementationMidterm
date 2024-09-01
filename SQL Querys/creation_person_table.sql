CREATE TABLE Person (
	id varchar(10) PRIMARY KEY,
	name varchar(30),
	cellphone varchar(10),
	role smallint references Role(id) ON DELETE SET NULL
)
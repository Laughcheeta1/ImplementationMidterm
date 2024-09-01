CREATE TABLE Role (
	id smallint GENERATED ALWAYS AS IDENTITY (INCREMENT 1 START 1) PRIMARY KEY,
	name varchar(10)
);

CREATE TABLE Category (
	id smallint GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1) PRIMARY KEY,
	name varchar(15)
);

CREATE TABLE Person (
	id varchar(10) PRIMARY KEY,
	name varchar(30),
	cellphone varchar(10),
	role smallint references Role(id) ON DELETE SET NULL
);


CREATE TABLE Media(
	id bigint GENERATED ALWAYS AS IDENTITY (INCREMENT 1 START 1) PRIMARY KEY,
	url varchar(100),
	media_type char(1)
);

CREATE TABLE Event (
	id int GENERATED ALWAYS AS IDENTITY (INCREMENT 1 START 1) PRIMARY KEY,
	name varchar(30),
	date_time timestamptz,
	location varchar(50)
);

CREATE TABLE Ticket_Type (
	event_id int REFERENCES Event(id) ON DELETE CASCADE,
	ticket_type_id smallint,
	name varchar(15),
	price int, 
	total_ticket_quantity int, 
	number_remaining int,
	PRIMARY KEY(event_id, ticket_type_id)
);

CREATE TABLE Participant_Portfolio (
	participant_id varchar(10) PRIMARY KEY REFERENCES Person(id) ON DELETE CASCADE,
	biography text,
	about text,
	web_page varchar(100)
);

CREATE TABLE Participant_Event (
	person_id varchar(10) REFERENCES Person(id) ON DELETE CASCADE,
	event_id int REFERENCES Event(id) ON DELETE CASCADE,
	participant_number int,
	PRIMARY KEY (person_id, event_id)
);

CREATE TABLE Organizer_Event (
	person_id varchar(10) REFERENCES Person(id) ON DELETE CASCADE,
	event_id int REFERENCES Event(id) ON DELETE CASCADE,
	PRIMARY KEY (person_id, event_id)
);

CREATE TABLE Media_In_Portfolio (
	participant_id varchar(10) REFERENCES Person(id) ON DELETE CASCADE,
	media_id bigint REFERENCES Media(id) ON DELETE CASCADE,
	date_of_media date,
	description text,
	PRIMARY KEY(participant_id, media_id)
);

CREATE TABLE Event_Media (
	event int REFERENCES Event(id) ON DELETE CASCADE,
	media_id bigint REFERENCES Media(id) ON DELETE CASCADE,
	part_of_show varchar(20),
	highlighted bool,
	PRIMARY KEY(event, media_id)
);

CREATE TABLE Category_Participant (
	id_category smallint REFERENCES Category(id) ON DELETE CASCADE,
	id_participant varchar(10) REFERENCES Person(id) ON DELETE CASCADE,
	PRIMARY KEY(id_category, id_participant)
	
);

CREATE TABLE Attendee_Event (
	person_id varchar(10) REFERENCES Person(id) ON DELETE CASCADE,
	event_id int REFERENCES Event(id) ON DELETE CASCADE,
	ticket_number int,
	ticket_type smallint,
	FOREIGN KEY (event_id, ticket_type) REFERENCES Ticket_Type(event_id, ticket_type_id) ON DELETE RESTRICT,
	PRIMARY KEY (person_id, event_id)
);

CREATE TABLE Active_Event (
event_id int PRIMARY KEY REFERENCES Event(id) ON DELETE CASCADE
);

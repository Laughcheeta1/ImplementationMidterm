CREATE TABLE Category_Participant (
	id_category smallint REFERENCES Category(id) ON DELETE CASCADE,
	id_participant varchar(10) REFERENCES Person(id) ON DELETE CASCADE,
	PRIMARY KEY(id_category, id_participant)
	
)
CREATE TABLE Event_Media (
	event int REFERENCES Event(id) ON DELETE CASCADE,
	media_id bigint REFERENCES Media(id) ON DELETE CASCADE,
	part_of_show varchar(20),
	highlighted bool,
	PRIMARY KEY(event, media_id)
)
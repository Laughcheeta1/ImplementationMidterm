CREATE TABLE Organizer_Event (
	person_id varchar(10) REFERENCES Person(id) ON DELETE CASCADE,
	event_id int REFERENCES Event(id) ON DELETE CASCADE,
	PRIMARY KEY (person_id, event_id)
)

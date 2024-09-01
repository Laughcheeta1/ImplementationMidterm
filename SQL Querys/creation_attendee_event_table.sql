CREATE TABLE Attendee_Event (
	person_id varchar(10) REFERENCES Person(id) ON DELETE CASCADE,
	event_id int REFERENCES Event(id) ON DELETE CASCADE,
	ticket_number int,
	ticket_type smallint,
	FOREIGN KEY (event_id, ticket_type) REFERENCES Ticket_Type(event_id, ticket_type_id) ON DELETE RESTRICT,
	PRIMARY KEY (person_id, event_id)
)
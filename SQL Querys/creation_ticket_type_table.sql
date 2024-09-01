CREATE TABLE Ticket_Type (
	event_id int REFERENCES Event(id) ON DELETE CASCADE,
	ticket_type_id smallint,
	name varchar(15),
	price int, 
	total_ticket_quantity int, 
	number_remaining int,
	PRIMARY KEY(event_id, ticket_type_id)
);
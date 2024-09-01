CREATE TABLE Participant_Portfolio (
	participant_id varchar(10) PRIMARY KEY REFERENCES Person(id) ON DELETE CASCADE,
	biography text,
	about text,
	web_page varchar(100)
)
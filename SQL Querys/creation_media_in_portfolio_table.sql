CREATE TABLE Media_In_Portfolio (
	participant_id varchar(10) REFERENCES Person(id) ON DELETE CASCADE,
	media_id bigint REFERENCES Media(id) ON DELETE CASCADE,
	date_of_media date,
	description text,
	PRIMARY KEY(participant_id, media_id)
)
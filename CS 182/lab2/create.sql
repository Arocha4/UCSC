/*
Antoine Rocha
arocha4@ucsc.edu
*/


DROP SCHEMA Lab2 CASCADE;
CREATE SCHEMA Lab2;


CREATE TABLE ChirpUsers (
	userID INT NOT NULL,
	userPassword CHAR(8) NOT NULL,
	userName VARCHAR(30),
	joinDate DATE,
	address VARCHAR(30),
	education CHAR(1),
	income DECIMAL(10,2),
	spouseID INT,
	active BOOLEAN,
	PRIMARY KEY(userID),
	UNIQUE (userName),
	UNIQUE (spouseID),
	UNIQUE (joinDate , address)
);

CREATE TABLE ChirpPosts (
	posterID INT NOT NULL,
	postNum INT NOT NULL,
	thePost VARCHAR(44) NOT NULL,
	censored BOOLEAN,
	postDate DATE,
	PRIMARY KEY(posterID, postNum)
);

CREATE TABLE ChirpFollowers (
	userID INT NOT NULL,
	followerID INT NOT NULL,
	followStartDate DATE,
	PRIMARY KEY(userID, followerID)
);

CREATE TABLE ChirpReads (
	posterID INT NOT NULL,
	postNum INT NOT NULL,
	postReader INT NOT NULL,
	timesRead INT,
	latestReadDate DATE,
	PRIMARY KEY(posterID, postNum, postReader)
);


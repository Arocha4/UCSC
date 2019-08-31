/**
 Antoine Rocha
 arocha4@ucsc.edu
 Lab1.sql
 cmps 182

**/
CREATE TABLE ChipUsers(

  userID                          INT PRIMARY KEY,
  
  userPassword                    CHAR(8),
  
  userName                        VARCHAR(30),

  joinDate                       Date,
 
  adress                       VARCHAR(30),

  education                  CHAR(1),

  income                    DECIMAL(8,2),

  spouseID                INT ,
  
  active                BOOLEAN

);



CREATE TABLE ChirpPost(

  posterID    INT,

  postNum     INT,

  thePos   VARCHAR(44),
  
  censored   BOOLEAN,

  postDate   DATE,

  PRIMARY KEY(posterID, postNum)

);


CREATE TABLE ChirpFollowers(

  userID      INT,

  followerID   INT,

  followerStartDate   DATE,

  PRIMARY KEY(userID, followerID)
);


CREATE TABLE ChirpReads(

  posterID   INT,

  postNum     INT,

  postReader  INT,

  timesRead    INT,

  lastestReadDate   DATE,

  PRIMARY KEY(posterID,postNum,postReader)

);


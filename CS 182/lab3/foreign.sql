/* Antoine Rocha
arocha4@ucsc.edu
 lab3
 foreign.sql 

a) The posterID field in ChirpPosts should reference the userID primary key in ChirpUsers.
b) The userD field in ChirpFollowers should reference the userID primary key in ChirpUsers.
c) The followerID field in ChirpFollowers should reference the userID primary key in ChirpUsers.



*/

ALTER TABLE ChirpPosts
ADD FOREIGN KEY (posterID) REFERENCES ChirpUsers(userID);

ALTER TABLE ChirpFollowers
ADD FOREIGN KEY (userID) REFERENCES ChirpUsers(userID);

ALTER TABLE ChirpFollowers
ADD FOREIGN KEY (followerID) REFERENCES ChirpUsers (userID);

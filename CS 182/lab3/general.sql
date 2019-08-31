/* Antoine Rocha
arocha4@ucsc.edu
lab3
 general.sql 


1. In ChirpReads, timesRead must be positive. Please give a name to this constraint when you create it. We
recommend that you use the name positive_reads, but you may use another name. (The other constraints don’t
need to have names.)
2. In ChirpUsers, userID and spouseID must not be the same.
3. In ChirpUsers, if joinDate is NULL, then active must also be NULL

*/

ALTER TABLE ChirpReads
ADD CONSTRAINT positive_reads
CHECK (timesRead > 0);

ALTER TABLE ChirpUsers
ADD CHECK (userID<>spouseID);

ALTER TABLE ChirpUsers
ADD CHECK ((joinDate IS NULL AND active IS NULL) OR joinDate IS NOT NULL);

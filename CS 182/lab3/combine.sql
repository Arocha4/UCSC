/* Antoine Rocha
arocha4@ucsc.edu
 lab3
 combine.sql 

Write a file, combine.sql (which may have multiple sql statements in it in a serializable transaction) that
will do the following. For each “new read” tuple t that’s in NewReads, either a) there isn’t a tuple in
ChirpReads that has the same primary key, or b)there is a tuple in ChirpReads with the same primary key


*/

/* If there is already a tuple in ChirpReads that has the same primary key, then update ChirpReads,
adding 1 to timesRead and setting latestReadDate to be the readDate in the NewReads tuple. (We’re
assuming that NewReads always have a later value for readDate.)*/


UPDATE ChirpReads CR
SET timesRead=timesRead+1, latestReadDate=NR.readDate
FROM NewReads NR	
WHERE CR.posterID = CR.posterID AND CR.postNum = NR.postNum
	 AND CR.postReader = NR.postReader;

/* If there isn’t already a tuple in ChirpReads that has the same primary key, then insert a tuple into the
ChirpReads table corresponding to that tuple in the NewReads table, with timesRead set to 1 and
latestReadDate set to the readDate in the NewReads tuple.*/

INSERT INTO ChirpReads(posterID, postNum, postReader, timesRead, latestReadDate)
	SELECT N.posterID, N.postNum, N.postReader, 1, N.readDate
	FROM NewReads N
	WHERE NOT EXISTS (
		SELECT *
		FROM ChirpReads CR
		WHERE CR.posterID=N.posterID AND CR.postNum=N.postNum
		AND CR.postReader=N.postReader);

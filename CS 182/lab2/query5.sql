/*
Antoine Rocha
arocha4@ucsc.edu
lab2
query5
If a row appears in ChirpsRead, then the postReader must have read the post (which is identified by
posterID and postNum) at least once. Find the userID and userName for every different user who has
read at least one post written by at least one of their followers.
*/



SELECT DISTINCT u.userID , u.userName
       FROM ChirpUsers u 
	WHERE u.userID  IN 
		(SELECT r.postReader
		  FROM ChirpReads r , ChirpFollowers f 
		   WHERE r.posterID = f.followerID AND r.timesRead > 0
	                   AND r.postReader = f.userID );
			
	 
		   

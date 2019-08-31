/*
Antoine Rocha
arocha4@ucsc.edu
lab2 
query 4

Find the name and address of Readers who have read posts written by a user whose name is 'Bill'. Your
result should not have any duplicates.


*/

SELECT DISTINCT r.userName , r.address 
FROM  ChirpUsers r

WHERE r.userID IN

	(SELECT PostReader 
	  FROM Chirpreads p, ChirpUsers B
	Where   p.posterID =  b.userID
		  And B.userName = 'Bill' AND p.timesRead >0);


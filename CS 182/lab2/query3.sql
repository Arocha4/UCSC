/*
Antoine Rocha
arocha4@ucsc.edu
lab2
query 3 

ChirpFollower tells you if user B follows user A. Sometimes user B follows user A and user A also follows
user B. Just using ChirpFollower, find pairs of userID's where B follows A and A also follows B. Yes, that
means that you'll have both A, B and B, A in your result. The two attributes in your result should be
called FirstUser and SecondUser.
*/

SELECT a.userID as FirstUser , b.userID as SecondUser 

FROM  ChirpFollowers a , ChirpFollowers b  

WHERE  a.userID= b.followerID AND a.followerID = b.userID ;
 

/*
Antoine Rocha
arocha4@ucsc.edu
lab2 
query2.sql
Output the uncensored posts made by active users whose income is more than 50000. Your result should
have the user's name and the post.

*/

SELECT u.username , p.thePost
FROM ChirpUsers u , ChirpPost p
WHERE u.income > 50000 AND u.active = true AND p.censored = false
	AND u.userID = p.posterID ;


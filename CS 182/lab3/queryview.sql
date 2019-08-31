
/*
Antoine Rocha
arocha4@ucsc.edu
queryview.sql


For users that have many followers, output that user’s userID, the date of that user’s earliest
post, the date of that user’s latest post, and that user’s numberOfFollowers (as it appears in
ManyFollowers). The attributes in your result should be called userID, earliestPostDate,
latestPostDate and numberOfFollowers.




Next, write commands that delete just the tuples with the following primary keys from the ChirpFollowers
table:
(120, 105)
(103, 111)
  */

SELECT userID, MIN(postDate) AS earlistPostDate, MAX(postDate) AS latestPostDate, numberOfFollowers
FROM ManyFollowers f, ChirpPosts p
WHERE f.userID = p.posterID
GROUP BY userID, numberOfFollowers;

/* After running this we got a result with 13 tuples */

DELETE FROM ChirpFollowers
WHERE userID=120 AND followerID=105;

DELETE FROM ChirpFollowers
WHERE userID=103 AND followerID=111;

/* Running this again after the two deletion statements
we got a result with 12 tuples */

/* Antoine Rocha
arocha4@ucsc.edu
createview.sql

Create a view named ManyFollowers. For each user in ChirpUsers, this view should provide userID and the
number of followers that the user has. Don’t count followers if their name is ‘Voldemort’ or ‘Malfoy’. In your
result, the second attribute should be called numberOfFollowers. But only include a tuple for a user if that user
has at least 3 followers (who aren’t named ‘Voldemort’ or ‘Malfoy’).

*/

CREATE VIEW ManyFollowers AS
SELECT u1.userID, COUNT(*) AS numberOfFollowers
FROM ChirpUsers u1, ChirpFollowers cf, ChirpUsers u2
WHERE u1.userID=cf.userID AND cf.followerID=u2.userID 
	AND u2.userName<>'Voldemort' AND u2.userName<>'Malfoy'
GROUP BY u1.userID
HAVING COUNT(cf.followerID)>=3;

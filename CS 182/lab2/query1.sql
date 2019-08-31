/*
Antoine Rocha
arocha4@ucsc.edu
Lan2
query1

Find all the users whose address has the string 'West' anywhere in their address. For each such user,
your result should include just the user's name and the date that the user joined. The result should
appear sorted by join date, with the most recent join date first and the least recent join date last. 
*/

SELECT userName, joinDate 

FROM ChirpUsers

WHERE address LIKE '%West%'

ORDER BY  joinDate DESC;


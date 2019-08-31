/* Antoine Rocha
arocha4@ucsc.edu
unittests.sql


For each of the 3 foreign key constraints specified in section 2.3, write one unit test:
o An INSERT command that violates the foreign key constraint (and elicits an error).
Also, for each of the 3 general constraints, write 2 unit tests:
o An UPDATE command that meets the constraint.
o An UPDATE command that violates the constraint (and elicits an error).

 */


/* these should violate the constraints*/
	INSERT INTO ChirpPosts(posterID, postNum)
	VALUES (NULL, 41);

	INSERT INTO ChirpFollowers(userID)
	VALUES (9000000);
	
	INSERT INTO ChirpFollowers(followerID)
	VALUES (1212131);


	UPDATE ChirpReads /* meets constraint */
	SET timesRead = 10;

	UPDATE ChirpReads /* violates */
	SET timesRead = -122;

	UPDATE ChirpUsers /* meets constraint */
	SET userID = 2, spouseID = 1;

	UPDATE ChirpUsers /* violates */
	SET userID = 33, spouseID = 33;

	UPDATE ChirpUsers /* meets constraint */
	SET joinDate = NULL, active = NULL;

	UPDATE ChirpUsers /* violates */
	SET joinDate = NULL, active = TRUE;

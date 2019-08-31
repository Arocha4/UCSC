/* arocha4 Arocha4@ucsc.edu purgeBadFunction.pgsql lab4 */

	CREATE OR REPLACE FUNCTION pugeBadFunction (censorLimit Integer)
	RETURNS Integer
	AS $$

	DECLARE
		result Integer;
	BEGIN
	
	
	
	
	
		CREATE VIEW num_censored_users AS
		SELECT userID, count(*) AS number_consored
		FROM ChirpUsers , ChirpPosts
		WHERE userID = posterID AND number_consored = TRUE
		GROUP BY userID;

	
	
	
	
	
	
		SELECT count(userID)
		INTO result
		FROM num_censored_users:wq
		WHERE num_censored_users.number_consored > censorLimit
		GROUP BY userID;

	
	
	
	
	
	
	
		IF num_censored_users.number_consored > censorLimit THEN
			DELETE FROM ChirpUsers u
			WHERE u.userID = num_censored_users.userID;
			UPDATE ChirpUsers
			SET spouseID = NULL
			WHERE spouseID = num_censored_users.userID;
			DELETE FROM ChirpPosts
			WHERE posterID = num_censored_users.userID;
			DELETE FROM ChirpFollowers F
			WHERE  F.userID = num_censored_users.userID OR followerID = num_censored_users.userID;
		
		
		RETURN result;
		END IF;
		END;
		$$ LANGUAGE plpgsql;

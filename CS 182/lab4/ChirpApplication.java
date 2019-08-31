import java.sql.*;
import java.util.*;

/**
 * The class implements methods of the ChirpBase database interface.
 *
 * All methods of the class receive a Connection object through which all
 * communication to the database should be performed. Note: the
 * Connection object should not be closed by any method.
 *
 * Also, no method should throw any exceptions. In particular, in case
 * an error occurs in the database, then the method should print an
 * error message and call System.exit(-1);
 */

public class ChirpApplication {

    private Connection connection;

    /*
     * Constructor
     */
    public ChirpApplication(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection()
    {
        return connection;
    }

    /**
     * Takes as argument a string called theAddress.
     * Returns the userID for each tuple in ChirpUsers
     * whose address attribute value is theAddress.
     */

    public List<Integer> getUsersByAddress(String theAddress)
    {
        List<Integer> result = new ArrayList<Integer>();
        // your code here
	
	String query="SELECT userID FROM ChirpUsers U WHERE U.address = ?";
	try{
		PreparedStatement stm1 = connection.prepareStatement(query);
		stm1.setString (1, theAddress);
		ResultSet results = stm1.executeQuery();
		while(results.next()){
		result.add(results.getInt(1));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
        // end of your code
        return result;
    }


    /**
     * The ChirpUsers table has a Boolean attribute called active.  We’ll say that a
     * user is active if the value of active is TRUE, and we’ll say that a user is inactive
     * if that attribute is FALSE.  There may be some active users who haven’t made any posts
     * after December 31, 2016.  Update the ChirpUsers rows for these users so that they
     * become inactive.  (Don’t update rows of users that were already inactive.)
     * makeUsersInactive should return the number of users who were made inactive by your update.
     */
    
    public int makeUsersInactive() {
        // your code here; return 0 appears for now to allow this skeleton to compile.
        //return 0;
	int inactive=0;
	String str1="SELECT COUNT(*) FROM ChirpUsers U, ChirpPosts P WHERE userID = posterID AND P.postDate <= '12|31|2016' AND active = TRUE";
	String str2="UPDATE ChirpUsers U SET active = FALSE FROM ChirpPosts P WHERE P.postdate <= '12|31|2016' AND active = FALSE and U.userID = P.posterID";
	try{
		PreparedStatement dev = connection.prepareStatement(str1);
		ResultSet results  = dev.executeQuery();
		PreparedStatement FL = connection.prepareStatement(str2);
		FL.executeUpdate();
		while(results .next()){
		inactive=results .getInt(1);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return inactive;


        // end of your code
    }


    /**
     * The purgeBadUsers method has has one integer parameter, censorLimit.  It invokes a
     * stored function purgeBadFunction that you will need to implement and store in the
     * database according to the description that appears in Section 5.
     * purgeBadFunction should take have the same parameter, censorLimit.  It will take
     * actions to purge all information about certain users from the database.
     * Section 5 explains which users will be purged, and what purging means.
     *
     * purgeBadFunction returns an integer value, and the purgeBadUsers method should
     * return the same integer value.
     */

    public int purgeBadUsers(int censorLimit)
    {
        // There's nothing special about the name storedFunctionResult
        int storedFunctionResult = 0;

        // your code here
        String ans = "SELECT * FROM purgeBadFunction(?)";
	try{
	PreparedStatement STR1 = connection.prepareStatement(ans);
	ResultSet RESSET = STR1.executeQuery();
	while(RESSET.next()){
		storedFunctionResult = RESSET.getInt(1);
	}
	RESSET.close();
	}catch(SQLException e){
		e.printStackTrace();
	}


        // end of your code
        return storedFunctionResult;

    }

};

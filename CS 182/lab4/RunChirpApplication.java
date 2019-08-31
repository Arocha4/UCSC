import java.sql.*;
import java.io.*;
import java.util.*;

/**
 * A class that connects to PostgreSQL and disconnects.
 * You will need to change your credentials below, to match the usename and password of your account
 * in the PostgreSQL server.
 * The name of your database in the server is the same as your username.
 * You are asked to include code that tests the methods of the ChirpApplication class
 * in a similar manner to the sample RunStoresApplication.java program.
*/


public class RunChirpApplication
{
    public static void main(String[] args) {
    	
    	Connection connection = null;
    	try {
    	    //Register the driver
    		Class.forName("org.postgresql.Driver"); 
    	    // Make the connection.
            // You will need to fill in your real username
            // and password for your Postgres account in the arguments of the
            // getConnection method below.
            connection = DriverManager.getConnection(
                                                     "jdbc:postgresql://cmps182-db.lt.ucsc.edu/arocha4",
                                                     "arocha4",
                                                     "arocha4arocha4");
            
            if (connection != null)
                System.out.println("Connected to the database!");

            /* Include your code below to test the methods of the ChirpApplication class
             * as described in Section 6 of the Lab4 pdf.
             * The sample code in RunStoresApplication.java should be useful.
             * That code tests other methods for a different database schema.
             * Your code below: */

		ChirpApplication app = new ChirpApplication(connection);
		List<Integer> people = app.getUsersByAddress("4 Privet Drive, Surrey");
		for (int x : people){
			System.out.println("Output of getUsersByAddress when the parameter theAddress is '4 Privet Drive, Surrey':");
			System.out.println(x);
		}
		List<Integer> people2 = app.getUsersByAddress("Tottenham Court Road, London");
		for (int i : people2) {
			System.out.println("Output of getUsersByAddress when the parameter theAddress is 'Tottenham Court Road, London':");
			System.out.println(i);
		}

		Integer anws = app.makeUsersInactive();
		System.out.println("Output of makeUsersInactive():");
		System.out.println(anws);
		
		int results;
		results = app.purgeBadUsers(3);
		System.out.println("Result of censorLimit = 3:");
		System.out.println(results);		
            /*******************
            * Your code ends here */
            
    	}
    	catch (SQLException | ClassNotFoundException e) {
    		System.out.println("Error while connecting to database: " + e);
    		e.printStackTrace();
    	}
    	finally {
    		if (connection != null) {
    			// Closing Connection
    			try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Failed to close connection: " + e);
					e.printStackTrace();
				}
    		}
    	}
    }
}

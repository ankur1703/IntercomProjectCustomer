/**
 *  Reader class
 * 
 *  It reads from JSON file and stores the customer data into Sorted set of customers
 * 
 */


package MainPackage;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reader {
	private SortedSet<Customer> customers; // To store customers in a set sorting with their IDs
	
	// Constructor
	Reader(){
		customers = new TreeSet<Customer>();
	}
	
	/**
	 * Method ReadJason
	 * This method reads from the file location provided and extracts Customer information from the JSON by reading the text file line by line.
	 * It stores the customer information into customers sorted set by sorting it using their user id.
	 * 
	 * @param fileLocation Address of the customer json file
	 * @return null
	 */
	public void readJason(String fileLocation){
		// To parse the text into JSON 
		JSONParser parser = new JSONParser();
		// It reads the file by taking FileReader object.
		BufferedReader bufferedReader = null;
		
		// try block start
		try{ 
			// Initializing byte level FileReader with the file location 
			FileReader fileReader = new FileReader(fileLocation);
			// Initializing character level BufferedRader with FileReader object
			bufferedReader = new BufferedReader(fileReader);
			
			String line;
			
			// Starting to read line by line until it reaches the file end
			while ((line = bufferedReader.readLine()) != null) {
				// Parsing the line to JSON object
				JSONObject customerJSON = (JSONObject) parser.parse(line);
				
			    int user_id = Integer.parseInt(customerJSON.get("user_id").toString()); // Extracting user id
			    String name = customerJSON.get("name").toString(); // Extracting name
				double latitude = Double.parseDouble(customerJSON.get("latitude").toString()); // Extracting latitude
			    double longitude = Double.parseDouble(customerJSON.get("longitude").toString()); // Extracting longitude			
			    // Storing all the above customer information into customer object
			    Customer customer = new Customer(user_id, name, latitude, longitude);
			    // Adding the customer object to the sorted set
			    customers.add(customer);
			}			
		}// try block end
		// Exception Handling for FimleNotFound, EOF, IO generic and Parse exceptions
		// Just prints about the problems
		catch(FileNotFoundException e){
			System.out.println("File not found:- Exception message: " + e.toString());
		}
		catch(EOFException e){
			System.out.println("End of file while reading:- Exception message: " + e.toString());
		}
		catch(IOException e){
			System.out.println("Generic IO exception:- Exception message: " + e.toString());
		}
		catch(ParseException e){
			System.out.println("Parsing failed:- Exception message: " + e.toString());
		}
		finally{
			// Closing the file handle
			try{ 
				if(bufferedReader != null)
					bufferedReader.close();
			} catch (IOException e) {
				System.out.println("BufferedReader didn't close. Exception message: " + e.toString());
			}
		}
	}
	
	/**
	 * Getter for customers
	 * @return customers in a sorted set
	 */
	public SortedSet<Customer> getCustomers() {
		return customers;
	}
}

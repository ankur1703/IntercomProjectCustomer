/**
 *  Reader class
 * 
 *  It reads from JSON file and stores the customer data into Sorted set of customers
 * 
 */


package DistanceMeasurementUsingCustomerData;

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

public class Reader{
	private SortedSet<Customer> customers; // To store customers in a set sorting with their IDs
	BufferedReader readerWithCustomersInformation = null;
	JSONParser parser;
	// Constructor
	public Reader(){
		customers = new TreeSet<Customer>();
		parser = new JSONParser();
	}
	
	/**
	 * Getter for customers
	 * @return customers in a sorted set
	 */
	public SortedSet<Customer> getCustomers() {
		return customers;
	}
	
	/**	  
	 * @param fileLocation Address of the customer json file
	 * @return null
	 */
	public void initialiseCustomers(String fromCustomerJSONFileAtThisLocation){
		
		initialiseReaderWithCustomerInformationFromJSONFile(fromCustomerJSONFileAtThisLocation);
		 			
		String line;			
		// Starting to read line by line until it reaches the file end
		while ((line = readLineByLineFromReaderWithCustomerInformationObject()) != null) {
			JSONObject customerJSON = parseLineToJSONObject(line);
			
			addCustomerInformationToCustomerTreeSet(customerJSON);
		}
		closeReaderStreamForReaderWithCustomersInformationObject();
	}
	
	private void initialiseReaderWithCustomerInformationFromJSONFile(String fileLocation){
		try{
			// Initializing byte level FileReader with the file location 
			FileReader fileReader = new FileReader(fileLocation);
			// Initializing character level BufferedRader with FileReader object
			readerWithCustomersInformation = new BufferedReader(fileReader);
		}
		catch(FileNotFoundException e){
			System.out.println("File not found:- Exception message: " + e.toString());
			System.exit(0);
		}
	}
	
	private String readLineByLineFromReaderWithCustomerInformationObject(){
		String line = null;
		
		try{
			line =  readerWithCustomersInformation.readLine();
		}
		catch(EOFException e){
			System.out.println("End of file while reading:- Exception message: " + e.toString());
		}
		catch(IOException e){
			System.out.println("Generic IO exception:- Exception message: " + e.toString());
		}
		
		return line;
		
	}
	
	private void closeReaderStreamForReaderWithCustomersInformationObject(){
		try{ 
			if(readerWithCustomersInformation != null)
				readerWithCustomersInformation.close();
		} 
		catch (IOException e) {
				System.out.println("BufferedReader didn't close. Exception message: " + e.toString());
		}
	}
	
	private JSONObject parseLineToJSONObject(String line){
		try{
			return (JSONObject) parser.parse(line);
		}
		catch(ParseException e){
			System.out.println("Parsing failed:- Exception message: " + e.toString());
			return new JSONObject();
		}
	}
	
	private void addCustomerInformationToCustomerTreeSet(JSONObject customerInformation){
		int user_id = Integer.parseInt(customerInformation.get("user_id").toString()); // Extracting user id
	    String name = customerInformation.get("name").toString(); // Extracting name
		double latitude = Double.parseDouble(customerInformation.get("latitude").toString()); // Extracting latitude
	    double longitude = Double.parseDouble(customerInformation.get("longitude").toString()); // Extracting longitude			
	    // Storing all the above customer information into customer object
	    Customer customer = new Customer(user_id, name, latitude, longitude);
	    // Adding the customer object to the sorted set
	    customers.add(customer);
	}
	
	
}

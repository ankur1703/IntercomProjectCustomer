package MainPackage;

import java.util.SortedSet;

public class Main {
	// Dublin office (GPS coordinates 53.3381985, -6.2592576)
	final static double officeLatitude = 53.3381985;
	final static double officeLongitude = -6.2592576;
	final static double distanceLimit = 100; // Threshold limit of 100 KMs
	static String customerJSONFileLocation = "CustomerData/customers.json"; // customer.json file location
	
	public static void main(String[] args) {		
		// Distance Calculator
		DistanceCalculator distanceCalculator = new DistanceCalculator();
		// JSON reader
		Reader reader = new Reader();
		
		// Reading JSON file and storing them to customers SortedSet
		reader.readJason(customerJSONFileLocation);
		
		// Getting customers from Reader class
		SortedSet<Customer> customers = reader.getCustomers();
		
		// Iterating through each customer from customers, customers are already sorted by their ID
		for (Customer customer: customers){
			// Calculating the distance between customers location and Dublin office
			double distance = distanceCalculator.calculateDistance(officeLatitude, officeLongitude, 
							   customer.getLatitude(), customer.getLongitude());
			
			// Checking if the customer is within the predefined limit, which is 100 KMs here
			if (distance < distanceLimit){
				// Printing the custoomer's ID and name who is under 100KMs from office
				System.out.println("UserId: " + customer.getUser_id() + " Name: " + customer.getName() + " " + distance);
			}
			
		}
	}

}

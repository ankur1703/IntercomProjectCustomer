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
				System.out.printf("UserId: %-3d Name: %-18s Distance: %f\n" , customer.getUser_id(), customer.getName(), distance);
			}
			
			/*  Output:
			 *  UserId: 4   Name: Ian Kehoe          Distance: 10.444826
				UserId: 5   Name: Nora Dempsey       Distance: 23.156501
				UserId: 6   Name: Theresa Enright    Distance: 23.945178
				UserId: 8   Name: Eoin Ahearn        Distance: 83.674953
				UserId: 11  Name: Richard Finnegan   Distance: 38.034269
				UserId: 12  Name: Christina McArdle  Distance: 41.676839
				UserId: 13  Name: Olive Ahearn       Distance: 62.064914
				UserId: 15  Name: Michael Ahearn     Distance: 43.559473
				UserId: 17  Name: Patricia Cahill    Distance: 96.235869
				UserId: 23  Name: Eoin Gallagher     Distance: 82.822554
				UserId: 24  Name: Rose Enright       Distance: 89.153095
				UserId: 26  Name: Stephen McArdle    Distance: 98.729680
				UserId: 29  Name: Oliver Ahearn      Distance: 72.205626
				UserId: 30  Name: Nick Enright       Distance: 82.634793
				UserId: 31  Name: Alan Behan         Distance: 44.132861
				UserId: 39  Name: Lisa Ahearn        Distance: 38.200926
			 */
			
			
		}
	}

}

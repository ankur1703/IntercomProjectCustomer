package MainPackage;

import java.util.SortedSet;

public class Tester {

	public static void main(String[] args) {
		// Dublin office (GPS coordinates 53.3381985, -6.2592576)
		final double officeLatitude = 53.3381985;
		final double officeLongitude = -6.2592576;
		
		DistanceCalculater distanceCalculater = new DistanceCalculater();
		Reader reader = new Reader();
		
		reader.readJason();
		
		SortedSet<Customer> customers = reader.getCustomers();
			
		for (Customer customer: customers){
			double distance = distanceCalculater.calculateDistance(officeLatitude, officeLongitude, 
							   customer.getLatitude(), customer.getLongitude());
			
			if (distance < 100){
				System.out.println("UserId: " + customer.getUser_id() + " Name: " + customer.getName() + " " + distance);
			}
			else{
				System.out.println("Out:UserId: " + customer.getUser_id() + " Name: " + customer.getName() + " " + distance);
			}
			
		}
	}

}

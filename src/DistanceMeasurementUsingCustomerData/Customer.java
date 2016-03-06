/**
 * Customer Class
 * 
 * This class saves the customer information such as name , user_id, latitude and longitude
 */

package DistanceMeasurementUsingCustomerData;

public class Customer implements Comparable<Customer> { // implements Comparable interface to be able to compare two customer objects
	private String name;	// name field
	private int user_id; 	// user_id field
	private double latitude; // latitude field
	private double longitude; // longitude field
	
	// Customer constructor  
	public Customer(int user_id, String name, double latitude, double longitude) {
		this.name = name;
		this.user_id = user_id;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * compareTo methods compares the user_id of both customers
	 * So sorting will based on the user ids of customers 
	 */
	@Override
	public int compareTo(Customer anotherCustomer) {
		if(this.user_id > anotherCustomer.user_id)
			return 1;
		else if(this.user_id < anotherCustomer.user_id)
			return -1;
		
		return 0;
	}
	
	
	
}

package MainPackage;

public class Customer implements Comparable<Customer> {
	private String name;	
	private int user_id;
	private double latitude;
	private double longitude;
	
	public Customer(int user_id, String name, double latitude, double longitude) {
		this.name = name;
		this.user_id = user_id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public int getUser_id() {
		return user_id;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public int compareTo(Customer anotherCustomer) {
		if(this.user_id > anotherCustomer.user_id)
			return 1;
		else if(this.user_id < anotherCustomer.user_id)
			return -1;
		
		return 0;
	}
	
	
	
}

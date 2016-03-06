package test;

import static org.junit.Assert.*;

import java.util.SortedSet;

import org.json.simple.JSONObject;
import org.junit.Test;

import DistanceMeasurementUsingCustomerData.Customer;
import DistanceMeasurementUsingCustomerData.Reader;

public class ReaderTests {
	static String customerJSONFileLocation = "CustomerData/customers.json";
	Reader reader = new Reader();	
	
	@Test
	public void testReaderWithCustomersInformationHasBeenIntialised() {
		reader.initialiseCustomers(customerJSONFileLocation);
		SortedSet<Customer> customers = reader.getCustomers();
		
		assertTrue(customers.size() > 0);
	}
	
}
